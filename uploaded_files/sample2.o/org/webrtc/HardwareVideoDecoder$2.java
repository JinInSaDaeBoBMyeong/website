package org.webrtc;
 class HardwareVideoDecoder$2 implements org.webrtc.VideoFrame$I420Buffer {
    private int refCount;
    final synthetic org.webrtc.HardwareVideoDecoder this$0;
    final synthetic java.nio.ByteBuffer val$buffer;
    final synthetic int val$chromaHeight;
    final synthetic int val$height;
    final synthetic int val$outputBufferIndex;
    final synthetic int val$stride;
    final synthetic int val$uPos;
    final synthetic int val$uvStride;
    final synthetic int val$vPos;
    final synthetic int val$width;
    final synthetic int val$yPos;

    HardwareVideoDecoder$2(org.webrtc.HardwareVideoDecoder p2, java.nio.ByteBuffer p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12)
    {
        this.this$0 = p2;
        this.val$buffer = p3;
        this.val$yPos = p4;
        this.val$height = p5;
        this.val$uPos = p6;
        this.val$chromaHeight = p7;
        this.val$vPos = p8;
        this.val$stride = p9;
        this.val$uvStride = p10;
        this.val$width = p11;
        this.val$outputBufferIndex = p12;
        this.refCount = 1;
        return;
    }

    public java.nio.ByteBuffer getDataU()
    {
        java.nio.ByteBuffer v0 = this.val$buffer.slice();
        v0.position(this.val$uPos);
        v0.limit((this.val$uPos + (this.getStrideU() * this.val$chromaHeight)));
        return v0;
    }

    public java.nio.ByteBuffer getDataV()
    {
        java.nio.ByteBuffer v0 = this.val$buffer.slice();
        v0.position(this.val$vPos);
        v0.limit((this.val$vPos + (this.getStrideV() * this.val$chromaHeight)));
        return v0;
    }

    public java.nio.ByteBuffer getDataY()
    {
        java.nio.ByteBuffer v0 = this.val$buffer.slice();
        v0.position(this.val$yPos);
        v0.limit((this.val$yPos + (this.getStrideY() * this.val$height)));
        return v0;
    }

    public int getHeight()
    {
        return this.val$height;
    }

    public int getStrideU()
    {
        return this.val$uvStride;
    }

    public int getStrideV()
    {
        return this.val$uvStride;
    }

    public int getStrideY()
    {
        return this.val$stride;
    }

    public int getWidth()
    {
        return this.val$width;
    }

    public void release()
    {
        this.refCount = (this.refCount - 1);
        try {
            if (this.refCount == 0) {
                org.webrtc.HardwareVideoDecoder.access$400(this.this$0).releaseOutputBuffer(this.val$outputBufferIndex, 0);
                org.webrtc.HardwareVideoDecoder.access$500(this.this$0);
                org.webrtc.HardwareVideoDecoder.access$610(this.this$0);
                org.webrtc.HardwareVideoDecoder.access$500(this.this$0).notifyAll();
            }
        } catch (Throwable v0_6) {
            throw v0_6;
        }
        return;
    }

    public void retain()
    {
        this.refCount = (this.refCount + 1);
        return;
    }

    public org.webrtc.VideoFrame$I420Buffer toI420()
    {
        return this;
    }
}
