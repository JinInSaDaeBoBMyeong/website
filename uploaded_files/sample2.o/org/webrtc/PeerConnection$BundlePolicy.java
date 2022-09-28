package org.webrtc;
public final enum class PeerConnection$BundlePolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$BundlePolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$BundlePolicy BALANCED;
    public static final enum org.webrtc.PeerConnection$BundlePolicy MAXBUNDLE;
    public static final enum org.webrtc.PeerConnection$BundlePolicy MAXCOMPAT;

    static PeerConnection$BundlePolicy()
    {
        org.webrtc.PeerConnection$BundlePolicy.BALANCED = new org.webrtc.PeerConnection$BundlePolicy("BALANCED", 0);
        org.webrtc.PeerConnection$BundlePolicy.MAXBUNDLE = new org.webrtc.PeerConnection$BundlePolicy("MAXBUNDLE", 1);
        org.webrtc.PeerConnection$BundlePolicy.MAXCOMPAT = new org.webrtc.PeerConnection$BundlePolicy("MAXCOMPAT", 2);
        org.webrtc.PeerConnection$BundlePolicy[] v0_3 = new org.webrtc.PeerConnection$BundlePolicy[3];
        v0_3[0] = org.webrtc.PeerConnection$BundlePolicy.BALANCED;
        v0_3[1] = org.webrtc.PeerConnection$BundlePolicy.MAXBUNDLE;
        v0_3[2] = org.webrtc.PeerConnection$BundlePolicy.MAXCOMPAT;
        org.webrtc.PeerConnection$BundlePolicy.$VALUES = v0_3;
        return;
    }

    private PeerConnection$BundlePolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$BundlePolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$BundlePolicy) Enum.valueOf(org.webrtc.PeerConnection$BundlePolicy, p1));
    }

    public static org.webrtc.PeerConnection$BundlePolicy[] values()
    {
        return ((org.webrtc.PeerConnection$BundlePolicy[]) org.webrtc.PeerConnection$BundlePolicy.$VALUES.clone());
    }
}
