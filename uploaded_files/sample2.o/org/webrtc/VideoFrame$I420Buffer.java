package org.webrtc;
public interface VideoFrame$I420Buffer implements org.webrtc.VideoFrame$Buffer {

    public abstract java.nio.ByteBuffer getDataU();

    public abstract java.nio.ByteBuffer getDataV();

    public abstract java.nio.ByteBuffer getDataY();

    public abstract int getStrideU();

    public abstract int getStrideV();

    public abstract int getStrideY();
}
