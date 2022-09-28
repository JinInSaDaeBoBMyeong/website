package android.support.v4.net;
 class TrafficStatsCompat$BaseTrafficStatsCompatImpl implements android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl {
    private ThreadLocal mThreadSocketTags;

    TrafficStatsCompat$BaseTrafficStatsCompatImpl()
    {
        this.mThreadSocketTags = new android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$1(this);
        return;
    }

    public void clearThreadStatsTag()
    {
        ((android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags) this.mThreadSocketTags.get()).statsTag = -1;
        return;
    }

    public int getThreadStatsTag()
    {
        return ((android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags) this.mThreadSocketTags.get()).statsTag;
    }

    public void incrementOperationCount(int p1)
    {
        return;
    }

    public void incrementOperationCount(int p1, int p2)
    {
        return;
    }

    public void setThreadStatsTag(int p2)
    {
        ((android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags) this.mThreadSocketTags.get()).statsTag = p2;
        return;
    }

    public void tagSocket(java.net.Socket p1)
    {
        return;
    }

    public void untagSocket(java.net.Socket p1)
    {
        return;
    }
}
