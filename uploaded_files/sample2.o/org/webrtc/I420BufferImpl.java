package org.webrtc;
 class I420BufferImpl implements org.webrtc.VideoFrame$I420Buffer {
    private final int height;
    private final int strideUV;
    private final java.nio.ByteBuffer u;
    private final java.nio.ByteBuffer v;
    private final int width;
    private final java.nio.ByteBuffer y;

    I420BufferImpl(int p3, int p4)
    {
        this.width = p3;
        this.height = p4;
        this.strideUV = ((p3 + 1) / 2);
        int v0 = ((p4 + 1) / 2);
        this.y = java.nio.ByteBuffer.allocateDirect((p3 * p4));
        this.u = java.nio.ByteBuffer.allocateDirect((this.strideUV * v0));
        this.v = java.nio.ByteBuffer.allocateDirect((this.strideUV * v0));
        return;
    }

    public java.nio.ByteBuffer getDataU()
    {
        return this.u;
    }

    public java.nio.ByteBuffer getDataV()
    {
        return this.v;
    }

    public java.nio.ByteBuffer getDataY()
    {
        return this.y;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getStrideU()
    {
        return this.strideUV;
    }

    public int getStrideV()
    {
        return this.strideUV;
    }

    public int getStrideY()
    {
        return this.width;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void release()
    {
        return;
    }

    public void retain()
    {
        return;
    }

    public org.webrtc.VideoFrame$I420Buffer toI420()
    {
        return this;
    }
}
