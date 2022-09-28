package org.webrtc;
public final enum class PeerConnection$KeyType extends java.lang.Enum {
    private static final synthetic org.webrtc.PeerConnection$KeyType[] $VALUES;
    public static final enum org.webrtc.PeerConnection$KeyType ECDSA;
    public static final enum org.webrtc.PeerConnection$KeyType RSA;

    static PeerConnection$KeyType()
    {
        org.webrtc.PeerConnection$KeyType.RSA = new org.webrtc.PeerConnection$KeyType("RSA", 0);
        org.webrtc.PeerConnection$KeyType.ECDSA = new org.webrtc.PeerConnection$KeyType("ECDSA", 1);
        org.webrtc.PeerConnection$KeyType[] v0_1 = new org.webrtc.PeerConnection$KeyType[2];
        v0_1[0] = org.webrtc.PeerConnection$KeyType.RSA;
        v0_1[1] = org.webrtc.PeerConnection$KeyType.ECDSA;
        org.webrtc.PeerConnection$KeyType.$VALUES = v0_1;
        return;
    }

    private PeerConnection$KeyType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.PeerConnection$KeyType valueOf(String p1)
    {
        return ((org.webrtc.PeerConnection$KeyType) Enum.valueOf(org.webrtc.PeerConnection$KeyType, p1));
    }

    public static org.webrtc.PeerConnection$KeyType[] values()
    {
        return ((org.webrtc.PeerConnection$KeyType[]) org.webrtc.PeerConnection$KeyType.$VALUES.clone());
    }
}
