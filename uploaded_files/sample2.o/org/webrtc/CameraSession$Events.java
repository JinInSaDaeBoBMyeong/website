package org.webrtc;
public interface CameraSession$Events {

    public abstract void onByteBufferFrameCaptured();

    public abstract void onCameraClosed();

    public abstract void onCameraDisconnected();

    public abstract void onCameraError();

    public abstract void onCameraOpening();

    public abstract void onTextureFrameCaptured();
}
