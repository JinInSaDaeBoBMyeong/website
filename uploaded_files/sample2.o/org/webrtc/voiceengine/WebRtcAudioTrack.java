package org.webrtc.voiceengine;
public class WebRtcAudioTrack {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = False;
    private static final String TAG = "WebRtcAudioTrack";
    private static org.webrtc.voiceengine.WebRtcAudioTrack$WebRtcAudioTrackErrorCallback errorCallback;
    private static volatile boolean speakerMute;
    private final android.media.AudioManager audioManager;
    private org.webrtc.voiceengine.WebRtcAudioTrack$AudioTrackThread audioThread;
    private android.media.AudioTrack audioTrack;
    private java.nio.ByteBuffer byteBuffer;
    private byte[] emptyBytes;
    private final long nativeAudioTrack;

    static WebRtcAudioTrack()
    {
        org.webrtc.voiceengine.WebRtcAudioTrack.speakerMute = 0;
        org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback = 0;
        return;
    }

    WebRtcAudioTrack(long p4)
    {
        this.audioTrack = 0;
        this.audioThread = 0;
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("ctor").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        this.nativeAudioTrack = p4;
        this.audioManager = ((android.media.AudioManager) org.webrtc.ContextUtils.getApplicationContext().getSystemService("audio"));
        return;
    }

    static synthetic android.media.AudioTrack access$000(org.webrtc.voiceengine.WebRtcAudioTrack p1)
    {
        return p1.audioTrack;
    }

    static synthetic void access$100(boolean p0)
    {
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(p0);
        return;
    }

    static synthetic void access$200(org.webrtc.voiceengine.WebRtcAudioTrack p0, String p1)
    {
        p0.reportWebRtcAudioTrackStartError(p1);
        return;
    }

    static synthetic void access$300(org.webrtc.voiceengine.WebRtcAudioTrack p0)
    {
        p0.releaseAudioResources();
        return;
    }

    static synthetic java.nio.ByteBuffer access$400(org.webrtc.voiceengine.WebRtcAudioTrack p1)
    {
        return p1.byteBuffer;
    }

    static synthetic long access$500(org.webrtc.voiceengine.WebRtcAudioTrack p2)
    {
        return p2.nativeAudioTrack;
    }

    static synthetic void access$600(org.webrtc.voiceengine.WebRtcAudioTrack p0, int p1, long p2)
    {
        p0.nativeGetPlayoutData(p1, p2);
        return;
    }

    static synthetic boolean access$700()
    {
        return org.webrtc.voiceengine.WebRtcAudioTrack.speakerMute;
    }

    static synthetic byte[] access$800(org.webrtc.voiceengine.WebRtcAudioTrack p1)
    {
        return p1.emptyBytes;
    }

