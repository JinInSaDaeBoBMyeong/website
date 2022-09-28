package org.webrtc;
public class HardwareVideoEncoderFactory implements org.webrtc.VideoEncoderFactory {
    private static final String H264_CONSTRAINED_BASELINE_3_1 = "42001f";
    private static final String H264_CONSTRAINED_HIGH_3_1 = "640c1f";
    private static final String H264_FMTP_LEVEL_ASYMMETRY_ALLOWED = "level-asymmetry-allowed";
    private static final String H264_FMTP_PACKETIZATION_MODE = "packetization-mode";
    private static final String H264_FMTP_PROFILE_LEVEL_ID = "profile-level-id";
    private static final java.util.List H264_HW_EXCEPTION_MODELS = None;
    private static final String H264_LEVEL_3_1 = "1f";
    private static final String H264_PROFILE_CONSTRAINED_BASELINE = "4200";
    private static final String H264_PROFILE_CONSTRAINED_HIGH = "640c";
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HardwareVideoEncoderFactory";
    private final boolean enableH264HighProfile;
    private final boolean enableIntelVp8Encoder;

    static HardwareVideoEncoderFactory()
    {
        java.util.List v0_1 = new String[3];
        v0_1[0] = "SAMSUNG-SGH-I337";
        v0_1[1] = "Nexus 7";
        v0_1[2] = "Nexus 4";
        org.webrtc.HardwareVideoEncoderFactory.H264_HW_EXCEPTION_MODELS = java.util.Arrays.asList(v0_1);
        return;
    }

    public HardwareVideoEncoderFactory(boolean p1, boolean p2)
    {
        this.enableIntelVp8Encoder = p1;
        this.enableH264HighProfile = p2;
        return;
    }

    private org.webrtc.BitrateAdjuster createBitrateAdjuster(org.webrtc.VideoCodecType p2, String p3)
    {
        org.webrtc.FramerateBitrateAdjuster v0_2;
        if (!p3.startsWith("OMX.Exynos.")) {
            v0_2 = new org.webrtc.BaseBitrateAdjuster();
        } else {
            if (p2 != org.webrtc.VideoCodecType.VP8) {
                v0_2 = new org.webrtc.FramerateBitrateAdjuster();
            } else {
                v0_2 = new org.webrtc.DynamicBitrateAdjuster();
            }
        }
        return v0_2;
    }

    private android.media.MediaCodecInfo findCodecForType(org.webrtc.VideoCodecType p6)
    {
        int v1 = 0;
        while (v1 < android.media.MediaCodecList.getCodecCount()) {
            try {
                android.media.MediaCodecInfo v2 = android.media.MediaCodecList.getCodecInfoAt(v1);
            } catch (IllegalArgumentException v0) {
                org.webrtc.Logging.e("HardwareVideoEncoderFactory", "Cannot retrieve encoder codec info", v0);
            }
            if ((v2 == null) || ((!v2.isEncoder()) || (!this.isSupportedCodec(v2, p6)))) {
                v1++;
            }
            return v2;
        }
        v2 = 0;
        return v2;
    }

    private java.util.Map getCodecProperties(org.webrtc.VideoCodecType p5, boolean p6)
    {
        java.util.HashMap v0_1;
        switch (org.webrtc.HardwareVideoEncoderFactory$1.$SwitchMap$org$webrtc$VideoCodecType[p5.ordinal()]) {
            case 1:
            case 2:
                v0_1 = new java.util.HashMap();
                break;
            case 3:
                String v1_2;
                v0_1 = new java.util.HashMap();
                v0_1.put("level-asymmetry-allowed", "1");
                v0_1.put("packetization-mode", "1");
                if (!p6) {
                    v1_2 = "42001f";
                } else {
                    v1_2 = "640c1f";
                }
                v0_1.put("profile-level-id", v1_2);
                break;
            default:
                throw new IllegalArgumentException(new StringBuilder().append("Unsupported codec: ").append(p5).toString());
        }
        return v0_1;
    }

    private int getForcedKeyFrameIntervalMs(org.webrtc.VideoCodecType p5, String p6)
    {
        int v0 = 15000;
        if ((p5 != org.webrtc.VideoCodecType.VP8) || (!p6.startsWith("OMX.qcom."))) {
            v0 = 0;
        } else {
            if ((android.os.Build$VERSION.SDK_INT != 21) && (android.os.Build$VERSION.SDK_INT != 22)) {
                if (android.os.Build$VERSION.SDK_INT != 23) {
                    if (android.os.Build$VERSION.SDK_INT <= 23) {
                    }
                } else {
                    v0 = 20000;
                }
            }
        }
        return v0;
    }

    private int getKeyFrameIntervalSec(org.webrtc.VideoCodecType p4)
    {
        int v0_3;
        switch (org.webrtc.HardwareVideoEncoderFactory$1.$SwitchMap$org$webrtc$VideoCodecType[p4.ordinal()]) {
            case 1:
            case 2:
                v0_3 = 100;
                break;
            case 3:
                v0_3 = 20;
                break;
            default:
                throw new IllegalArgumentException(new StringBuilder().append("Unsupported VideoCodecType ").append(p4).toString());
        }
        return v0_3;
    }

