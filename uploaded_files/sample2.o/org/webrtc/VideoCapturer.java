package org.webrtc;
public interface VideoCapturer {

    public abstract void changeCaptureFormat();

    public abstract void dispose();

    public abstract void initialize();

    public abstract boolean isScreencast();

    public abstract void startCapture();

    public abstract void stopCapture();
}
