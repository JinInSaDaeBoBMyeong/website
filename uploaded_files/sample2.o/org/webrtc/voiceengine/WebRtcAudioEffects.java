package org.webrtc.voiceengine;
public class WebRtcAudioEffects {
    private static final java.util.UUID AOSP_ACOUSTIC_ECHO_CANCELER = None;
    private static final java.util.UUID AOSP_NOISE_SUPPRESSOR = None;
    private static final boolean DEBUG = False;
    private static final String TAG = "WebRtcAudioEffects";
    private static android.media.audiofx.AudioEffect$Descriptor[] cachedEffects;
    private android.media.audiofx.AcousticEchoCanceler aec;
    private android.media.audiofx.NoiseSuppressor ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    static WebRtcAudioEffects()
    {
        org.webrtc.voiceengine.WebRtcAudioEffects.AOSP_ACOUSTIC_ECHO_CANCELER = java.util.UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
        org.webrtc.voiceengine.WebRtcAudioEffects.AOSP_NOISE_SUPPRESSOR = java.util.UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
        org.webrtc.voiceengine.WebRtcAudioEffects.cachedEffects = 0;
        return;
    }

    private WebRtcAudioEffects()
    {
        this.aec = 0;
        this.ns = 0;
        this.shouldEnableAec = 0;
        this.shouldEnableNs = 0;
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("ctor").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
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

    public static boolean canUseAcousticEchoCanceler()
    {
        if ((!org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerSupported()) || ((org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler()) || ((org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerBlacklisted()) || (org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerExcludedByUUID())))) {
            int v0 = 0;
        } else {
            v0 = 1;
        }
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("canUseAcousticEchoCanceler: ").append(v0).toString());
        return v0;
    }

