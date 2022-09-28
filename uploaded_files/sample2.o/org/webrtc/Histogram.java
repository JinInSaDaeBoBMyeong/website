package org.webrtc;
 class Histogram {
    private final long handle;

    private Histogram(long p2)
    {
        this.handle = p2;
        return;
    }

    public static org.webrtc.Histogram createCounts(String p4, int p5, int p6, int p7)
    {
        return new org.webrtc.Histogram(org.webrtc.Histogram.nativeCreateCounts(p4, p5, p6, p7));
    }

    public static org.webrtc.Histogram createEnumeration(String p4, int p5)
    {
        return new org.webrtc.Histogram(org.webrtc.Histogram.nativeCreateEnumeration(p4, p5));
    }

    private static native void nativeAddSample();

    private static native long nativeCreateCounts();

    private static native long nativeCreateEnumeration();

    public void addSample(int p3)
    {
        org.webrtc.Histogram.nativeAddSample(this.handle, p3);
        return;
    }
}
