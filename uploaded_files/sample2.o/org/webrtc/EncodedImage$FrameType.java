package org.webrtc;
public final enum class EncodedImage$FrameType extends java.lang.Enum {
    private static final synthetic org.webrtc.EncodedImage$FrameType[] $VALUES;
    public static final enum org.webrtc.EncodedImage$FrameType EmptyFrame;
    public static final enum org.webrtc.EncodedImage$FrameType VideoFrameDelta;
    public static final enum org.webrtc.EncodedImage$FrameType VideoFrameKey;

    static EncodedImage$FrameType()
    {
        org.webrtc.EncodedImage$FrameType.EmptyFrame = new org.webrtc.EncodedImage$FrameType("EmptyFrame", 0);
        org.webrtc.EncodedImage$FrameType.VideoFrameKey = new org.webrtc.EncodedImage$FrameType("VideoFrameKey", 1);
        org.webrtc.EncodedImage$FrameType.VideoFrameDelta = new org.webrtc.EncodedImage$FrameType("VideoFrameDelta", 2);
        org.webrtc.EncodedImage$FrameType[] v0_3 = new org.webrtc.EncodedImage$FrameType[3];
        v0_3[0] = org.webrtc.EncodedImage$FrameType.EmptyFrame;
        v0_3[1] = org.webrtc.EncodedImage$FrameType.VideoFrameKey;
        v0_3[2] = org.webrtc.EncodedImage$FrameType.VideoFrameDelta;
        org.webrtc.EncodedImage$FrameType.$VALUES = v0_3;
        return;
    }

    private EncodedImage$FrameType(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.EncodedImage$FrameType valueOf(String p1)
    {
        return ((org.webrtc.EncodedImage$FrameType) Enum.valueOf(org.webrtc.EncodedImage$FrameType, p1));
    }

    public static org.webrtc.EncodedImage$FrameType[] values()
    {
        return ((org.webrtc.EncodedImage$FrameType[]) org.webrtc.EncodedImage$FrameType.$VALUES.clone());
    }
}
