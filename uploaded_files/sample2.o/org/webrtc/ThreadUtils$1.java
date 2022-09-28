package org.webrtc;
final class ThreadUtils$1 implements org.webrtc.ThreadUtils$BlockingOperation {
    final synthetic Thread val$thread;

    ThreadUtils$1(Thread p1)
    {
        this.val$thread = p1;
        return;
    }

    public void run()
    {
        this.val$thread.join();
        return;
    }
}
