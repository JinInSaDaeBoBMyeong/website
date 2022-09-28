package org.webrtc;
public class DtmfSender {
    final long nativeDtmfSender;

    public DtmfSender(long p2)
    {
        this.nativeDtmfSender = p2;
        return;
    }

    private static native void free();

    private static native boolean nativeCanInsertDtmf();

    private static native int nativeDuration();

    private static native boolean nativeInsertDtmf();

    private static native int nativeInterToneGap();

    private static native String nativeTones();

    public boolean canInsertDtmf()
    {
        return org.webrtc.DtmfSender.nativeCanInsertDtmf(this.nativeDtmfSender);
    }

    public void dispose()
    {
        org.webrtc.DtmfSender.free(this.nativeDtmfSender);
        return;
    }

    public int duration()
    {
        return org.webrtc.DtmfSender.nativeDuration(this.nativeDtmfSender);
    }

    public boolean insertDtmf(String p3, int p4, int p5)
    {
        return org.webrtc.DtmfSender.nativeInsertDtmf(this.nativeDtmfSender, p3, p4, p5);
    }

    public int interToneGap()
    {
        return org.webrtc.DtmfSender.nativeInterToneGap(this.nativeDtmfSender);
    }

    public String tones()
    {
        return org.webrtc.DtmfSender.nativeTones(this.nativeDtmfSender);
    }
}