    private boolean isH264HighProfileSupported(android.media.MediaCodecInfo p3)
    {
        if ((!this.enableH264HighProfile) || (!p3.getName().startsWith("OMX.qcom."))) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    private boolean isHardwareSupportedInCurrentSdk(android.media.MediaCodecInfo p3, org.webrtc.VideoCodecType p4)
    {
        boolean v0_1;
        switch (org.webrtc.HardwareVideoEncoderFactory$1.$SwitchMap$org$webrtc$VideoCodecType[p4.ordinal()]) {
            case 1:
                v0_1 = this.isHardwareSupportedInCurrentSdkVp8(p3);
                break;
            case 2:
                v0_1 = this.isHardwareSupportedInCurrentSdkVp9(p3);
                break;
            case 3:
                v0_1 = this.isHardwareSupportedInCurrentSdkH264(p3);
                break;
            default:
                v0_1 = 0;
        }
        return v0_1;
    }

    private boolean isHardwareSupportedInCurrentSdkH264(android.media.MediaCodecInfo p5)
    {
        int v1 = 0;
        if (!org.webrtc.HardwareVideoEncoderFactory.H264_HW_EXCEPTION_MODELS.contains(android.os.Build.MODEL)) {
            String v0 = p5.getName();
            if (((v0.startsWith("OMX.qcom.")) && (android.os.Build$VERSION.SDK_INT >= 19)) || ((v0.startsWith("OMX.Exynos.")) && (android.os.Build$VERSION.SDK_INT >= 21))) {
                v1 = 1;
            }
        }
        return v1;
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(android.media.MediaCodecInfo p4)
    {
        boolean v1_7;
        String v0 = p4.getName();
        if (((!v0.startsWith("OMX.qcom.")) || (android.os.Build$VERSION.SDK_INT < 19)) && (((!v0.startsWith("OMX.Exynos.")) || (android.os.Build$VERSION.SDK_INT < 23)) && ((!v0.startsWith("OMX.Intel.")) || ((android.os.Build$VERSION.SDK_INT < 21) || (!this.enableIntelVp8Encoder))))) {
            v1_7 = 0;
        } else {
            v1_7 = 1;
        }
        return v1_7;
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(android.media.MediaCodecInfo p4)
    {
        int v1_1;
        String v0 = p4.getName();
        if (((!v0.startsWith("OMX.qcom.")) && (!v0.startsWith("OMX.Exynos."))) || (android.os.Build$VERSION.SDK_INT < 24)) {
            v1_1 = 0;
        } else {
            v1_1 = 1;
        }
        return v1_1;
    }

    private boolean isSupportedCodec(android.media.MediaCodecInfo p4, org.webrtc.VideoCodecType p5)
    {
        boolean v0 = 0;
        if ((org.webrtc.MediaCodecUtils.codecSupportsType(p4, p5)) && (org.webrtc.MediaCodecUtils.selectColorFormat(org.webrtc.MediaCodecUtils.ENCODER_COLOR_FORMATS, p4.getCapabilitiesForType(p5.mimeType())) != null)) {
            v0 = this.isHardwareSupportedInCurrentSdk(p4, p5);
        }
        return v0;
    }

    public org.webrtc.VideoEncoder createEncoder(org.webrtc.VideoCodecInfo p10)
    {
        org.webrtc.HardwareVideoEncoder v0_4;
        org.webrtc.VideoCodecType v2 = org.webrtc.VideoCodecType.valueOf(p10.name);
        android.media.MediaCodecInfo v7 = this.findCodecForType(v2);
        if (v7 != null) {
            String v1 = v7.getName();
            v0_4 = new org.webrtc.HardwareVideoEncoder(v1, v2, org.webrtc.MediaCodecUtils.selectColorFormat(org.webrtc.MediaCodecUtils.ENCODER_COLOR_FORMATS, v7.getCapabilitiesForType(v2.mimeType())).intValue(), this.getKeyFrameIntervalSec(v2), this.getForcedKeyFrameIntervalMs(v2, v1), this.createBitrateAdjuster(v2, v1));
        } else {
            v0_4 = 0;
        }
        return v0_4;
    }

    public org.webrtc.VideoCodecInfo[] getSupportedCodecs()
    {
        java.util.ArrayList v2_1 = new java.util.ArrayList();
        org.webrtc.VideoCodecType[] v6 = new org.webrtc.VideoCodecType[3];
        v6[0] = org.webrtc.VideoCodecType.VP8;
        v6[1] = org.webrtc.VideoCodecType.VP9;
        v6[2] = org.webrtc.VideoCodecType.H264;
        int v7_1 = v6.length;
        int v4_1 = 0;
        while (v4_1 < v7_1) {
            org.webrtc.VideoCodecType v3 = v6[v4_1];
            android.media.MediaCodecInfo v0 = this.findCodecForType(v3);
            if (v0 != null) {
                String v1 = v3.name();
                if ((v3 == org.webrtc.VideoCodecType.H264) && (this.isH264HighProfileSupported(v0))) {
                    v2_1.add(new org.webrtc.VideoCodecInfo(0, v1, this.getCodecProperties(v3, 1)));
                }
                v2_1.add(new org.webrtc.VideoCodecInfo(0, v1, this.getCodecProperties(v3, 0)));
            }
            v4_1++;
        }
        int v4_3 = new org.webrtc.VideoCodecInfo[v2_1.size()];
        return ((org.webrtc.VideoCodecInfo[]) v2_1.toArray(v4_3));
    }
}
