package android.support.v4.content;
public class LocalBroadcastManager {
    private static final boolean DEBUG = False;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static android.support.v4.content.LocalBroadcastManager mInstance;
    private static final Object mLock;
    private final java.util.HashMap mActions;
    private final android.content.Context mAppContext;
    private final android.os.Handler mHandler;
    private final java.util.ArrayList mPendingBroadcasts;
    private final java.util.HashMap mReceivers;

    static LocalBroadcastManager()
    {
        android.support.v4.content.LocalBroadcastManager.mLock = new Object();
        return;
    }

    private LocalBroadcastManager(android.content.Context p3)
    {
        this.mReceivers = new java.util.HashMap();
        this.mActions = new java.util.HashMap();
        this.mPendingBroadcasts = new java.util.ArrayList();
        this.mAppContext = p3;
        this.mHandler = new android.support.v4.content.LocalBroadcastManager$1(this, p3.getMainLooper());
        return;
    }

    static synthetic void access$000(android.support.v4.content.LocalBroadcastManager p0)
    {
        p0.executePendingBroadcasts();
        return;
    }

    private void executePendingBroadcasts()
    {
        do {
            android.content.Context v6 = this.mReceivers;
            int v0 = this.mPendingBroadcasts.size();
            if (v0 > 0) {
                android.support.v4.content.LocalBroadcastManager$BroadcastRecord[] v2 = new android.support.v4.content.LocalBroadcastManager$BroadcastRecord[v0];
                this.mPendingBroadcasts.toArray(v2);
                this.mPendingBroadcasts.clear();
                int v3 = 0;
            } else {
                return;
            }
        } while(v3 >= v2.length);
        android.support.v4.content.LocalBroadcastManager$BroadcastRecord v1 = v2[v3];
        int v4 = 0;
        while (v4 < v1.receivers.size()) {
            ((android.support.v4.content.LocalBroadcastManager$ReceiverRecord) v1.receivers.get(v4)).receiver.onReceive(this.mAppContext, v1.intent);
            v4++;
        }
        v3++;
        while (v3 < v2.length) {
        }
    }

    public static android.support.v4.content.LocalBroadcastManager getInstance(android.content.Context p3)
    {
        try {
            if (android.support.v4.content.LocalBroadcastManager.mInstance == null) {
                android.support.v4.content.LocalBroadcastManager.mInstance = new android.support.v4.content.LocalBroadcastManager(p3.getApplicationContext());
            }
        } catch (android.support.v4.content.LocalBroadcastManager v0_1) {
            throw v0_1;
        }
        return android.support.v4.content.LocalBroadcastManager.mInstance;
    }

    public void registerReceiver(android.content.BroadcastReceiver p8, android.content.IntentFilter p9)
    {
        try {
            android.support.v4.content.LocalBroadcastManager$ReceiverRecord v2_1 = new android.support.v4.content.LocalBroadcastManager$ReceiverRecord(p9, p8);
            java.util.ArrayList v3_0 = ((java.util.ArrayList) this.mReceivers.get(p8));
        } catch (java.util.HashMap v5_6) {
            throw v5_6;
        }
        if (v3_0 == null) {
            v3_0 = new java.util.ArrayList(1);
            this.mReceivers.put(p8, v3_0);
        }
        v3_0.add(p9);
        int v4 = 0;
        while (v4 < p9.countActions()) {
            String v0 = p9.getAction(v4);
            java.util.ArrayList v1_1 = ((java.util.ArrayList) this.mActions.get(v0));
            if (v1_1 == null) {
                v1_1 = new java.util.ArrayList(1);
                this.mActions.put(v0, v1_1);
            }
            v1_1.add(v2_1);
            v4++;
        }
        return;
    }

