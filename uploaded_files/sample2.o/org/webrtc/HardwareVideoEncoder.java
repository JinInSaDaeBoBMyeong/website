package org.webrtc;
 class HardwareVideoEncoder implements org.webrtc.VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final String KEY_BITRATE_MODE = "bitrate-mode";
    private static final int MAX_ENCODER_Q_SIZE = 2;
    private static final int MAX_VIDEO_FRAMERATE = 30;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private static final int VIDEO_ControlRateConstant = 2;
    private int adjustedBitrate;
    private final org.webrtc.BitrateAdjuster bitrateAdjuster;
    private org.webrtc.VideoEncoder$Callback callback;
    private android.media.MediaCodec codec;
    private final String codecName;
    private final org.webrtc.VideoCodecType codecType;
    private final int colorFormat;
    private java.nio.ByteBuffer configBuffer;
    private final long forcedKeyFrameMs;
    private int height;
    private final org.webrtc.HardwareVideoEncoder$ColorFormat inputColorFormat;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameMs;
    private final java.util.Deque outputBuilders;
    private Thread outputThread;
    private volatile boolean running;
    private volatile Exception shutdownException;
    private int width;

    public HardwareVideoEncoder(String p3, org.webrtc.VideoCodecType p4, int p5, int p6, int p7, org.webrtc.BitrateAdjuster p8)
    {
        this.running = 0;
        this.shutdownException = 0;
        this.configBuffer = 0;
        this.codecName = p3;
        this.codecType = p4;
        this.colorFormat = p5;
        this.inputColorFormat = org.webrtc.HardwareVideoEncoder$ColorFormat.valueOf(p5);
        this.keyFrameIntervalSec = p6;
        this.forcedKeyFrameMs = ((long) p7);
        this.bitrateAdjuster = p8;
        this.outputBuilders = new java.util.concurrent.LinkedBlockingDeque();
        return;
    }

    static synthetic boolean access$000(org.webrtc.HardwareVideoEncoder p1)
    {
        return p1.running;
    }

    static synthetic void access$100(org.webrtc.HardwareVideoEncoder p0)
    {
        p0.deliverEncodedImage();
        return;
    }

    static synthetic void access$200(org.webrtc.HardwareVideoEncoder p0)
    {
        p0.releaseCodecOnOutputThread();
        return;
    }

    private Thread createOutputThread()
    {
        return new org.webrtc.HardwareVideoEncoder$1(this);
    }

    private void deliverEncodedImage()
    {
        int v7 = 0;
        try {
            android.media.MediaCodec$BufferInfo v6_1 = new android.media.MediaCodec$BufferInfo();
            int v5 = this.codec.dequeueOutputBuffer(v6_1, 100000);
        } catch (IllegalStateException v2) {
            org.webrtc.Logging.e("HardwareVideoEncoder", "deliverOutput failed", v2);
            return;
        }
        if (v5 >= 0) {
            java.nio.ByteBuffer v1 = this.codec.getOutputBuffers()[v5];
            v1.position(v6_1.offset);
            v1.limit((v6_1.offset + v6_1.size));
            if ((v6_1.flags & 2) == 0) {
                this.bitrateAdjuster.reportEncodedFrame(v6_1.size);
                if (this.adjustedBitrate != this.bitrateAdjuster.getAdjustedBitrateBps()) {
                    this.updateBitrate();
                }
                if ((v6_1.flags & 1) != 0) {
                    v7 = 1;
                }
                if ((v7 == 0) || (this.codecType != org.webrtc.VideoCodecType.H264)) {
                    java.nio.ByteBuffer v3 = java.nio.ByteBuffer.allocateDirect(v6_1.size);
                } else {
                    org.webrtc.Logging.d("HardwareVideoEncoder", new StringBuilder().append("Prepending config frame of size ").append(this.configBuffer.capacity()).append(" to output buffer with offset ").append(v6_1.offset).append(", size ").append(v6_1.size).toString());
                    v3 = java.nio.ByteBuffer.allocateDirect((v6_1.size + this.configBuffer.capacity()));
                    this.configBuffer.rewind();
                    v3.put(this.configBuffer);
                }
                v3.put(v1);
                v3.rewind();
                org.webrtc.EncodedImage$FrameType v4 = org.webrtc.EncodedImage$FrameType.VideoFrameDelta;
                if (v7 != 0) {
                    org.webrtc.Logging.d("HardwareVideoEncoder", "Sync frame generated");
                    v4 = org.webrtc.EncodedImage$FrameType.VideoFrameKey;
                }
                org.webrtc.EncodedImage$Builder v0_1 = ((org.webrtc.EncodedImage$Builder) this.outputBuilders.poll());
                v0_1.setBuffer(v3).setFrameType(v4);
                this.callback.onEncodedFrame(v0_1.createEncodedImage(), new org.webrtc.VideoEncoder$CodecSpecificInfo());
            } else {
                org.webrtc.Logging.d("HardwareVideoEncoder", new StringBuilder().append("Config frame generated. Offset: ").append(v6_1.offset).append(". Size: ").append(v6_1.size).toString());
                this.configBuffer = java.nio.ByteBuffer.allocateDirect(v6_1.size);
                this.configBuffer.put(v1);
            }
            this.codec.releaseOutputBuffer(v5, 0);
            return;
        } else {
            return;
        }
    }

    private org.webrtc.VideoCodecStatus initEncodeInternal(int p8, int p9, int p10, int p11, org.webrtc.VideoEncoder$Callback p12)
    {
        org.webrtc.Logging.d("HardwareVideoEncoder", new StringBuilder().append("initEncode: ").append(p8).append(" x ").append(p9).append(". @ ").append(p10).append("kbps. Fps: ").append(p11).toString());
        this.width = p8;
        this.height = p9;
        if ((p10 != 0) && (p11 != 0)) {
            this.bitrateAdjuster.setTargets((p10 * 1000), p11);
        }
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        this.callback = p12;
        this.lastKeyFrameMs = -1;
        try {
            this.codec = android.media.MediaCodec.createByCodecName(this.codecName);
            try {
                android.media.MediaFormat v1 = android.media.MediaFormat.createVideoFormat(this.codecType.mimeType(), p8, p9);
                v1.setInteger("bitrate", this.adjustedBitrate);
                v1.setInteger("bitrate-mode", 2);
                v1.setInteger("color-format", this.colorFormat);
                v1.setInteger("frame-rate", this.bitrateAdjuster.getAdjustedFramerate());
                v1.setInteger("i-frame-interval", this.keyFrameIntervalSec);
                org.webrtc.Logging.d("HardwareVideoEncoder", new StringBuilder().append("Format: ").append(v1).toString());
                this.codec.configure(v1, 0, 0, 1);
                this.codec.start();
                this.running = 1;
                this.outputThread = this.createOutputThread();
                this.outputThread.start();
                org.webrtc.VideoCodecStatus v2_3 = org.webrtc.VideoCodecStatus.OK;
            } catch (IllegalStateException v0) {
                org.webrtc.Logging.e("HardwareVideoEncoder", "initEncode failed", v0);
                this.release();
                v2_3 = org.webrtc.VideoCodecStatus.ERROR;
            }
            return v2_3;
        } catch (IllegalStateException v0) {
            org.webrtc.Logging.e("HardwareVideoEncoder", new StringBuilder().append("Cannot create media encoder ").append(this.codecName).toString());
            v2_3 = org.webrtc.VideoCodecStatus.ERROR;
            return v2_3;
        } catch (IllegalStateException v0) {
        }
    }

    private void releaseCodecOnOutputThread()
    {
        org.webrtc.Logging.d("HardwareVideoEncoder", "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
            try {
                this.codec.release();
            } catch (Exception v0_0) {
                org.webrtc.Logging.e("HardwareVideoEncoder", "Media encoder release failed", v0_0);
                this.shutdownException = v0_0;
            }
            org.webrtc.Logging.d("HardwareVideoEncoder", "Release on output thread done");
            return;
        } catch (Exception v0_1) {
            org.webrtc.Logging.e("HardwareVideoEncoder", "Media encoder stop failed", v0_1);
        }
    }

    private void requestKeyFrame(long p6)
    {
        try {
            android.os.Bundle v0_1 = new android.os.Bundle();
            v0_1.putInt("request-sync", 0);
            this.codec.setParameters(v0_1);
            this.lastKeyFrameMs = p6;
        } catch (IllegalStateException v1) {
            org.webrtc.Logging.e("HardwareVideoEncoder", "requestKeyFrame failed", v1);
        }
        return;
    }

    private org.webrtc.VideoCodecStatus resetCodec(int p8, int p9)
    {
        org.webrtc.VideoCodecStatus v6 = this.release();
        if (v6 == org.webrtc.VideoCodecStatus.OK) {
            v6 = this.initEncodeInternal(p8, p9, 0, 0, this.callback);
        }
        return v6;
    }

    private boolean shouldForceKeyFrame(long p6)
    {
        if ((this.forcedKeyFrameMs <= 0) || (p6 <= (this.lastKeyFrameMs + this.forcedKeyFrameMs))) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    private org.webrtc.VideoCodecStatus updateBitrate()
    {
        this.adjustedBitrate = this.bitrateAdjuster.getAdjustedBitrateBps();
        try {
            android.os.Bundle v1_1 = new android.os.Bundle();
            v1_1.putInt("video-bitrate", this.adjustedBitrate);
            this.codec.setParameters(v1_1);
            org.webrtc.VideoCodecStatus v2_1 = org.webrtc.VideoCodecStatus.OK;
        } catch (IllegalStateException v0) {
            org.webrtc.Logging.e("HardwareVideoEncoder", "updateBitrate failed", v0);
            v2_1 = org.webrtc.VideoCodecStatus.ERROR;
        }
        return v2_1;
    }

    public org.webrtc.VideoCodecStatus encode(org.webrtc.VideoFrame p27, org.webrtc.VideoEncoder$EncodeInfo p28)
    {
        org.webrtc.VideoCodecStatus v21;
        if (this.codec != null) {
            int v16 = p27.getWidth();
            int v14 = p27.getHeight();
            if ((v16 != this.width) || (v14 != this.height)) {
                v21 = this.resetCodec(v16, v14);
                if (v21 != org.webrtc.VideoCodecStatus.OK) {
                    return v21;
                }
            }
            try {
                int v5 = this.codec.dequeueInputBuffer(0);
            } catch (IllegalStateException v13_1) {
                org.webrtc.Logging.e("HardwareVideoEncoder", "dequeueInputBuffer failed", v13_1);
                v21 = org.webrtc.VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            if (v5 != -1) {
                if (this.outputBuilders.size() <= 2) {
                    try {
                        this.inputColorFormat.fillBufferFromI420(this.codec.getInputBuffers()[v5], p27.getBuffer().toI420());
                        int v20 = 0;
                        String v6_9 = p28.frameTypes;
                        java.util.Deque v4_9 = 0;
                    } catch (IllegalStateException v13_2) {
                        org.webrtc.Logging.e("HardwareVideoEncoder", "getInputBuffers failed", v13_2);
                        v21 = org.webrtc.VideoCodecStatus.FALLBACK_SOFTWARE;
                    }
                    while (v4_9 < v6_9.length) {
                        if (v6_9[v4_9] == org.webrtc.EncodedImage$FrameType.VideoFrameKey) {
                            v20 = 1;
                        }
                        v4_9++;
                    }
                    long v8 = ((p27.getTimestampNs() + 500) / 1000);
                    long v18 = ((500 + v8) / 1000);
                    if ((v20 != 0) || (this.shouldForceKeyFrame(v18))) {
                        this.requestKeyFrame(v18);
                    }
                    int v7 = (((p27.getBuffer().getHeight() * p27.getBuffer().getWidth()) * 3) / 2);
                    this.outputBuilders.offer(org.webrtc.EncodedImage.builder().setCaptureTimeMs(v18).setCompleteFrame(1).setEncodedWidth(p27.getWidth()).setEncodedHeight(p27.getHeight()).setRotation(p27.getRotation()));
                    try {
                        this.codec.queueInputBuffer(v5, 0, v7, v8, 0);
                        v21 = org.webrtc.VideoCodecStatus.OK;
                    } catch (IllegalStateException v13_0) {
                        org.webrtc.Logging.e("HardwareVideoEncoder", "queueInputBuffer failed", v13_0);
                        this.outputBuilders.pollLast();
                        v21 = org.webrtc.VideoCodecStatus.FALLBACK_SOFTWARE;
                    }
                } else {
                    org.webrtc.Logging.e("HardwareVideoEncoder", "Dropped frame, encoder queue full");
                    v21 = org.webrtc.VideoCodecStatus.OK;
                }
            } else {
                org.webrtc.Logging.e("HardwareVideoEncoder", "Dropped frame, no input buffers available");
                v21 = org.webrtc.VideoCodecStatus.OK;
            }
        } else {
            v21 = org.webrtc.VideoCodecStatus.UNINITIALIZED;
        }
        return v21;
    }

    public String getImplementationName()
    {
        return new StringBuilder().append("HardwareVideoEncoder: ").append(this.codecName).toString();
    }

    public org.webrtc.VideoEncoder$ScalingSettings getScalingSettings()
    {
        return 0;
    }

    public org.webrtc.VideoCodecStatus initEncode(org.webrtc.VideoEncoder$Settings p7, org.webrtc.VideoEncoder$Callback p8)
    {
        return this.initEncodeInternal(p7.width, p7.height, p7.startBitrate, p7.maxFramerate, p8);
    }

    public org.webrtc.VideoCodecStatus release()
    {
        try {
            org.webrtc.VideoCodecStatus v0_3;
            this.running = 0;
        } catch (org.webrtc.VideoCodecStatus v0_1) {
            this.codec = 0;
            this.outputThread = 0;
            this.outputBuilders.clear();
            throw v0_1;
        }
        if (org.webrtc.ThreadUtils.joinUninterruptibly(this.outputThread, 5000)) {
            if (this.shutdownException == null) {
                this.codec = 0;
                this.outputThread = 0;
                this.outputBuilders.clear();
                v0_3 = org.webrtc.VideoCodecStatus.OK;
            } else {
                org.webrtc.Logging.e("HardwareVideoEncoder", "Media encoder release exception", this.shutdownException);
                v0_3 = org.webrtc.VideoCodecStatus.ERROR;
                this.codec = 0;
                this.outputThread = 0;
                this.outputBuilders.clear();
            }
        } else {
            org.webrtc.Logging.e("HardwareVideoEncoder", "Media encoder release timeout");
            v0_3 = org.webrtc.VideoCodecStatus.TIMEOUT;
            this.codec = 0;
            this.outputThread = 0;
            this.outputBuilders.clear();
        }
        return v0_3;
    }

    public org.webrtc.VideoCodecStatus setChannelParameters(short p2, long p3)
    {
        return org.webrtc.VideoCodecStatus.OK;
    }

    public org.webrtc.VideoCodecStatus setRateAllocation(org.webrtc.VideoEncoder$BitrateAllocation p3, int p4)
    {
        if (p4 > 30) {
            p4 = 30;
        }
        this.bitrateAdjuster.setTargets(p3.getSum(), p4);
        return this.updateBitrate();
    }
}
