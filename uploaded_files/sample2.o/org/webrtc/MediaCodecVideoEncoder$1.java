package org.webrtc;
 class MediaCodecVideoEncoder$1 implements java.lang.Runnable {
    final synthetic org.webrtc.MediaCodecVideoEncoder this$0;
    final synthetic org.webrtc.MediaCodecVideoEncoder$1CaughtException val$caughtException;
    final synthetic java.util.concurrent.CountDownLatch val$releaseDone;

    MediaCodecVideoEncoder$1(org.webrtc.MediaCodecVideoEncoder p1, org.webrtc.MediaCodecVideoEncoder$1CaughtException p2, java.util.concurrent.CountDownLatch p3)
    {
        this.this$0 = p1;
        this.val$caughtException = p2;
        this.val$releaseDone = p3;
        return;
    }

    public void run()
    {
        org.webrtc.Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder on release thread");
        try {
            org.webrtc.MediaCodecVideoEncoder.access$000(this.this$0).stop();
            try {
                org.webrtc.MediaCodecVideoEncoder.access$000(this.this$0).release();
            } catch (Exception v0_0) {
                org.webrtc.Logging.e("MediaCodecVideoEncoder", "Media encoder release failed", v0_0);
                this.val$caughtException.e = v0_0;
            }
            org.webrtc.Logging.d("MediaCodecVideoEncoder", "Java releaseEncoder on release thread done");
            this.val$releaseDone.countDown();
            return;
        } catch (Exception v0_1) {
            org.webrtc.Logging.e("MediaCodecVideoEncoder", "Media encoder stop failed", v0_1);
        }
    }
}
