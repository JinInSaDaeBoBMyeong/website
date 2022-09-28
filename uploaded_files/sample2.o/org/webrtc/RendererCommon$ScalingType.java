package org.webrtc;
public final enum class RendererCommon$ScalingType extends java.lang.Enum {
    private static final synthetic org.webrtc.RendererCommon$ScalingType[] $VALUES;
    public static final enum org.webrtc.RendererCommon$ScalingType SCALE_ASPECT_BALANCED;
    public static final enum org.webrtc.RendererCommon$ScalingType SCALE_ASPECT_FILL;
    public static final enum org.webrtc.RendererCommon$ScalingType SCALE_ASPECT_FIT;

    static RendererCommon$ScalingType()
    {
        org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FIT = new org.webrtc.RendererCommon$ScalingType("SCALE_ASPECT_FIT", 0);
        org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FILL = new org.webrtc.RendererCommon$ScalingType("SCALE_ASPECT_FILL", 1);
        org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_BALANCED = new org.webrtc.RendererCommon$ScalingType("SCALE_ASPECT_BALANCED", 2);
        org.webrtc.RendererCommon$ScalingType[] v0_3 = new org.webrtc.RendererCommon$ScalingType[3];
        v0_3[0] = org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FIT;
        v0_3[1] = org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FILL;
        v0_3[2] = org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_BALANCED;
        org.webrtc.RendererCommon$ScalingType.$VALUES = v0_3;
        return;
    }

    private RendererCommon$ScalingType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.RendererCommon$ScalingType valueOf(String p1)
    {
        return ((org.webrtc.RendererCommon$ScalingType) Enum.valueOf(org.webrtc.RendererCommon$ScalingType, p1));
    }

    public static org.webrtc.RendererCommon$ScalingType[] values()
    {
        return ((org.webrtc.RendererCommon$ScalingType[]) org.webrtc.RendererCommon$ScalingType.$VALUES.clone());
    }
}
