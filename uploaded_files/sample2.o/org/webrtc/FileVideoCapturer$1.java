package org.webrtc;
 class FileVideoCapturer$1 extends java.util.TimerTask {
    final synthetic org.webrtc.FileVideoCapturer this$0;

    FileVideoCapturer$1(org.webrtc.FileVideoCapturer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        this.this$0.tick();
        return;
    }
}
