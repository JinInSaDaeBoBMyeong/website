package org.webrtc;
 class VideoFileRenderer$1 implements java.lang.Runnable {
    final synthetic org.webrtc.VideoFileRenderer this$0;
    final synthetic org.webrtc.EglBase$Context val$sharedContext;

    VideoFileRenderer$1(org.webrtc.VideoFileRenderer p1, org.webrtc.EglBase$Context p2)
    {
        this.this$0 = p1;
        this.val$sharedContext = p2;
        return;
    }

    public void run()
    {
        org.webrtc.VideoFileRenderer.access$002(this.this$0, org.webrtc.EglBase.create(this.val$sharedContext, org.webrtc.EglBase.CONFIG_PIXEL_BUFFER));
        org.webrtc.VideoFileRenderer.access$000(this.this$0).createDummyPbufferSurface();
        org.webrtc.VideoFileRenderer.access$000(this.this$0).makeCurrent();
        org.webrtc.VideoFileRenderer.access$102(this.this$0, new org.webrtc.YuvConverter());
        return;
    }
}
