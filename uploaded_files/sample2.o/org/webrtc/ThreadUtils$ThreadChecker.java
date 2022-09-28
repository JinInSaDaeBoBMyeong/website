package org.webrtc;
public class ThreadUtils$ThreadChecker {
    private Thread thread;

    public ThreadUtils$ThreadChecker()
    {
        this.thread = Thread.currentThread();
        return;
    }

    public void checkIsOnValidThread()
    {
        if (this.thread == null) {
            this.thread = Thread.currentThread();
        }
        if (Thread.currentThread() == this.thread) {
            return;
        } else {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public void detachThread()
    {
        this.thread = 0;
        return;
    }
}
