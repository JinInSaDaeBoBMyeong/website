package org.webrtc;
public final enum class MediaCodecVideoEncoder$BitrateAdjustmentType extends java.lang.Enum {
    private static final synthetic org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType[] $VALUES;
    public static final enum org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType DYNAMIC_ADJUSTMENT;
    public static final enum org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType FRAMERATE_ADJUSTMENT;
    public static final enum org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType NO_ADJUSTMENT;

    static MediaCodecVideoEncoder$BitrateAdjustmentType()
    {
        org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT = new org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType("NO_ADJUSTMENT", 0);
        org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT = new org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType("FRAMERATE_ADJUSTMENT", 1);
        org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT = new org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType("DYNAMIC_ADJUSTMENT", 2);
        org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType[] v0_3 = new org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType[3];
        v0_3[0] = org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT;
        v0_3[1] = org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT;
        v0_3[2] = org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT;
        org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.$VALUES = v0_3;
        return;
    }

    private MediaCodecVideoEncoder$BitrateAdjustmentType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType valueOf(String p1)
    {
        return ((org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType) Enum.valueOf(org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType, p1));
    }

    public static org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType[] values()
    {
        return ((org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType[]) org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.$VALUES.clone());
    }
}
