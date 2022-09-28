package org.webrtc;
 class MediaCodecVideoEncoder$OutputBufferInfo {
    public final java.nio.ByteBuffer buffer;
    public final int index;
    public final boolean isKeyFrame;
    public final long presentationTimestampUs;

    public MediaCodecVideoEncoder$OutputBufferInfo(int p1, java.nio.ByteBuffer p2, boolean p3, long p4)
    {
        this.index = p1;
        this.buffer = p2;
        this.isKeyFrame = p3;
        this.presentationTimestampUs = p4;
        return;
    }
}
