package org.webrtc;
public class HardwareVideoDecoderFactory implements org.webrtc.VideoDecoderFactory {
    private static final String TAG = "HardwareVideoDecoderFactory";

    public HardwareVideoDecoderFactory()
    {
        return;
    }

    private android.media.MediaCodecInfo findCodecForType(org.webrtc.VideoCodecType p7)
    {
        android.media.MediaCodecInfo v2;
        if (android.os.Build$VERSION.SDK_INT >= 19) {
            int v1 = 0;
            while (v1 < android.media.MediaCodecList.getCodecCount()) {
                try {
                    v2 = android.media.MediaCodecList.getCodecInfoAt(v1);
                } catch (IllegalArgumentException v0) {
                    org.webrtc.Logging.e("HardwareVideoDecoderFactory", "Cannot retrieve encoder codec info", v0);
                }
                if ((v2 == null) || ((v2.isEncoder()) || (!this.isSupportedCodec(v2, p7)))) {
                    v1++;
                }
            }
            v2 = 0;
        } else {
            v2 = 0;
        }
        return v2;
    }

    private boolean isHardwareSupported(android.media.MediaCodecInfo p6, org.webrtc.VideoCodecType p7)
    {
        int v1 = 0;
        String v0 = p6.getName();
        switch (org.webrtc.HardwareVideoDecoderFactory$1.$SwitchMap$org$webrtc$VideoCodecType[p7.ordinal()]) {
            case 1:
                if ((!v0.startsWith("OMX.qcom.")) && ((!v0.startsWith("OMX.Intel.")) && ((!v0.startsWith("OMX.Exynos.")) && (!v0.startsWith("OMX.Nvidia."))))) {
                } else {
                    v1 = 1;
                }
                break;
            case 2:
                if ((!v0.startsWith("OMX.qcom.")) && (!v0.startsWith("OMX.Exynos."))) {
                } else {
                    v1 = 1;
                }
                break;
            case 3:
                if ((!v0.startsWith("OMX.qcom.")) && ((!v0.startsWith("OMX.Intel.")) && (!v0.startsWith("OMX.Exynos.")))) {
                } else {
                    v1 = 1;
                }
                break;
        }
        return v1;
    }

    private boolean isSupportedCodec(android.media.MediaCodecInfo p4, org.webrtc.VideoCodecType p5)
    {
        boolean v0 = 0;
        if ((org.webrtc.MediaCodecUtils.codecSupportsType(p4, p5)) && (org.webrtc.MediaCodecUtils.selectColorFormat(org.webrtc.MediaCodecUtils.DECODER_COLOR_FORMATS, p4.getCapabilitiesForType(p5.mimeType())) != null)) {
            v0 = this.isHardwareSupported(p4, p5);
        }
        return v0;
    }

    public org.webrtc.VideoDecoder createDecoder(String p7)
    {
        org.webrtc.HardwareVideoDecoder v3_0;
        org.webrtc.VideoCodecType v2 = org.webrtc.VideoCodecType.valueOf(p7);
        android.media.MediaCodecInfo v1 = this.findCodecForType(v2);
        if (v1 != null) {
            v3_0 = new org.webrtc.HardwareVideoDecoder(v1.getName(), v2, org.webrtc.MediaCodecUtils.selectColorFormat(org.webrtc.MediaCodecUtils.DECODER_COLOR_FORMATS, v1.getCapabilitiesForType(v2.mimeType())).intValue());
        } else {
            v3_0 = 0;
        }
        return v3_0;
    }
}
