package org.webrtc;
public class MediaSource {
    final long nativeSource;

    public MediaSource(long p2)
    {
        this.nativeSource = p2;
        return;
    }

    private static native void free();

    private static native org.webrtc.MediaSource$State nativeState();

    public void dispose()
    {
        org.webrtc.MediaSource.free(this.nativeSource);
        return;
    }

    public org.webrtc.MediaSource$State state()
    {
        return org.webrtc.MediaSource.nativeState(this.nativeSource);
    }
}
