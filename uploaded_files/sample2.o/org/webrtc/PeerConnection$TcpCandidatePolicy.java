package org.webrtc;
public final enum class PeerConnection$TcpCandidatePolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$TcpCandidatePolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$TcpCandidatePolicy DISABLED;
    public static final enum org.webrtc.PeerConnection$TcpCandidatePolicy ENABLED;

    static PeerConnection$TcpCandidatePolicy()
    {
        org.webrtc.PeerConnection$TcpCandidatePolicy.ENABLED = new org.webrtc.PeerConnection$TcpCandidatePolicy("ENABLED", 0);
        org.webrtc.PeerConnection$TcpCandidatePolicy.DISABLED = new org.webrtc.PeerConnection$TcpCandidatePolicy("DISABLED", 1);
        org.webrtc.PeerConnection$TcpCandidatePolicy[] v0_1 = new org.webrtc.PeerConnection$TcpCandidatePolicy[2];
        v0_1[0] = org.webrtc.PeerConnection$TcpCandidatePolicy.ENABLED;
        v0_1[1] = org.webrtc.PeerConnection$TcpCandidatePolicy.DISABLED;
        org.webrtc.PeerConnection$TcpCandidatePolicy.$VALUES = v0_1;
        return;
    }

    private PeerConnection$TcpCandidatePolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$TcpCandidatePolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$TcpCandidatePolicy) Enum.valueOf(org.webrtc.PeerConnection$TcpCandidatePolicy, p1));
    }

    public static org.webrtc.PeerConnection$TcpCandidatePolicy[] values()
    {
        return ((org.webrtc.PeerConnection$TcpCandidatePolicy[]) org.webrtc.PeerConnection$TcpCandidatePolicy.$VALUES.clone());
    }
}
