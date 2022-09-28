package org.webrtc;
public final enum class Logging$Severity extends java.lang.Enum {
    private static final synthetic org.webrtc.Logging$Severity[] $VALUES;
    public static final enum org.webrtc.Logging$Severity LS_ERROR;
    public static final enum org.webrtc.Logging$Severity LS_INFO;
    public static final enum org.webrtc.Logging$Severity LS_NONE;
    public static final enum org.webrtc.Logging$Severity LS_SENSITIVE;
    public static final enum org.webrtc.Logging$Severity LS_VERBOSE;
    public static final enum org.webrtc.Logging$Severity LS_WARNING;

    static Logging$Severity()
    {
        org.webrtc.Logging$Severity.LS_SENSITIVE = new org.webrtc.Logging$Severity("LS_SENSITIVE", 0);
        org.webrtc.Logging$Severity.LS_VERBOSE = new org.webrtc.Logging$Severity("LS_VERBOSE", 1);
        org.webrtc.Logging$Severity.LS_INFO = new org.webrtc.Logging$Severity("LS_INFO", 2);
        org.webrtc.Logging$Severity.LS_WARNING = new org.webrtc.Logging$Severity("LS_WARNING", 3);
        org.webrtc.Logging$Severity.LS_ERROR = new org.webrtc.Logging$Severity("LS_ERROR", 4);
        org.webrtc.Logging$Severity.LS_NONE = new org.webrtc.Logging$Severity("LS_NONE", 5);
        org.webrtc.Logging$Severity[] v0_10 = new org.webrtc.Logging$Severity[6];
        v0_10[0] = org.webrtc.Logging$Severity.LS_SENSITIVE;
        v0_10[1] = org.webrtc.Logging$Severity.LS_VERBOSE;
        v0_10[2] = org.webrtc.Logging$Severity.LS_INFO;
        v0_10[3] = org.webrtc.Logging$Severity.LS_WARNING;
        v0_10[4] = org.webrtc.Logging$Severity.LS_ERROR;
        v0_10[5] = org.webrtc.Logging$Severity.LS_NONE;
        org.webrtc.Logging$Severity.$VALUES = v0_10;
        return;
    }

    private Logging$Severity(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.Logging$Severity valueOf(String p1)
    {
        return ((org.webrtc.Logging$Severity) Enum.valueOf(org.webrtc.Logging$Severity, p1));
    }

    public static org.webrtc.Logging$Severity[] values()
    {
        return ((org.webrtc.Logging$Severity[]) org.webrtc.Logging$Severity.$VALUES.clone());
    }
}
