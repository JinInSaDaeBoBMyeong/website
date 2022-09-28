package org.webrtc;
public final enum class PeerConnection$SignalingState extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$SignalingState[] $VALUES;
    public static final enum org.webrtc.PeerConnection$SignalingState CLOSED;
    public static final enum org.webrtc.PeerConnection$SignalingState HAVE_LOCAL_OFFER;
    public static final enum org.webrtc.PeerConnection$SignalingState HAVE_LOCAL_PRANSWER;
    public static final enum org.webrtc.PeerConnection$SignalingState HAVE_REMOTE_OFFER;
    public static final enum org.webrtc.PeerConnection$SignalingState HAVE_REMOTE_PRANSWER;
    public static final enum org.webrtc.PeerConnection$SignalingState STABLE;

    static PeerConnection$SignalingState()
    {
        org.webrtc.PeerConnection$SignalingState.STABLE = new org.webrtc.PeerConnection$SignalingState("STABLE", 0);
        org.webrtc.PeerConnection$SignalingState.HAVE_LOCAL_OFFER = new org.webrtc.PeerConnection$SignalingState("HAVE_LOCAL_OFFER", 1);
        org.webrtc.PeerConnection$SignalingState.HAVE_LOCAL_PRANSWER = new org.webrtc.PeerConnection$SignalingState("HAVE_LOCAL_PRANSWER", 2);
        org.webrtc.PeerConnection$SignalingState.HAVE_REMOTE_OFFER = new org.webrtc.PeerConnection$SignalingState("HAVE_REMOTE_OFFER", 3);
        org.webrtc.PeerConnection$SignalingState.HAVE_REMOTE_PRANSWER = new org.webrtc.PeerConnection$SignalingState("HAVE_REMOTE_PRANSWER", 4);
        org.webrtc.PeerConnection$SignalingState.CLOSED = new org.webrtc.PeerConnection$SignalingState("CLOSED", 5);
        org.webrtc.PeerConnection$SignalingState[] v0_10 = new org.webrtc.PeerConnection$SignalingState[6];
        v0_10[0] = org.webrtc.PeerConnection$SignalingState.STABLE;
        v0_10[1] = org.webrtc.PeerConnection$SignalingState.HAVE_LOCAL_OFFER;
        v0_10[2] = org.webrtc.PeerConnection$SignalingState.HAVE_LOCAL_PRANSWER;
        v0_10[3] = org.webrtc.PeerConnection$SignalingState.HAVE_REMOTE_OFFER;
        v0_10[4] = org.webrtc.PeerConnection$SignalingState.HAVE_REMOTE_PRANSWER;
        v0_10[5] = org.webrtc.PeerConnection$SignalingState.CLOSED;
        org.webrtc.PeerConnection$SignalingState.$VALUES = v0_10;
        return;
    }

    private PeerConnection$SignalingState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$SignalingState valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$SignalingState) Enum.valueOf(org.webrtc.PeerConnection$SignalingState, p1));
    }

    public static org.webrtc.PeerConnection$SignalingState[] values()
    {
        return ((org.webrtc.PeerConnection$SignalingState[]) org.webrtc.PeerConnection$SignalingState.$VALUES.clone());
    }
}
