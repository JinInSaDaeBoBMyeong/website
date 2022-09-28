package org.webrtc;
final class ThreadUtils$3 implements org.webrtc.ThreadUtils$BlockingOperation {
    final synthetic Object val$object;

    ThreadUtils$3(Object p1)
    {
        this.val$object = p1;
        return;
    }

    public void run()
    {
        this.val$object.wait();
        return;
    }
}
