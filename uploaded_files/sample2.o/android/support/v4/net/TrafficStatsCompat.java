package android.support.v4.net;
public class TrafficStatsCompat {
    private static final android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl IMPL;

    static TrafficStatsCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.net.TrafficStatsCompat.IMPL = new android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl();
        } else {
            android.support.v4.net.TrafficStatsCompat.IMPL = new android.support.v4.net.TrafficStatsCompat$IcsTrafficStatsCompatImpl();
        }
        return;
    }

    public TrafficStatsCompat()
    {
        return;
    }

    public static void clearThreadStatsTag()
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.clearThreadStatsTag();
        return;
    }

    public static int getThreadStatsTag()
    {
        return android.support.v4.net.TrafficStatsCompat.IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int p1)
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.incrementOperationCount(p1);
        return;
    }

    public static void incrementOperationCount(int p1, int p2)
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.incrementOperationCount(p1, p2);
        return;
    }

    public static void setThreadStatsTag(int p1)
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.setThreadStatsTag(p1);
        return;
    }

    public static void tagSocket(java.net.Socket p1)
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.tagSocket(p1);
        return;
    }

    public static void untagSocket(java.net.Socket p1)
    {
        android.support.v4.net.TrafficStatsCompat.IMPL.untagSocket(p1);
        return;
    }
}
