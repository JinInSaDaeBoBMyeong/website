package org.webrtc;
public class EncodedImage {
    public final java.nio.ByteBuffer buffer;
    public final long captureTimeMs;
    public final boolean completeFrame;
    public final int encodedHeight;
    public final int encodedWidth;
    public final org.webrtc.EncodedImage$FrameType frameType;
    public final Integer qp;
    public final int rotation;

    private EncodedImage(java.nio.ByteBuffer p1, int p2, int p3, long p4, org.webrtc.EncodedImage$FrameType p6, int p7, boolean p8, Integer p9)
    {
        this.buffer = p1;
        this.encodedWidth = p2;
        this.encodedHeight = p3;
        this.captureTimeMs = p4;
        this.frameType = p6;
        this.rotation = p7;
        this.completeFrame = p8;
        this.qp = p9;
        return;
    }

    synthetic EncodedImage(java.nio.ByteBuffer p1, int p2, int p3, long p4, org.webrtc.EncodedImage$FrameType p6, int p7, boolean p8, Integer p9, org.webrtc.EncodedImage$1 p10)
    {
        this(p1, p2, p3, p4, p6, p7, p8, p9);
        return;
    }

    public static org.webrtc.EncodedImage$Builder builder()
    {
        return new org.webrtc.EncodedImage$Builder(0);
    }
}
