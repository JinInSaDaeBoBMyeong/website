package org.webrtc;
public final enum class PeerConnection$IceGatheringState extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$IceGatheringState[] $VALUES;
    public static final enum org.webrtc.PeerConnection$IceGatheringState COMPLETE;
    public static final enum org.webrtc.PeerConnection$IceGatheringState GATHERING;
    public static final enum org.webrtc.PeerConnection$IceGatheringState NEW;

    static PeerConnection$IceGatheringState()
    {
        org.webrtc.PeerConnection$IceGatheringState.NEW = new org.webrtc.PeerConnection$IceGatheringState("NEW", 0);
        org.webrtc.PeerConnection$IceGatheringState.GATHERING = new org.webrtc.PeerConnection$IceGatheringState("GATHERING", 1);
        org.webrtc.PeerConnection$IceGatheringState.COMPLETE = new org.webrtc.PeerConnection$IceGatheringState("COMPLETE", 2);
        org.webrtc.PeerConnection$IceGatheringState[] v0_3 = new org.webrtc.PeerConnection$IceGatheringState[3];
        v0_3[0] = org.webrtc.PeerConnection$IceGatheringState.NEW;
        v0_3[1] = org.webrtc.PeerConnection$IceGatheringState.GATHERING;
        v0_3[2] = org.webrtc.PeerConnection$IceGatheringState.COMPLETE;
        org.webrtc.PeerConnection$IceGatheringState.$VALUES = v0_3;
        return;
    }

    private PeerConnection$IceGatheringState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$IceGatheringState valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$IceGatheringState) Enum.valueOf(org.webrtc.PeerConnection$IceGatheringState, p1));
    }

    public static org.webrtc.PeerConnection$IceGatheringState[] values()
    {
        return ((org.webrtc.PeerConnection$IceGatheringState[]) org.webrtc.PeerConnection$IceGatheringState.$VALUES.clone());
    }
}
