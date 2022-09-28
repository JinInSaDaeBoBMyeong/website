package org.webrtc;
public final enum class PeerConnection$CandidateNetworkPolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$CandidateNetworkPolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$CandidateNetworkPolicy ALL;
    public static final enum org.webrtc.PeerConnection$CandidateNetworkPolicy LOW_COST;

    static PeerConnection$CandidateNetworkPolicy()
    {
        org.webrtc.PeerConnection$CandidateNetworkPolicy.ALL = new org.webrtc.PeerConnection$CandidateNetworkPolicy("ALL", 0);
        org.webrtc.PeerConnection$CandidateNetworkPolicy.LOW_COST = new org.webrtc.PeerConnection$CandidateNetworkPolicy("LOW_COST", 1);
        org.webrtc.PeerConnection$CandidateNetworkPolicy[] v0_1 = new org.webrtc.PeerConnection$CandidateNetworkPolicy[2];
        v0_1[0] = org.webrtc.PeerConnection$CandidateNetworkPolicy.ALL;
        v0_1[1] = org.webrtc.PeerConnection$CandidateNetworkPolicy.LOW_COST;
        org.webrtc.PeerConnection$CandidateNetworkPolicy.$VALUES = v0_1;
        return;
    }

    private PeerConnection$CandidateNetworkPolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$CandidateNetworkPolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$CandidateNetworkPolicy) Enum.valueOf(org.webrtc.PeerConnection$CandidateNetworkPolicy, p1));
    }

    public static org.webrtc.PeerConnection$CandidateNetworkPolicy[] values()
    {
        return ((org.webrtc.PeerConnection$CandidateNetworkPolicy[]) org.webrtc.PeerConnection$CandidateNetworkPolicy.$VALUES.clone());
    }
}
