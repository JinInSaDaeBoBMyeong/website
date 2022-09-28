package org.webrtc;
public class VideoFrame {
    private final org.webrtc.VideoFrame$Buffer buffer;
    private final int rotation;
    private final long timestampNs;
    private final android.graphics.Matrix transformMatrix;

    public VideoFrame(org.webrtc.VideoFrame$Buffer p4, int p5, long p6, android.graphics.Matrix p8)
    {
        if (p4 != null) {
            if (p8 != null) {
                this.buffer = p4;
                this.rotation = p5;
                this.timestampNs = p6;
                this.transformMatrix = p8;
                return;
            } else {
                throw new IllegalArgumentException("transformMatrix not allowed to be null");
            }
        } else {
            throw new IllegalArgumentException("buffer not allowed to be null");
        }
    }

    public org.webrtc.VideoFrame$Buffer getBuffer()
    {
        return this.buffer;
    }

    public int getHeight()
    {
        return this.buffer.getHeight();
    }

    public int getRotation()
    {
        return this.rotation;
    }

    public long getTimestampNs()
    {
        return this.timestampNs;
    }

    public android.graphics.Matrix getTransformMatrix()
    {
        return this.transformMatrix;
    }

    public int getWidth()
    {
        return this.buffer.getWidth();
    }

    public void release()
    {
        this.buffer.release();
        return;
    }

    public void retain()
    {
        this.buffer.retain();
        return;
    }
}
