package org.webrtc;
public interface SdpObserver {

    public abstract void onCreateFailure();

    public abstract void onCreateSuccess();

    public abstract void onSetFailure();

    public abstract void onSetSuccess();
}
