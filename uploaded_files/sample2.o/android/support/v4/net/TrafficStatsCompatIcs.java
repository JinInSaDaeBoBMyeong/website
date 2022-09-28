package android.support.v4.net;
 class TrafficStatsCompatIcs {

    TrafficStatsCompatIcs()
    {
        return;
    }

    public static void clearThreadStatsTag()
    {
        android.net.TrafficStats.clearThreadStatsTag();
        return;
    }

    public static int getThreadStatsTag()
    {
        return android.net.TrafficStats.getThreadStatsTag();
    }

    public static void incrementOperationCount(int p0)
    {
        android.net.TrafficStats.incrementOperationCount(p0);
        return;
    }

    public static void incrementOperationCount(int p0, int p1)
    {
        android.net.TrafficStats.incrementOperationCount(p0, p1);
        return;
    }

    public static void setThreadStatsTag(int p0)
    {
        android.net.TrafficStats.setThreadStatsTag(p0);
        return;
    }

    public static void tagSocket(java.net.Socket p0)
    {
        android.net.TrafficStats.tagSocket(p0);
        return;
    }

    public static void untagSocket(java.net.Socket p0)
    {
        android.net.TrafficStats.untagSocket(p0);
        return;
    }
}
