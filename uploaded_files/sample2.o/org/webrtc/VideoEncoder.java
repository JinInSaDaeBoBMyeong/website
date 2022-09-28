package org.webrtc;
public interface VideoEncoder {

    public abstract org.webrtc.VideoCodecStatus encode();

    public abstract String getImplementationName();

    public abstract org.webrtc.VideoEncoder$ScalingSettings getScalingSettings();

    public abstract org.webrtc.VideoCodecStatus initEncode();

    public abstract org.webrtc.VideoCodecStatus release();

    public abstract org.webrtc.VideoCodecStatus setChannelParameters();

    public abstract org.webrtc.VideoCodecStatus setRateAllocation();
}
