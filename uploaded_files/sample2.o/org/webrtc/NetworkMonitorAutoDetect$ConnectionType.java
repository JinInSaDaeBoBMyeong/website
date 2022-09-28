package org.webrtc;
public final enum class NetworkMonitorAutoDetect$ConnectionType extends java.lang.Enum {
    private static final synthetic org.webrtc.NetworkMonitorAutoDetect$ConnectionType[] $VALUES;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_2G;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_3G;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_4G;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_BLUETOOTH;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_ETHERNET;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_NONE;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_UNKNOWN;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_UNKNOWN_CELLULAR;
    public static final enum org.webrtc.NetworkMonitorAutoDetect$ConnectionType CONNECTION_WIFI;

    static NetworkMonitorAutoDetect$ConnectionType()
    {
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_UNKNOWN", 0);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_ETHERNET = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_ETHERNET", 1);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_WIFI = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_WIFI", 2);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_4G = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_4G", 3);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_3G = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_3G", 4);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_2G = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_2G", 5);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN_CELLULAR = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_UNKNOWN_CELLULAR", 6);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_BLUETOOTH = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_BLUETOOTH", 7);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_NONE = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType("CONNECTION_NONE", 8);
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType[] v0_16 = new org.webrtc.NetworkMonitorAutoDetect$ConnectionType[9];
        v0_16[0] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN;
        v0_16[1] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_ETHERNET;
        v0_16[2] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_WIFI;
        v0_16[3] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_4G;
        v0_16[4] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_3G;
        v0_16[5] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_2G;
        v0_16[6] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_UNKNOWN_CELLULAR;
        v0_16[7] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_BLUETOOTH;
        v0_16[8] = org.webrtc.NetworkMonitorAutoDetect$ConnectionType.CONNECTION_NONE;
        org.webrtc.NetworkMonitorAutoDetect$ConnectionType.$VALUES = v0_16;
        return;
    }

    private NetworkMonitorAutoDetect$ConnectionType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.NetworkMonitorAutoDetect$ConnectionType valueOf(String p1)
    {
        return ((org.webrtc.NetworkMonitorAutoDetect$ConnectionType) Enum.valueOf(org.webrtc.NetworkMonitorAutoDetect$ConnectionType, p1));
    }

    public static org.webrtc.NetworkMonitorAutoDetect$ConnectionType[] values()
    {
        return ((org.webrtc.NetworkMonitorAutoDetect$ConnectionType[]) org.webrtc.NetworkMonitorAutoDetect$ConnectionType.$VALUES.clone());
    }
}
