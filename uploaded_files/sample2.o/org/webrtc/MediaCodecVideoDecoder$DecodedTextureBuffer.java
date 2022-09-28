package org.webrtc;
 class MediaCodecVideoDecoder$DecodedTextureBuffer {
    private final long decodeTimeMs;
    private final long frameDelayMs;
    private final long ntpTimeStampMs;
    private final long presentationTimeStampMs;
    private final int textureID;
    private final long timeStampMs;
    private final float[] transformMatrix;

    public MediaCodecVideoDecoder$DecodedTextureBuffer(int p2, float[] p3, long p4, long p6, long p8, long p10, long p12)
    {
        this.textureID = p2;
        this.transformMatrix = p3;
        this.presentationTimeStampMs = p4;
        this.timeStampMs = p6;
        this.ntpTimeStampMs = p8;
        this.decodeTimeMs = p10;
        this.frameDelayMs = p12;
        return;
    }
}
