package org.webrtc.voiceengine;
 class WebRtcAudioManager$VolumeLogger$LogVolumeTask extends java.util.TimerTask {
    private final int maxRingVolume;
    private final int maxVoiceCallVolume;
    final synthetic org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger this$0;

    WebRtcAudioManager$VolumeLogger$LogVolumeTask(org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger p1, int p2, int p3)
    {
        this.this$0 = p1;
        this.maxRingVolume = p2;
        this.maxVoiceCallVolume = p3;
        return;
    }

    public void run()
    {
        int v0 = org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getMode();
        if (v0 != 1) {
            if (v0 == 3) {
                org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("VOICE_CALL stream volume: ").append(org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getStreamVolume(0)).append(" (max=").append(this.maxVoiceCallVolume).append(")").toString());
            }
        } else {
            org.webrtc.Logging.d("WebRtcAudioManager", new StringBuilder().append("STREAM_RING stream volume: ").append(org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger.access$000(this.this$0).getStreamVolume(2)).append(" (max=").append(this.maxRingVolume).append(")").toString());
        }
        return;
    }
}
