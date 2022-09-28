package org.webrtc;
 class MediaCodecVideoDecoder$DecodedOutputBuffer {
    private final long decodeTimeMs;
    private final long endDecodeTimeMs;
    private final int index;
    private final long ntpTimeStampMs;
    private final int offset;
    private final long presentationTimeStampMs;
    private final int size;
    private final long timeStampMs;

    public MediaCodecVideoDecoder$DecodedOutputBuffer(int p1, int p2, int p3, long p4, long p6, long p8, long p10, long p12)
    {
        this.index = p1;
        this.offset = p2;
        this.size = p3;
        this.presentationTimeStampMs = p4;
        this.timeStampMs = p6;
        this.ntpTimeStampMs = p8;
        this.decodeTimeMs = p10;
        this.endDecodeTimeMs = p12;
        return;
    }

    static synthetic long access$100(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p2)
    {
        return p2.presentationTimeStampMs;
    }

    static synthetic long access$200(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p2)
    {
        return p2.timeStampMs;
    }

    static synthetic long access$300(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p2)
    {
        return p2.ntpTimeStampMs;
    }

    static synthetic long access$400(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p2)
    {
        return p2.decodeTimeMs;
    }

    static synthetic long access$500(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p2)
    {
        return p2.endDecodeTimeMs;
    }

    static synthetic int access$900(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer p1)
    {
        return p1.index;
    }
}
