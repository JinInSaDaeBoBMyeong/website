package org.webrtc;
final class ThreadUtils$4 implements java.lang.Runnable {
    final synthetic java.util.concurrent.CountDownLatch val$barrier;
    final synthetic java.util.concurrent.Callable val$callable;
    final synthetic org.webrtc.ThreadUtils$1CaughtException val$caughtException;
    final synthetic org.webrtc.ThreadUtils$1Result val$result;

    ThreadUtils$4(org.webrtc.ThreadUtils$1Result p1, java.util.concurrent.Callable p2, org.webrtc.ThreadUtils$1CaughtException p3, java.util.concurrent.CountDownLatch p4)
    {
        this.val$result = p1;
        this.val$callable = p2;
        this.val$caughtException = p3;
        this.val$barrier = p4;
        return;
    }

    public void run()
    {
        try {
            this.val$result.value = this.val$callable.call();
        } catch (Exception v0) {
            this.val$caughtException.e = v0;
        }
        this.val$barrier.countDown();
        return;
    }
}
