package org.webrtc;
public final enum class PeerConnection$TlsCertPolicy extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$TlsCertPolicy[] $VALUES;
    public static final enum org.webrtc.PeerConnection$TlsCertPolicy TLS_CERT_POLICY_INSECURE_NO_CHECK;
    public static final enum org.webrtc.PeerConnection$TlsCertPolicy TLS_CERT_POLICY_SECURE;

    static PeerConnection$TlsCertPolicy()
    {
        org.webrtc.PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_SECURE = new org.webrtc.PeerConnection$TlsCertPolicy("TLS_CERT_POLICY_SECURE", 0);
        org.webrtc.PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_INSECURE_NO_CHECK = new org.webrtc.PeerConnection$TlsCertPolicy("TLS_CERT_POLICY_INSECURE_NO_CHECK", 1);
        org.webrtc.PeerConnection$TlsCertPolicy[] v0_1 = new org.webrtc.PeerConnection$TlsCertPolicy[2];
        v0_1[0] = org.webrtc.PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_SECURE;
        v0_1[1] = org.webrtc.PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_INSECURE_NO_CHECK;
        org.webrtc.PeerConnection$TlsCertPolicy.$VALUES = v0_1;
        return;
    }

    private PeerConnection$TlsCertPolicy(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$TlsCertPolicy valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$TlsCertPolicy) Enum.valueOf(org.webrtc.PeerConnection$TlsCertPolicy, p1));
    }

    public static org.webrtc.PeerConnection$TlsCertPolicy[] values()
    {
        return ((org.webrtc.PeerConnection$TlsCertPolicy[]) org.webrtc.PeerConnection$TlsCertPolicy.$VALUES.clone());
    }
}
