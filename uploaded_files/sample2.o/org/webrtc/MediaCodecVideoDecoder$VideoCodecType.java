package org.webrtc;
public final enum class MediaCodecVideoDecoder$VideoCodecType extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaCodecVideoDecoder$VideoCodecType[] $VALUES;
    public static final enum org.webrtc.MediaCodecVideoDecoder$VideoCodecType VIDEO_CODEC_H264;
    public static final enum org.webrtc.MediaCodecVideoDecoder$VideoCodecType VIDEO_CODEC_VP8;
    public static final enum org.webrtc.MediaCodecVideoDecoder$VideoCodecType VIDEO_CODEC_VP9;

    static MediaCodecVideoDecoder$VideoCodecType()
    {
        org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP8 = new org.webrtc.MediaCodecVideoDecoder$VideoCodecType("VIDEO_CODEC_VP8", 0);
        org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP9 = new org.webrtc.MediaCodecVideoDecoder$VideoCodecType("VIDEO_CODEC_VP9", 1);
        org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_H264 = new org.webrtc.MediaCodecVideoDecoder$VideoCodecType("VIDEO_CODEC_H264", 2);
        org.webrtc.MediaCodecVideoDecoder$VideoCodecType[] v0_3 = new org.webrtc.MediaCodecVideoDecoder$VideoCodecType[3];
        v0_3[0] = org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP8;
        v0_3[1] = org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP9;
        v0_3[2] = org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_H264;
        org.webrtc.MediaCodecVideoDecoder$VideoCodecType.$VALUES = v0_3;
        return;
    }

    private MediaCodecVideoDecoder$VideoCodecType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaCodecVideoDecoder$VideoCodecType valueOf(String p1)
    {
        return ((org.webrtc.MediaCodecVideoDecoder$VideoCodecType) Enum.valueOf(org.webrtc.MediaCodecVideoDecoder$VideoCodecType, p1));
    }

    public static org.webrtc.MediaCodecVideoDecoder$VideoCodecType[] values()
    {
        return ((org.webrtc.MediaCodecVideoDecoder$VideoCodecType[]) org.webrtc.MediaCodecVideoDecoder$VideoCodecType.$VALUES.clone());
    }
}