    static synthetic void access$900(org.webrtc.voiceengine.WebRtcAudioTrack p0, String p1)
    {
        p0.reportWebRtcAudioTrackError(p1);
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
            v0_1 = 4;
        }
        return v0_1;
    }

    private android.media.AudioTrack createAudioTrackOnLollipopOrHigher(int p8, int p9, int p10)
    {
        org.webrtc.Logging.d("WebRtcAudioTrack", "createAudioTrackOnLollipopOrHigher");
        int v6 = android.media.AudioTrack.getNativeOutputSampleRate(0);
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("nativeOutputSampleRate: ").append(v6).toString());
        if (p8 != v6) {
            org.webrtc.Logging.w("WebRtcAudioTrack", "Unable to use fast mode since requested sample rate is not native");
        }
        return new android.media.AudioTrack(new android.media.AudioAttributes$Builder().setUsage(2).setContentType(1).build(), new android.media.AudioFormat$Builder().setEncoding(2).setSampleRate(p8).setChannelMask(p9).build(), p10, 1, 0);
    }

    private int getStreamMaxVolume()
    {
        int v0_3;
        org.webrtc.Logging.d("WebRtcAudioTrack", "getStreamMaxVolume");
        if (this.audioManager == null) {
            v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_3);
        return this.audioManager.getStreamMaxVolume(0);
    }

    private int getStreamVolume()
    {
        int v0_3;
        org.webrtc.Logging.d("WebRtcAudioTrack", "getStreamVolume");
        if (this.audioManager == null) {
            v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_3);
        return this.audioManager.getStreamVolume(0);
    }

    private boolean initPlayout(int p13, int p14)
    {
        int v0_1;
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("initPlayout(sampleRate=").append(p13).append(", channels=").append(p14).append(")").toString());
        this.byteBuffer = java.nio.ByteBuffer.allocateDirect(((p13 / 100) * (p14 * 2)));
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("byteBuffer.capacity: ").append(this.byteBuffer.capacity()).toString());
        int v0_10 = new byte[this.byteBuffer.capacity()];
        this.emptyBytes = v0_10;
        this.nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
        int v3 = this.channelCountToConfiguration(p14);
        int v5 = android.media.AudioTrack.getMinBufferSize(p13, v3, 2);
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("AudioTrack.getMinBufferSize: ").append(v5).toString());
        if (v5 >= this.byteBuffer.capacity()) {
            if (this.audioTrack == null) {
                try {
                    if (!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                        this.audioTrack = new android.media.AudioTrack(0, p13, v3, 2, v5, 1);
                    } else {
                        this.audioTrack = this.createAudioTrackOnLollipopOrHigher(p13, v3, v5);
                    }
                } catch (IllegalArgumentException v8) {
                    this.reportWebRtcAudioTrackInitError(v8.getMessage());
                    this.releaseAudioResources();
                    v0_1 = 0;
                }
                if ((this.audioTrack != null) && (this.audioTrack.getState() == 1)) {
                    this.logMainParameters();
                    this.logMainParametersExtended();
                    v0_1 = 1;
                } else {
                    this.reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                    this.releaseAudioResources();
                    v0_1 = 0;
                }
            } else {
                this.reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
                v0_1 = 0;
            }
        } else {
            this.reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            v0_1 = 0;
        }
        return v0_1;
    }

    private boolean isVolumeFixed()
    {
        boolean v0_2;
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnLollipopOrHigher()) {
            v0_2 = this.audioManager.isVolumeFixed();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    private void logMainParameters()
    {
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("AudioTrack: session ID: ").append(this.audioTrack.getAudioSessionId()).append(", channels: ").append(this.audioTrack.getChannelCount()).append(", sample rate: ").append(this.audioTrack.getSampleRate()).append(", max gain: ").append(android.media.AudioTrack.getMaxVolume()).toString());
        return;
    }

    private void logMainParametersExtended()
    {
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnMarshmallowOrHigher()) {
            org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("AudioTrack: buffer size in frames: ").append(this.audioTrack.getBufferSizeInFrames()).toString());
        }
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnNougatOrHigher()) {
            org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("AudioTrack: buffer capacity in frames: ").append(this.audioTrack.getBufferCapacityInFrames()).toString());
        }
        return;
    }

    private void logUnderrunCount()
    {
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnNougatOrHigher()) {
            org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("underrun count: ").append(this.audioTrack.getUnderrunCount()).toString());
        }
        return;
    }

    private native void nativeCacheDirectBufferAddress();

    private native void nativeGetPlayoutData();

    private void releaseAudioResources()
    {
        if (this.audioTrack != null) {
            this.audioTrack.release();
            this.audioTrack = 0;
        }
        return;
    }

    private void reportWebRtcAudioTrackError(String p4)
    {
        org.webrtc.Logging.e("WebRtcAudioTrack", new StringBuilder().append("Run-time playback error: ").append(p4).toString());
        if (org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback.onWebRtcAudioTrackError(p4);
        }
        return;
    }

    private void reportWebRtcAudioTrackInitError(String p4)
    {
        org.webrtc.Logging.e("WebRtcAudioTrack", new StringBuilder().append("Init error: ").append(p4).toString());
        if (org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback.onWebRtcAudioTrackInitError(p4);
        }
        return;
    }

    private void reportWebRtcAudioTrackStartError(String p4)
    {
        org.webrtc.Logging.e("WebRtcAudioTrack", new StringBuilder().append("Start error: ").append(p4).toString());
        if (org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback != null) {
            org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback.onWebRtcAudioTrackStartError(p4);
        }
        return;
    }

    public static void setErrorCallback(org.webrtc.voiceengine.WebRtcAudioTrack$WebRtcAudioTrackErrorCallback p2)
    {
        org.webrtc.Logging.d("WebRtcAudioTrack", "Set error callback");
        org.webrtc.voiceengine.WebRtcAudioTrack.errorCallback = p2;
        return;
    }

    public static void setSpeakerMute(boolean p3)
    {
        org.webrtc.Logging.w("WebRtcAudioTrack", new StringBuilder().append("setSpeakerMute(").append(p3).append(")").toString());
        org.webrtc.voiceengine.WebRtcAudioTrack.speakerMute = p3;
        return;
    }

    private boolean setStreamVolume(int p6)
    {
        android.media.AudioManager v0_1;
        String v2 = 0;
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("setStreamVolume(").append(p6).append(")").toString());
        if (this.audioManager == null) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_1);
        if (!this.isVolumeFixed()) {
            this.audioManager.setStreamVolume(0, p6, 0);
            v2 = 1;
        } else {
            org.webrtc.Logging.e("WebRtcAudioTrack", "The device implements a fixed volume policy.");
        }
        return v2;
    }

    private boolean startPlayout()
    {
        org.webrtc.voiceengine.WebRtcAudioTrack$AudioTrackThread v0_10;
        int v2_0 = 0;
        org.webrtc.Logging.d("WebRtcAudioTrack", "startPlayout");
        if (this.audioTrack == null) {
            v0_10 = 0;
        } else {
            v0_10 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack$AudioTrackThread v0_1;
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_10);
        if (this.audioThread != null) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_1);
        if (this.audioTrack.getState() == 1) {
            this.audioThread = new org.webrtc.voiceengine.WebRtcAudioTrack$AudioTrackThread(this, "AudioTrackJavaThread");
            this.audioThread.start();
            v2_0 = 1;
        } else {
            this.reportWebRtcAudioTrackStartError("AudioTrack instance is not successfully initialized.");
        }
        return v2_0;
    }

    private boolean stopPlayout()
    {
        int v0_4;
        org.webrtc.Logging.d("WebRtcAudioTrack", "stopPlayout");
        if (this.audioThread == null) {
            v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.assertTrue(v0_4);
        this.logUnderrunCount();
        this.audioThread.joinThread();
        this.audioThread = 0;
        this.releaseAudioResources();
        return 1;
    }
}
