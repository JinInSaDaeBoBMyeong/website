package org.webrtc;
 class WrappedNativeI420Buffer implements org.webrtc.VideoFrame$I420Buffer {
    private final java.nio.ByteBuffer dataU;
    private final java.nio.ByteBuffer dataV;
    private final java.nio.ByteBuffer dataY;
    private final int height;
    private final long nativeBuffer;
    private final int strideU;
    private final int strideV;
    private final int strideY;
    private final int width;

    WrappedNativeI420Buffer(int p2, int p3, java.nio.ByteBuffer p4, int p5, java.nio.ByteBuffer p6, int p7, java.nio.ByteBuffer p8, int p9, long p10)
    {
        this.width = p2;
        this.height = p3;
        this.dataY = p4;
        this.strideY = p5;
        this.dataU = p6;
        this.strideU = p7;
        this.dataV = p8;
        this.strideV = p9;
        this.nativeBuffer = p10;
        return;
    }

    private static native long nativeAddRef();

    private static native long nativeRelease();

    public java.nio.ByteBuffer getDataU()
    {
        return this.dataU;
    }

    public java.nio.ByteBuffer getDataV()
    {
        return this.dataV;
    }

    public java.nio.ByteBuffer getDataY()
    {
        return this.dataY;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getStrideU()
    {
        return this.strideU;
    }

    public int getStrideV()
    {
        return this.strideV;
    }

    public int getStrideY()
    {
        return this.strideY;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void release()
    {
        org.webrtc.WrappedNativeI420Buffer.nativeRelease(this.nativeBuffer);
        return;
    }

    public void retain()
    {
        org.webrtc.WrappedNativeI420Buffer.nativeAddRef(this.nativeBuffer);
        return;
    }

    public org.webrtc.VideoFrame$I420Buffer toI420()
    {
        return this;
    }
}
