package org.webrtc;
public interface VideoEncoderFactory {

    public abstract org.webrtc.VideoEncoder createEncoder();

    public abstract org.webrtc.VideoCodecInfo[] getSupportedCodecs();
}
