package org.webrtc;
 class SurfaceViewRenderer$1 implements java.lang.Runnable {
    final synthetic org.webrtc.SurfaceViewRenderer this$0;
    final synthetic java.util.concurrent.CountDownLatch val$completionLatch;

    SurfaceViewRenderer$1(org.webrtc.SurfaceViewRenderer p1, java.util.concurrent.CountDownLatch p2)
    {
        this.this$0 = p1;
        this.val$completionLatch = p2;
        return;
    }

    public void run()
    {
        this.val$completionLatch.countDown();
        return;
    }
}
