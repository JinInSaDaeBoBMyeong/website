package android.support.v4.app;
public class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final android.support.v4.app.NotificationManagerCompat$Impl IMPL = None;
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_BIND_FLAGS = 0;
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static java.util.Set sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static android.support.v4.app.NotificationManagerCompat$SideChannelManager sSideChannelManager;
    private final android.content.Context mContext;
    private final android.app.NotificationManager mNotificationManager;

    static NotificationManagerCompat()
    {
        android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListenersLock = new Object();
        android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListenerPackages = new java.util.HashSet();
        android.support.v4.app.NotificationManagerCompat.sLock = new Object();
        if (android.os.Build$VERSION.SDK_INT < 14) {
            if (android.os.Build$VERSION.SDK_INT < 5) {
                android.support.v4.app.NotificationManagerCompat.IMPL = new android.support.v4.app.NotificationManagerCompat$ImplBase();
            } else {
                android.support.v4.app.NotificationManagerCompat.IMPL = new android.support.v4.app.NotificationManagerCompat$ImplEclair();
            }
        } else {
            android.support.v4.app.NotificationManagerCompat.IMPL = new android.support.v4.app.NotificationManagerCompat$ImplIceCreamSandwich();
        }
        android.support.v4.app.NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS = android.support.v4.app.NotificationManagerCompat.IMPL.getSideChannelBindFlags();
        return;
    }

    private NotificationManagerCompat(android.content.Context p3)
    {
        this.mContext = p3;
        this.mNotificationManager = ((android.app.NotificationManager) this.mContext.getSystemService("notification"));
        return;
    }

    static synthetic int access$000()
    {
        return android.support.v4.app.NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS;
    }

    public static android.support.v4.app.NotificationManagerCompat from(android.content.Context p1)
    {
        return new android.support.v4.app.NotificationManagerCompat(p1);
    }

    public static java.util.Set getEnabledListenerPackages(android.content.Context p10)
    {
        String v4 = android.provider.Settings$Secure.getString(p10.getContentResolver(), "enabled_notification_listeners");
        if ((v4 != null) && (!v4.equals(android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListeners))) {
            String[] v3 = v4.split(":");
            java.util.HashSet v7_1 = new java.util.HashSet(v3.length);
            String[] v0 = v3;
            int v6 = v0.length;
            int v5 = 0;
            while (v5 < v6) {
                android.content.ComponentName v2 = android.content.ComponentName.unflattenFromString(v0[v5]);
                if (v2 != null) {
                    v7_1.add(v2.getPackageName());
                }
                v5++;
            }
            android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListenerPackages = v7_1;
            android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListeners = v4;
        }
        return android.support.v4.app.NotificationManagerCompat.sEnabledNotificationListenerPackages;
    }

    private void pushSideChannelQueue(android.support.v4.app.NotificationManagerCompat$Task p4)
    {
        if (android.support.v4.app.NotificationManagerCompat.sSideChannelManager == null) {
            android.support.v4.app.NotificationManagerCompat.sSideChannelManager = new android.support.v4.app.NotificationManagerCompat$SideChannelManager(this.mContext.getApplicationContext());
        }
        android.support.v4.app.NotificationManagerCompat.sSideChannelManager.queueTask(p4);
        return;
    }

    private static boolean useSideChannelForNotification(android.app.Notification p2)
    {
        int v1_2;
        android.os.Bundle v0 = android.support.v4.app.NotificationCompat.getExtras(p2);
        if ((v0 == null) || (!v0.getBoolean("android.support.useSideChannel"))) {
            v1_2 = 0;
        } else {
            v1_2 = 1;
        }
        return v1_2;
    }

    public void cancel(int p2)
    {
        this.cancel(0, p2);
        return;
    }

    public void cancel(String p3, int p4)
    {
        android.support.v4.app.NotificationManagerCompat.IMPL.cancelNotification(this.mNotificationManager, p3, p4);
        this.pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat$CancelTask(this.mContext.getPackageName(), p4, p3));
        return;
    }

    public void cancelAll()
    {
        this.mNotificationManager.cancelAll();
        this.pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat$CancelTask(this.mContext.getPackageName()));
        return;
    }

    public void notify(int p2, android.app.Notification p3)
    {
        this.notify(0, p2, p3);
        return;
    }

    public void notify(String p3, int p4, android.app.Notification p5)
    {
        if (!android.support.v4.app.NotificationManagerCompat.useSideChannelForNotification(p5)) {
            android.support.v4.app.NotificationManagerCompat.IMPL.postNotification(this.mNotificationManager, p3, p4, p5);
        } else {
            this.pushSideChannelQueue(new android.support.v4.app.NotificationManagerCompat$NotifyTask(this.mContext.getPackageName(), p4, p3, p5));
        }
        return;
    }
}
