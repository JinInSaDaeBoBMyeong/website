package org.webrtc;
public class VideoSource extends org.webrtc.MediaSource {

    public VideoSource(long p2)
    {
        super(p2);
        return;
    }

    private static native void nativeAdaptOutputFormat();

    public void adaptOutputFormat(int p3, int p4, int p5)
    {
        org.webrtc.VideoSource.nativeAdaptOutputFormat(this.nativeSource, p3, p4, p5);
        return;
    }
}
