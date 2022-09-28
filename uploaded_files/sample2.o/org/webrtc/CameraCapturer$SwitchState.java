package org.webrtc;
final enum class CameraCapturer$SwitchState extends java.lang.Enum {
    private static final synthetic org.webrtc.CameraCapturer$SwitchState[] $VALUES;
    public static final enum org.webrtc.CameraCapturer$SwitchState IDLE;
    public static final enum org.webrtc.CameraCapturer$SwitchState IN_PROGRESS;
    public static final enum org.webrtc.CameraCapturer$SwitchState PENDING;

    static CameraCapturer$SwitchState()
    {
        org.webrtc.CameraCapturer$SwitchState.IDLE = new org.webrtc.CameraCapturer$SwitchState("IDLE", 0);
        org.webrtc.CameraCapturer$SwitchState.PENDING = new org.webrtc.CameraCapturer$SwitchState("PENDING", 1);
        org.webrtc.CameraCapturer$SwitchState.IN_PROGRESS = new org.webrtc.CameraCapturer$SwitchState("IN_PROGRESS", 2);
        org.webrtc.CameraCapturer$SwitchState[] v0_3 = new org.webrtc.CameraCapturer$SwitchState[3];
        v0_3[0] = org.webrtc.CameraCapturer$SwitchState.IDLE;
        v0_3[1] = org.webrtc.CameraCapturer$SwitchState.PENDING;
        v0_3[2] = org.webrtc.CameraCapturer$SwitchState.IN_PROGRESS;
        org.webrtc.CameraCapturer$SwitchState.$VALUES = v0_3;
        return;
    }

    private CameraCapturer$SwitchState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.CameraCapturer$SwitchState valueOf(String p1)
    {
        return ((org.webrtc.CameraCapturer$SwitchState) Enum.valueOf(org.webrtc.CameraCapturer$SwitchState, p1));
    }

    public static org.webrtc.CameraCapturer$SwitchState[] values()
    {
        return ((org.webrtc.CameraCapturer$SwitchState[]) org.webrtc.CameraCapturer$SwitchState.$VALUES.clone());
    }
}
