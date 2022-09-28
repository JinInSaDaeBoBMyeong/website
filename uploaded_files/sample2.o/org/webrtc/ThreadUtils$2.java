package org.webrtc;
final class ThreadUtils$2 implements org.webrtc.ThreadUtils$BlockingOperation {
    final synthetic java.util.concurrent.CountDownLatch val$latch;

    ThreadUtils$2(java.util.concurrent.CountDownLatch p1)
    {
        this.val$latch = p1;
        return;
    }

    public void run()
    {
        this.val$latch.await();
        return;
    }
}
