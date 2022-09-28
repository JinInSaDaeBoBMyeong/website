package org.webrtc;
public final enum class MediaCodecVideoEncoder$H264Profile extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaCodecVideoEncoder$H264Profile[] $VALUES;
    public static final enum org.webrtc.MediaCodecVideoEncoder$H264Profile BASELINE;
    public static final enum org.webrtc.MediaCodecVideoEncoder$H264Profile CONSTRAINED_BASELINE;
    public static final enum org.webrtc.MediaCodecVideoEncoder$H264Profile CONSTRAINED_HIGH;
    public static final enum org.webrtc.MediaCodecVideoEncoder$H264Profile HIGH;
    public static final enum org.webrtc.MediaCodecVideoEncoder$H264Profile MAIN;
    private final int value;

    static MediaCodecVideoEncoder$H264Profile()
    {
        org.webrtc.MediaCodecVideoEncoder$H264Profile.CONSTRAINED_BASELINE = new org.webrtc.MediaCodecVideoEncoder$H264Profile("CONSTRAINED_BASELINE", 0, 0);
        org.webrtc.MediaCodecVideoEncoder$H264Profile.BASELINE = new org.webrtc.MediaCodecVideoEncoder$H264Profile("BASELINE", 1, 1);
        org.webrtc.MediaCodecVideoEncoder$H264Profile.MAIN = new org.webrtc.MediaCodecVideoEncoder$H264Profile("MAIN", 2, 2);
        org.webrtc.MediaCodecVideoEncoder$H264Profile.CONSTRAINED_HIGH = new org.webrtc.MediaCodecVideoEncoder$H264Profile("CONSTRAINED_HIGH", 3, 3);
        org.webrtc.MediaCodecVideoEncoder$H264Profile.HIGH = new org.webrtc.MediaCodecVideoEncoder$H264Profile("HIGH", 4, 4);
        org.webrtc.MediaCodecVideoEncoder$H264Profile[] v0_8 = new org.webrtc.MediaCodecVideoEncoder$H264Profile[5];
        v0_8[0] = org.webrtc.MediaCodecVideoEncoder$H264Profile.CONSTRAINED_BASELINE;
        v0_8[1] = org.webrtc.MediaCodecVideoEncoder$H264Profile.BASELINE;
        v0_8[2] = org.webrtc.MediaCodecVideoEncoder$H264Profile.MAIN;
        v0_8[3] = org.webrtc.MediaCodecVideoEncoder$H264Profile.CONSTRAINED_HIGH;
        v0_8[4] = org.webrtc.MediaCodecVideoEncoder$H264Profile.HIGH;
        org.webrtc.MediaCodecVideoEncoder$H264Profile.$VALUES = v0_8;
        return;
    }

    private MediaCodecVideoEncoder$H264Profile(String p1, int p2, int p3)
    {
        super(p1, p2);
        super.value = p3;
        return;
    }

    public static org.webrtc.MediaCodecVideoEncoder$H264Profile valueOf(String p1)
    {
        return ((org.webrtc.MediaCodecVideoEncoder$H264Profile) Enum.valueOf(org.webrtc.MediaCodecVideoEncoder$H264Profile, p1));
    }

    public static org.webrtc.MediaCodecVideoEncoder$H264Profile[] values()
    {
        return ((org.webrtc.MediaCodecVideoEncoder$H264Profile[]) org.webrtc.MediaCodecVideoEncoder$H264Profile.$VALUES.clone());
    }

    public int getValue()
    {
        return this.value;
    }
}
