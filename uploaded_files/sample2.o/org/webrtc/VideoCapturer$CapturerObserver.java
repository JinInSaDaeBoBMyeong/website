package org.webrtc;
public interface VideoCapturer$CapturerObserver {

    public abstract void onByteBufferFrameCaptured();

    public abstract void onCapturerStarted();

    public abstract void onCapturerStopped();

    public abstract void onTextureFrameCaptured();
}
