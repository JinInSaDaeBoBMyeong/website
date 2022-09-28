package org.webrtc;
public final enum class PeerConnection$ContinualGatheringPolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$ContinualGatheringPolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$ContinualGatheringPolicy GATHER_CONTINUALLY;
    public static final enum org.webrtc.PeerConnection$ContinualGatheringPolicy GATHER_ONCE;

    static PeerConnection$ContinualGatheringPolicy()
    {
        org.webrtc.PeerConnection$ContinualGatheringPolicy.GATHER_ONCE = new org.webrtc.PeerConnection$ContinualGatheringPolicy("GATHER_ONCE", 0);
        org.webrtc.PeerConnection$ContinualGatheringPolicy.GATHER_CONTINUALLY = new org.webrtc.PeerConnection$ContinualGatheringPolicy("GATHER_CONTINUALLY", 1);
        org.webrtc.PeerConnection$ContinualGatheringPolicy[] v0_1 = new org.webrtc.PeerConnection$ContinualGatheringPolicy[2];
        v0_1[0] = org.webrtc.PeerConnection$ContinualGatheringPolicy.GATHER_ONCE;
        v0_1[1] = org.webrtc.PeerConnection$ContinualGatheringPolicy.GATHER_CONTINUALLY;
        org.webrtc.PeerConnection$ContinualGatheringPolicy.$VALUES = v0_1;
        return;
    }

    private PeerConnection$ContinualGatheringPolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$ContinualGatheringPolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$ContinualGatheringPolicy) Enum.valueOf(org.webrtc.PeerConnection$ContinualGatheringPolicy, p1));
    }

    public static org.webrtc.PeerConnection$ContinualGatheringPolicy[] values()
    {
        return ((org.webrtc.PeerConnection$ContinualGatheringPolicy[]) org.webrtc.PeerConnection$ContinualGatheringPolicy.$VALUES.clone());
    }
}
