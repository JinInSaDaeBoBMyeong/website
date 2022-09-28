package org.webrtc;
public interface VideoFrame$Buffer {

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract void release();

    public abstract void retain();

    public abstract org.webrtc.VideoFrame$I420Buffer toI420();
}
