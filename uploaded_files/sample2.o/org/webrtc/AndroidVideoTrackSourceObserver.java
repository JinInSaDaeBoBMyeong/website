package org.webrtc;
 class AndroidVideoTrackSourceObserver implements org.webrtc.VideoCapturer$CapturerObserver {
    private final long nativeSource;

    public AndroidVideoTrackSourceObserver(long p2)
    {
        this.nativeSource = p2;
        return;
    }

    private native void nativeCapturerStarted();

    private native void nativeCapturerStopped();

    private native void nativeOnByteBufferFrameCaptured();

    private native void nativeOnTextureFrameCaptured();

    public void onByteBufferFrameCaptured(byte[] p12, int p13, int p14, int p15, long p16)
    {
        this.nativeOnByteBufferFrameCaptured(this.nativeSource, p12, p12.length, p13, p14, p15, p16);
        return;
    }

    public void onCapturerStarted(boolean p3)
    {
        this.nativeCapturerStarted(this.nativeSource, p3);
        return;
    }

    public void onCapturerStopped()
    {
        this.nativeCapturerStopped(this.nativeSource);
        return;
    }

    public void onTextureFrameCaptured(int p11, int p12, int p13, float[] p14, int p15, long p16)
    {
        this.nativeOnTextureFrameCaptured(this.nativeSource, p11, p12, p13, p14, p15, p16);
        return;
    }
}
