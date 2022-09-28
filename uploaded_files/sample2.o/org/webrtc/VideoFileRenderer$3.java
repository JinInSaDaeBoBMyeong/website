package org.webrtc;
 class VideoFileRenderer$3 implements java.lang.Runnable {
    final synthetic org.webrtc.VideoFileRenderer this$0;
    final synthetic java.util.concurrent.CountDownLatch val$cleanupBarrier;

    VideoFileRenderer$3(org.webrtc.VideoFileRenderer p1, java.util.concurrent.CountDownLatch p2)
    {
        this.this$0 = p1;
        this.val$cleanupBarrier = p2;
        return;
    }

    public void run()
    {
        org.webrtc.VideoFileRenderer.access$100(this.this$0).release();
        org.webrtc.VideoFileRenderer.access$000(this.this$0).release();
        org.webrtc.VideoFileRenderer.access$300(this.this$0).quit();
        this.val$cleanupBarrier.countDown();
        return;
    }
}
