package org.webrtc;
public final enum class MediaStreamTrack$MediaType extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaStreamTrack$MediaType[] $VALUES;
    public static final enum org.webrtc.MediaStreamTrack$MediaType MEDIA_TYPE_AUDIO;
    public static final enum org.webrtc.MediaStreamTrack$MediaType MEDIA_TYPE_VIDEO;

    static MediaStreamTrack$MediaType()
    {
        org.webrtc.MediaStreamTrack$MediaType.MEDIA_TYPE_AUDIO = new org.webrtc.MediaStreamTrack$MediaType("MEDIA_TYPE_AUDIO", 0);
        org.webrtc.MediaStreamTrack$MediaType.MEDIA_TYPE_VIDEO = new org.webrtc.MediaStreamTrack$MediaType("MEDIA_TYPE_VIDEO", 1);
        org.webrtc.MediaStreamTrack$MediaType[] v0_1 = new org.webrtc.MediaStreamTrack$MediaType[2];
        v0_1[0] = org.webrtc.MediaStreamTrack$MediaType.MEDIA_TYPE_AUDIO;
        v0_1[1] = org.webrtc.MediaStreamTrack$MediaType.MEDIA_TYPE_VIDEO;
        org.webrtc.MediaStreamTrack$MediaType.$VALUES = v0_1;
        return;
    }

    private MediaStreamTrack$MediaType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaStreamTrack$MediaType valueOf(String p1)
    {
        return ((org.webrtc.MediaStreamTrack$MediaType) Enum.valueOf(org.webrtc.MediaStreamTrack$MediaType, p1));
    }

    public static org.webrtc.MediaStreamTrack$MediaType[] values()
    {
        return ((org.webrtc.MediaStreamTrack$MediaType[]) org.webrtc.MediaStreamTrack$MediaType.$VALUES.clone());
    }
}
