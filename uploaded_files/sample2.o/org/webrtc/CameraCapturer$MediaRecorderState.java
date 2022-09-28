package org.webrtc;
final enum class CameraCapturer$MediaRecorderState extends java.lang.Enum {
    private static final synthetic org.webrtc.CameraCapturer$MediaRecorderState[] $VALUES;
    public static final enum org.webrtc.CameraCapturer$MediaRecorderState ACTIVE;
    public static final enum org.webrtc.CameraCapturer$MediaRecorderState ACTIVE_TO_IDLE;
    public static final enum org.webrtc.CameraCapturer$MediaRecorderState IDLE;
    public static final enum org.webrtc.CameraCapturer$MediaRecorderState IDLE_TO_ACTIVE;

    static CameraCapturer$MediaRecorderState()
    {
        org.webrtc.CameraCapturer$MediaRecorderState.IDLE = new org.webrtc.CameraCapturer$MediaRecorderState("IDLE", 0);
        org.webrtc.CameraCapturer$MediaRecorderState.IDLE_TO_ACTIVE = new org.webrtc.CameraCapturer$MediaRecorderState("IDLE_TO_ACTIVE", 1);
        org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE_TO_IDLE = new org.webrtc.CameraCapturer$MediaRecorderState("ACTIVE_TO_IDLE", 2);
        org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE = new org.webrtc.CameraCapturer$MediaRecorderState("ACTIVE", 3);
        org.webrtc.CameraCapturer$MediaRecorderState[] v0_6 = new org.webrtc.CameraCapturer$MediaRecorderState[4];
        v0_6[0] = org.webrtc.CameraCapturer$MediaRecorderState.IDLE;
        v0_6[1] = org.webrtc.CameraCapturer$MediaRecorderState.IDLE_TO_ACTIVE;
        v0_6[2] = org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE_TO_IDLE;
        v0_6[3] = org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE;
        org.webrtc.CameraCapturer$MediaRecorderState.$VALUES = v0_6;
        return;
    }

    private CameraCapturer$MediaRecorderState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.CameraCapturer$MediaRecorderState valueOf(String p1)
    {
        return ((org.webrtc.CameraCapturer$MediaRecorderState) Enum.valueOf(org.webrtc.CameraCapturer$MediaRecorderState, p1));
    }

    public static org.webrtc.CameraCapturer$MediaRecorderState[] values()
    {
        return ((org.webrtc.CameraCapturer$MediaRecorderState[]) org.webrtc.CameraCapturer$MediaRecorderState.$VALUES.clone());
    }
}
