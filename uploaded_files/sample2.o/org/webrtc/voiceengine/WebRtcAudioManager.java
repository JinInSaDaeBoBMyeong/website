package org.webrtc.voiceengine;
public class WebRtcAudioManager {
    private static final String[] AUDIO_MODES = None;
    private static final int BITS_PER_SAMPLE = 16;
    private static final boolean DEBUG = False;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final String TAG = "WebRtcAudioManager";
    private static boolean blacklistDeviceForOpenSLESUsage;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
    private static boolean useStereoInput;
    private static boolean useStereoOutput;
    private final android.media.AudioManager audioManager;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private boolean initialized;
    private int inputBufferSize;
    private int inputChannels;
    private boolean lowLatencyInput;
    private boolean lowLatencyOutput;
    private final long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int outputChannels;
    private boolean proAudio;
    private int sampleRate;
    private final org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger volumeLogger;

    static WebRtcAudioManager()
    {
        org.webrtc.voiceengine.WebRtcAudioManager.useStereoOutput = 0;
        org.webrtc.voiceengine.WebRtcAudioManager.useStereoInput = 0;
        org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsage = 0;
        org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsageIsOverridden = 0;
        String[] v0_1 = new String[4];
        v0_1[0] = "MODE_NORMAL";
        v0_1[1] = "MODE_RINGTONE";
        v0_1[2] = "MODE_IN_CALL";
        v0_1[3] = "MODE_IN_COMMUNICATION";
        org.webrtc.voiceengine.WebRtcAudioManager.AUDIO_MODES = v0_1;
        return;
    }

