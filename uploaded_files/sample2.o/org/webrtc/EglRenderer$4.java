package org.webrtc;
 class EglRenderer$4 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic java.util.concurrent.CountDownLatch val$eglCleanupBarrier;

    EglRenderer$4(org.webrtc.EglRenderer p1, java.util.concurrent.CountDownLatch p2)
    {
        this.this$0 = p1;
        this.val$eglCleanupBarrier = p2;
        return;
    }

    public void run()
    {
        if (org.webrtc.EglRenderer.access$800(this.this$0) != null) {
            org.webrtc.EglRenderer.access$800(this.this$0).release();
            org.webrtc.EglRenderer.access$802(this.this$0, 0);
        }
        org.webrtc.EglRenderer.access$900(this.this$0).release();
        if (org.webrtc.EglRenderer.access$1000(this.this$0) != null) {
            org.webrtc.EglRenderer.access$1000(this.this$0).release();
            org.webrtc.EglRenderer.access$1002(this.this$0, 0);
        }
        if (org.webrtc.EglRenderer.access$000(this.this$0) != null) {
            org.webrtc.EglRenderer.access$700(this.this$0, "eglBase detach and release.");
            org.webrtc.EglRenderer.access$000(this.this$0).detachCurrent();
            org.webrtc.EglRenderer.access$000(this.this$0).release();
            org.webrtc.EglRenderer.access$002(this.this$0, 0);
        }
        this.val$eglCleanupBarrier.countDown();
        return;
    }
}
