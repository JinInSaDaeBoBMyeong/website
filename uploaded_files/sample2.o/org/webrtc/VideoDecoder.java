package org.webrtc;
public interface VideoDecoder {

    public abstract org.webrtc.VideoCodecStatus decode();

    public abstract String getImplementationName();

    public abstract boolean getPrefersLateDecoding();

    public abstract org.webrtc.VideoCodecStatus initDecode();

    public abstract org.webrtc.VideoCodecStatus release();
}
