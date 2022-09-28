package org.webrtc;
synthetic class RendererCommon$1 {
    static final synthetic int[] $SwitchMap$org$webrtc$RendererCommon$ScalingType;

    static RendererCommon$1()
    {
        NoSuchFieldError v0_4 = new int[org.webrtc.RendererCommon$ScalingType.values().length];
        org.webrtc.RendererCommon$1.$SwitchMap$org$webrtc$RendererCommon$ScalingType = v0_4;
        try {
            org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FIT.ordinal()[int v1_5] = 1;
            try {
                org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_FILL.ordinal()[int v1_1] = 2;
                try {
                    org.webrtc.RendererCommon$ScalingType.SCALE_ASPECT_BALANCED.ordinal()[int v1_3] = 3;
                } catch (NoSuchFieldError v0) {
                }
                return;
            } catch (NoSuchFieldError v0) {
            }
        } catch (NoSuchFieldError v0) {
        }
    }
}
