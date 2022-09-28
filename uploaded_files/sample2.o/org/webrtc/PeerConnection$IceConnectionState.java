package org.webrtc;
public final enum class PeerConnection$IceConnectionState extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$IceConnectionState[] $VALUES;
    public static final enum org.webrtc.PeerConnection$IceConnectionState CHECKING;
    public static final enum org.webrtc.PeerConnection$IceConnectionState CLOSED;
    public static final enum org.webrtc.PeerConnection$IceConnectionState COMPLETED;
    public static final enum org.webrtc.PeerConnection$IceConnectionState CONNECTED;
    public static final enum org.webrtc.PeerConnection$IceConnectionState DISCONNECTED;
    public static final enum org.webrtc.PeerConnection$IceConnectionState FAILED;
    public static final enum org.webrtc.PeerConnection$IceConnectionState NEW;

    static PeerConnection$IceConnectionState()
    {
        org.webrtc.PeerConnection$IceConnectionState.NEW = new org.webrtc.PeerConnection$IceConnectionState("NEW", 0);
        org.webrtc.PeerConnection$IceConnectionState.CHECKING = new org.webrtc.PeerConnection$IceConnectionState("CHECKING", 1);
        org.webrtc.PeerConnection$IceConnectionState.CONNECTED = new org.webrtc.PeerConnection$IceConnectionState("CONNECTED", 2);
        org.webrtc.PeerConnection$IceConnectionState.COMPLETED = new org.webrtc.PeerConnection$IceConnectionState("COMPLETED", 3);
        org.webrtc.PeerConnection$IceConnectionState.FAILED = new org.webrtc.PeerConnection$IceConnectionState("FAILED", 4);
        org.webrtc.PeerConnection$IceConnectionState.DISCONNECTED = new org.webrtc.PeerConnection$IceConnectionState("DISCONNECTED", 5);
        org.webrtc.PeerConnection$IceConnectionState.CLOSED = new org.webrtc.PeerConnection$IceConnectionState("CLOSED", 6);
        org.webrtc.PeerConnection$IceConnectionState[] v0_12 = new org.webrtc.PeerConnection$IceConnectionState[7];
        v0_12[0] = org.webrtc.PeerConnection$IceConnectionState.NEW;
        v0_12[1] = org.webrtc.PeerConnection$IceConnectionState.CHECKING;
        v0_12[2] = org.webrtc.PeerConnection$IceConnectionState.CONNECTED;
        v0_12[3] = org.webrtc.PeerConnection$IceConnectionState.COMPLETED;
        v0_12[4] = org.webrtc.PeerConnection$IceConnectionState.FAILED;
        v0_12[5] = org.webrtc.PeerConnection$IceConnectionState.DISCONNECTED;
        v0_12[6] = org.webrtc.PeerConnection$IceConnectionState.CLOSED;
        org.webrtc.PeerConnection$IceConnectionState.$VALUES = v0_12;
        return;
    }

    private PeerConnection$IceConnectionState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$IceConnectionState valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$IceConnectionState) Enum.valueOf(org.webrtc.PeerConnection$IceConnectionState, p1));
    }

    public static org.webrtc.PeerConnection$IceConnectionState[] values()
    {
        return ((org.webrtc.PeerConnection$IceConnectionState[]) org.webrtc.PeerConnection$IceConnectionState.$VALUES.clone());
    }
}
