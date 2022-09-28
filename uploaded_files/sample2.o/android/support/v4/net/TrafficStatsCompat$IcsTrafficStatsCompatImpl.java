package android.support.v4.net;
 class TrafficStatsCompat$IcsTrafficStatsCompatImpl implements android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl {

    TrafficStatsCompat$IcsTrafficStatsCompatImpl()
    {
        return;
    }

    public void clearThreadStatsTag()
    {
        android.support.v4.net.TrafficStatsCompatIcs.clearThreadStatsTag();
        return;
    }

    public int getThreadStatsTag()
    {
        return android.support.v4.net.TrafficStatsCompatIcs.getThreadStatsTag();
    }

    public void incrementOperationCount(int p1)
    {
        android.support.v4.net.TrafficStatsCompatIcs.incrementOperationCount(p1);
        return;
    }

    public void incrementOperationCount(int p1, int p2)
    {
        android.support.v4.net.TrafficStatsCompatIcs.incrementOperationCount(p1, p2);
        return;
    }

    public void setThreadStatsTag(int p1)
    {
        android.support.v4.net.TrafficStatsCompatIcs.setThreadStatsTag(p1);
        return;
    }

    public void tagSocket(java.net.Socket p1)
    {
        android.support.v4.net.TrafficStatsCompatIcs.tagSocket(p1);
        return;
    }

    public void untagSocket(java.net.Socket p1)
    {
        android.support.v4.net.TrafficStatsCompatIcs.untagSocket(p1);
        return;
    }
}
