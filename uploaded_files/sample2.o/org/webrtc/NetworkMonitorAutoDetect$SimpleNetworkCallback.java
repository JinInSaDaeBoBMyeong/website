package org.webrtc;
 class NetworkMonitorAutoDetect$SimpleNetworkCallback extends android.net.ConnectivityManager$NetworkCallback {
    final synthetic org.webrtc.NetworkMonitorAutoDetect this$0;

    private NetworkMonitorAutoDetect$SimpleNetworkCallback(org.webrtc.NetworkMonitorAutoDetect p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic NetworkMonitorAutoDetect$SimpleNetworkCallback(org.webrtc.NetworkMonitorAutoDetect p1, org.webrtc.NetworkMonitorAutoDetect$1 p2)
    {
        this(p1);
        return;
    }

    private void onNetworkChanged(android.net.Network p3)
    {
        org.webrtc.NetworkMonitorAutoDetect$NetworkInformation v0 = org.webrtc.NetworkMonitorAutoDetect$ConnectivityManagerDelegate.access$300(org.webrtc.NetworkMonitorAutoDetect.access$200(this.this$0), p3);
        if (v0 != null) {
            org.webrtc.NetworkMonitorAutoDetect.access$100(this.this$0).onNetworkConnect(v0);
        }
        return;
    }

    public void onAvailable(android.net.Network p4)
    {
        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network becomes available: ").append(p4.toString()).toString());
        this.onNetworkChanged(p4);
        return;
    }

    public void onCapabilitiesChanged(android.net.Network p4, android.net.NetworkCapabilities p5)
    {
        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("capabilities changed: ").append(p5.toString()).toString());
        this.onNetworkChanged(p4);
        return;
    }

    public void onLinkPropertiesChanged(android.net.Network p4, android.net.LinkProperties p5)
    {
        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("link properties changed: ").append(p5.toString()).toString());
        this.onNetworkChanged(p4);
        return;
    }

    public void onLosing(android.net.Network p4, int p5)
    {
        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network ").append(p4.toString()).append(" is about to lose in ").append(p5).append("ms").toString());
        return;
    }

    public void onLost(android.net.Network p5)
    {
        org.webrtc.Logging.d("NetworkMonitorAutoDetect", new StringBuilder().append("Network ").append(p5.toString()).append(" is disconnected").toString());
        org.webrtc.NetworkMonitorAutoDetect.access$100(this.this$0).onNetworkDisconnect(org.webrtc.NetworkMonitorAutoDetect.access$000(p5));
        return;
    }
}
