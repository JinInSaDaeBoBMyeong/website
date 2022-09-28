package org.webrtc;
public class RtpSender {
    private org.webrtc.MediaStreamTrack cachedTrack;
    private final org.webrtc.DtmfSender dtmfSender;
    final long nativeRtpSender;
    private boolean ownsTrack;

    public RtpSender(long p10)
    {
        long v4_0;
        org.webrtc.DtmfSender v5_0 = 0;
        this.ownsTrack = 1;
        this.nativeRtpSender = p10;
        long v2 = org.webrtc.RtpSender.nativeGetTrack(p10);
        if (v2 == 0) {
            v4_0 = 0;
        } else {
            v4_0 = new org.webrtc.MediaStreamTrack(v2);
        }
        this.cachedTrack = v4_0;
        long v0 = org.webrtc.RtpSender.nativeGetDtmfSender(p10);
        if (v0 != 0) {
            v5_0 = new org.webrtc.DtmfSender(v0);
        }
        this.dtmfSender = v5_0;
        return;
    }

    private static native void free();

    private static native long nativeGetDtmfSender();

    private static native org.webrtc.RtpParameters nativeGetParameters();

    private static native long nativeGetTrack();

    private static native String nativeId();

    private static native boolean nativeSetParameters();

    private static native boolean nativeSetTrack();

    public void dispose()
    {
        if (this.dtmfSender != null) {
            this.dtmfSender.dispose();
        }
        if ((this.cachedTrack != null) && (this.ownsTrack)) {
            this.cachedTrack.dispose();
        }
        org.webrtc.RtpSender.free(this.nativeRtpSender);
        return;
    }

    public org.webrtc.DtmfSender dtmf()
    {
        return this.dtmfSender;
    }

    public org.webrtc.RtpParameters getParameters()
    {
        return org.webrtc.RtpSender.nativeGetParameters(this.nativeRtpSender);
    }

    public String id()
    {
        return org.webrtc.RtpSender.nativeId(this.nativeRtpSender);
    }

    public boolean setParameters(org.webrtc.RtpParameters p3)
    {
        return org.webrtc.RtpSender.nativeSetParameters(this.nativeRtpSender, p3);
    }

    public boolean setTrack(org.webrtc.MediaStreamTrack p5, boolean p6)
    {
        org.webrtc.MediaStreamTrack v0_2;
        if (p5 != null) {
            v0_2 = p5.nativeTrack;
        } else {
            v0_2 = 0;
        }
        org.webrtc.MediaStreamTrack v0_1;
        if (org.webrtc.RtpSender.nativeSetTrack(this.nativeRtpSender, v0_2)) {
            if ((this.cachedTrack != null) && (this.ownsTrack)) {
                this.cachedTrack.dispose();
            }
            this.cachedTrack = p5;
            this.ownsTrack = p6;
            v0_1 = 1;
        } else {
            v0_1 = 0;
        }
        return v0_1;
    }

    public org.webrtc.MediaStreamTrack track()
    {
        return this.cachedTrack;
    }
}
