package org.webrtc;
 class EglRenderer$7 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic java.util.concurrent.CountDownLatch val$latch;
    final synthetic org.webrtc.EglRenderer$FrameListener val$listener;

    EglRenderer$7(org.webrtc.EglRenderer p1, java.util.concurrent.CountDownLatch p2, org.webrtc.EglRenderer$FrameListener p3)
    {
        this.this$0 = p1;
        this.val$latch = p2;
        this.val$listener = p3;
        return;
    }

    public void run()
    {
        this.val$latch.countDown();
        java.util.Iterator v0 = org.webrtc.EglRenderer.access$1100(this.this$0).iterator();
        while (v0.hasNext()) {
            if (((org.webrtc.EglRenderer$FrameListenerAndParams) v0.next()).listener == this.val$listener) {
                v0.remove();
            }
        }
        return;
    }
}
