package org.webrtc;
public interface VideoFrame$TextureBuffer implements org.webrtc.VideoFrame$Buffer {

    public abstract int getTextureId();

    public abstract org.webrtc.VideoFrame$TextureBuffer$Type getType();
}
