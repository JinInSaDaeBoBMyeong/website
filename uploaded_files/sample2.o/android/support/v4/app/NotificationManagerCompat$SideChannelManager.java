package android.support.v4.app;
 class NotificationManagerCompat$SideChannelManager implements android.os.Handler$Callback, android.content.ServiceConnection {
    private static final String KEY_BINDER = "binder";
    private static final int MSG_QUEUE_TASK = 0;
    private static final int MSG_RETRY_LISTENER_QUEUE = 3;
    private static final int MSG_SERVICE_CONNECTED = 1;
    private static final int MSG_SERVICE_DISCONNECTED = 2;
    private java.util.Set mCachedEnabledPackages;
    private final android.content.Context mContext;
    private final android.os.Handler mHandler;
    private final android.os.HandlerThread mHandlerThread;
    private final java.util.Map mRecordMap;

    public NotificationManagerCompat$SideChannelManager(android.content.Context p3)
    {
        this.mRecordMap = new java.util.HashMap();
        this.mCachedEnabledPackages = new java.util.HashSet();
        this.mContext = p3;
        this.mHandlerThread = new android.os.HandlerThread("NotificationManagerCompat");
        this.mHandlerThread.start();
        this.mHandler = new android.os.Handler(this.mHandlerThread.getLooper(), this);
        return;
    }

    private boolean ensureServiceBound(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord p5)
    {
        boolean v1_7;
        if (!p5.bound) {
            p5.bound = this.mContext.bindService(new android.content.Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(p5.componentName), this, android.support.v4.app.NotificationManagerCompat.access$000());
            if (!p5.bound) {
                android.util.Log.w("NotifManCompat", new StringBuilder().append("Unable to bind to listener ").append(p5.componentName).toString());
                this.mContext.unbindService(this);
            } else {
                p5.retryCount = 0;
            }
            v1_7 = p5.bound;
        } else {
            v1_7 = 1;
        }
        return v1_7;
    }

    private void ensureServiceUnbound(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord p2)
    {
        if (p2.bound) {
            this.mContext.unbindService(this);
            p2.bound = 0;
        }
        p2.service = 0;
        return;
    }

    private void handleQueueTask(android.support.v4.app.NotificationManagerCompat$Task p4)
    {
        this.updateListenerMap();
        java.util.Iterator v0 = this.mRecordMap.values().iterator();
        while (v0.hasNext()) {
            android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord v1_1 = ((android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord) v0.next());
            v1_1.taskQueue.add(p4);
            this.processListenerQueue(v1_1);
        }
        return;
    }

    private void handleRetryListenerQueue(android.content.ComponentName p3)
    {
        android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord v0_1 = ((android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord) this.mRecordMap.get(p3));
        if (v0_1 != null) {
            this.processListenerQueue(v0_1);
        }
        return;
    }

    private void handleServiceConnected(android.content.ComponentName p3, android.os.IBinder p4)
    {
        android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord v0_1 = ((android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord) this.mRecordMap.get(p3));
        if (v0_1 != null) {
            v0_1.service = android.support.v4.app.INotificationSideChannel$Stub.asInterface(p4);
            v0_1.retryCount = 0;
            this.processListenerQueue(v0_1);
        }
        return;
    }

    private void handleServiceDisconnected(android.content.ComponentName p3)
    {
        android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord v0_1 = ((android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord) this.mRecordMap.get(p3));
        if (v0_1 != null) {
            this.ensureServiceUnbound(v0_1);
        }
        return;
    }

    private void processListenerQueue(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord p7)
    {
        if (android.util.Log.isLoggable("NotifManCompat", 3)) {
            android.util.Log.d("NotifManCompat", new StringBuilder().append("Processing component ").append(p7.componentName).append(", ").append(p7.taskQueue.size()).append(" queued tasks").toString());
        }
        if (!p7.taskQueue.isEmpty()) {
            if ((!this.ensureServiceBound(p7)) || (p7.service == null)) {
                this.scheduleListenerRetry(p7);
                return;
            }
            while(true) {
                android.support.v4.app.NotificationManagerCompat$Task v1_1 = ((android.support.v4.app.NotificationManagerCompat$Task) p7.taskQueue.peek());
                if (v1_1 == null) {
                    break;
                }
                try {
                    if (android.util.Log.isLoggable("NotifManCompat", 3)) {
                        android.util.Log.d("NotifManCompat", new StringBuilder().append("Sending task ").append(v1_1).toString());
                    }
                    v1_1.send(p7.service);
                    p7.taskQueue.remove();
                } catch (android.os.RemoteException v0) {
                    android.util.Log.w("NotifManCompat", new StringBuilder().append("RemoteException communicating with ").append(p7.componentName).toString(), v0);
                    break;
                } catch (android.os.RemoteException v0) {
                    if (!android.util.Log.isLoggable("NotifManCompat", 3)) {
                        break;
                    }
                    android.util.Log.d("NotifManCompat", new StringBuilder().append("Remote service has died: ").append(p7.componentName).toString());
                    break;
                }
            }
            if (!p7.taskQueue.isEmpty()) {
                this.scheduleListenerRetry(p7);
            }
        }
        return;
    }

    private void scheduleListenerRetry(android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord p7)
    {
        if (!this.mHandler.hasMessages(3, p7.componentName)) {
            p7.retryCount = (p7.retryCount + 1);
            if (p7.retryCount <= 6) {
                int v0 = ((1 << (p7.retryCount - 1)) * 1000);
                if (android.util.Log.isLoggable("NotifManCompat", 3)) {
                    android.util.Log.d("NotifManCompat", new StringBuilder().append("Scheduling retry for ").append(v0).append(" ms").toString());
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, p7.componentName), ((long) v0));
            } else {
                android.util.Log.w("NotifManCompat", new StringBuilder().append("Giving up on delivering ").append(p7.taskQueue.size()).append(" tasks to ").append(p7.componentName).append(" after ").append(p7.retryCount).append(" retries").toString());
                p7.taskQueue.clear();
            }
        }
        return;
    }

    private void updateListenerMap()
    {
        java.util.Set v2 = android.support.v4.app.NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
        if (!v2.equals(this.mCachedEnabledPackages)) {
            this.mCachedEnabledPackages = v2;
            java.util.List v7 = this.mContext.getPackageManager().queryIntentServices(new android.content.Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 4);
            java.util.HashSet v1_1 = new java.util.HashSet();
            java.util.Iterator v4_0 = v7.iterator();
            while (v4_0.hasNext()) {
                android.content.pm.ResolveInfo v6_1 = ((android.content.pm.ResolveInfo) v4_0.next());
                if (v2.contains(v6_1.serviceInfo.packageName)) {
                    android.content.ComponentName v0_1 = new android.content.ComponentName(v6_1.serviceInfo.packageName, v6_1.serviceInfo.name);
                    if (v6_1.serviceInfo.permission == null) {
                        v1_1.add(v0_1);
                    } else {
                        android.util.Log.w("NotifManCompat", new StringBuilder().append("Permission present on component ").append(v0_1).append(", not adding listener record.").toString());
                    }
                }
            }
            java.util.Iterator v4_1 = v1_1.iterator();
            while (v4_1.hasNext()) {
                android.content.ComponentName v0_3 = ((android.content.ComponentName) v4_1.next());
                if (!this.mRecordMap.containsKey(v0_3)) {
                    if (android.util.Log.isLoggable("NotifManCompat", 3)) {
                        android.util.Log.d("NotifManCompat", new StringBuilder().append("Adding listener record for ").append(v0_3).toString());
                    }
                    this.mRecordMap.put(v0_3, new android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord(v0_3));
                }
            }
            java.util.Iterator v5 = this.mRecordMap.entrySet().iterator();
            while (v5.hasNext()) {
                java.util.Map$Entry v3_1 = ((java.util.Map$Entry) v5.next());
                if (!v1_1.contains(v3_1.getKey())) {
                    if (android.util.Log.isLoggable("NotifManCompat", 3)) {
                        android.util.Log.d("NotifManCompat", new StringBuilder().append("Removing listener record for ").append(v3_1.getKey()).toString());
                    }
                    this.ensureServiceUnbound(((android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord) v3_1.getValue()));
                    v5.remove();
                }
            }
        }
        return;
    }

    public boolean handleMessage(android.os.Message p5)
    {
        int v1_1;
        switch (p5.what) {
            case 0:
                this.handleQueueTask(((android.support.v4.app.NotificationManagerCompat$Task) p5.obj));
                v1_1 = 1;
                break;
            case 1:
                android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent v0_1 = ((android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent) p5.obj);
                this.handleServiceConnected(v0_1.componentName, v0_1.iBinder);
                v1_1 = 1;
                break;
            case 2:
                this.handleServiceDisconnected(((android.content.ComponentName) p5.obj));
                v1_1 = 1;
                break;
            case 3:
                this.handleRetryListenerQueue(((android.content.ComponentName) p5.obj));
                v1_1 = 1;
                break;
            default:
                v1_1 = 0;
        }
        return v1_1;
    }

    public void onServiceConnected(android.content.ComponentName p4, android.os.IBinder p5)
    {
        if (android.util.Log.isLoggable("NotifManCompat", 3)) {
            android.util.Log.d("NotifManCompat", new StringBuilder().append("Connected to service ").append(p4).toString());
        }
        this.mHandler.obtainMessage(1, new android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent(p4, p5)).sendToTarget();
        return;
    }

    public void onServiceDisconnected(android.content.ComponentName p4)
    {
        if (android.util.Log.isLoggable("NotifManCompat", 3)) {
            android.util.Log.d("NotifManCompat", new StringBuilder().append("Disconnected from service ").append(p4).toString());
        }
        this.mHandler.obtainMessage(2, p4).sendToTarget();
        return;
    }

    public void queueTask(android.support.v4.app.NotificationManagerCompat$Task p3)
    {
        this.mHandler.obtainMessage(0, p3).sendToTarget();
        return;
    }
}
