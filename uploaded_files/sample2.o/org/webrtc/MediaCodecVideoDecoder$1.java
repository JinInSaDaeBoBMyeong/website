package org.webrtc;
 class MediaCodecVideoDecoder$1 implements java.lang.Runnable {
    final synthetic org.webrtc.MediaCodecVideoDecoder this$0;
    final synthetic java.util.concurrent.CountDownLatch val$releaseDone;

    MediaCodecVideoDecoder$1(org.webrtc.MediaCodecVideoDecoder p1, java.util.concurrent.CountDownLatch p2)
    {
        this.this$0 = p1;
        this.val$releaseDone = p2;
        return;
    }

    public void run()
    {
        try {
            org.webrtc.Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder on release thread");
            org.webrtc.MediaCodecVideoDecoder.access$000(this.this$0).stop();
            org.webrtc.MediaCodecVideoDecoder.access$000(this.this$0).release();
            org.webrtc.Logging.d("MediaCodecVideoDecoder", "Java releaseDecoder on release thread done");
        } catch (Exception v0) {
            org.webrtc.Logging.e("MediaCodecVideoDecoder", "Media decoder release failed", v0);
        }
        this.val$releaseDone.countDown();
        return;
    }
}
