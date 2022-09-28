package org.webrtc;
public interface CameraEnumerator {

    public abstract org.webrtc.CameraVideoCapturer createCapturer();

    public abstract String[] getDeviceNames();

    public abstract java.util.List getSupportedFormats();

    public abstract boolean isBackFacing();

    public abstract boolean isFrontFacing();
}
