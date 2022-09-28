package org.webrtc.voiceengine;
 class WebRtcAudioRecord$AudioRecordThread extends java.lang.Thread {
    private volatile boolean keepAlive;
    final synthetic org.webrtc.voiceengine.WebRtcAudioRecord this$0;

    public WebRtcAudioRecord$AudioRecordThread(org.webrtc.voiceengine.WebRtcAudioRecord p2, String p3)
    {
        this.this$0 = p2;
        super(p3);
        super.keepAlive = 1;
        return;
    }

    public void run()
    {
        org.webrtc.voiceengine.WebRtcAudioRecord v3_5;
        android.os.Process.setThreadPriority(-19);
        org.webrtc.Logging.d("WebRtcAudioRecord", new StringBuilder().append("AudioRecordThread").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        if (org.webrtc.voiceengine.WebRtcAudioRecord.access$000(this.this$0).getRecordingState() != 3) {
            v3_5 = 0;
        } else {
            v3_5 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioRecord.access$100(v3_5);
        System.nanoTime();
        while (this.keepAlive) {
            int v0 = org.webrtc.voiceengine.WebRtcAudioRecord.access$000(this.this$0).read(org.webrtc.voiceengine.WebRtcAudioRecord.access$200(this.this$0), org.webrtc.voiceengine.WebRtcAudioRecord.access$200(this.this$0).capacity());
            if (v0 != org.webrtc.voiceengine.WebRtcAudioRecord.access$200(this.this$0).capacity()) {
                String v2 = new StringBuilder().append("AudioRecord.read failed: ").append(v0).toString();
                org.webrtc.Logging.e("WebRtcAudioRecord", v2);
                if (v0 == -3) {
                    this.keepAlive = 0;
                    org.webrtc.voiceengine.WebRtcAudioRecord.access$700(this.this$0, v2);
                }
            } else {
                if (org.webrtc.voiceengine.WebRtcAudioRecord.access$300()) {
                    org.webrtc.voiceengine.WebRtcAudioRecord.access$200(this.this$0).clear();
                    org.webrtc.voiceengine.WebRtcAudioRecord.access$200(this.this$0).put(org.webrtc.voiceengine.WebRtcAudioRecord.access$400(this.this$0));
                }
                org.webrtc.voiceengine.WebRtcAudioRecord.access$600(this.this$0, v0, org.webrtc.voiceengine.WebRtcAudioRecord.access$500(this.this$0));
            }
        }
        try {
            if (org.webrtc.voiceengine.WebRtcAudioRecord.access$000(this.this$0) != null) {
                org.webrtc.voiceengine.WebRtcAudioRecord.access$000(this.this$0).stop();
            }
        } catch (IllegalStateException v1) {
            org.webrtc.Logging.e("WebRtcAudioRecord", new StringBuilder().append("AudioRecord.stop failed: ").append(v1.getMessage()).toString());
        }
        return;
    }

    public void stopThread()
    {
        org.webrtc.Logging.d("WebRtcAudioRecord", "stopThread");
        this.keepAlive = 0;
        return;
    }
}
