package org.webrtc;
 class NetworkMonitorAutoDetect$NetworkState {
    private final boolean connected;
    private final int subtype;
    private final int type;

    public NetworkMonitorAutoDetect$NetworkState(boolean p1, int p2, int p3)
    {
        this.connected = p1;
        this.type = p2;
        this.subtype = p3;
        return;
    }

    static synthetic boolean access$400(org.webrtc.NetworkMonitorAutoDetect$NetworkState p1)
    {
        return p1.connected;
    }

    public int getNetworkSubType()
    {
        return this.subtype;
    }

    public int getNetworkType()
    {
        return this.type;
    }

    public boolean isConnected()
    {
        return this.connected;
    }
}
