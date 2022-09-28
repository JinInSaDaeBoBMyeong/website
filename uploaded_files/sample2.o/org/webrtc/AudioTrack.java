package org.webrtc;
public class AudioTrack extends org.webrtc.MediaStreamTrack {

    public AudioTrack(long p2)
    {
        super(p2);
        return;
    }

    private static native void nativeSetVolume();

    public void setVolume(double p4)
    {
        org.webrtc.AudioTrack.nativeSetVolume(this.nativeTrack, p4);
        return;
    }
}
