package org.webrtc;
final enum class Logging$NativeLibStatus extends java.lang.Enum {
    private static final synthetic org.webrtc.Logging$NativeLibStatus[] $VALUES;
    public static final enum org.webrtc.Logging$NativeLibStatus FAILED;
    public static final enum org.webrtc.Logging$NativeLibStatus LOADED;
    public static final enum org.webrtc.Logging$NativeLibStatus UNINITIALIZED;

    static Logging$NativeLibStatus()
    {
        org.webrtc.Logging$NativeLibStatus.UNINITIALIZED = new org.webrtc.Logging$NativeLibStatus("UNINITIALIZED", 0);
        org.webrtc.Logging$NativeLibStatus.LOADED = new org.webrtc.Logging$NativeLibStatus("LOADED", 1);
        org.webrtc.Logging$NativeLibStatus.FAILED = new org.webrtc.Logging$NativeLibStatus("FAILED", 2);
        org.webrtc.Logging$NativeLibStatus[] v0_3 = new org.webrtc.Logging$NativeLibStatus[3];
        v0_3[0] = org.webrtc.Logging$NativeLibStatus.UNINITIALIZED;
        v0_3[1] = org.webrtc.Logging$NativeLibStatus.LOADED;
        v0_3[2] = org.webrtc.Logging$NativeLibStatus.FAILED;
        org.webrtc.Logging$NativeLibStatus.$VALUES = v0_3;
        return;
    }

    private Logging$NativeLibStatus(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.Logging$NativeLibStatus valueOf(String p1)
    {
        return ((org.webrtc.Logging$NativeLibStatus) Enum.valueOf(org.webrtc.Logging$NativeLibStatus, p1));
    }

    public static org.webrtc.Logging$NativeLibStatus[] values()
    {
        return ((org.webrtc.Logging$NativeLibStatus[]) org.webrtc.Logging$NativeLibStatus.$VALUES.clone());
    }
}
