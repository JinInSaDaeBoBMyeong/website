package org.webrtc;
 class VideoDecoderWrapperCallback implements org.webrtc.VideoDecoder$Callback {
    private final long nativeDecoder;

    public VideoDecoderWrapperCallback(long p2)
    {
        this.nativeDecoder = p2;
        return;
    }

    private static native void nativeOnDecodedFrame();

    public void onDecodedFrame(org.webrtc.VideoFrame p3, Integer p4, Integer p5)
    {
        org.webrtc.VideoDecoderWrapperCallback.nativeOnDecodedFrame(this.nativeDecoder, p3, p4, p5);
        return;
    }
}
