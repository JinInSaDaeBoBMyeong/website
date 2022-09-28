package android.support.v4.content;
public abstract class WakefulBroadcastReceiver extends android.content.BroadcastReceiver {
    private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
    private static final android.util.SparseArray mActiveWakeLocks;
    private static int mNextId;

    static WakefulBroadcastReceiver()
    {
        android.support.v4.content.WakefulBroadcastReceiver.mActiveWakeLocks = new android.util.SparseArray();
        android.support.v4.content.WakefulBroadcastReceiver.mNextId = 1;
        return;
    }

    public WakefulBroadcastReceiver()
    {
        return;
    }

    public static boolean completeWakefulIntent(android.content.Intent p7)
    {
        int v2_0 = 0;
        int v0 = p7.getIntExtra("android.support.content.wakelockid", 0);
        if (v0 != 0) {
            try {
                android.os.PowerManager$WakeLock v1_0 = ((android.os.PowerManager$WakeLock) android.support.v4.content.WakefulBroadcastReceiver.mActiveWakeLocks.get(v0));
            } catch (int v2_3) {
                throw v2_3;
            }
            if (v1_0 == null) {
                android.util.Log.w("WakefulBroadcastReceiver", new StringBuilder().append("No active wake lock id #").append(v0).toString());
                v2_0 = 1;
            } else {
                v1_0.release();
                android.support.v4.content.WakefulBroadcastReceiver.mActiveWakeLocks.remove(v0);
                v2_0 = 1;
            }
        }
        return v2_0;
    }

    public static android.content.ComponentName startWakefulService(android.content.Context p8, android.content.Intent p9)
    {
        try {
            int v1 = android.support.v4.content.WakefulBroadcastReceiver.mNextId;
            android.support.v4.content.WakefulBroadcastReceiver.mNextId = (android.support.v4.content.WakefulBroadcastReceiver.mNextId + 1);
        } catch (android.util.SparseArray v4_6) {
            throw v4_6;
        }
        if (android.support.v4.content.WakefulBroadcastReceiver.mNextId <= 0) {
            android.support.v4.content.WakefulBroadcastReceiver.mNextId = 1;
        }
        p9.putExtra("android.support.content.wakelockid", v1);
        int v0 = p8.startService(p9);
        if (v0 != 0) {
            android.os.PowerManager$WakeLock v3 = ((android.os.PowerManager) p8.getSystemService("power")).newWakeLock(1, new StringBuilder().append("wake:").append(v0.flattenToShortString()).toString());
            v3.setReferenceCounted(0);
            v3.acquire(60000);
            android.support.v4.content.WakefulBroadcastReceiver.mActiveWakeLocks.put(v1, v3);
        } else {
            v0 = 0;
        }
        return v0;
    }
}
