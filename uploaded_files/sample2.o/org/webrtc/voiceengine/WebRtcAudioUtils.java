package org.webrtc.voiceengine;
public final class WebRtcAudioUtils {
    private static final String[] BLACKLISTED_AEC_MODELS = None;
    private static final String[] BLACKLISTED_NS_MODELS = None;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = None;
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;

    static WebRtcAudioUtils()
    {
        int v0_0 = new String[0];
        org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_OPEN_SL_ES_MODELS = v0_0;
        int v0_1 = new String[0];
        org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_AEC_MODELS = v0_1;
        int v0_2 = new String[0];
        org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_NS_MODELS = v0_2;
        org.webrtc.voiceengine.WebRtcAudioUtils.defaultSampleRateHz = 16000;
        org.webrtc.voiceengine.WebRtcAudioUtils.isDefaultSampleRateOverridden = 0;
        org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler = 0;
        org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor = 0;
        return;
    }

    public WebRtcAudioUtils()
    {
        return;
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage()
    {
        return java.util.Arrays.asList(org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_OPEN_SL_ES_MODELS).contains(android.os.Build.MODEL);
    }

    public static java.util.List getBlackListedModelsForAecUsage()
    {
        return java.util.Arrays.asList(org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_AEC_MODELS);
    }

    public static java.util.List getBlackListedModelsForNsUsage()
    {
        return java.util.Arrays.asList(org.webrtc.voiceengine.WebRtcAudioUtils.BLACKLISTED_NS_MODELS);
    }

    public static declared_synchronized int getDefaultSampleRateHz()
    {
        try {
            return org.webrtc.voiceengine.WebRtcAudioUtils.defaultSampleRateHz;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public static String getThreadInfo()
    {
        return new StringBuilder().append("@[name=").append(Thread.currentThread().getName()).append(", id=").append(Thread.currentThread().getId()).append("]").toString();
    }

    public static boolean hasPermission(android.content.Context p2, String p3)
    {
        int v0_2;
        if (p2.checkPermission(p3, android.os.Process.myPid(), android.os.Process.myUid()) != 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public static boolean isAcousticEchoCancelerSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isAutomaticGainControlSupported()
    {
        return 0;
    }

    public static declared_synchronized boolean isDefaultSampleRateOverridden()
    {
        try {
            return org.webrtc.voiceengine.WebRtcAudioUtils.isDefaultSampleRateOverridden;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public static boolean isNoiseSuppressorSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    public static void logDeviceInfo(String p2)
    {
        org.webrtc.Logging.d(p2, new StringBuilder().append("Android SDK: ").append(android.os.Build$VERSION.SDK_INT).append(", Release: ").append(android.os.Build$VERSION.RELEASE).append(", Brand: ").append(android.os.Build.BRAND).append(", Device: ").append(android.os.Build.DEVICE).append(", Id: ").append(android.os.Build.ID).append(", Hardware: ").append(android.os.Build.HARDWARE).append(", Manufacturer: ").append(android.os.Build.MANUFACTURER).append(", Model: ").append(android.os.Build.MODEL).append(", Product: ").append(android.os.Build.PRODUCT).toString());
        return;
    }

    public static boolean runningOnEmulator()
    {
        if ((!android.os.Build.HARDWARE.equals("goldfish")) || (!android.os.Build.BRAND.startsWith("generic_"))) {
            int v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean runningOnJellyBeanMR1OrHigher()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 17) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean runningOnJellyBeanMR2OrHigher()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 18) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean runningOnLollipopOrHigher()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 21) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean runningOnMarshmallowOrHigher()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 23) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static boolean runningOnNougatOrHigher()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 24) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public static declared_synchronized void setDefaultSampleRateHz(int p2)
    {
        try {
            org.webrtc.voiceengine.WebRtcAudioUtils.isDefaultSampleRateOverridden = 1;
            org.webrtc.voiceengine.WebRtcAudioUtils.defaultSampleRateHz = p2;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public static declared_synchronized void setWebRtcBasedAcousticEchoCanceler(boolean p2)
    {
        try {
            org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler = p2;
            return;
        } catch (Throwable v1) {
            throw v1;
        }
    }

    public static declared_synchronized void setWebRtcBasedAutomaticGainControl(boolean p3)
    {
        try {
            org.webrtc.Logging.w("WebRtcAudioUtils", "setWebRtcBasedAutomaticGainControl() is deprecated");
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public static declared_synchronized void setWebRtcBasedNoiseSuppressor(boolean p2)
    {
        try {
            org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor = p2;
            return;
        } catch (Throwable v1) {
            throw v1;
        }
    }

    public static declared_synchronized boolean useWebRtcBasedAcousticEchoCanceler()
    {
        try {
            if (org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler) {
                org.webrtc.Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC AEC!");
            }
        } catch (boolean v0_2) {
            throw v0_2;
        }
        return org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler;
    }

    public static declared_synchronized boolean useWebRtcBasedAutomaticGainControl()
    {
        return 1;
    }

    public static declared_synchronized boolean useWebRtcBasedNoiseSuppressor()
    {
        try {
            if (org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor) {
                org.webrtc.Logging.w("WebRtcAudioUtils", "Overriding default behavior; now using WebRTC NS!");
            }
        } catch (boolean v0_2) {
            throw v0_2;
        }
        return org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor;
    }
}
