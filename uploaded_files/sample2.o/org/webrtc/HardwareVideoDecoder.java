package org.webrtc;
 class HardwareVideoDecoder implements org.webrtc.VideoDecoder {
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final String TAG = "HardwareVideoDecoder";
    private int activeOutputBuffers;
    private final Object activeOutputBuffersLock;
    private org.webrtc.VideoDecoder$Callback callback;
    private android.media.MediaCodec codec;
    private final String codecName;
    private final org.webrtc.VideoCodecType codecType;
    private int colorFormat;
    private org.webrtc.ThreadUtils$ThreadChecker decoderThreadChecker;
    private final Object dimensionLock;
    private final java.util.Deque frameInfos;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean keyFrameRequired;
    private Thread outputThread;
    private org.webrtc.ThreadUtils$ThreadChecker outputThreadChecker;
    private volatile boolean running;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;
    private int width;

    HardwareVideoDecoder(String p4, org.webrtc.VideoCodecType p5, int p6)
    {
        this.running = 0;
        this.shutdownException = 0;
        this.activeOutputBuffersLock = new Object();
        this.activeOutputBuffers = 0;
        this.dimensionLock = new Object();
        this.codec = 0;
        if (this.isSupportedColorFormat(p6)) {
            this.codecName = p4;
            this.codecType = p5;
            this.colorFormat = p6;
            this.frameInfos = new java.util.concurrent.LinkedBlockingDeque();
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Unsupported color format: ").append(p6).toString());
        }
    }

    static synthetic org.webrtc.ThreadUtils$ThreadChecker access$002(org.webrtc.HardwareVideoDecoder p0, org.webrtc.ThreadUtils$ThreadChecker p1)
    {
        p0.outputThreadChecker = p1;
        return p1;
    }

    static synthetic boolean access$100(org.webrtc.HardwareVideoDecoder p1)
    {
        return p1.running;
    }

    static synthetic void access$200(org.webrtc.HardwareVideoDecoder p0)
    {
        p0.deliverDecodedFrame();
        return;
    }

    static synthetic void access$300(org.webrtc.HardwareVideoDecoder p0)
    {
        p0.releaseCodecOnOutputThread();
        return;
    }

    static synthetic android.media.MediaCodec access$400(org.webrtc.HardwareVideoDecoder p1)
    {
        return p1.codec;
    }

    static synthetic Object access$500(org.webrtc.HardwareVideoDecoder p1)
    {
        return p1.activeOutputBuffersLock;
    }

    static synthetic int access$610(org.webrtc.HardwareVideoDecoder p2)
    {
        int v0 = p2.activeOutputBuffers;
        p2.activeOutputBuffers = (v0 - 1);
        return v0;
    }

    private static void copyI420(java.nio.ByteBuffer p17, int p18, org.webrtc.VideoFrame$I420Buffer p19, int p20, int p21, int p22, int p23)
    {
        int v9;
        int v15 = (p20 / 2);
        int v8 = ((p22 + 1) / 2);
        if ((p21 % 2) != 0) {
            v9 = (p23 / 2);
        } else {
            v9 = ((p23 + 1) / 2);
        }
        int v14 = (p18 + (p20 * p21));
        int v16 = (v14 + ((v15 * p21) / 2));
        org.webrtc.HardwareVideoDecoder.copyPlane(p17, p18, p20, p19.getDataY(), 0, p19.getStrideY(), p22, p23);
        org.webrtc.HardwareVideoDecoder.copyPlane(p17, v14, v15, p19.getDataU(), 0, p19.getStrideU(), v8, v9);
        org.webrtc.HardwareVideoDecoder.copyPlane(p17, v16, v15, p19.getDataV(), 0, p19.getStrideV(), v8, v9);
        if ((p21 % 2) != 0) {
            int v12 = p19.getStrideU();
            int v10 = (v9 * v12);
            org.webrtc.HardwareVideoDecoder.copyRow(p19.getDataU(), (v10 - v12), p19.getDataU(), v10, v8);
            int v13 = p19.getStrideV();
            int v11 = (v9 * v13);
            org.webrtc.HardwareVideoDecoder.copyRow(p19.getDataV(), (v11 - v13), p19.getDataV(), v11, v8);
        }
        return;
    }

    private static void copyPlane(java.nio.ByteBuffer p1, int p2, int p3, java.nio.ByteBuffer p4, int p5, int p6, int p7, int p8)
    {
        int v0 = 0;
        while (v0 < p8) {
            org.webrtc.HardwareVideoDecoder.copyRow(p1, p2, p4, p5, p7);
            p2 += p3;
            p5 += p6;
            v0++;
        }
        return;
    }

    private static void copyRow(java.nio.ByteBuffer p3, int p4, java.nio.ByteBuffer p5, int p6, int p7)
    {
        int v0 = 0;
        while (v0 < p7) {
            p5.put((p6 + v0), p3.get((p4 + v0)));
            v0++;
        }
        return;
    }

    private org.webrtc.VideoFrame$I420Buffer createBufferFromI420(java.nio.ByteBuffer p14, int p15, int p16, int p17, int p18, int p19, int p20)
    {
        int v9 = (p17 / 2);
        int v6 = ((p20 + 1) / 2);
        int v5 = (p16 + (p17 * p18));
        int v7 = (v5 + ((v9 * p18) / 2));
        this.activeOutputBuffers = (this.activeOutputBuffers + 1);
        return new org.webrtc.HardwareVideoDecoder$2(this, p14, p16, p20, v5, v6, v7, p17, v9, p19, p15);
    }

    private Thread createOutputThread()
    {
        return new org.webrtc.HardwareVideoDecoder$1(this, "HardwareVideoDecoder.outputThread");
    }

    private void deliverDecodedFrame()
    {
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            android.media.MediaCodec$BufferInfo v22_1 = new android.media.MediaCodec$BufferInfo();
            int v6 = this.codec.dequeueOutputBuffer(v22_1, 100000);
        } catch (IllegalStateException v20) {
            org.webrtc.Logging.e("HardwareVideoDecoder", "deliverDecodedFrame failed", v20);
            return;
        }
        if (v6 != -2) {
            if (v6 >= 0) {
                org.webrtc.HardwareVideoDecoder$FrameInfo v21_1 = ((org.webrtc.HardwareVideoDecoder$FrameInfo) this.frameInfos.poll());
                Integer v19 = 0;
                int v23 = 0;
                if (v21_1 != null) {
                    v19 = Integer.valueOf(((int) (android.os.SystemClock.elapsedRealtime() - v21_1.decodeStartTimeMs)));
                    v23 = v21_1.rotation;
                }
                this.hasDecodedFirstFrame = 1;
                int v10 = this.width;
                int v11 = this.height;
                int v8 = this.stride;
                int v9 = this.sliceHeight;
                if (v22_1.size >= (((v10 * v11) * 3) / 2)) {
                    if ((v22_1.size < (((v8 * v11) * 3) / 2)) && ((v9 == v11) && (v8 > v10))) {
                        v8 = ((v22_1.size * 2) / (v11 * 3));
                    }
                    org.webrtc.I420BufferImpl v14_1;
                    java.nio.ByteBuffer v5 = this.codec.getOutputBuffers()[v6];
                    v5.position(v22_1.offset);
                    v5.limit(v22_1.size);
                    if (this.colorFormat != 19) {
                        v14_1 = new org.webrtc.I420BufferImpl(v10, v11);
                        org.webrtc.HardwareVideoDecoder.nv12ToI420(v5, v22_1.offset, v14_1, v8, v9, v10, v11);
                        this.codec.releaseOutputBuffer(v6, 0);
                    } else {
                        if ((v9 % 2) != 0) {
                            v14_1 = new org.webrtc.I420BufferImpl(v10, v11);
                            org.webrtc.HardwareVideoDecoder.copyI420(v5, v22_1.offset, v14_1, v8, v9, v10, v11);
                            this.codec.releaseOutputBuffer(v6, 0);
                        } else {
                            v14_1 = this.createBufferFromI420(v5, v6, v22_1.offset, v8, v9, v10, v11);
                        }
                    }
                    org.webrtc.VideoFrame v13_2 = new org.webrtc.VideoFrame(v14_1, v23, (v22_1.presentationTimeUs * 1000), new android.graphics.Matrix());
                    this.callback.onDecodedFrame(v13_2, v19, 0);
                    v13_2.release();
                    return;
                } else {
                    org.webrtc.Logging.e("HardwareVideoDecoder", new StringBuilder().append("Insufficient output buffer size: ").append(v22_1.size).toString());
                    return;
                }
            } else {
                org.webrtc.Logging.v("HardwareVideoDecoder", new StringBuilder().append("dequeueOutputBuffer returned ").append(v6).toString());
                return;
            }
        } else {
            this.reformat(this.codec.getOutputFormat());
            return;
        }
    }

    private org.webrtc.VideoCodecStatus initDecodeInternal(int p8, int p9, org.webrtc.VideoDecoder$Callback p10)
    {
        org.webrtc.VideoCodecStatus v2_4;
        this.decoderThreadChecker.checkIsOnValidThread();
        if (this.outputThread == null) {
            this.callback = p10;
            this.width = p8;
            this.height = p9;
            this.stride = p8;
            this.sliceHeight = p9;
            this.hasDecodedFirstFrame = 0;
            this.keyFrameRequired = 1;
            try {
                this.codec = android.media.MediaCodec.createByCodecName(this.codecName);
                try {
                    android.media.MediaFormat v1 = android.media.MediaFormat.createVideoFormat(this.codecType.mimeType(), p8, p9);
                    v1.setInteger("color-format", this.colorFormat);
                    this.codec.configure(v1, 0, 0, 0);
                    this.codec.start();
                    this.running = 1;
                    this.outputThread = this.createOutputThread();
                    this.outputThread.start();
                    v2_4 = org.webrtc.VideoCodecStatus.OK;
                } catch (IllegalStateException v0) {
                    org.webrtc.Logging.e("HardwareVideoDecoder", "initDecode failed", v0);
                    this.release();
                    v2_4 = org.webrtc.VideoCodecStatus.ERROR;
                }
            } catch (IllegalStateException v0) {
                org.webrtc.Logging.e("HardwareVideoDecoder", new StringBuilder().append("Cannot create media decoder ").append(this.codecName).toString());
                v2_4 = org.webrtc.VideoCodecStatus.ERROR;
            } catch (IllegalStateException v0) {
            }
        } else {
            org.webrtc.Logging.e("HardwareVideoDecoder", "initDecodeInternal called while the codec is already running");
            v2_4 = org.webrtc.VideoCodecStatus.ERROR;
        }
        return v2_4;
    }

    private boolean isSupportedColorFormat(int p6)
    {
        int v1 = 0;
        int[] v3 = org.webrtc.MediaCodecUtils.DECODER_COLOR_FORMATS;
        int v2 = 0;
        while (v2 < v3.length) {
            if (v3[v2] != p6) {
                v2++;
            } else {
                v1 = 1;
                break;
            }
        }
        return v1;
    }

    private static void nv12ToI420(java.nio.ByteBuffer p15, int p16, org.webrtc.VideoFrame$I420Buffer p17, int p18, int p19, int p20, int p21)
    {
        int v14 = (p16 + (p18 * p19));
        int v9 = ((p20 + 1) / 2);
        int v8 = ((p21 + 1) / 2);
        org.webrtc.HardwareVideoDecoder.copyPlane(p15, p16, p18, p17.getDataY(), 0, p17.getStrideY(), p20, p21);
        int v10 = 0;
        int v11 = 0;
        int v12 = 0;
        while (v12 < v8) {
            int v13 = 0;
            while (v13 < v9) {
                p17.getDataU().put((v10 + v13), p15.get(((v13 * 2) + v14)));
                p17.getDataV().put((v11 + v13), p15.get((((v13 * 2) + v14) + 1)));
                v13++;
            }
            v10 += p17.getStrideU();
            v11 += p17.getStrideV();
            v14 += p18;
            v12++;
        }
        return;
    }

    private void reformat(android.media.MediaFormat p7)
    {
        int v1;
        int v0;
        this.outputThreadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("HardwareVideoDecoder", new StringBuilder().append("Decoder format changed: ").append(p7.toString()).toString());
        if ((!p7.containsKey("crop-left")) || ((!p7.containsKey("crop-right")) || ((!p7.containsKey("crop-bottom")) || (!p7.containsKey("crop-top"))))) {
            v1 = p7.getInteger("width");
            v0 = p7.getInteger("height");
        } else {
            v1 = ((p7.getInteger("crop-right") + 1) - p7.getInteger("crop-left"));
            v0 = ((p7.getInteger("crop-bottom") + 1) - p7.getInteger("crop-top"));
        }
        if ((!this.hasDecodedFirstFrame) || ((this.width == v1) && (this.height == v0))) {
            this.width = v1;
            this.height = v0;
            if (p7.containsKey("color-format")) {
                this.colorFormat = p7.getInteger("color-format");
                org.webrtc.Logging.d("HardwareVideoDecoder", new StringBuilder().append("Color: 0x").append(Integer.toHexString(this.colorFormat)).toString());
                if (!this.isSupportedColorFormat(this.colorFormat)) {
                    this.stopOnOutputThread(new IllegalStateException(new StringBuilder().append("Unsupported color format: ").append(this.colorFormat).toString()));
                    return;
                }
            }
            try {
                if (p7.containsKey("stride")) {
                    this.stride = p7.getInteger("stride");
                }
            } catch (int v2_8) {
                throw v2_8;
            }
            if (p7.containsKey("slice-height")) {
                this.sliceHeight = p7.getInteger("slice-height");
            }
            org.webrtc.Logging.d("HardwareVideoDecoder", new StringBuilder().append("Frame stride and slice height: ").append(this.stride).append(" x ").append(this.sliceHeight).toString());
            this.stride = Math.max(this.width, this.stride);
            this.sliceHeight = Math.max(this.height, this.sliceHeight);
        } else {
            this.stopOnOutputThread(new RuntimeException(new StringBuilder().append("Unexpected size change. Configured ").append(this.width).append("*").append(this.height).append(". New ").append(v1).append("*").append(v0).toString()));
        }
        return;
    }

    private org.webrtc.VideoCodecStatus reinitDecode(int p3, int p4)
    {
        this.decoderThreadChecker.checkIsOnValidThread();
        org.webrtc.VideoCodecStatus v0 = this.release();
        if (v0 == org.webrtc.VideoCodecStatus.OK) {
            v0 = this.initDecodeInternal(p3, p4, this.callback);
        }
        return v0;
    }

    private void releaseCodecOnOutputThread()
    {
        this.outputThreadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("HardwareVideoDecoder", "Releasing MediaCodec on output thread");
        this.waitOutputBuffersReleasedOnOutputThread();
        try {
            this.codec.stop();
            try {
                this.codec.release();
            } catch (Exception v0_0) {
                org.webrtc.Logging.e("HardwareVideoDecoder", "Media decoder release failed", v0_0);
                this.shutdownException = v0_0;
            }
            this.codec = 0;
            this.callback = 0;
            this.outputThread = 0;
            this.frameInfos.clear();
            org.webrtc.Logging.d("HardwareVideoDecoder", "Release on output thread done");
            return;
        } catch (Exception v0_1) {
            org.webrtc.Logging.e("HardwareVideoDecoder", "Media decoder stop failed", v0_1);
        }
    }

    private void stopOnOutputThread(Exception p2)
    {
        this.outputThreadChecker.checkIsOnValidThread();
        this.running = 0;
        this.shutdownException = p2;
        return;
    }

    private void waitOutputBuffersReleasedOnOutputThread()
    {
        this.outputThreadChecker.checkIsOnValidThread();
        try {
            while (this.activeOutputBuffers > 0) {
                org.webrtc.Logging.d("HardwareVideoDecoder", "Waiting for all frames to be released.");
                try {
                    this.activeOutputBuffersLock.wait();
                } catch (InterruptedException v0) {
                    org.webrtc.Logging.e("HardwareVideoDecoder", "Interrupted while waiting for output buffers to be released.", v0);
                    return;
                }
            }
        } catch (String v1_2) {
            throw v1_2;
        }
        return;
    }

    public org.webrtc.VideoCodecStatus decode(org.webrtc.EncodedImage p15, org.webrtc.VideoDecoder$DecodeInfo p16)
    {
        org.webrtc.VideoCodecStatus v10;
        this.decoderThreadChecker.checkIsOnValidThread();
        if ((this.codec != null) && (this.callback != null)) {
            if (p15.buffer != null) {
                int v3 = p15.buffer.remaining();
                if (v3 != 0) {
                    if (((p15.encodedWidth * p15.encodedHeight) > 0) && ((p15.encodedWidth != this.width) || (p15.encodedHeight != this.height))) {
                        v10 = this.reinitDecode(p15.encodedWidth, p15.encodedHeight);
                        if (v10 != org.webrtc.VideoCodecStatus.OK) {
                            return v10;
                        }
                    }
                    if (this.keyFrameRequired) {
                        if (p15.frameType == org.webrtc.EncodedImage$FrameType.VideoFrameKey) {
                            if (!p15.completeFrame) {
                                org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - complete frame required first");
                                v10 = org.webrtc.VideoCodecStatus.ERROR;
                                return v10;
                            }
                        } else {
                            org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - key frame required first");
                            v10 = org.webrtc.VideoCodecStatus.ERROR;
                            return v10;
                        }
                    }
                    try {
                        int v1 = this.codec.dequeueInputBuffer(500000);
                    } catch (IllegalStateException v8_0) {
                        org.webrtc.Logging.e("HardwareVideoDecoder", "dequeueInputBuffer failed", v8_0);
                        v10 = org.webrtc.VideoCodecStatus.ERROR;
                    }
                    if (v1 >= 0) {
                        try {
                            java.nio.ByteBuffer v7 = this.codec.getInputBuffers()[v1];
                        } catch (IllegalStateException v8_1) {
                            org.webrtc.Logging.e("HardwareVideoDecoder", "getInputBuffers failed", v8_1);
                            v10 = org.webrtc.VideoCodecStatus.ERROR;
                        }
                        if (v7.capacity() >= v3) {
                            v7.put(p15.buffer);
                            this.frameInfos.offer(new org.webrtc.HardwareVideoDecoder$FrameInfo(android.os.SystemClock.elapsedRealtime(), p15.rotation));
                            try {
                                this.codec.queueInputBuffer(v1, 0, v3, (p15.captureTimeMs * 1000), 0);
                            } catch (IllegalStateException v8_2) {
                                org.webrtc.Logging.e("HardwareVideoDecoder", "queueInputBuffer failed", v8_2);
                                this.frameInfos.pollLast();
                                v10 = org.webrtc.VideoCodecStatus.ERROR;
                            }
                            if (this.keyFrameRequired) {
                                this.keyFrameRequired = 0;
                            }
                            v10 = org.webrtc.VideoCodecStatus.OK;
                        } else {
                            org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - HW buffer too small");
                            v10 = org.webrtc.VideoCodecStatus.ERROR;
                        }
                    } else {
                        org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - no HW buffers available; decoder falling behind");
                        v10 = org.webrtc.VideoCodecStatus.ERROR;
                    }
                } else {
                    org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - input buffer empty");
                    v10 = org.webrtc.VideoCodecStatus.ERR_PARAMETER;
                }
            } else {
                org.webrtc.Logging.e("HardwareVideoDecoder", "decode() - no input data");
                v10 = org.webrtc.VideoCodecStatus.ERR_PARAMETER;
            }
        } else {
            v10 = org.webrtc.VideoCodecStatus.UNINITIALIZED;
        }
        return v10;
    }

    public String getImplementationName()
    {
        return new StringBuilder().append("HardwareVideoDecoder: ").append(this.codecName).toString();
    }

    public boolean getPrefersLateDecoding()
    {
        return 1;
    }

    public org.webrtc.VideoCodecStatus initDecode(org.webrtc.VideoDecoder$Settings p3, org.webrtc.VideoDecoder$Callback p4)
    {
        this.decoderThreadChecker = new org.webrtc.ThreadUtils$ThreadChecker();
        return this.initDecodeInternal(p3.width, p3.height, p4);
    }

    public org.webrtc.VideoCodecStatus release()
    {
        try {
            org.webrtc.VideoCodecStatus v0_3;
            this.running = 0;
        } catch (org.webrtc.VideoCodecStatus v0_1) {
            this.codec = 0;
            this.callback = 0;
            this.outputThread = 0;
            this.frameInfos.clear();
            throw v0_1;
        }
        if (org.webrtc.ThreadUtils.joinUninterruptibly(this.outputThread, 5000)) {
            if (this.shutdownException == null) {
                this.codec = 0;
                this.callback = 0;
                this.outputThread = 0;
                this.frameInfos.clear();
                v0_3 = org.webrtc.VideoCodecStatus.OK;
            } else {
                org.webrtc.Logging.e("HardwareVideoDecoder", "Media encoder release error", new RuntimeException(this.shutdownException));
                this.shutdownException = 0;
                v0_3 = org.webrtc.VideoCodecStatus.ERROR;
                this.codec = 0;
                this.callback = 0;
                this.outputThread = 0;
                this.frameInfos.clear();
            }
        } else {
            org.webrtc.Logging.e("HardwareVideoDecoder", "Media encoder release timeout", new RuntimeException());
            v0_3 = org.webrtc.VideoCodecStatus.TIMEOUT;
            this.codec = 0;
            this.callback = 0;
            this.outputThread = 0;
            this.frameInfos.clear();
        }
        return v0_3;
    }
}
