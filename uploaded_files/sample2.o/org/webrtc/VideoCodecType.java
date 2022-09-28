package org.webrtc;
final enum class VideoCodecType extends java.lang.Enum {
    private static final synthetic org.webrtc.VideoCodecType[] $VALUES;
    public static final enum org.webrtc.VideoCodecType H264;
    public static final enum org.webrtc.VideoCodecType VP8;
    public static final enum org.webrtc.VideoCodecType VP9;
    private final String mimeType;

    static VideoCodecType()
    {
        org.webrtc.VideoCodecType.VP8 = new org.webrtc.VideoCodecType("VP8", 0, "video/x-vnd.on2.vp8");
        org.webrtc.VideoCodecType.VP9 = new org.webrtc.VideoCodecType("VP9", 1, "video/x-vnd.on2.vp9");
        org.webrtc.VideoCodecType.H264 = new org.webrtc.VideoCodecType("H264", 2, "video/avc");
        org.webrtc.VideoCodecType[] v0_4 = new org.webrtc.VideoCodecType[3];
        v0_4[0] = org.webrtc.VideoCodecType.VP8;
        v0_4[1] = org.webrtc.VideoCodecType.VP9;
        v0_4[2] = org.webrtc.VideoCodecType.H264;
        org.webrtc.VideoCodecType.$VALUES = v0_4;
        return;
    }

    private VideoCodecType(String p1, int p2, String p3)
    {
        super(p1, p2);
        super.mimeType = p3;
        return;
    }

    public static org.webrtc.VideoCodecType valueOf(String p1)
    {
        return ((org.webrtc.VideoCodecType) Enum.valueOf(org.webrtc.VideoCodecType, p1));
    }

    public static org.webrtc.VideoCodecType[] values()
    {
        return ((org.webrtc.VideoCodecType[]) org.webrtc.VideoCodecType.$VALUES.clone());
    }

    String mimeType()
    {
        return this.mimeType;
    }
}
