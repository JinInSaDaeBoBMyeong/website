package org.webrtc;
public final enum class CameraSession$FailureType extends java.lang.Enum {
    private static final synthetic org.webrtc.CameraSession$FailureType[] $VALUES;
    public static final enum org.webrtc.CameraSession$FailureType DISCONNECTED;
    public static final enum org.webrtc.CameraSession$FailureType ERROR;

    static CameraSession$FailureType()
    {
        org.webrtc.CameraSession$FailureType.ERROR = new org.webrtc.CameraSession$FailureType("ERROR", 0);
        org.webrtc.CameraSession$FailureType.DISCONNECTED = new org.webrtc.CameraSession$FailureType("DISCONNECTED", 1);
        org.webrtc.CameraSession$FailureType[] v0_1 = new org.webrtc.CameraSession$FailureType[2];
        v0_1[0] = org.webrtc.CameraSession$FailureType.ERROR;
        v0_1[1] = org.webrtc.CameraSession$FailureType.DISCONNECTED;
        org.webrtc.CameraSession$FailureType.$VALUES = v0_1;
        return;
    }

    private CameraSession$FailureType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.CameraSession$FailureType valueOf(String p1)
    {
        return ((org.webrtc.CameraSession$FailureType) Enum.valueOf(org.webrtc.CameraSession$FailureType, p1));
    }

    public static org.webrtc.CameraSession$FailureType[] values()
    {
        return ((org.webrtc.CameraSession$FailureType[]) org.webrtc.CameraSession$FailureType.$VALUES.clone());
    }
}
