package org.webrtc;
public class MediaCodecVideoDecoder {
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar16m4ka = 2141391874;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar32m4ka = 2141391873;
    private static final int COLOR_QCOM_FORMATYVU420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final long MAX_DECODE_TIME_MS = 200;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors = 0;
    private static org.webrtc.MediaCodecVideoDecoder$MediaCodecVideoDecoderErrorCallback errorCallback = None;
    private static java.util.Set hwDecoderDisabledTypes = None;
    private static org.webrtc.MediaCodecVideoDecoder runningInstance = None;
    private static final java.util.List supportedColorList = None;
    private static final String supportedExynosH264HighProfileHwCodecPrefix = "OMX.Exynos.";
    private static final String[] supportedH264HwCodecPrefixes = None;
    private static final String supportedQcomH264HighProfileHwCodecPrefix = "OMX.qcom.";
    private static final String[] supportedVp8HwCodecPrefixes;
    private static final String[] supportedVp9HwCodecPrefixes;
    private int colorFormat;
    private final java.util.Queue decodeStartTimeMs;
    private final java.util.Queue dequeuedSurfaceOutputBuffers;
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    private java.nio.ByteBuffer[] inputBuffers;
    private android.media.MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private java.nio.ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private android.view.Surface surface;
    private org.webrtc.MediaCodecVideoDecoder$TextureListener textureListener;
    private boolean useSurface;
    private int width;

    static MediaCodecVideoDecoder()
    {
        org.webrtc.MediaCodecVideoDecoder.runningInstance = 0;
        org.webrtc.MediaCodecVideoDecoder.errorCallback = 0;
        org.webrtc.MediaCodecVideoDecoder.codecErrors = 0;
        org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes = new java.util.HashSet();
        java.util.List v0_2 = new String[4];
        v0_2[0] = "OMX.qcom.";
        v0_2[1] = "OMX.Nvidia.";
        v0_2[2] = "OMX.Exynos.";
        v0_2[3] = "OMX.Intel.";
        org.webrtc.MediaCodecVideoDecoder.supportedVp8HwCodecPrefixes = v0_2;
        java.util.List v0_3 = new String[2];
        v0_3[0] = "OMX.qcom.";
        v0_3[1] = "OMX.Exynos.";
        org.webrtc.MediaCodecVideoDecoder.supportedVp9HwCodecPrefixes = v0_3;
        java.util.List v0_4 = new String[3];
        v0_4[0] = "OMX.qcom.";
        v0_4[1] = "OMX.Intel.";
        v0_4[2] = "OMX.Exynos.";
        org.webrtc.MediaCodecVideoDecoder.supportedH264HwCodecPrefixes = v0_4;
        java.util.List v0_6 = new Integer[7];
        v0_6[0] = Integer.valueOf(19);
        v0_6[1] = Integer.valueOf(21);
        v0_6[2] = Integer.valueOf(2141391872);
        v0_6[3] = Integer.valueOf(2141391873);
        v0_6[4] = Integer.valueOf(2141391874);
        v0_6[5] = Integer.valueOf(2141391875);
        v0_6[6] = Integer.valueOf(2141391876);
        org.webrtc.MediaCodecVideoDecoder.supportedColorList = java.util.Arrays.asList(v0_6);
        return;
    }

    public MediaCodecVideoDecoder()
    {
        this.decodeStartTimeMs = new java.util.LinkedList();
        this.surface = 0;
        this.dequeuedSurfaceOutputBuffers = new java.util.LinkedList();
        return;
    }

    private void MaybeRenderDecodedTextureBuffer()
    {
        if ((!this.dequeuedSurfaceOutputBuffers.isEmpty()) && (!this.textureListener.isWaitingForTexture())) {
            org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer v0_1 = ((org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer) this.dequeuedSurfaceOutputBuffers.remove());
            this.textureListener.addBufferToRender(v0_1);
            this.mediaCodec.releaseOutputBuffer(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$900(v0_1), 1);
        }
        return;
    }

    static synthetic android.media.MediaCodec access$000(org.webrtc.MediaCodecVideoDecoder p1)
    {
        return p1.mediaCodec;
    }