    public static boolean canUseNoiseSuppressor()
    {
        if ((!org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorSupported()) || ((org.webrtc.voiceengine.WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor()) || ((org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorBlacklisted()) || (org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorExcludedByUUID())))) {
            int v0 = 0;
        } else {
            v0 = 1;
        }
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("canUseNoiseSuppressor: ").append(v0).toString());
        return v0;
    }

    public static org.webrtc.voiceengine.WebRtcAudioEffects create()
    {
        return new org.webrtc.voiceengine.WebRtcAudioEffects();
    }

    private boolean effectTypeIsVoIP(java.util.UUID p3)
    {
        int v0 = 0;
        if ((org.webrtc.voiceengine.WebRtcAudioUtils.runningOnJellyBeanMR2OrHigher()) && (((android.media.audiofx.AudioEffect.EFFECT_TYPE_AEC.equals(p3)) && (org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerSupported())) || ((android.media.audiofx.AudioEffect.EFFECT_TYPE_NS.equals(p3)) && (org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorSupported())))) {
            v0 = 1;
        }
        return v0;
    }

    private static android.media.audiofx.AudioEffect$Descriptor[] getAvailableEffects()
    {
        android.media.audiofx.AudioEffect$Descriptor[] v0_2;
        if (org.webrtc.voiceengine.WebRtcAudioEffects.cachedEffects == null) {
            org.webrtc.voiceengine.WebRtcAudioEffects.cachedEffects = android.media.audiofx.AudioEffect.queryEffects();
            v0_2 = org.webrtc.voiceengine.WebRtcAudioEffects.cachedEffects;
        } else {
            v0_2 = org.webrtc.voiceengine.WebRtcAudioEffects.cachedEffects;
        }
        return v0_2;
    }

    public static boolean isAcousticEchoCancelerBlacklisted()
    {
        boolean v1 = org.webrtc.voiceengine.WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(android.os.Build.MODEL);
        if (v1) {
            org.webrtc.Logging.w("WebRtcAudioEffects", new StringBuilder().append(android.os.Build.MODEL).append(" is blacklisted for HW AEC usage!").toString());
        }
        return v1;
    }

    private static boolean isAcousticEchoCancelerEffectAvailable()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.isEffectTypeAvailable(android.media.audiofx.AudioEffect.EFFECT_TYPE_AEC);
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID()
    {
        int v1 = 0;
        android.media.audiofx.AudioEffect$Descriptor[] v3 = org.webrtc.voiceengine.WebRtcAudioEffects.getAvailableEffects();
        int v2 = 0;
        while (v2 < v3.length) {
            android.media.audiofx.AudioEffect$Descriptor v0 = v3[v2];
            if ((!v0.type.equals(android.media.audiofx.AudioEffect.EFFECT_TYPE_AEC)) || (!v0.uuid.equals(org.webrtc.voiceengine.WebRtcAudioEffects.AOSP_ACOUSTIC_ECHO_CANCELER))) {
                v2++;
            } else {
                v1 = 1;
                break;
            }
        }
        return v1;
    }

    public static boolean isAcousticEchoCancelerSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerEffectAvailable();
    }

    private static boolean isEffectTypeAvailable(java.util.UUID p6)
    {
        int v2 = 0;
        android.media.audiofx.AudioEffect$Descriptor[] v1 = org.webrtc.voiceengine.WebRtcAudioEffects.getAvailableEffects();
        if (v1 != null) {
            int v3 = 0;
            while (v3 < v1.length) {
                if (!v1[v3].type.equals(p6)) {
                    v3++;
                } else {
                    v2 = 1;
                    break;
                }
            }
        }
        return v2;
    }

    public static boolean isNoiseSuppressorBlacklisted()
    {
        boolean v1 = org.webrtc.voiceengine.WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(android.os.Build.MODEL);
        if (v1) {
            org.webrtc.Logging.w("WebRtcAudioEffects", new StringBuilder().append(android.os.Build.MODEL).append(" is blacklisted for HW NS usage!").toString());
        }
        return v1;
    }

    private static boolean isNoiseSuppressorEffectAvailable()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.isEffectTypeAvailable(android.media.audiofx.AudioEffect.EFFECT_TYPE_NS);
    }

    private static boolean isNoiseSuppressorExcludedByUUID()
    {
        int v1 = 0;
        android.media.audiofx.AudioEffect$Descriptor[] v3 = org.webrtc.voiceengine.WebRtcAudioEffects.getAvailableEffects();
        int v2 = 0;
        while (v2 < v3.length) {
            android.media.audiofx.AudioEffect$Descriptor v0 = v3[v2];
            if ((!v0.type.equals(android.media.audiofx.AudioEffect.EFFECT_TYPE_NS)) || (!v0.uuid.equals(org.webrtc.voiceengine.WebRtcAudioEffects.AOSP_NOISE_SUPPRESSOR))) {
                v2++;
            } else {
                v1 = 1;
                break;
            }
        }
        return v1;
    }

    public static boolean isNoiseSuppressorSupported()
    {
        return org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorEffectAvailable();
    }

    public void enable(int p8)
    {
        String v2_16;
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("enable(audioSession=").append(p8).append(")").toString());
        if (this.aec != null) {
            v2_16 = 0;
        } else {
            v2_16 = 1;
        }
        String v2_19;
        org.webrtc.voiceengine.WebRtcAudioEffects.assertTrue(v2_16);
        if (this.ns != null) {
            v2_19 = 0;
        } else {
            v2_19 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioEffects.assertTrue(v2_19);
        if (org.webrtc.voiceengine.WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            this.aec = android.media.audiofx.AcousticEchoCanceler.create(p8);
            if (this.aec == null) {
                org.webrtc.Logging.e("WebRtcAudioEffects", "Failed to create the AcousticEchoCanceler instance");
            } else {
                String v0_1;
                boolean v1_0 = this.aec.getEnabled();
                if ((!this.shouldEnableAec) || (!org.webrtc.voiceengine.WebRtcAudioEffects.canUseAcousticEchoCanceler())) {
                    v0_1 = 0;
                } else {
                    v0_1 = 1;
                }
                if (this.aec.setEnabled(v0_1) != 0) {
                    org.webrtc.Logging.e("WebRtcAudioEffects", "Failed to set the AcousticEchoCanceler state");
                }
                String v2_32;
                StringBuilder vtmp14 = new StringBuilder().append("AcousticEchoCanceler: was ");
                if (!v1_0) {
                    v2_32 = "disabled";
                } else {
                    v2_32 = "enabled";
                }
                String v2_38;
                StringBuilder v6_6 = vtmp14.append(v2_32).append(", enable: ").append(v0_1).append(", is now: ");
                if (!this.aec.getEnabled()) {
                    v2_38 = "disabled";
                } else {
                    v2_38 = "enabled";
                }
                org.webrtc.Logging.d("WebRtcAudioEffects", v6_6.append(v2_38).toString());
            }
        }
        if (org.webrtc.voiceengine.WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            this.ns = android.media.audiofx.NoiseSuppressor.create(p8);
            if (this.ns == null) {
                org.webrtc.Logging.e("WebRtcAudioEffects", "Failed to create the NoiseSuppressor instance");
            } else {
                String v0_0;
                boolean v1_1 = this.ns.getEnabled();
                if ((!this.shouldEnableNs) || (!org.webrtc.voiceengine.WebRtcAudioEffects.canUseNoiseSuppressor())) {
                    v0_0 = 0;
                } else {
                    v0_0 = 1;
                }
                if (this.ns.setEnabled(v0_0) != 0) {
                    org.webrtc.Logging.e("WebRtcAudioEffects", "Failed to set the NoiseSuppressor state");
                }
                String v2_6;
                StringBuilder vtmp16 = new StringBuilder().append("NoiseSuppressor: was ");
                if (!v1_1) {
                    v2_6 = "disabled";
                } else {
                    v2_6 = "enabled";
                }
                String v2_12;
                StringBuilder v4_5 = vtmp16.append(v2_6).append(", enable: ").append(v0_0).append(", is now: ");
                if (!this.ns.getEnabled()) {
                    v2_12 = "disabled";
                } else {
                    v2_12 = "enabled";
                }
                org.webrtc.Logging.d("WebRtcAudioEffects", v4_5.append(v2_12).toString());
            }
        }
        return;
    }

    public void release()
    {
        org.webrtc.Logging.d("WebRtcAudioEffects", "release");
        if (this.aec != null) {
            this.aec.release();
            this.aec = 0;
        }
        if (this.ns != null) {
            this.ns.release();
            this.ns = 0;
        }
        return;
    }

    public boolean setAEC(boolean p5)
    {
        int v0 = 0;
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("setAEC(").append(p5).append(")").toString());
        if (org.webrtc.voiceengine.WebRtcAudioEffects.canUseAcousticEchoCanceler()) {
            if ((this.aec == null) || (p5 == this.shouldEnableAec)) {
                this.shouldEnableAec = p5;
                v0 = 1;
            } else {
                org.webrtc.Logging.e("WebRtcAudioEffects", "Platform AEC state can\'t be modified while recording");
            }
        } else {
            org.webrtc.Logging.w("WebRtcAudioEffects", "Platform AEC is not supported");
            this.shouldEnableAec = 0;
        }
        return v0;
    }

    public boolean setNS(boolean p5)
    {
        int v0 = 0;
        org.webrtc.Logging.d("WebRtcAudioEffects", new StringBuilder().append("setNS(").append(p5).append(")").toString());
        if (org.webrtc.voiceengine.WebRtcAudioEffects.canUseNoiseSuppressor()) {
            if ((this.ns == null) || (p5 == this.shouldEnableNs)) {
                this.shouldEnableNs = p5;
                v0 = 1;
            } else {
                org.webrtc.Logging.e("WebRtcAudioEffects", "Platform NS state can\'t be modified while recording");
            }
        } else {
            org.webrtc.Logging.w("WebRtcAudioEffects", "Platform NS is not supported");
            this.shouldEnableNs = 0;
        }
        return v0;
    }
}