    WebRtcAudioManager(long p20)
    {
        void v19_1 = ;
v19_1.initialized = 0;
        org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("ctor").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        v19_1.nativeAudioManager = p20;
        v19_1.audioManager = ((android.media.AudioManager) org.webrtc.ContextUtils.getApplicationContext().getSystemService("audio"));
        v19_1.volumeLogger = new org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger(v19_1.audioManager);
        void v19_2 = v19_1.storeAudioParameters();
        v19_2.nativeCacheAudioParameters(v19_2.sampleRate, v19_2.outputChannels, v19_2.inputChannels, v19_2.hardwareAEC, v19_2.hardwareAGC, v19_2.hardwareNS, v19_2.lowLatencyOutput, v19_2.lowLatencyInput, v19_2.proAudio, v19_2.outputBufferSize, v19_2.inputBufferSize, p20);
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

    private void dispose()
    {
        org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("dispose").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        if (this.initialized) {
            org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger.access$100(this.volumeLogger);
        }
        return;
    }

    private int getLowLatencyInputFramesPerBuffer()
    {
        org.webrtc.voiceengine.WebRtcAudioManager.assertTrue(this.isLowLatencyInputSupported());
        return this.getLowLatencyOutputFramesPerBuffer();
    }

    private int getLowLatencyOutputFramesPerBuffer()
    {
        int v1 = 256;
        org.webrtc.voiceengine.WebRtcAudioManager.assertTrue(this.isLowLatencyOutputSupported());
        if (org.webrtc.voiceengine.WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher()) {
            String v0 = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            if (v0 != null) {
                v1 = Integer.parseInt(v0);
            }
        }
        return v1;
    }

    private static int getMinInputFrameSize(int p3, int p4)
    {
        int v1;
        if (p4 != 1) {
            v1 = 12;
        } else {
            v1 = 16;
        }
        return (android.media.AudioRecord.getMinBufferSize(p3, v1, 2) / (p4 * 2));
    }

    private static int getMinOutputFrameSize(int p3, int p4)
    {
        int v1;
        if (p4 != 1) {
            v1 = 12;
        } else {
            v1 = 4;
        }
        return (android.media.AudioTrack.getMinBufferSize(p3, v1, 2) / (p4 * 2));
    }

    private int getNativeOutputSampleRate()
    {
        int v0;
        if (!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnEmulator()) {
            if (!org.webrtc.voiceengine.WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
                if (!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher()) {
                    v0 = org.webrtc.voiceengine.WebRtcAudioUtils.getDefaultSampleRateHz();
                } else {
                    v0 = this.getSampleRateOnJellyBeanMR10OrHigher();
                }
                org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("Sample rate is set to ").append(v0).append(" Hz").toString());
            } else {
                org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("Default sample rate is overriden to ").append(org.webrtc.voiceengine.WebRtcAudioUtils.getDefaultSampleRateHz()).append(" Hz").toString());
                v0 = org.webrtc.voiceengine.WebRtcAudioUtils.getDefaultSampleRateHz();
            }
        } else {
            org.webrtc.Logging.d("WebRtcAudioManager", "Running emulator, overriding sample rate to 8 kHz.");
            v0 = 8000;
        }
        return v0;
    }

    private int getSampleRateOnJellyBeanMR10OrHigher()
    {
        int v1_1;
        String v0 = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (v0 != null) {
            v1_1 = Integer.parseInt(v0);
        } else {
            v1_1 = org.webrtc.voiceengine.WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        return v1_1;
    }

    public static declared_synchronized boolean getStereoInput()
    {
        try {
            return org.webrtc.voiceengine.WebRtcAudioManager.useStereoInput;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public static declared_synchronized boolean getStereoOutput()
    {
        try {
            return org.webrtc.voiceengine.WebRtcAudioManager.useStereoOutput;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    private boolean hasEarpiece()
    {
        return org.webrtc.ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private boolean init()
    {
        org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("init").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        if (!this.initialized) {
            org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("audio mode is: ").append(org.webrtc.voiceengine.WebRtcAudioManager.AUDIO_MODES[this.audioManager.getMode()]).toString());
            this.initialized = 1;
            this.volumeLogger.start();
        }
        return 1;
    }

    private static boolean isAcousticEchoCancelerSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private boolean isCommunicationModeEnabled()
    {
        int v0_2;
        if (this.audioManager.getMode() != 3) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage()
    {
        boolean v0;
        if (!org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsageIsOverridden) {
            v0 = org.webrtc.voiceengine.WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        } else {
            v0 = org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsage;
        }
        if (v0) {
            org.webrtc.Logging.e("WebRtcAudioManager", new StringBuilder().append(android.os.Build.MODEL).append(" is blacklisted for OpenSL ES usage!").toString());
        }
        return v0;
    }

    private boolean isLowLatencyOutputSupported()
    {
        return org.webrtc.ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private static boolean isNoiseSuppressorSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private boolean isProAudioSupported()
    {
        if ((!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnMarshmallowOrHigher()) || (!org.webrtc.ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro"))) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    private native void nativeCacheAudioParameters();

    public static declared_synchronized void setBlacklistDeviceForOpenSLESUsage(boolean p2)
    {
        try {
            org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsageIsOverridden = 1;
            org.webrtc.voiceengine.WebRtcAudioManager.blacklistDeviceForOpenSLESUsage = p2;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public static declared_synchronized void setStereoInput(boolean p4)
    {
        try {
            org.webrtc.Logging.w("WebRtcAudioManager", new StringBuilder().append("Overriding default input behavior: setStereoInput(").append(p4).append(41).toString());
            org.webrtc.voiceengine.WebRtcAudioManager.useStereoInput = p4;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public static declared_synchronized void setStereoOutput(boolean p4)
    {
        try {
            org.webrtc.Logging.w("WebRtcAudioManager", new StringBuilder().append("Overriding default output behavior: setStereoOutput(").append(p4).append(41).toString());
            org.webrtc.voiceengine.WebRtcAudioManager.useStereoOutput = p4;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    private void storeAudioParameters()
    {
        int v0_14;
        int v1_0 = 2;
        if (!org.webrtc.voiceengine.WebRtcAudioManager.getStereoOutput()) {
            v0_14 = 1;
        } else {
            v0_14 = 2;
        }
        this.outputChannels = v0_14;
        if (!org.webrtc.voiceengine.WebRtcAudioManager.getStereoInput()) {
            v1_0 = 1;
        }
        int v0_10;
        this.inputChannels = v1_0;
        this.sampleRate = this.getNativeOutputSampleRate();
        this.hardwareAEC = org.webrtc.voiceengine.WebRtcAudioManager.isAcousticEchoCancelerSupported();
        this.hardwareAGC = 0;
        this.hardwareNS = org.webrtc.voiceengine.WebRtcAudioManager.isNoiseSuppressorSupported();
        this.lowLatencyOutput = this.isLowLatencyOutputSupported();
        this.lowLatencyInput = this.isLowLatencyInputSupported();
        this.proAudio = this.isProAudioSupported();
        if (!this.lowLatencyOutput) {
            v0_10 = org.webrtc.voiceengine.WebRtcAudioManager.getMinOutputFrameSize(this.sampleRate, this.outputChannels);
        } else {
            v0_10 = this.getLowLatencyOutputFramesPerBuffer();
        }
        int v0_13;
        this.outputBufferSize = v0_10;
        if (!this.lowLatencyInput) {
            v0_13 = org.webrtc.voiceengine.WebRtcAudioManager.getMinInputFrameSize(this.sampleRate, this.inputChannels);
        } else {
            v0_13 = this.getLowLatencyInputFramesPerBuffer();
        }
        this.inputBufferSize = v0_13;
        return;
    }

    public boolean isLowLatencyInputSupported()
    {
        if ((!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnLollipopOrHigher()) || (!this.isLowLatencyOutputSupported())) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
