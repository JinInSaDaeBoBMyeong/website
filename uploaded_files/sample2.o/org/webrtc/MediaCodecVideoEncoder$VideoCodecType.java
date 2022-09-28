package org.webrtc;
public final enum class MediaCodecVideoEncoder$VideoCodecType extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaCodecVideoEncoder$VideoCodecType[] $VALUES;
    public static final enum org.webrtc.MediaCodecVideoEncoder$VideoCodecType VIDEO_CODEC_H264;
    public static final enum org.webrtc.MediaCodecVideoEncoder$VideoCodecType VIDEO_CODEC_VP8;
    public static final enum org.webrtc.MediaCodecVideoEncoder$VideoCodecType VIDEO_CODEC_VP9;

    static MediaCodecVideoEncoder$VideoCodecType()
    {
        org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP8 = new org.webrtc.MediaCodecVideoEncoder$VideoCodecType("VIDEO_CODEC_VP8", 0);
        org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP9 = new org.webrtc.MediaCodecVideoEncoder$VideoCodecType("VIDEO_CODEC_VP9", 1);
        org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_H264 = new org.webrtc.MediaCodecVideoEncoder$VideoCodecType("VIDEO_CODEC_H264", 2);
        org.webrtc.MediaCodecVideoEncoder$VideoCodecType[] v0_3 = new org.webrtc.MediaCodecVideoEncoder$VideoCodecType[3];
        v0_3[0] = org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP8;
        v0_3[1] = org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP9;
        v0_3[2] = org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_H264;
        org.webrtc.MediaCodecVideoEncoder$VideoCodecType.$VALUES = v0_3;
        return;
    }

    private MediaCodecVideoEncoder$VideoCodecType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaCodecVideoEncoder$VideoCodecType valueOf(String p1)
    {
        return ((org.webrtc.MediaCodecVideoEncoder$VideoCodecType) Enum.valueOf(org.webrtc.MediaCodecVideoEncoder$VideoCodecType, p1));
    }

    public static org.webrtc.MediaCodecVideoEncoder$VideoCodecType[] values()
    {
        return ((org.webrtc.MediaCodecVideoEncoder$VideoCodecType[]) org.webrtc.MediaCodecVideoEncoder$VideoCodecType.$VALUES.clone());
    }
}
