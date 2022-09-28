package org.webrtc;
 class VideoFileRenderer$2 implements java.lang.Runnable {
    final synthetic org.webrtc.VideoFileRenderer this$0;
    final synthetic org.webrtc.VideoRenderer$I420Frame val$frame;

    VideoFileRenderer$2(org.webrtc.VideoFileRenderer p1, org.webrtc.VideoRenderer$I420Frame p2)
    {
        this.this$0 = p1;
        this.val$frame = p2;
        return;
    }

    public void run()
    {
        org.webrtc.VideoFileRenderer.access$200(this.this$0, this.val$frame);
        return;
    }
}
