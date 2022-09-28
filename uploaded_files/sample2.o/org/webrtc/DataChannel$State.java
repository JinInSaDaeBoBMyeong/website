package org.webrtc;
public final enum class DataChannel$State extends java.lang.Enum {
    private static final synthetic org.webrtc.DataChannel$State[] $VALUES;
    public static final enum org.webrtc.DataChannel$State CLOSED;
    public static final enum org.webrtc.DataChannel$State CLOSING;
    public static final enum org.webrtc.DataChannel$State CONNECTING;
    public static final enum org.webrtc.DataChannel$State OPEN;

    static DataChannel$State()
    {
        org.webrtc.DataChannel$State.CONNECTING = new org.webrtc.DataChannel$State("CONNECTING", 0);
        org.webrtc.DataChannel$State.OPEN = new org.webrtc.DataChannel$State("OPEN", 1);
        org.webrtc.DataChannel$State.CLOSING = new org.webrtc.DataChannel$State("CLOSING", 2);
        org.webrtc.DataChannel$State.CLOSED = new org.webrtc.DataChannel$State("CLOSED", 3);
        org.webrtc.DataChannel$State[] v0_6 = new org.webrtc.DataChannel$State[4];
        v0_6[0] = org.webrtc.DataChannel$State.CONNECTING;
        v0_6[1] = org.webrtc.DataChannel$State.OPEN;
        v0_6[2] = org.webrtc.DataChannel$State.CLOSING;
        v0_6[3] = org.webrtc.DataChannel$State.CLOSED;
        org.webrtc.DataChannel$State.$VALUES = v0_6;
        return;
    }

    private DataChannel$State(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.DataChannel$State valueOf(String p1)
    {
        return ((org.webrtc.DataChannel$State) Enum.valueOf(org.webrtc.DataChannel$State, p1));
    }

    public static org.webrtc.DataChannel$State[] values()
    {
        return ((org.webrtc.DataChannel$State[]) org.webrtc.DataChannel$State.$VALUES.clone());
    }
}
