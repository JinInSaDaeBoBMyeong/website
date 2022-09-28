package org.webrtc;
public interface PeerConnection$Observer {

    public abstract void onAddStream();

    public abstract void onAddTrack();

    public abstract void onDataChannel();

    public abstract void onIceCandidate();

    public abstract void onIceCandidatesRemoved();

    public abstract void onIceConnectionChange();

    public abstract void onIceConnectionReceivingChange();

    public abstract void onIceGatheringChange();

    public abstract void onRemoveStream();

    public abstract void onRenegotiationNeeded();

    public abstract void onSignalingChange();
}
