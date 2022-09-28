package org.webrtc;
final enum class Camera1Session$SessionState extends java.lang.Enum {
    private static final synthetic org.webrtc.Camera1Session$SessionState[] $VALUES;
    public static final enum org.webrtc.Camera1Session$SessionState RUNNING;
    public static final enum org.webrtc.Camera1Session$SessionState STOPPED;

    static Camera1Session$SessionState()
    {
        org.webrtc.Camera1Session$SessionState.RUNNING = new org.webrtc.Camera1Session$SessionState("RUNNING", 0);
        org.webrtc.Camera1Session$SessionState.STOPPED = new org.webrtc.Camera1Session$SessionState("STOPPED", 1);
        org.webrtc.Camera1Session$SessionState[] v0_1 = new org.webrtc.Camera1Session$SessionState[2];
        v0_1[0] = org.webrtc.Camera1Session$SessionState.RUNNING;
        v0_1[1] = org.webrtc.Camera1Session$SessionState.STOPPED;
        org.webrtc.Camera1Session$SessionState.$VALUES = v0_1;
        return;
    }

    private Camera1Session$SessionState(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.Camera1Session$SessionState valueOf(String p1)
    {
        return ((org.webrtc.Camera1Session$SessionState) Enum.valueOf(org.webrtc.Camera1Session$SessionState, p1));
    }

    public static org.webrtc.Camera1Session$SessionState[] values()
    {
        return ((org.webrtc.Camera1Session$SessionState[]) org.webrtc.Camera1Session$SessionState.$VALUES.clone());
    }
}
