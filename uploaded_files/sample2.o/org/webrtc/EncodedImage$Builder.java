package org.webrtc;
public class EncodedImage$Builder {
    private java.nio.ByteBuffer buffer;
    private long captureTimeMs;
    private boolean completeFrame;
    private int encodedHeight;
    private int encodedWidth;
    private org.webrtc.EncodedImage$FrameType frameType;
    private Integer qp;
    private int rotation;

    private EncodedImage$Builder()
    {
        return;
    }

    synthetic EncodedImage$Builder(org.webrtc.EncodedImage$1 p1)
    {
        return;
    }

    public org.webrtc.EncodedImage createEncodedImage()
    {
        return new org.webrtc.EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeMs, this.frameType, this.rotation, this.completeFrame, this.qp, 0);
    }

    public org.webrtc.EncodedImage$Builder setBuffer(java.nio.ByteBuffer p1)
    {
        this.buffer = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setCaptureTimeMs(long p2)
    {
        this.captureTimeMs = p2;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setCompleteFrame(boolean p1)
    {
        this.completeFrame = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setEncodedHeight(int p1)
    {
        this.encodedHeight = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setEncodedWidth(int p1)
    {
        this.encodedWidth = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setFrameType(org.webrtc.EncodedImage$FrameType p1)
    {
        this.frameType = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setQp(Integer p1)
    {
        this.qp = p1;
        return this;
    }

    public org.webrtc.EncodedImage$Builder setRotation(int p1)
    {
        this.rotation = p1;
        return this;
    }
}
