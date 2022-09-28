package org.webrtc.voiceengine;
 class WebRtcAudioTrack$AudioTrackThread extends java.lang.Thread {
    private volatile boolean keepAlive;
    final synthetic org.webrtc.voiceengine.WebRtcAudioTrack this$0;

    public WebRtcAudioTrack$AudioTrackThread(org.webrtc.voiceengine.WebRtcAudioTrack p2, String p3)
    {
        this.this$0 = p2;
        super(p3);
        super.keepAlive = 1;
        return;
    }

    private int writeOnLollipop(android.media.AudioTrack p2, java.nio.ByteBuffer p3, int p4)
    {
        return p2.write(p3, p4, 0);
    }

    private int writePreLollipop(android.media.AudioTrack p3, java.nio.ByteBuffer p4, int p5)
    {
        return p3.write(p4.array(), p4.arrayOffset(), p5);
    }

    public void joinThread()
    {
        this.keepAlive = 0;
        while (this.isAlive()) {
            try {
                this.join();
            } catch (InterruptedException v0) {
            }
        }
        return;
    }

    public void run()
    {
        String v4_0 = 1;
        android.os.Process.setThreadPriority(-19);
        org.webrtc.Logging.d("WebRtcAudioTrack", new StringBuilder().append("AudioTrackThread").append(org.webrtc.voiceengine.WebRtcAudioUtils.getThreadInfo()).toString());
        try {
            org.webrtc.voiceengine.WebRtcAudioTrack v3_23;
            org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0).play();
        } catch (IllegalStateException v1_0) {
            org.webrtc.voiceengine.WebRtcAudioTrack.access$200(this.this$0, new StringBuilder().append("AudioTrack.play failed: ").append(v1_0.getMessage()).toString());
            org.webrtc.voiceengine.WebRtcAudioTrack.access$300(this.this$0);
            return;
        }
        if (org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0).getPlayState() != 3) {
            v3_23 = 0;
        } else {
            v3_23 = 1;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.access$100(v3_23);
        int v2 = org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).capacity();
        while (this.keepAlive) {
            org.webrtc.voiceengine.WebRtcAudioTrack v3_42;
            org.webrtc.voiceengine.WebRtcAudioTrack.access$600(this.this$0, v2, org.webrtc.voiceengine.WebRtcAudioTrack.access$500(this.this$0));
            if (v2 > org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).remaining()) {
                v3_42 = 0;
            } else {
                v3_42 = 1;
            }
            org.webrtc.voiceengine.WebRtcAudioTrack.access$100(v3_42);
            if (org.webrtc.voiceengine.WebRtcAudioTrack.access$700()) {
                org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).clear();
                org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).put(org.webrtc.voiceengine.WebRtcAudioTrack.access$800(this.this$0));
                org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).position(0);
            }
            int v0;
            if (!org.webrtc.voiceengine.WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                v0 = this.writePreLollipop(org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0), org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0), v2);
            } else {
                v0 = this.writeOnLollipop(org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0), org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0), v2);
            }
            if (v0 != v2) {
                org.webrtc.Logging.e("WebRtcAudioTrack", new StringBuilder().append("AudioTrack.write failed: ").append(v0).toString());
                if (v0 == -3) {
                    this.keepAlive = 0;
                    org.webrtc.voiceengine.WebRtcAudioTrack.access$900(this.this$0, new StringBuilder().append("AudioTrack.write failed: ").append(v0).toString());
                }
            }
            org.webrtc.voiceengine.WebRtcAudioTrack.access$400(this.this$0).rewind();
        }
        try {
            org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0).stop();
        } catch (IllegalStateException v1_1) {
            org.webrtc.Logging.e("WebRtcAudioTrack", new StringBuilder().append("AudioTrack.stop failed: ").append(v1_1.getMessage()).toString());
        }
        if (org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0).getPlayState() != 1) {
            v4_0 = 0;
        }
        org.webrtc.voiceengine.WebRtcAudioTrack.access$100(v4_0);
        org.webrtc.voiceengine.WebRtcAudioTrack.access$000(this.this$0).flush();
        return;
    }
}
