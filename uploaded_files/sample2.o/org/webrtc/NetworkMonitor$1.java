package org.webrtc;
 class NetworkMonitor$1 implements org.webrtc.NetworkMonitorAutoDetect$Observer {
    final synthetic org.webrtc.NetworkMonitor this$0;

    NetworkMonitor$1(org.webrtc.NetworkMonitor p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onConnectionTypeChanged(org.webrtc.NetworkMonitorAutoDetect$ConnectionType p2)
    {
        org.webrtc.NetworkMonitor.access$000(this.this$0, p2);
        return;
    }

    public void onNetworkConnect(org.webrtc.NetworkMonitorAutoDetect$NetworkInformation p2)
    {
        org.webrtc.NetworkMonitor.access$100(this.this$0, p2);
        return;
    }

    public void onNetworkDisconnect(long p2)
    {
        org.webrtc.NetworkMonitor.access$200(this.this$0, p2);
        return;
    }
}
