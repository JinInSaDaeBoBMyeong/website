package org.webrtc.voiceengine;
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = False;
    private static final String TAG = "WebRtcAudioRecord";
    private static org.webrtc.voiceengine.WebRtcAudioRecord$WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;
    private android.media.AudioRecord audioRecord;
    private org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordThread audioThread;
    private java.nio.ByteBuffer byteBuffer;
    private org.webrtc.voiceengine.WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;
    private final org.webrtc.ThreadUtils$ThreadChecker threadChecker;

    static WebRtcAudioRecord()
    {
        org.webrtc.voiceengine.WebRtcAudioRecord.microphoneMute = 0;
        org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback = 0;
        return;
    }

    WebRtcAudioRecord(long p4)
    {
        this.threadChecker = new org.webrtc.ThreadUtils$ThreadChecker();
        this.effects = 0;
        this.audioRecord = 0;
        this.audioThread = 0;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("ctor").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        this.nativeAudioRecord = p4;
        this.effects = org.webrtc.voiceengine.WebRtcAudioEffects.create();
        return;
    }

    static synthetic android.media.AudioRecord access$000(org.webrtc.voiceengine.WebRtcAudioRecord p1)
    {
        return p1.audioRecord;
    }

    static synthetic void access$100(boolean p0)
    {
        org.webrtc.voiceengine.WebRtcAudioRecord.assertTrue(p0);
        return;
    }

    static synthetic java.nio.ByteBuffer access$200(org.webrtc.voiceengine.WebRtcAudioRecord p1)
    {
        return p1.byteBuffer;
    }

    static synthetic boolean access$300()
    {
        return org.webrtc.voiceengine.WebRtcAudioRecord.microphoneMute;
    }

    static synthetic byte[] access$400(org.webrtc.voiceengine.WebRtcAudioRecord p1)
    {
        return p1.emptyBytes;
    }

    static synthetic long access$500(org.webrtc.voiceengine.WebRtcAudioRecord p2)
    {
        return p2.nativeAudioRecord;
    }

    static synthetic void access$600(org.webrtc.voiceengine.WebRtcAudioRecord p0, int p1, long p2)
    {
        p0.nativeDataIsRecorded(p1, p2);
        return;
    }

    static synthetic void access$700(org.webrtc.voiceengine.WebRtcAudioRecord p0, String p1)
    {
        p0.reportWebRtcAudioRecordError(p1);
        return;
    }

    private static void assertTrue(boolean p2)
    {
        if (p2) {
            return;
        } else {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int p2)
    {
        int v0_1;
        if (p2 != 1) {
            v0_1 = 12;
        } else {
            v0_1 = 16;
        }
        return v0_1;
    }

    private boolean enableBuiltInAEC(boolean p4)
    {
        boolean v0_4;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("enableBuiltInAEC(").append(p4).append(41).toString());
        if (this.effects != null) {
            v0_4 = this.effects.setAEC(p4);
        } else {
            org.webrtc.Logging.e("WebRtcAudioRecord", "Built-in AEC is not supported on this platform");
            v0_4 = 0;
        }
        return v0_4;
    }

    private boolean enableBuiltInNS(boolean p4)
    {
        boolean v0_4;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("enableBuiltInNS(").append(p4).append(41).toString());
        if (this.effects != null) {
            v0_4 = this.effects.setNS(p4);
        } else {
            org.webrtc.Logging.e("WebRtcAudioRecord", "Built-in NS is not supported on this platform");
            v0_4 = 0;
        }
        return v0_4;
    }

    private int initRecording(int p13, int p14)
    {
        int v8;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("initRecording(sampleRate=").append(p13).append(", channels=").append(p14).append(")").toString());
        if (org.webrtc.voiceengine.WebRtcAudioUtils.hasPermission(org.webrtc.ContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO")) {
            if (this.audioRecord == null) {
                v8 = (p13 / 100);
                this.byteBuffer = java.nio.ByteBuffer.allocateDirect(((p14 * 2) * v8));
                org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("byteBuffer.capacity: ").append(this.byteBuffer.capacity()).toString());
                org.webrtc.voiceengine.WebRtcAudioEffects v0_28 = new byte[this.byteBuffer.capacity()];
                this.emptyBytes = v0_28;
                this.nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
                int v3 = this.channelCountToConfiguration(p14);
                int v9 = android.media.AudioRecord.getMinBufferSize(p13, v3, 2);
                if ((v9 != -1) && (v9 != -2)) {
                    org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("AudioRecord.getMinBufferSize: ").append(v9).toString());
                    int v5 = Math.max((v9 * 2), this.byteBuffer.capacity());
                    org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("bufferSizeInBytes: ").append(v5).toString());
                    try {
                        this.audioRecord = new android.media.AudioRecord(7, p13, v3, 2, v5);
                    } catch (IllegalArgumentException v7) {
                        this.reportWebRtcAudioRecordInitError(new StringBuilder().append("AudioRecord ctor error: ").append(v7.getMessage()).toString());
                        this.releaseAudioResources();
                        v8 = -1;
                    }
                    if ((this.audioRecord != null) && (this.audioRecord.getState() == 1)) {
                        if (this.effects != null) {
                            this.effects.enable(this.audioRecord.getAudioSessionId());
                        }
                        this.logMainParameters();
                        this.logMainParametersExtended();
                    } else {
                        this.reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                        this.releaseAudioResources();
                        v8 = -1;
                    }
                } else {
                    this.reportWebRtcAudioRecordInitError(new StringBuilder().append("AudioRecord.getMinBufferSize failed: ").append(v9).toString());
                    v8 = -1;
                }
            } else {
                this.reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
                v8 = -1;
            }
        } else {
            this.reportWebRtcAudioRecordInitError("RECORD_AUDIO permission is missing");
            v8 = -1;
        }
        return v8;
    }

    private void logMainParameters()
    {
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("AudioRecord: session ID: ").append(this.audioRecord.getAudioSessionId()).append(", channels: ").append(this.audioRecord.getChannelCount()).append(", sample rate: ").append(this.audioRecord.getSampleRate()).toString());
        return;
    }

    private void logMainParametersExtended()
    {
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
            org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("AudioRecord: buffer size in frames: ").append(this.audioRecord.getBufferSizeInFrames()).toString());
        }
        return;
    }

    private native void nativeCacheDirectBufferAddress();

    private native void nativeDataIsRecorded();

    private void releaseAudioResources()
    {
        if (this.audioRecord != null) {
            this.audioRecord.release();
            this.audioRecord = 0;
        }
        return;
    }

    private void reportWebRtcAudioRecordError(String p4)
    {
        org.webrtc.Logging.e("WebRtcAudioRecord", new StringBuilder().append("Run-time recording error: ").append(p4).toString());
        if (org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback.onWebRtcAudioRecordError(p4);
        }
        return;
    }

    private void reportWebRtcAudioRecordInitError(String p4)
    {
        org.webrtc.Logging.e("WebRtcAudioRecord", new StringBuilder().append("Init recording error: ").append(p4).toString());
        if (org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback.onWebRtcAudioRecordInitError(p4);
        }
        return;
    }

    private void reportWebRtcAudioRecordStartError(org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode p4, String p5)
    {
        org.webrtc.Logging.e("WebRtcAudioRecord", new StringBuilder().append("Start recording error: ").append(p4).append(". ").append(p5).toString());
        if (org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback.onWebRtcAudioRecordStartError(p4, p5);
        }
        return;
    }

    public static void setErrorCallback(org.webrtc.voiceengine.WebRtcAudioRecord$WebRtcAudioRecordErrorCallback p2)
    {
        org.webrtc.Logging.d("WebRtcAudioRecord", "Set error callback");
        org.webrtc.voiceengine.WebRtcAudioRecord.errorCallback = p2;
        return;
    }

    public static void setMicrophoneMute(boolean p3)
    {
        org.webrtc.Logging.w("WebRtcAudioRecord", new StringBuilder().append("setMicrophoneMute(").append(p3).append(")").toString());
        org.webrtc.voiceengine.WebRtcAudioRecord.microphoneMute = p3;
        return;
    }

    private boolean startRecording()
    {
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordThread v2_0;
        String v4_0 = 0;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", "startRecording");
        if (this.audioRecord == null) {
            v2_0 = 0;
        } else {
            v2_0 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordThread v2_2;
        org.webrtc.voiceengine.WebRtcAudioRecord.assertTrue(v2_0);
        if (this.audioThread != null) {
            v2_2 = 0;
        } else {
            v2_2 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioRecord.assertTrue(v2_2);
        try {
            this.audioRecord.startRecording();
            int v1 = 0;
        } catch (IllegalStateException v0) {
            this.reportWebRtcAudioRecordStartError(org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, new StringBuilder().append("AudioRecord.startRecording failed: ").append(v0.getMessage()).toString());
            return v4_0;
        }
        while (this.audioRecord.getRecordingState() != 3) {
            v1++;
            if (v1 >= 2) {
                break;
            }
            this.threadSleep(200);
        }
        if (this.audioRecord.getRecordingState() == 3) {
            this.audioThread = new org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordThread(this, "AudioRecordJavaThread");
            this.audioThread.start();
            v4_0 = 1;
            return v4_0;
        } else {
            this.reportWebRtcAudioRecordStartError(org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, new StringBuilder().append("AudioRecord.startRecording failed - incorrect state :").append(this.audioRecord.getRecordingState()).toString());
            return v4_0;
        }
    }

    private boolean stopRecording()
    {
        org.webrtc.voiceengine.WebRtcAudioEffects v0_10;
        this.threadChecker.checkIsOnValidThread();
        org.webrtc.Logging.d("WebRtcAudioRecord", "stopRecording");
        if (this.audioThread == null) {
            v0_10 = 0;
        } else {
            v0_10 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioRecord.assertTrue(v0_10);
        this.audioThread.stopThread();
        if (!org.webrtc.ThreadUtils.joinUninterruptibly(this.audioThread, 2000)) {
            org.webrtc.Logging.e("WebRtcAudioRecord", "Join of AudioRecordJavaThread timed out");
        }
        this.audioThread = 0;
        if (this.effects != null) {
            this.effects.release();
        }
        this.releaseAudioResources();
        return 1;
    }

    private void threadSleep(long p6)
    {
        try {
            Thread.sleep(p6);
        } catch (InterruptedException v0) {
            org.webrtc.Logging.e("WebRtcAudioRecord", new StringBuilder().append("Thread.sleep failed: ").append(v0.getMessage()).toString());
        }
        return;
    }
}
