package org.webrtc;
public class CallSessionFileRotatingLogSink {
    private long nativeSink;

    static CallSessionFileRotatingLogSink()
    {
        System.loadLibrary("jingle_peerconnection_so");
        return;
    }

    public CallSessionFileRotatingLogSink(String p3, int p4, org.webrtc.Logging$Severity p5)
    {
        this.nativeSink = org.webrtc.CallSessionFileRotatingLogSink.nativeAddSink(p3, p4, p5.ordinal());
        return;
    }

    public static byte[] getLogData(String p1)
    {
        return org.webrtc.CallSessionFileRotatingLogSink.nativeGetLogData(p1);
    }

    private static native long nativeAddSink();

    private static native void nativeDeleteSink();

    private static native byte[] nativeGetLogData();

    public void dispose()
    {
        if (this.nativeSink != 0) {
            org.webrtc.CallSessionFileRotatingLogSink.nativeDeleteSink(this.nativeSink);
            this.nativeSink = 0;
        }
        return;
    }
}
