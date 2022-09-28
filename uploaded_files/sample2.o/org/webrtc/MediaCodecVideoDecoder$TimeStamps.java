package org.webrtc;
 class MediaCodecVideoDecoder$TimeStamps {
    private final long decodeStartTimeMs;
    private final long ntpTimeStampMs;
    private final long timeStampMs;

    public MediaCodecVideoDecoder$TimeStamps(long p2, long p4, long p6)
    {
        this.decodeStartTimeMs = p2;
        this.timeStampMs = p4;
        this.ntpTimeStampMs = p6;
        return;
    }

    static synthetic long access$600(org.webrtc.MediaCodecVideoDecoder$TimeStamps p2)
    {
        return p2.decodeStartTimeMs;
    }

    static synthetic long access$700(org.webrtc.MediaCodecVideoDecoder$TimeStamps p2)
    {
        return p2.timeStampMs;
    }

    static synthetic long access$800(org.webrtc.MediaCodecVideoDecoder$TimeStamps p2)
    {
        return p2.ntpTimeStampMs;
    }
}
