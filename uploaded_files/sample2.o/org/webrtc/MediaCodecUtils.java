package org.webrtc;
 class MediaCodecUtils {
    static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    static final int[] DECODER_COLOR_FORMATS = None;
    static final int[] ENCODER_COLOR_FORMATS = None;
    static final String EXYNOS_PREFIX = "OMX.Exynos.";
    static final String INTEL_PREFIX = "OMX.Intel.";
    static final String NVIDIA_PREFIX = "OMX.Nvidia.";
    static final String QCOM_PREFIX = "OMX.qcom.";
    private static final String TAG = "MediaCodecUtils";

    static MediaCodecUtils()
    {
        int[] v0_1 = new int[7];
        v0_1 = {19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876};
        org.webrtc.MediaCodecUtils.DECODER_COLOR_FORMATS = v0_1;
        int[] v0_3 = new int[4];
        v0_3 = {19, 21, 2141391872, 2141391876};
        org.webrtc.MediaCodecUtils.ENCODER_COLOR_FORMATS = v0_3;
        return;
    }

    private MediaCodecUtils()
    {
        return;
    }

    static boolean codecSupportsType(android.media.MediaCodecInfo p6, org.webrtc.VideoCodecType p7)
    {
        int v1 = 0;
        String[] v3 = p6.getSupportedTypes();
        int v2 = 0;
        while (v2 < v3.length) {
            if (!p7.mimeType().equals(v3[v2])) {
                v2++;
            } else {
                v1 = 1;
                break;
            }
        }
        return v1;
    }

    static Integer selectColorFormat(int[] p8, android.media.MediaCodecInfo$CodecCapabilities p9)
    {
        int v4 = 0;
        while (v4 < p8.length) {
            int[] v6 = p9.colorFormats;
            int v2_1 = 0;
            while (v2_1 < v6.length) {
                int v0 = v6[v2_1];
                if (v0 != p8[v4]) {
                    v2_1++;
                } else {
                    int v2_2 = Integer.valueOf(v0);
                }
                return v2_2;
            }
            v4++;
        }
        v2_2 = 0;
        return v2_2;
    }
}
