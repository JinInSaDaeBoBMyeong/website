package org.webrtc;
public class RtpReceiver {
    private org.webrtc.MediaStreamTrack cachedTrack;
    private long nativeObserver;
    final long nativeRtpReceiver;

    public RtpReceiver(long p4)
    {
        this.nativeRtpReceiver = p4;
        this.cachedTrack = new org.webrtc.MediaStreamTrack(org.webrtc.RtpReceiver.nativeGetTrack(p4));
        return;
    }

    private static native void free();

    private static native org.webrtc.RtpParameters nativeGetParameters();

    private static native long nativeGetTrack();

    private static native String nativeId();

    private static native long nativeSetObserver();

    private static native boolean nativeSetParameters();

    private static native long nativeUnsetObserver();

    public void SetObserver(org.webrtc.RtpReceiver$Observer p5)
    {
        if (this.nativeObserver != 0) {
            org.webrtc.RtpReceiver.nativeUnsetObserver(this.nativeRtpReceiver, this.nativeObserver);
        }
        this.nativeObserver = org.webrtc.RtpReceiver.nativeSetObserver(this.nativeRtpReceiver, p5);
        return;
    }

    public void dispose()
    {
        this.cachedTrack.dispose();
        if (this.nativeObserver != 0) {
            org.webrtc.RtpReceiver.nativeUnsetObserver(this.nativeRtpReceiver, this.nativeObserver);
            this.nativeObserver = 0;
        }
        org.webrtc.RtpReceiver.free(this.nativeRtpReceiver);
        return;
    }

    public org.webrtc.RtpParameters getParameters()
    {
        return org.webrtc.RtpReceiver.nativeGetParameters(this.nativeRtpReceiver);
    }

    public String id()
    {
        return org.webrtc.RtpReceiver.nativeId(this.nativeRtpReceiver);
    }

    public boolean setParameters(org.webrtc.RtpParameters p3)
    {
        return org.webrtc.RtpReceiver.nativeSetParameters(this.nativeRtpReceiver, p3);
    }

    public org.webrtc.MediaStreamTrack track()
    {
        return this.cachedTrack;
    }
}
