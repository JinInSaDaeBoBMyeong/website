package org.webrtc;
public class MediaStreamTrack {
    final long nativeTrack;

    public MediaStreamTrack(long p2)
    {
        this.nativeTrack = p2;
        return;
    }

    private static native void free();

    private static native boolean nativeEnabled();

    private static native String nativeId();

    private static native String nativeKind();

    private static native boolean nativeSetEnabled();

    private static native org.webrtc.MediaStreamTrack$State nativeState();

    public void dispose()
    {
        org.webrtc.MediaStreamTrack.free(this.nativeTrack);
        return;
    }

    public boolean enabled()
    {
        return org.webrtc.MediaStreamTrack.nativeEnabled(this.nativeTrack);
    }

    public String id()
    {
        return org.webrtc.MediaStreamTrack.nativeId(this.nativeTrack);
    }

    public String kind()
    {
        return org.webrtc.MediaStreamTrack.nativeKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean p3)
    {
        return org.webrtc.MediaStreamTrack.nativeSetEnabled(this.nativeTrack, p3);
    }

    public org.webrtc.MediaStreamTrack$State state()
    {
        return org.webrtc.MediaStreamTrack.nativeState(this.nativeTrack);
    }
}
