package org.webrtc;
synthetic class HardwareVideoEncoderFactory$1 {
    static final synthetic int[] $SwitchMap$org$webrtc$VideoCodecType;

    static HardwareVideoEncoderFactory$1()
    {
        NoSuchFieldError v0_4 = new int[org.webrtc.VideoCodecType.values().length];
        org.webrtc.HardwareVideoEncoderFactory$1.$SwitchMap$org$webrtc$VideoCodecType = v0_4;
        try {
            org.webrtc.VideoCodecType.VP8.ordinal()[int v1_5] = 1;
            try {
                org.webrtc.VideoCodecType.VP9.ordinal()[int v1_1] = 2;
                try {
                    org.webrtc.VideoCodecType.H264.ordinal()[int v1_3] = 3;
                } catch (NoSuchFieldError v0) {
                }
                return;
            } catch (NoSuchFieldError v0) {
            }
        } catch (NoSuchFieldError v0) {
        }
    }
}
