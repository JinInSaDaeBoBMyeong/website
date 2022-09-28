package org.webrtc;
public final enum class VideoFrame$TextureBuffer$Type extends java.lang.Enum {
    private static final synthetic org.webrtc.VideoFrame$TextureBuffer$Type[] $VALUES;
    public static final enum org.webrtc.VideoFrame$TextureBuffer$Type OES;
    public static final enum org.webrtc.VideoFrame$TextureBuffer$Type RGB;

    static VideoFrame$TextureBuffer$Type()
    {
        org.webrtc.VideoFrame$TextureBuffer$Type.OES = new org.webrtc.VideoFrame$TextureBuffer$Type("OES", 0);
        org.webrtc.VideoFrame$TextureBuffer$Type.RGB = new org.webrtc.VideoFrame$TextureBuffer$Type("RGB", 1);
        org.webrtc.VideoFrame$TextureBuffer$Type[] v0_1 = new org.webrtc.VideoFrame$TextureBuffer$Type[2];
        v0_1[0] = org.webrtc.VideoFrame$TextureBuffer$Type.OES;
        v0_1[1] = org.webrtc.VideoFrame$TextureBuffer$Type.RGB;
        org.webrtc.VideoFrame$TextureBuffer$Type.$VALUES = v0_1;
        return;
    }

    private VideoFrame$TextureBuffer$Type(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.VideoFrame$TextureBuffer$Type valueOf(String p1)
    {
        return ((org.webrtc.VideoFrame$TextureBuffer$Type) Enum.valueOf(org.webrtc.VideoFrame$TextureBuffer$Type, p1));
    }

    public static org.webrtc.VideoFrame$TextureBuffer$Type[] values()
    {
        return ((org.webrtc.VideoFrame$TextureBuffer$Type[]) org.webrtc.VideoFrame$TextureBuffer$Type.$VALUES.clone());
    }
}