    private void checkOnMediaCodecThread()
    {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        } else {
            throw new IllegalStateException(new StringBuilder().append("MediaCodecVideoDecoder previously operated on ").append(this.mediaCodecThread).append(" but is now called on ").append(Thread.currentThread()).toString());
        }
    }

    private int dequeueInputBuffer()
    {
        this.checkOnMediaCodecThread();
        try {
            int v1_1 = this.mediaCodec.dequeueInputBuffer(500000);
        } catch (IllegalStateException v0) {
            org.webrtc.Logging.e("MediaCodecVideoDecoder", "dequeueIntputBuffer failed", v0);
            v1_1 = -2;
        }
        return v1_1;
    }

    private org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer dequeueOutputBuffer(int p22)
    {
        int v2_19;
        void v21_1 = this.checkOnMediaCodecThread();
        if (!v21_1.decodeStartTimeMs.isEmpty()) {
            android.media.MediaCodec$BufferInfo v17_1 = new android.media.MediaCodec$BufferInfo();
            do {
                int v3 = v21_1.mediaCodec.dequeueOutputBuffer(v17_1, java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(((long) p22)));
                switch (v3) {
                    case -3:
                        v21_1.outputBuffers = v21_1.mediaCodec.getOutputBuffers();
                        org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Decoder output buffers changed: ").append(v21_1.outputBuffers.length).toString());
                        break;
                    case -2:
                        int v19;
                        int v18;
                        android.media.MediaFormat v16 = v21_1.mediaCodec.getOutputFormat();
                        org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Decoder format changed: ").append(v16.toString()).toString());
                        if ((!v16.containsKey("crop-left")) || ((!v16.containsKey("crop-right")) || ((!v16.containsKey("crop-bottom")) || (!v16.containsKey("crop-top"))))) {
                            v19 = v16.getInteger("width");
                            v18 = v16.getInteger("height");
                        } else {
                            v19 = ((v16.getInteger("crop-right") + 1) - v16.getInteger("crop-left"));
                            v18 = ((v16.getInteger("crop-bottom") + 1) - v16.getInteger("crop-top"));
                        }
                        if ((!v21_1.hasDecodedFirstFrame) || ((v19 == v21_1.width) && (v18 == v21_1.height))) {
                            v21_1.width = v19;
                            v21_1.height = v18;
                            if ((!v21_1.useSurface) && (v16.containsKey("color-format"))) {
                                v21_1.colorFormat = v16.getInteger("color-format");
                                org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Color: 0x").append(Integer.toHexString(v21_1.colorFormat)).toString());
                                if (!org.webrtc.MediaCodecVideoDecoder.supportedColorList.contains(Integer.valueOf(v21_1.colorFormat))) {
                                    throw new IllegalStateException(new StringBuilder().append("Non supported color format: ").append(v21_1.colorFormat).toString());
                                }
                            }
                            if (v16.containsKey("stride")) {
                                v21_1.stride = v16.getInteger("stride");
                            }
                            if (v16.containsKey("slice-height")) {
                                v21_1.sliceHeight = v16.getInteger("slice-height");
                            }
                            org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Frame stride and slice height: ").append(v21_1.stride).append(" x ").append(v21_1.sliceHeight).toString());
                            v21_1.stride = Math.max(v21_1.width, v21_1.stride);
                            v21_1.sliceHeight = Math.max(v21_1.height, v21_1.sliceHeight);
                        } else {
                            throw new RuntimeException(new StringBuilder().append("Unexpected size change. Configured ").append(v21_1.width).append("*").append(v21_1.height).append(". New ").append(v19).append("*").append(v18).toString());
                        }
                        break;
                    case -1:
                        v2_19 = 0;
                        break;
                    default:
                        v21_1.hasDecodedFirstFrame = 1;
                        org.webrtc.MediaCodecVideoDecoder$TimeStamps v20_1 = ((org.webrtc.MediaCodecVideoDecoder$TimeStamps) v21_1.decodeStartTimeMs.remove());
                        long v12 = (android.os.SystemClock.elapsedRealtime() - org.webrtc.MediaCodecVideoDecoder$TimeStamps.access$600(v20_1));
                        if (v12 > 200) {
                            org.webrtc.Logging.e("MediaCodecVideoDecoder", new StringBuilder().append("Very high decode time: ").append(v12).append("ms. Q size: ").append(v21_1.decodeStartTimeMs.size()).append(". Might be caused by resuming H264 decoding after a pause.").toString());
                            v12 = 200;
                        }
                        v2_19 = new org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer(v3, v17_1.offset, v17_1.size, java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(v17_1.presentationTimeUs), org.webrtc.MediaCodecVideoDecoder$TimeStamps.access$700(v20_1), org.webrtc.MediaCodecVideoDecoder$TimeStamps.access$800(v20_1), v12, android.os.SystemClock.elapsedRealtime());
                }
            } while(!v21_1.hasDecodedFirstFrame);
            throw new RuntimeException("Unexpected output buffer change event.");
        } else {
            v2_19 = 0;
        }
        return v2_19;
    }

    private org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer dequeueTextureBuffer(int p21)
    {
        void v20_1 = this.checkOnMediaCodecThread();
        if (v20_1.useSurface) {
            org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer v16 = v20_1.dequeueOutputBuffer(p21);
            if (v16 != null) {
                v20_1.dequeuedSurfaceOutputBuffers.add(v16);
            }
            void v20_2 = v20_1.MaybeRenderDecodedTextureBuffer();
            org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer v17 = v20_2.textureListener.dequeueTextureBuffer(p21);
            if (v17 == null) {
                if ((v20_2.dequeuedSurfaceOutputBuffers.size() < Math.min(3, v20_2.outputBuffers.length)) && ((p21 <= 0) || (v20_2.dequeuedSurfaceOutputBuffers.isEmpty()))) {
                    v17 = 0;
                } else {
                    v20_2.droppedFrames = (v20_2.droppedFrames + 1);
                    org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer v2_1 = ((org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer) v20_2.dequeuedSurfaceOutputBuffers.remove());
                    if (p21 <= 0) {
                        org.webrtc.Logging.w("MediaCodecVideoDecoder", new StringBuilder().append("Too many output buffers ").append(v20_2.dequeuedSurfaceOutputBuffers.size()).append(". Dropping frame with TS: ").append(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$100(v2_1)).append(". Total number of dropped frames: ").append(v20_2.droppedFrames).toString());
                    } else {
                        org.webrtc.Logging.w("MediaCodecVideoDecoder", new StringBuilder().append("Draining decoder. Dropping frame with TS: ").append(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$100(v2_1)).append(". Total number of dropped frames: ").append(v20_2.droppedFrames).toString());
                    }
                    v20_2.mediaCodec.releaseOutputBuffer(org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$900(v2_1), 0);
                    v17 = new org.webrtc.MediaCodecVideoDecoder$DecodedTextureBuffer(0, 0, org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$100(v2_1), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$200(v2_1), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$300(v2_1), org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$400(v2_1), (android.os.SystemClock.elapsedRealtime() - org.webrtc.MediaCodecVideoDecoder$DecodedOutputBuffer.access$500(v2_1)));
                }
            } else {
                v20_2.MaybeRenderDecodedTextureBuffer();
            }
            return v17;
        } else {
            throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
        }
    }

    public static void disableH264HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoDecoder", "H.264 decoding is disabled by application.");
        org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.add("video/avc");
        return;
    }

    public static void disableVp8HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoDecoder", "VP8 decoding is disabled by application.");
        org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
        return;
    }

    public static void disableVp9HwCodec()
    {
        org.webrtc.Logging.w("MediaCodecVideoDecoder", "VP9 decoding is disabled by application.");
        org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
        return;
    }

    private static org.webrtc.MediaCodecVideoDecoder$DecoderProperties findDecoder(String p18, String[] p19)
    {
        int v12_5;
        if (android.os.Build$VERSION.SDK_INT >= 19) {
            org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Trying to find HW decoder for mime ").append(p18).toString());
            int v6 = 0;
            while (v6 < android.media.MediaCodecList.getCodecCount()) {
                try {
                    android.media.MediaCodecInfo v7 = android.media.MediaCodecList.getCodecInfoAt(v6);
                } catch (IllegalArgumentException v5_0) {
                    org.webrtc.Logging.e("MediaCodecVideoDecoder", "Cannot retrieve decoder codec info", v5_0);
                }
                if ((v7 != null) && (!v7.isEncoder())) {
                    String v9 = 0;
                    String v13_17 = v7.getSupportedTypes();
                    int v12_12 = 0;
                    while (v12_12 < v13_17.length) {
                        if (!v13_17[v12_12].equals(p18)) {
                            v12_12++;
                        } else {
                            v9 = v7.getName();
                            break;
                        }
                    }
                    if (v9 != null) {
                        org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Found candidate decoder ").append(v9).toString());
                        int v10 = 0;
                        int v12_14 = 0;
                        while (v12_14 < p19.length) {
                            if (!v9.startsWith(p19[v12_14])) {
                                v12_14++;
                            } else {
                                v10 = 1;
                                break;
                            }
                        }
                        if (v10 != 0) {
                            try {
                                android.media.MediaCodecInfo$CodecCapabilities v1 = v7.getCapabilitiesForType(p18);
                                String v13_26 = v1.colorFormats;
                                String v14_9 = v13_26.length;
                                int v12_6 = 0;
                            } catch (IllegalArgumentException v5_1) {
                                org.webrtc.Logging.e("MediaCodecVideoDecoder", "Cannot retrieve decoder capabilities", v5_1);
                            }
                            while (v12_6 < v14_9) {
                                org.webrtc.Logging.v("MediaCodecVideoDecoder", new StringBuilder().append("   Color: 0x").append(Integer.toHexString(v13_26[v12_6])).toString());
                                v12_6++;
                            }
                            String v13_28 = org.webrtc.MediaCodecVideoDecoder.supportedColorList.iterator();
                            while (v13_28.hasNext()) {
                                int vtmp25 = ((Integer) v13_28.next()).intValue();
                                String v14_0 = v1.colorFormats;
                                int v12_2 = 0;
                                while (v12_2 < v14_0.length) {
                                    int v2 = v14_0[v12_2];
                                    if (v2 != vtmp25) {
                                        v12_2++;
                                    } else {
                                        org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Found target decoder ").append(v9).append(". Color: 0x").append(Integer.toHexString(v2)).toString());
                                        v12_5 = new org.webrtc.MediaCodecVideoDecoder$DecoderProperties(v9, v2);
                                    }
                                    return v12_5;
                                }
                            }
                        }
                    }
                }
                v6++;
            }
            org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("No HW decoder found for mime ").append(p18).toString());
            v12_5 = 0;
        } else {
            v12_5 = 0;
        }
        return v12_5;
    }

    private boolean initDecode(org.webrtc.MediaCodecVideoDecoder$VideoCodecType p12, int p13, int p14, org.webrtc.SurfaceTextureHelper p15)
    {
        String v7_0 = 0;
        if (this.mediaCodecThread == null) {
            String v5_28;
            if (p15 == null) {
                v5_28 = 0;
            } else {
                v5_28 = 1;
            }
            String[] v4;
            String v2;
            this.useSurface = v5_28;
            if (p12 != org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP8) {
                if (p12 != org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_VP9) {
                    if (p12 != org.webrtc.MediaCodecVideoDecoder$VideoCodecType.VIDEO_CODEC_H264) {
                        throw new RuntimeException(new StringBuilder().append("initDecode: Non-supported codec ").append(p12).toString());
                    } else {
                        v2 = "video/avc";
                        v4 = org.webrtc.MediaCodecVideoDecoder.supportedH264HwCodecPrefixes;
                    }
                } else {
                    v2 = "video/x-vnd.on2.vp9";
                    v4 = org.webrtc.MediaCodecVideoDecoder.supportedVp9HwCodecPrefixes;
                }
            } else {
                v2 = "video/x-vnd.on2.vp8";
                v4 = org.webrtc.MediaCodecVideoDecoder.supportedVp8HwCodecPrefixes;
            }
            org.webrtc.MediaCodecVideoDecoder$DecoderProperties v3 = org.webrtc.MediaCodecVideoDecoder.findDecoder(v2, v4);
            if (v3 != null) {
                org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Java initDecode: ").append(p12).append(" : ").append(p13).append(" x ").append(p14).append(". Color: 0x").append(Integer.toHexString(v3.colorFormat)).append(". Use Surface: ").append(this.useSurface).toString());
                org.webrtc.MediaCodecVideoDecoder.runningInstance = this;
                this.mediaCodecThread = Thread.currentThread();
                try {
                    this.width = p13;
                    this.height = p14;
                    this.stride = p13;
                    this.sliceHeight = p14;
                } catch (IllegalStateException v0) {
                    org.webrtc.Logging.e("MediaCodecVideoDecoder", "initDecode failed", v0);
                    return v7_0;
                }
                if (this.useSurface) {
                    this.textureListener = new org.webrtc.MediaCodecVideoDecoder$TextureListener(p15);
                    this.surface = new android.view.Surface(p15.getSurfaceTexture());
                }
                android.media.MediaFormat v1 = android.media.MediaFormat.createVideoFormat(v2, p13, p14);
                if (!this.useSurface) {
                    v1.setInteger("color-format", v3.colorFormat);
                }
                org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("  Format: ").append(v1).toString());
                this.mediaCodec = org.webrtc.MediaCodecVideoEncoder.createByCodecName(v3.codecName);
                if (this.mediaCodec != null) {
                    this.mediaCodec.configure(v1, this.surface, 0, 0);
                    this.mediaCodec.start();
                    this.colorFormat = v3.colorFormat;
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                    this.inputBuffers = this.mediaCodec.getInputBuffers();
                    this.decodeStartTimeMs.clear();
                    this.hasDecodedFirstFrame = 0;
                    this.dequeuedSurfaceOutputBuffers.clear();
                    this.droppedFrames = 0;
                    org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Input buffers: ").append(this.inputBuffers.length).append(". Output buffers: ").append(this.outputBuffers.length).toString());
                    v7_0 = 1;
                    return v7_0;
                } else {
                    org.webrtc.Logging.e("MediaCodecVideoDecoder", "Can not create media decoder");
                    return v7_0;
                }
            } else {
                throw new RuntimeException(new StringBuilder().append("Cannot find HW decoder for ").append(p12).toString());
            }
        } else {
            throw new RuntimeException("initDecode: Forgot to release()?");
        }
    }

    public static boolean isH264HighProfileHwSupported()
    {
        int v0 = 0;
        if (!org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.contains("video/avc")) {
            if (android.os.Build$VERSION.SDK_INT >= 21) {
                String[] v3_0 = new String[1];
                v3_0[0] = "OMX.qcom.";
                if (org.webrtc.MediaCodecVideoDecoder.findDecoder("video/avc", v3_0) != null) {
                    v0 = 1;
                    return v0;
                }
            }
            if (android.os.Build$VERSION.SDK_INT >= 23) {
                String[] v3_2 = new String[1];
                v3_2[0] = "OMX.Exynos.";
                if (org.webrtc.MediaCodecVideoDecoder.findDecoder("video/avc", v3_2) != null) {
                    v0 = 1;
                }
            }
        }
        return v0;
    }

    public static boolean isH264HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.contains("video/avc")) || (org.webrtc.MediaCodecVideoDecoder.findDecoder("video/avc", org.webrtc.MediaCodecVideoDecoder.supportedH264HwCodecPrefixes) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isVp8HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8")) || (org.webrtc.MediaCodecVideoDecoder.findDecoder("video/x-vnd.on2.vp8", org.webrtc.MediaCodecVideoDecoder.supportedVp8HwCodecPrefixes) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean isVp9HwSupported()
    {
        if ((org.webrtc.MediaCodecVideoDecoder.hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9")) || (org.webrtc.MediaCodecVideoDecoder.findDecoder("video/x-vnd.on2.vp9", org.webrtc.MediaCodecVideoDecoder.supportedVp9HwCodecPrefixes) == null)) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static void printStackTrace()
    {
        if ((org.webrtc.MediaCodecVideoDecoder.runningInstance != null) && (org.webrtc.MediaCodecVideoDecoder.runningInstance.mediaCodecThread != null)) {
            StackTraceElement[] v0 = org.webrtc.MediaCodecVideoDecoder.runningInstance.mediaCodecThread.getStackTrace();
            if (v0.length > 0) {
                org.webrtc.Logging.d("MediaCodecVideoDecoder", "MediaCodecVideoDecoder stacks trace:");
                int v3_1 = v0.length;
                int v2_2 = 0;
                while (v2_2 < v3_1) {
                    org.webrtc.Logging.d("MediaCodecVideoDecoder", v0[v2_2].toString());
                    v2_2++;
                }
            }
        }
        return;
    }

    private boolean queueInputBuffer(int p10, int p11, long p12, long p14, long p16)
    {
        this.checkOnMediaCodecThread();
        try {
            this.inputBuffers[p10].position(0);
            this.inputBuffers[p10].limit(p11);
            this.decodeStartTimeMs.add(new org.webrtc.MediaCodecVideoDecoder$TimeStamps(android.os.SystemClock.elapsedRealtime(), p14, p16));
            this.mediaCodec.queueInputBuffer(p10, 0, p11, p12, 0);
            int v0_3 = 1;
        } catch (IllegalStateException v8) {
            org.webrtc.Logging.e("MediaCodecVideoDecoder", "decode failed", v8);
            v0_3 = 0;
        }
        return v0_3;
    }

    private void release()
    {
        org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Java releaseDecoder. Total number of dropped frames: ").append(this.droppedFrames).toString());
        this.checkOnMediaCodecThread();
        java.util.concurrent.CountDownLatch v0_1 = new java.util.concurrent.CountDownLatch(1);
        new Thread(new org.webrtc.MediaCodecVideoDecoder$1(this, v0_1)).start();
        if (!org.webrtc.ThreadUtils.awaitUninterruptibly(v0_1, 5000)) {
            org.webrtc.Logging.e("MediaCodecVideoDecoder", "Media decoder release timeout");
            org.webrtc.MediaCodecVideoDecoder.codecErrors = (org.webrtc.MediaCodecVideoDecoder.codecErrors + 1);
            if (org.webrtc.MediaCodecVideoDecoder.errorCallback != null) {
                org.webrtc.Logging.e("MediaCodecVideoDecoder", new StringBuilder().append("Invoke codec error callback. Errors: ").append(org.webrtc.MediaCodecVideoDecoder.codecErrors).toString());
                org.webrtc.MediaCodecVideoDecoder.errorCallback.onMediaCodecVideoDecoderCriticalError(org.webrtc.MediaCodecVideoDecoder.codecErrors);
            }
        }
        this.mediaCodec = 0;
        this.mediaCodecThread = 0;
        org.webrtc.MediaCodecVideoDecoder.runningInstance = 0;
        if (this.useSurface) {
            this.surface.release();
            this.surface = 0;
            this.textureListener.release();
        }
        org.webrtc.Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder done");
        return;
    }

    private void reset(int p5, int p6)
    {
        if ((this.mediaCodecThread != null) && (this.mediaCodec != null)) {
            org.webrtc.Logging.d("MediaCodecVideoDecoder", new StringBuilder().append("Java reset: ").append(p5).append(" x ").append(p6).toString());
            this.mediaCodec.flush();
            this.width = p5;
            this.height = p6;
            this.decodeStartTimeMs.clear();
            this.dequeuedSurfaceOutputBuffers.clear();
            this.hasDecodedFirstFrame = 0;
            this.droppedFrames = 0;
            return;
        } else {
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
    }

    private void returnDecodedOutputBuffer(int p3)
    {
        this.checkOnMediaCodecThread();
        if (!this.useSurface) {
            this.mediaCodec.releaseOutputBuffer(p3, 0);
            return;
        } else {
            throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
        }
    }

    public static void setErrorCallback(org.webrtc.MediaCodecVideoDecoder$MediaCodecVideoDecoderErrorCallback p2)
    {
        org.webrtc.Logging.d("MediaCodecVideoDecoder", "Set error callback");
        org.webrtc.MediaCodecVideoDecoder.errorCallback = p2;
        return;
    }
}