    public boolean sendBroadcast(android.content.Intent p18)
    {
        try {
            int v8;
            String v2 = p18.getAction();
            String v3 = p18.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            android.net.Uri v5 = p18.getData();
            String v4 = p18.getScheme();
            java.util.Set v6 = p18.getCategories();
        } catch (String v1_9) {
            throw v1_9;
        }
        if ((p18.getFlags() & 8) == 0) {
            v8 = 0;
        } else {
            v8 = 1;
        }
        if (v8 != 0) {
            android.util.Log.v("LocalBroadcastManager", new StringBuilder().append("Resolving type ").append(v3).append(" scheme ").append(v4).append(" of intent ").append(p18).toString());
        }
        String v1_18;
        java.util.ArrayList v9_1 = ((java.util.ArrayList) this.mActions.get(p18.getAction()));
        if (v9_1 == null) {
            v1_18 = 0;
        } else {
            if (v8 != 0) {
                android.util.Log.v("LocalBroadcastManager", new StringBuilder().append("Action list: ").append(v9_1).toString());
            }
            java.util.ArrayList v14_1 = 0;
            int v10_1 = 0;
            while (v10_1 < v9_1.size()) {
                android.support.v4.content.LocalBroadcastManager$ReceiverRecord v13_1 = ((android.support.v4.content.LocalBroadcastManager$ReceiverRecord) v9_1.get(v10_1));
                if (v8 != 0) {
                    android.util.Log.v("LocalBroadcastManager", new StringBuilder().append("Matching against filter ").append(v13_1.filter).toString());
                }
                if (!v13_1.broadcasting) {
                    int v11 = v13_1.filter.match(v2, v3, v4, v5, v6, "LocalBroadcastManager");
                    if (v11 < 0) {
                        if (v8 != 0) {
                            String v12;
                            switch (v11) {
                                case -4:
                                    v12 = "category";
                                    break;
                                case -3:
                                    v12 = "action";
                                    break;
                                case -2:
                                    v12 = "data";
                                    break;
                                case -1:
                                    v12 = "type";
                                    break;
                                default:
                                    v12 = "unknown reason";
                            }
                            android.util.Log.v("LocalBroadcastManager", new StringBuilder().append("  Filter did not match: ").append(v12).toString());
                        }
                    } else {
                        if (v8 != 0) {
                            android.util.Log.v("LocalBroadcastManager", new StringBuilder().append("  Filter matched!  match=0x").append(Integer.toHexString(v11)).toString());
                        }
                        if (v14_1 == null) {
                            v14_1 = new java.util.ArrayList();
                        }
                        v14_1.add(v13_1);
                        v13_1.broadcasting = 1;
                    }
                } else {
                    if (v8 != 0) {
                        android.util.Log.v("LocalBroadcastManager", "  Filter\'s target already added");
                    }
                }
                v10_1++;
            }
            if (v14_1 == null) {
            } else {
                int v10_0 = 0;
                while (v10_0 < v14_1.size()) {
                    ((android.support.v4.content.LocalBroadcastManager$ReceiverRecord) v14_1.get(v10_0)).broadcasting = 0;
                    v10_0++;
                }
                this.mPendingBroadcasts.add(new android.support.v4.content.LocalBroadcastManager$BroadcastRecord(p18, v14_1));
                if (!this.mHandler.hasMessages(1)) {
                    this.mHandler.sendEmptyMessage(1);
                }
                v1_18 = 1;
            }
        }
        return v1_18;
    }

    public void sendBroadcastSync(android.content.Intent p2)
    {
        if (this.sendBroadcast(p2)) {
            this.executePendingBroadcasts();
        }
        return;
    }

    public void unregisterReceiver(android.content.BroadcastReceiver p10)
    {
        try {
            java.util.ArrayList v2_1 = ((java.util.ArrayList) this.mReceivers.remove(p10));
        } catch (java.util.HashMap v7_9) {
            throw v7_9;
        }
        if (v2_1 != null) {
            int v3 = 0;
            while (v3 < v2_1.size()) {
                android.content.IntentFilter v1_1 = ((android.content.IntentFilter) v2_1.get(v3));
                int v4 = 0;
                while (v4 < v1_1.countActions()) {
                    String v0 = v1_1.getAction(v4);
                    java.util.ArrayList v6_1 = ((java.util.ArrayList) this.mActions.get(v0));
                    if (v6_1 != null) {
                        int v5 = 0;
                        while (v5 < v6_1.size()) {
                            if (((android.support.v4.content.LocalBroadcastManager$ReceiverRecord) v6_1.get(v5)).receiver == p10) {
                                v6_1.remove(v5);
                                v5--;
                            }
                            v5++;
                        }
                        if (v6_1.size() <= 0) {
                            this.mActions.remove(v0);
                        }
                    }
                    v4++;
                }
                v3++;
            }
        } else {
        }
        return;
    }
}
