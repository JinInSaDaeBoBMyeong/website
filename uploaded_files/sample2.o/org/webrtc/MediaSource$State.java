package org.webrtc;
public final enum class MediaSource$State extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaSource$State[] $VALUES;
    public static final enum org.webrtc.MediaSource$State ENDED;
    public static final enum org.webrtc.MediaSource$State INITIALIZING;
    public static final enum org.webrtc.MediaSource$State LIVE;
    public static final enum org.webrtc.MediaSource$State MUTED;

    static MediaSource$State()
    {
        org.webrtc.MediaSource$State.INITIALIZING = new org.webrtc.MediaSource$State("INITIALIZING", 0);
        org.webrtc.MediaSource$State.LIVE = new org.webrtc.MediaSource$State("LIVE", 1);
        org.webrtc.MediaSource$State.ENDED = new org.webrtc.MediaSource$State("ENDED", 2);
        org.webrtc.MediaSource$State.MUTED = new org.webrtc.MediaSource$State("MUTED", 3);
        org.webrtc.MediaSource$State[] v0_6 = new org.webrtc.MediaSource$State[4];
        v0_6[0] = org.webrtc.MediaSource$State.INITIALIZING;
        v0_6[1] = org.webrtc.MediaSource$State.LIVE;
        v0_6[2] = org.webrtc.MediaSource$State.ENDED;
        v0_6[3] = org.webrtc.MediaSource$State.MUTED;
        org.webrtc.MediaSource$State.$VALUES = v0_6;
        return;
    }

    private MediaSource$State(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaSource$State valueOf(String p1)
    {
        return ((org.webrtc.MediaSource$State) Enum.valueOf(org.webrtc.MediaSource$State, p1));
    }

    public static org.webrtc.MediaSource$State[] values()
    {
        return ((org.webrtc.MediaSource$State[]) org.webrtc.MediaSource$State.$VALUES.clone());
    }
}
