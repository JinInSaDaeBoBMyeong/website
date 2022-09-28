package org.webrtc;
public final enum class PeerConnection$IceTransportsType extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$IceTransportsType[] $VALUES;
    public static final enum org.webrtc.PeerConnection$IceTransportsType ALL;
    public static final enum org.webrtc.PeerConnection$IceTransportsType NOHOST;
    public static final enum org.webrtc.PeerConnection$IceTransportsType NONE;
    public static final enum org.webrtc.PeerConnection$IceTransportsType RELAY;

    static PeerConnection$IceTransportsType()
    {
        org.webrtc.PeerConnection$IceTransportsType.NONE = new org.webrtc.PeerConnection$IceTransportsType("NONE", 0);
        org.webrtc.PeerConnection$IceTransportsType.RELAY = new org.webrtc.PeerConnection$IceTransportsType("RELAY", 1);
        org.webrtc.PeerConnection$IceTransportsType.NOHOST = new org.webrtc.PeerConnection$IceTransportsType("NOHOST", 2);
        org.webrtc.PeerConnection$IceTransportsType.ALL = new org.webrtc.PeerConnection$IceTransportsType("ALL", 3);
        org.webrtc.PeerConnection$IceTransportsType[] v0_6 = new org.webrtc.PeerConnection$IceTransportsType[4];
        v0_6[0] = org.webrtc.PeerConnection$IceTransportsType.NONE;
        v0_6[1] = org.webrtc.PeerConnection$IceTransportsType.RELAY;
        v0_6[2] = org.webrtc.PeerConnection$IceTransportsType.NOHOST;
        v0_6[3] = org.webrtc.PeerConnection$IceTransportsType.ALL;
        org.webrtc.PeerConnection$IceTransportsType.$VALUES = v0_6;
        return;
    }

    private PeerConnection$IceTransportsType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$IceTransportsType valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$IceTransportsType) Enum.valueOf(org.webrtc.PeerConnection$IceTransportsType, p1));
    }

    public static org.webrtc.PeerConnection$IceTransportsType[] values()
    {
        return ((org.webrtc.PeerConnection$IceTransportsType[]) org.webrtc.PeerConnection$IceTransportsType.$VALUES.clone());
    }
}
