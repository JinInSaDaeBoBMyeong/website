package org.webrtc;
public final enum class PeerConnection$RtcpMuxPolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$RtcpMuxPolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$RtcpMuxPolicy NEGOTIATE;
    public static final enum org.webrtc.PeerConnection$RtcpMuxPolicy REQUIRE;

    static PeerConnection$RtcpMuxPolicy()
    {
        org.webrtc.PeerConnection$RtcpMuxPolicy.NEGOTIATE = new org.webrtc.PeerConnection$RtcpMuxPolicy("NEGOTIATE", 0);
        org.webrtc.PeerConnection$RtcpMuxPolicy.REQUIRE = new org.webrtc.PeerConnection$RtcpMuxPolicy("REQUIRE", 1);
        org.webrtc.PeerConnection$RtcpMuxPolicy[] v0_1 = new org.webrtc.PeerConnection$RtcpMuxPolicy[2];
        v0_1[0] = org.webrtc.PeerConnection$RtcpMuxPolicy.NEGOTIATE;
        v0_1[1] = org.webrtc.PeerConnection$RtcpMuxPolicy.REQUIRE;
        org.webrtc.PeerConnection$RtcpMuxPolicy.$VALUES = v0_1;
        return;
    }

    private PeerConnection$RtcpMuxPolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$RtcpMuxPolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$RtcpMuxPolicy) Enum.valueOf(org.webrtc.PeerConnection$RtcpMuxPolicy, p1));
    }

    public static org.webrtc.PeerConnection$RtcpMuxPolicy[] values()
    {
        return ((org.webrtc.PeerConnection$RtcpMuxPolicy[]) org.webrtc.PeerConnection$RtcpMuxPolicy.$VALUES.clone());
    }
}
