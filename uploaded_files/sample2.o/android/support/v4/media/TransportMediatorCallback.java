package android.support.v4.media;
interface TransportMediatorCallback {

    public abstract long getPlaybackPosition();

    public abstract void handleAudioFocusChange();

    public abstract void handleKey();

    public abstract void playbackPositionUpdate();
}
