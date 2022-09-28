package org.webrtc;
public final enum class SessionDescription$Type extends java.lang.Enum {
    private static final synthetic org.webrtc.SessionDescription$Type[] $VALUES;
    public static final enum org.webrtc.SessionDescription$Type ANSWER;
    public static final enum org.webrtc.SessionDescription$Type OFFER;
    public static final enum org.webrtc.SessionDescription$Type PRANSWER;

    static SessionDescription$Type()
    {
        org.webrtc.SessionDescription$Type.OFFER = new org.webrtc.SessionDescription$Type("OFFER", 0);
        org.webrtc.SessionDescription$Type.PRANSWER = new org.webrtc.SessionDescription$Type("PRANSWER", 1);
        org.webrtc.SessionDescription$Type.ANSWER = new org.webrtc.SessionDescription$Type("ANSWER", 2);
        org.webrtc.SessionDescription$Type[] v0_3 = new org.webrtc.SessionDescription$Type[3];
        v0_3[0] = org.webrtc.SessionDescription$Type.OFFER;
        v0_3[1] = org.webrtc.SessionDescription$Type.PRANSWER;
        v0_3[2] = org.webrtc.SessionDescription$Type.ANSWER;
        org.webrtc.SessionDescription$Type.$VALUES = v0_3;
        return;
    }

    private SessionDescription$Type(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.SessionDescription$Type fromCanonicalForm(String p2)
    {
        return ((org.webrtc.SessionDescription$Type) org.webrtc.SessionDescription$Type.valueOf(org.webrtc.SessionDescription$Type, p2.toUpperCase(java.util.Locale.US)));
    }

    public static org.webrtc.SessionDescription$Type valueOf(String p1)
    {
        return ((org.webrtc.SessionDescription$Type) Enum.valueOf(org.webrtc.SessionDescription$Type, p1));
    }

    public static org.webrtc.SessionDescription$Type[] values()
    {
        return ((org.webrtc.SessionDescription$Type[]) org.webrtc.SessionDescription$Type.$VALUES.clone());
    }

    public String canonicalForm()
    {
        return this.name().toLowerCase(java.util.Locale.US);
    }
}
