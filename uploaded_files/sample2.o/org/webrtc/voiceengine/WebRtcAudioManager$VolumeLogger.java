package org.webrtc.voiceengine;
 class WebRtcAudioManager$VolumeLogger {
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final android.media.AudioManager audioManager;
    private java.util.Timer timer;

    public WebRtcAudioManager$VolumeLogger(android.media.AudioManager p1)
    {
        this.audioManager = p1;
        return;
    }

    static synthetic android.media.AudioManager access$000(org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger p1)
    {
        return p1.audioManager;
    }

    static synthetic void access$100(org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger p0)
    {
        p0.stop();
        return;
    }

    private void stop()
    {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = 0;
        }
        return;
    }

    public void start()
    {
        this.timer = new java.util.Timer("WebRtcVolumeLevelLoggerThread");
        this.timer.schedule(new org.webrtc.voiceengine.WebRtcAudioManager$VolumeLogger$LogVolumeTask(this, this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0, 30000);
        return;
    }
}
