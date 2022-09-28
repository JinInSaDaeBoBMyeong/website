package org.webrtc;
public interface CameraVideoCapturer$CameraEventsHandler {

    public abstract void onCameraClosed();

    public abstract void onCameraDisconnected();

    public abstract void onCameraError();

    public abstract void onCameraFreezed();

    public abstract void onCameraOpening();

    public abstract void onFirstFrameAvailable();
}
