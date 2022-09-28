package org.webrtc;
public class NetworkMonitorAutoDetect$NetworkInformation {
    public final long handle;
    public final org.webrtc.NetworkMonitorAutoDetect$IPAddress[] ipAddresses;
    public final String name;
    public final org.webrtc.NetworkMonitorAutoDetect$ConnectionType type;

    public NetworkMonitorAutoDetect$NetworkInformation(String p2, org.webrtc.NetworkMonitorAutoDetect$ConnectionType p3, long p4, org.webrtc.NetworkMonitorAutoDetect$IPAddress[] p6)
    {
        this.name = p2;
        this.type = p3;
        this.handle = p4;
        this.ipAddresses = p6;
        return;
    }
}
