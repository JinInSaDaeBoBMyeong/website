package org.webrtc;
public class MediaCodecVideoEncoder {
    private static final int BITRATE_ADJUSTMENT_FPS = 30;
    private static final double BITRATE_CORRECTION_MAX_SCALE = 16400;
    private static final double BITRATE_CORRECTION_SEC = 16392;
    private static final int BITRATE_CORRECTION_STEPS = 20;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_HW_EXCEPTION_MODELS = None;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final int MAXIMUM_INITIAL_FPS = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final long QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_AVCLevel3 = 256;
    private static final int VIDEO_AVCProfileHigh = 8;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static org.webrtc.MediaCodecVideoEncoder$MediaCodecVideoEncoderErrorCallback errorCallback;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties exynosH264HighProfileHwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties exynosH264HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties exynosVp8HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties exynosVp9HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] h264HighProfileHwList;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] h264HwList;
    private static java.util.Set hwEncoderDisabledTypes;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties intelVp8HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties qcomH264HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties qcomVp8HwProperties;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties qcomVp9HwProperties;
    private static org.webrtc.MediaCodecVideoEncoder runningInstance;
    private static final int[] supportedColorList;
    private static final int[] supportedSurfaceColorList;
    private static final org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] vp9HwList;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType bitrateAdjustmentType;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    private java.nio.ByteBuffer configData;
    private org.webrtc.GlRectDrawer drawer;
    private org.webrtc.EglBase14 eglBase;
    private long forcedKeyFrameMs;
    private int height;
    private android.view.Surface inputSurface;
    private long lastKeyFrameMs;
    private android.media.MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private java.nio.ByteBuffer[] outputBuffers;
    private int profile;
    private int targetBitrateBps;
    private int targetFps;
    private org.webrtc.MediaCodecVideoEncoder$VideoCodecType type;
    private int width;

    static MediaCodecVideoEncoder()
    {
        org.webrtc.MediaCodecVideoEncoder.runningInstance = 0;
        org.webrtc.MediaCodecVideoEncoder.errorCallback = 0;
        org.webrtc.MediaCodecVideoEncoder.codecErrors = 0;
        org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes = new java.util.HashSet();
        org.webrtc.MediaCodecVideoEncoder.qcomVp8HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.qcom.", 19, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT);
        org.webrtc.MediaCodecVideoEncoder.exynosVp8HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.Exynos.", 23, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT);
        org.webrtc.MediaCodecVideoEncoder.intelVp8HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.Intel.", 21, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT);
        org.webrtc.MediaCodecVideoEncoder.qcomVp9HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.qcom.", 24, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT);
        org.webrtc.MediaCodecVideoEncoder.exynosVp9HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.Exynos.", 24, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        int[] v0_12 = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[2];
        v0_12[0] = org.webrtc.MediaCodecVideoEncoder.qcomVp9HwProperties;
        v0_12[1] = org.webrtc.MediaCodecVideoEncoder.exynosVp9HwProperties;
        org.webrtc.MediaCodecVideoEncoder.vp9HwList = v0_12;
        org.webrtc.MediaCodecVideoEncoder.qcomH264HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.qcom.", 19, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT);
        org.webrtc.MediaCodecVideoEncoder.exynosH264HwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.Exynos.", 21, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        int[] v0_18 = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[2];
        v0_18[0] = org.webrtc.MediaCodecVideoEncoder.qcomH264HwProperties;
        v0_18[1] = org.webrtc.MediaCodecVideoEncoder.exynosH264HwProperties;
        org.webrtc.MediaCodecVideoEncoder.h264HwList = v0_18;
        org.webrtc.MediaCodecVideoEncoder.exynosH264HighProfileHwProperties = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties("OMX.Exynos.", 23, org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT);
        int[] v0_21 = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[1];
        v0_21[0] = org.webrtc.MediaCodecVideoEncoder.exynosH264HighProfileHwProperties;
        org.webrtc.MediaCodecVideoEncoder.h264HighProfileHwList = v0_21;
        int[] v0_24 = new String[3];
        v0_24[0] = "SAMSUNG-SGH-I337";
        v0_24[1] = "Nexus 7";
        v0_24[2] = "Nexus 4";
        org.webrtc.MediaCodecVideoEncoder.H264_HW_EXCEPTION_MODELS = v0_24;
        int[] v0_26 = new int[4];
        v0_26 = {19, 21, 2141391872, 2141391876};
        org.webrtc.MediaCodecVideoEncoder.supportedColorList = v0_26;
        int[] v0_27 = new int[1];
        v0_27[0] = 2130708361;
        org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList = v0_27;
        return;
    }

    public MediaCodecVideoEncoder()
    {
        this.bitrateAdjustmentType = org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT;
        this.configData = 0;
        return;
    }

    static synthetic android.media.MediaCodec access$000(org.webrtc.MediaCodecVideoEncoder p1)
    {
        return p1.mediaCodec;
    }

    private void checkOnMediaCodecThread()
    {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        } else {
            throw new RuntimeException(new StringBuilder().append("MediaCodecVideoEncoder previously operated on ").append(this.mediaCodecThread).append(" but is now called on ").append(Thread.currentThread()).toString());
        }
    }

    static android.media.MediaCodec createByCodecName(String p2)
    {
        try {
            int v1 = android.media.MediaCodec.createByCodecName(p2);
        } catch (Exception v0) {
            v1 = 0;
        }
        return v1;
    }

    public static void disableH264HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoEncoder", "H.264 encoding is disabled by application.");
        org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.add("video/avc");
        return;
    }

    public static void disableVp8HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoEncoder", "VP8 encoding is disabled by application.");
        org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
        return;
    }

    public static void disableVp9HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoEncoder", "VP9 encoding is disabled by application.");
        org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
        return;
    }

    private static org.webrtc.MediaCodecVideoEncoder$EncoderProperties findHwEncoder(String p21, org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] p22, int[] p23)
    {
        int v15_11;
        if (android.os.Build$VERSION.SDK_INT >= 19) {
            if ((!p21.equals("video/avc")) || (!java.util.Arrays.asList(org.webrtc.MediaCodecVideoEncoder.H264_HW_EXCEPTION_MODELS).contains(android.os.Build.MODEL))) {
                int v9 = 0;
                while (v9 < android.media.MediaCodecList.getCodecCount()) {
                    try {
                        android.media.MediaCodecInfo v10 = android.media.MediaCodecList.getCodecInfoAt(v9);
                    } catch (IllegalArgumentException v7_1) {
                        org.webrtc.Logging.e("MediaCodecVideoEncoder", "Cannot retrieve encoder codec info", v7_1);
                    }
                    if ((v10 != null) && (v10.isEncoder())) {
                        String v12 = 0;
                        String v16_25 = v10.getSupportedTypes();
                        int v15_16 = 0;
                        while (v15_16 < v16_25.length) {
                            if (!v16_25[v15_16].equals(p21)) {
                                v15_16++;
                            } else {
                                v12 = v10.getName();
                                break;
                            }
                        }
                        if (v12 != null) {
                            org.webrtc.Logging.v("MediaCodecVideoEncoder", new StringBuilder().append("Found candidate encoder ").append(v12).toString());
                            int v13 = 0;
                            org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType v2 = org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT;
                            String v16_31 = p22.length;
                            int v15_12 = 0;
                            while (v15_12 < v16_31) {
                                org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties v5 = p22[v15_12];
                                if (v12.startsWith(v5.codecPrefix)) {
                                    if (android.os.Build$VERSION.SDK_INT >= v5.minSdk) {
                                        if (v5.bitrateAdjustmentType != org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.NO_ADJUSTMENT) {
                                            v2 = v5.bitrateAdjustmentType;
                                            org.webrtc.Logging.w("MediaCodecVideoEncoder", new StringBuilder().append("Codec ").append(v12).append(" requires bitrate adjustment: ").append(v2).toString());
                                        }
                                        v13 = 1;
                                        break;
                                    } else {
                                        org.webrtc.Logging.w("MediaCodecVideoEncoder", new StringBuilder().append("Codec ").append(v12).append(" is disabled due to SDK version ").append(android.os.Build$VERSION.SDK_INT).toString());
                                    }
                                }
                                v15_12++;
                            }
                            if (v13 != 0) {
                                try {
                                    android.media.MediaCodecInfo$CodecCapabilities v3 = v10.getCapabilitiesForType(p21);
                                    String v16_4 = v3.colorFormats;
                                    String v17_0 = v16_4.length;
                                    int v15_1 = 0;
                                } catch (IllegalArgumentException v7_0) {
                                    org.webrtc.Logging.e("MediaCodecVideoEncoder", "Cannot retrieve encoder capabilities", v7_0);
                                }
                                while (v15_1 < v17_0) {
                                    org.webrtc.Logging.v("MediaCodecVideoEncoder", new StringBuilder().append("   Color: 0x").append(Integer.toHexString(v16_4[v15_1])).toString());
                                    v15_1++;
                                }
                                String v16_6 = 0;
                                while (v16_6 < p23.length) {
                                    int[] v18_0 = v3.colorFormats;
                                    int v15_5 = 0;
                                    while (v15_5 < v18_0.length) {
                                        int v4 = v18_0[v15_5];
                                        if (v4 != p23[v16_6]) {
                                            v15_5++;
                                        } else {
                                            org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Found target encoder for mime ").append(p21).append(" : ").append(v12).append(". Color: 0x").append(Integer.toHexString(v4)).append(". Bitrate adjustment: ").append(v2).toString());
                                            v15_11 = new org.webrtc.MediaCodecVideoEncoder$EncoderProperties(v12, v4, v2);
                                        }
                                        return v15_11;
                                    }
                                    v16_6++;
                                }
                            }
                        }
                    }
                    v9++;
                }
                v15_11 = 0;
            } else {
                org.webrtc.Logging.w("MediaCodecVideoEncoder", new StringBuilder().append("Model: ").append(android.os.Build.MODEL).append(" has black listed H.264 encoder.").toString());
                v15_11 = 0;
            }
        } else {
            v15_11 = 0;
        }
        return v15_11;
    }

    private double getBitrateScale(int p7)
    {
        return Math.pow(4.0, (((double) p7) / 20.0));
    }

    public static boolean isH264HighProfileHwSupported()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/avc")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/avc", org.webrtc.MediaCodecVideoEncoder.h264HighProfileHwList, org.webrtc.MediaCodecVideoEncoder.supportedColorList) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isH264HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/avc")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/avc", org.webrtc.MediaCodecVideoEncoder.h264HwList, org.webrtc.MediaCodecVideoEncoder.supportedColorList) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isH264HwSupportedUsingTextures()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/avc")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/avc", org.webrtc.MediaCodecVideoEncoder.h264HwList, org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isVp8HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp8", org.webrtc.MediaCodecVideoEncoder.vp8HwList(), org.webrtc.MediaCodecVideoEncoder.supportedColorList) == null)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public static boolean isVp8HwSupportedUsingTextures()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp8", org.webrtc.MediaCodecVideoEncoder.vp8HwList(), org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList) == null)) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public static boolean isVp9HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp9", org.webrtc.MediaCodecVideoEncoder.vp9HwList, org.webrtc.MediaCodecVideoEncoder.supportedColorList) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isVp9HwSupportedUsingTextures()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp9")) || (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp9", org.webrtc.MediaCodecVideoEncoder.vp9HwList, org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static void printStackTrace()
    {
        if ((org.webrtc.MediaCodecVideoEncoder.runningInstance != null) && (org.webrtc.MediaCodecVideoEncoder.runningInstance.mediaCodecThread != null)) {
            StackTraceElement[] v0 = org.webrtc.MediaCodecVideoEncoder.runningInstance.mediaCodecThread.getStackTrace();
            if (v0.length > 0) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", "MediaCodecVideoEncoder stacks trace:");
                int v3_1 = v0.length;
                int v2_2 = 0;
                while (v2_2 < v3_1) {
                    org.webrtc.Logging.d("MediaCodecVideoEncoder", v0[v2_2].toString());
                    v2_2++;
                }
            }
        }
        return;
    }

    private void reportEncodedFrame(int p15)
    {
        if ((this.targetFps != 0) && (this.bitrateAdjustmentType == org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT)) {
            this.bitrateAccumulator = (this.bitrateAccumulator + (((double) p15) - (((double) this.targetBitrateBps) / (8.0 * ((double) this.targetFps)))));
            this.bitrateObservationTimeMs = (this.bitrateObservationTimeMs + (1000.0 / ((double) this.targetFps)));
            double v0 = (3.0 * this.bitrateAccumulatorMax);
            this.bitrateAccumulator = Math.min(this.bitrateAccumulator, v0);
            this.bitrateAccumulator = Math.max(this.bitrateAccumulator, (- v0));
            if (this.bitrateObservationTimeMs > 3000.0) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Acc: ").append(((int) this.bitrateAccumulator)).append(". Max: ").append(((int) this.bitrateAccumulatorMax)).append(". ExpScale: ").append(this.bitrateAdjustmentScaleExp).toString());
                int v3 = 0;
                if (this.bitrateAccumulator <= this.bitrateAccumulatorMax) {
                    if (this.bitrateAccumulator < (- this.bitrateAccumulatorMax)) {
                        this.bitrateAdjustmentScaleExp = (this.bitrateAdjustmentScaleExp + ((int) (((- this.bitrateAccumulator) / this.bitrateAccumulatorMax) + 0.5)));
                        this.bitrateAccumulator = (- this.bitrateAccumulatorMax);
                        v3 = 1;
                    }
                } else {
                    this.bitrateAdjustmentScaleExp = (this.bitrateAdjustmentScaleExp - ((int) ((this.bitrateAccumulator / this.bitrateAccumulatorMax) + 0.5)));
                    this.bitrateAccumulator = this.bitrateAccumulatorMax;
                    v3 = 1;
                }
                if (v3 != 0) {
                    this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
                    this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
                    org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Adjusting bitrate scale to ").append(this.bitrateAdjustmentScaleExp).append(". Value: ").append(this.getBitrateScale(this.bitrateAdjustmentScaleExp)).toString());
                    this.setRates((this.targetBitrateBps / 1000), this.targetFps);
                }
                this.bitrateObservationTimeMs = 0;
            }
        }
        return;
    }

    public static void setErrorCallback(org.webrtc.MediaCodecVideoEncoder$MediaCodecVideoEncoderErrorCallback p2)
    {
        org.webrtc.Logging.d("MediaCodecVideoEncoder", "Set error callback");
        org.webrtc.MediaCodecVideoEncoder.errorCallback = p2;
        return;
    }

    private boolean setRates(int p9, int p10)
    {
        this.checkOnMediaCodecThread();
        int v0 = (p9 * 1000);
        if (this.bitrateAdjustmentType == org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            this.bitrateAccumulatorMax = (((double) v0) / 8.0);
            if ((this.targetBitrateBps > 0) && (v0 < this.targetBitrateBps)) {
                this.bitrateAccumulator = ((this.bitrateAccumulator * ((double) v0)) / ((double) this.targetBitrateBps));
            }
        }
        this.targetBitrateBps = v0;
        this.targetFps = p10;
        if ((this.bitrateAdjustmentType != org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) || (this.targetFps <= 0)) {
            if (this.bitrateAdjustmentType != org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
                org.webrtc.Logging.v("MediaCodecVideoEncoder", new StringBuilder().append("setRates: ").append(p9).append(" kbps. Fps: ").append(this.targetFps).toString());
            } else {
                org.webrtc.Logging.v("MediaCodecVideoEncoder", new StringBuilder().append("setRates: ").append(p9).append(" kbps. Fps: ").append(this.targetFps).append(". ExpScale: ").append(this.bitrateAdjustmentScaleExp).toString());
                if (this.bitrateAdjustmentScaleExp != 0) {
                    v0 = ((int) (((double) v0) * this.getBitrateScale(this.bitrateAdjustmentScaleExp)));
                }
            }
        } else {
            v0 = ((this.targetBitrateBps * 30) / this.targetFps);
            org.webrtc.Logging.v("MediaCodecVideoEncoder", new StringBuilder().append("setRates: ").append(p9).append(" -> ").append((v0 / 1000)).append(" kbps. Fps: ").append(this.targetFps).toString());
        }
        try {
            android.os.Bundle v2_1 = new android.os.Bundle();
            v2_1.putInt("video-bitrate", v0);
            this.mediaCodec.setParameters(v2_1);
            int v3_3 = 1;
        } catch (IllegalStateException v1) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "setRates failed", v1);
            v3_3 = 0;
        }
        return v3_3;
    }

    public static org.webrtc.MediaCodecVideoEncoder$EncoderProperties vp8HwEncoderProperties()
    {
        org.webrtc.MediaCodecVideoEncoder$EncoderProperties v0_1;
        if (!org.webrtc.MediaCodecVideoEncoder.hwEncoderDisabledTypes.contains("video/x-vnd.on2.vp8")) {
            v0_1 = org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp8", org.webrtc.MediaCodecVideoEncoder.vp8HwList(), org.webrtc.MediaCodecVideoEncoder.supportedColorList);
        } else {
            v0_1 = 0;
        }
        return v0_1;
    }

    private static org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] vp8HwList()
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        v0_1.add(org.webrtc.MediaCodecVideoEncoder.qcomVp8HwProperties);
        v0_1.add(org.webrtc.MediaCodecVideoEncoder.exynosVp8HwProperties);
        if (org.webrtc.PeerConnectionFactory.fieldTrialsFindFullName("WebRTC-IntelVP8").equals("Enabled")) {
            v0_1.add(org.webrtc.MediaCodecVideoEncoder.intelVp8HwProperties);
        }
        org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[] v1_3 = new org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[v0_1.size()];
        return ((org.webrtc.MediaCodecVideoEncoder$MediaCodecProperties[]) v0_1.toArray(v1_3));
    }

    void checkKeyFrameRequired(boolean p11, long p12)
    {
        long v2 = ((500 + p12) / 1000);
        if (this.lastKeyFrameMs < 0) {
            this.lastKeyFrameMs = v2;
        }
        int v1 = 0;
        if ((!p11) && ((this.forcedKeyFrameMs > 0) && (v2 > (this.lastKeyFrameMs + this.forcedKeyFrameMs)))) {
            v1 = 1;
        }
        if ((p11) || (v1 != 0)) {
            if (!p11) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", "Sync frame forced");
            } else {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", "Sync frame request");
            }
            android.os.Bundle v0_1 = new android.os.Bundle();
            v0_1.putInt("request-sync", 0);
            this.mediaCodec.setParameters(v0_1);
            this.lastKeyFrameMs = v2;
        }
        return;
    }

    int dequeueInputBuffer()
    {
        this.checkOnMediaCodecThread();
        try {
            int v1_1 = this.mediaCodec.dequeueInputBuffer(0);
        } catch (IllegalStateException v0) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "dequeueIntputBuffer failed", v0);
            v1_1 = -2;
        }
        return v1_1;
    }

    org.webrtc.MediaCodecVideoEncoder$OutputBufferInfo dequeueOutputBuffer()
    {
        void v18_1 = this.checkOnMediaCodecThread();
        try {
            android.media.MediaCodec$BufferInfo v14_1 = new android.media.MediaCodec$BufferInfo();
            int v3 = v18_1.mediaCodec.dequeueOutputBuffer(v14_1, 0);
        } catch (IllegalStateException v12) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "dequeueOutputBuffer failed", v12);
            long v6_0 = new org.webrtc.MediaCodecVideoEncoder$OutputBufferInfo(-1, 0, 0, -1);
            return v6_0;
        }
        if (v3 >= 0) {
            int v15;
            if ((v14_1.flags & 2) == 0) {
                v15 = 0;
            } else {
                v15 = 1;
            }
            if (v15 != 0) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Config frame generated. Offset: ").append(v14_1.offset).append(". Size: ").append(v14_1.size).toString());
                v18_1.configData = java.nio.ByteBuffer.allocateDirect(v14_1.size);
                v18_1.outputBuffers[v3].position(v14_1.offset);
                v18_1.outputBuffers[v3].limit((v14_1.offset + v14_1.size));
                v18_1.configData.put(v18_1.outputBuffers[v3]);
                String v17 = "";
                int v13 = 0;
                while(true) {
                    android.media.MediaCodec v2_37;
                    if (v14_1.size >= 8) {
                        v2_37 = 8;
                    } else {
                        v2_37 = v14_1.size;
                    }
                    if (v13 >= v2_37) {
                        break;
                    }
                    v17 = new StringBuilder().append(v17).append(Integer.toHexString((v18_1.configData.get(v13) & 255))).append(" ").toString();
                    v13++;
                }
                org.webrtc.Logging.d("MediaCodecVideoEncoder", v17);
                v18_1.mediaCodec.releaseOutputBuffer(v3, 0);
                v3 = v18_1.mediaCodec.dequeueOutputBuffer(v14_1, 0);
            }
        }
        if (v3 < 0) {
            if (v3 != -3) {
                if (v3 != -2) {
                    if (v3 != -1) {
                        throw new RuntimeException(new StringBuilder().append("dequeueOutputBuffer: ").append(v3).toString());
                    } else {
                        v6_0 = 0;
                        return v6_0;
                    }
                } else {
                    v6_0 = v18_1.dequeueOutputBuffer();
                    return v6_0;
                }
            } else {
                v18_1.outputBuffers = v18_1.mediaCodec.getOutputBuffers();
                v6_0 = v18_1.dequeueOutputBuffer();
                return v6_0;
            }
        } else {
            int v5;
            java.nio.ByteBuffer v16 = v18_1.outputBuffers[v3].duplicate();
            v16.position(v14_1.offset);
            v16.limit((v14_1.offset + v14_1.size));
            v18_1.reportEncodedFrame(v14_1.size);
            if ((v14_1.flags & 1) == 0) {
                v5 = 0;
            } else {
                v5 = 1;
            }
            if (v5 != 0) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", "Sync frame generated");
            }
            if ((v5 == 0) || (v18_1.type != org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_H264)) {
                v6_0 = new org.webrtc.MediaCodecVideoEncoder$OutputBufferInfo(v3, v16.slice(), v5, v14_1.presentationTimeUs);
                return v6_0;
            } else {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Appending config frame of size ").append(v18_1.configData.capacity()).append(" to output buffer with offset ").append(v14_1.offset).append(", size ").append(v14_1.size).toString());
                java.nio.ByteBuffer v4 = java.nio.ByteBuffer.allocateDirect((v18_1.configData.capacity() + v14_1.size));
                v18_1.configData.rewind();
                v4.put(v18_1.configData);
                v4.put(v16);
                v4.position(0);
                v6_0 = new org.webrtc.MediaCodecVideoEncoder$OutputBufferInfo(v3, v4, v5, v14_1.presentationTimeUs);
                return v6_0;
            }
        }
    }

    boolean encodeBuffer(boolean p11, int p12, int p13, long p14)
    {
        this.checkOnMediaCodecThread();
        try {
            this.checkKeyFrameRequired(p11, p14);
            this.mediaCodec.queueInputBuffer(p12, 0, p13, p14, 0);
            int v0_0 = 1;
        } catch (IllegalStateException v7) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "encodeBuffer failed", v7);
            v0_0 = 0;
        }
        return v0_0;
    }

    boolean encodeTexture(boolean p11, int p12, float[] p13, long p14)
    {
        this.checkOnMediaCodecThread();
        try {
            this.checkKeyFrameRequired(p11, p14);
            this.eglBase.makeCurrent();
            android.opengl.GLES20.glClear(16384);
            this.drawer.drawOes(p12, p13, this.width, this.height, 0, 0, this.width, this.height);
            this.eglBase.swapBuffers(java.util.concurrent.TimeUnit.MICROSECONDS.toNanos(p14));
            int v0_2 = 1;
        } catch (RuntimeException v9) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "encodeTexture failed", v9);
            v0_2 = 0;
        }
        return v0_2;
    }

    java.nio.ByteBuffer[] getInputBuffers()
    {
        java.nio.ByteBuffer[] v0 = this.mediaCodec.getInputBuffers();
        org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Input buffers: ").append(v0.length).toString());
        return v0;
    }

    boolean initEncode(org.webrtc.MediaCodecVideoEncoder$VideoCodecType p15, int p16, int p17, int p18, int p19, int p20, org.webrtc.EglBase14$Context p21)
    {
        int v9;
        if (p21 == null) {
            v9 = 0;
        } else {
            v9 = 1;
        }
        org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Java initEncode: ").append(p15).append(". Profile: ").append(p16).append(" : ").append(p17).append(" x ").append(p18).append(". @ ").append(p19).append(" kbps. Fps: ").append(p20).append(". Encode from texture : ").append(v9).toString());
        this.profile = p16;
        this.width = p17;
        this.height = p18;
        if (this.mediaCodecThread == null) {
            org.webrtc.MediaCodecVideoEncoder$EncoderProperties v8 = 0;
            String v7 = 0;
            int v6 = 0;
            int v2 = 0;
            if (p15 != org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP8) {
                if (p15 != org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP9) {
                    if (p15 == org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_H264) {
                        long v10_62;
                        v7 = "video/avc";
                        if (v9 == 0) {
                            v10_62 = org.webrtc.MediaCodecVideoEncoder.supportedColorList;
                        } else {
                            v10_62 = org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList;
                        }
                        v8 = org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/avc", org.webrtc.MediaCodecVideoEncoder.h264HwList, v10_62);
                        if (p16 == org.webrtc.MediaCodecVideoEncoder$H264Profile.CONSTRAINED_HIGH.getValue()) {
                            long v10_65;
                            if (v9 == 0) {
                                v10_65 = org.webrtc.MediaCodecVideoEncoder.supportedColorList;
                            } else {
                                v10_65 = org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList;
                            }
                            if (org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/avc", org.webrtc.MediaCodecVideoEncoder.h264HighProfileHwList, v10_65) == null) {
                                org.webrtc.Logging.d("MediaCodecVideoEncoder", "High profile H.264 encoder requested, but not supported. Use baseline.");
                            } else {
                                org.webrtc.Logging.d("MediaCodecVideoEncoder", "High profile H.264 encoder supported.");
                                v2 = 1;
                            }
                        }
                        v6 = 20;
                    }
                } else {
                    long v10_0;
                    v7 = "video/x-vnd.on2.vp9";
                    if (v9 == 0) {
                        v10_0 = org.webrtc.MediaCodecVideoEncoder.supportedColorList;
                    } else {
                        v10_0 = org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList;
                    }
                    v8 = org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp9", org.webrtc.MediaCodecVideoEncoder.vp9HwList, v10_0);
                    v6 = 100;
                }
            } else {
                long v10_1;
                v7 = "video/x-vnd.on2.vp8";
                int v12_0 = org.webrtc.MediaCodecVideoEncoder.vp8HwList();
                if (v9 == 0) {
                    v10_1 = org.webrtc.MediaCodecVideoEncoder.supportedColorList;
                } else {
                    v10_1 = org.webrtc.MediaCodecVideoEncoder.supportedSurfaceColorList;
                }
                v8 = org.webrtc.MediaCodecVideoEncoder.findHwEncoder("video/x-vnd.on2.vp8", v12_0, v10_1);
                v6 = 100;
            }
            if (v8 != null) {
                int v20_1;
                org.webrtc.MediaCodecVideoEncoder.runningInstance = this;
                this.colorFormat = v8.colorFormat;
                this.bitrateAdjustmentType = v8.bitrateAdjustmentType;
                if (this.bitrateAdjustmentType != org.webrtc.MediaCodecVideoEncoder$BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) {
                    v20_1 = Math.min(p20, 30);
                } else {
                    v20_1 = 30;
                }
                this.forcedKeyFrameMs = 0;
                this.lastKeyFrameMs = -1;
                if ((p15 == org.webrtc.MediaCodecVideoEncoder$VideoCodecType.VIDEO_CODEC_VP8) && (v8.codecName.startsWith(org.webrtc.MediaCodecVideoEncoder.qcomVp8HwProperties.codecPrefix))) {
                    if ((android.os.Build$VERSION.SDK_INT != 21) && (android.os.Build$VERSION.SDK_INT != 22)) {
                        if (android.os.Build$VERSION.SDK_INT != 23) {
                            if (android.os.Build$VERSION.SDK_INT > 23) {
                                this.forcedKeyFrameMs = 15000;
                            }
                        } else {
                            this.forcedKeyFrameMs = 20000;
                        }
                    } else {
                        this.forcedKeyFrameMs = 15000;
                    }
                }
                org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Color format: ").append(this.colorFormat).append(". Bitrate adjustment: ").append(this.bitrateAdjustmentType).append(". Key frame interval: ").append(this.forcedKeyFrameMs).append(" . Initial fps: ").append(v20_1).toString());
                this.targetBitrateBps = (p19 * 1000);
                this.targetFps = v20_1;
                this.bitrateAccumulatorMax = (((double) this.targetBitrateBps) / 8.0);
                this.bitrateAccumulator = 0;
                this.bitrateObservationTimeMs = 0;
                this.bitrateAdjustmentScaleExp = 0;
                this.mediaCodecThread = Thread.currentThread();
                try {
                    android.media.MediaFormat v4 = android.media.MediaFormat.createVideoFormat(v7, p17, p18);
                    v4.setInteger("bitrate", this.targetBitrateBps);
                    v4.setInteger("bitrate-mode", 2);
                    v4.setInteger("color-format", v8.colorFormat);
                    v4.setInteger("frame-rate", this.targetFps);
                    v4.setInteger("i-frame-interval", v6);
                } catch (IllegalStateException v3) {
                    org.webrtc.Logging.e("MediaCodecVideoEncoder", "initEncode failed", v3);
                    this.release();
                    long v10_47 = 0;
                    return v10_47;
                }
                if (v2 != 0) {
                    v4.setInteger("profile", 8);
                    v4.setInteger("level", 256);
                }
                org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("  Format: ").append(v4).toString());
                this.mediaCodec = org.webrtc.MediaCodecVideoEncoder.createByCodecName(v8.codecName);
                this.type = p15;
                if (this.mediaCodec != null) {
                    this.mediaCodec.configure(v4, 0, 0, 1);
                    if (v9 != 0) {
                        this.eglBase = new org.webrtc.EglBase14(p21, org.webrtc.EglBase.CONFIG_RECORDABLE);
                        this.inputSurface = this.mediaCodec.createInputSurface();
                        this.eglBase.createSurface(this.inputSurface);
                        this.drawer = new org.webrtc.GlRectDrawer();
                    }
                    this.mediaCodec.start();
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    org.webrtc.Logging.d("MediaCodecVideoEncoder", new StringBuilder().append("Output buffers: ").append(this.outputBuffers.length).toString());
                    v10_47 = 1;
                    return v10_47;
                } else {
                    org.webrtc.Logging.e("MediaCodecVideoEncoder", "Can not create media encoder");
                    this.release();
                    v10_47 = 0;
                    return v10_47;
                }
            } else {
                throw new RuntimeException(new StringBuilder().append("Can not find HW encoder for ").append(p15).toString());
            }
        } else {
            throw new RuntimeException("Forgot to release()?");
        }
    }

    void release()
    {
        org.webrtc.Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder");
        this.checkOnMediaCodecThread();
        org.webrtc.MediaCodecVideoEncoder$1CaughtException v0_1 = new org.webrtc.MediaCodecVideoEncoder$1CaughtException(this);
        int v4 = 0;
        if (this.mediaCodec != null) {
            java.util.concurrent.CountDownLatch v1_1 = new java.util.concurrent.CountDownLatch(1);
            new Thread(new org.webrtc.MediaCodecVideoEncoder$1(this, v0_1, v1_1)).start();
            if (!org.webrtc.ThreadUtils.awaitUninterruptibly(v1_1, 5000)) {
                org.webrtc.Logging.e("MediaCodecVideoEncoder", "Media encoder release timeout");
                v4 = 1;
            }
            this.mediaCodec = 0;
        }
        this.mediaCodecThread = 0;
        if (this.drawer != null) {
            this.drawer.release();
            this.drawer = 0;
        }
        if (this.eglBase != null) {
            this.eglBase.release();
            this.eglBase = 0;
        }
        if (this.inputSurface != null) {
            this.inputSurface.release();
            this.inputSurface = 0;
        }
        org.webrtc.MediaCodecVideoEncoder.runningInstance = 0;
        if (v4 == 0) {
            if (v0_1.e == null) {
                org.webrtc.Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder done");
                return;
            } else {
                RuntimeException v3_1 = new RuntimeException(v0_1.e);
                v3_1.setStackTrace(org.webrtc.ThreadUtils.concatStackTraces(v0_1.e.getStackTrace(), v3_1.getStackTrace()));
                throw v3_1;
            }
        } else {
            org.webrtc.MediaCodecVideoEncoder.codecErrors = (org.webrtc.MediaCodecVideoEncoder.codecErrors + 1);
            if (org.webrtc.MediaCodecVideoEncoder.errorCallback != null) {
                org.webrtc.Logging.e("MediaCodecVideoEncoder", new StringBuilder().append("Invoke codec error callback. Errors: ").append(org.webrtc.MediaCodecVideoEncoder.codecErrors).toString());
                org.webrtc.MediaCodecVideoEncoder.errorCallback.onMediaCodecVideoEncoderCriticalError(org.webrtc.MediaCodecVideoEncoder.codecErrors);
            }
            throw new RuntimeException("Media encoder release timeout.");
        }
    }

    boolean releaseOutputBuffer(int p5)
    {
        this.checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(p5, 0);
        } catch (IllegalStateException v0) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "releaseOutputBuffer failed", v0);
        }
        return 1;
    }
}
