package org.webrtc;
public interface CameraVideoCapturer implements org.webrtc.VideoCapturer {

    public abstract void addMediaRecorderToCamera();

    public abstract void removeMediaRecorderFromCamera();

    public abstract void switchCamera();
}
