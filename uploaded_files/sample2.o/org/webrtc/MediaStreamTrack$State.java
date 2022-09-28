package org.webrtc;
public final enum class MediaStreamTrack$State extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaStreamTrack$State[] $VALUES;
    public static final enum org.webrtc.MediaStreamTrack$State ENDED;
    public static final enum org.webrtc.MediaStreamTrack$State LIVE;

    static MediaStreamTrack$State()
    {
        org.webrtc.MediaStreamTrack$State.LIVE = new org.webrtc.MediaStreamTrack$State("LIVE", 0);
        org.webrtc.MediaStreamTrack$State.ENDED = new org.webrtc.MediaStreamTrack$State("ENDED", 1);
        org.webrtc.MediaStreamTrack$State[] v0_1 = new org.webrtc.MediaStreamTrack$State[2];
        v0_1[0] = org.webrtc.MediaStreamTrack$State.LIVE;
        v0_1[1] = org.webrtc.MediaStreamTrack$State.ENDED;
        org.webrtc.MediaStreamTrack$State.$VALUES = v0_1;
        return;
    }

    private MediaStreamTrack$State(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaStreamTrack$State valueOf(String p1)
    {
        return ((org.webrtc.MediaStreamTrack$State) Enum.valueOf(org.webrtc.MediaStreamTrack$State, p1));
    }

    public static org.webrtc.MediaStreamTrack$State[] values()
    {
        return ((org.webrtc.MediaStreamTrack$State[]) org.webrtc.MediaStreamTrack$State.$VALUES.clone());
    }
}
