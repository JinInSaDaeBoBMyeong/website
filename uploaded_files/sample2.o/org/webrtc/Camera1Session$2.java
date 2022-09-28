package org.webrtc;
 class Camera1Session$2 implements org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener {
    final synthetic org.webrtc.Camera1Session this$0;

    Camera1Session$2(org.webrtc.Camera1Session p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onTextureFrameAvailable(int p12, float[] p13, long p14)
    {
        org.webrtc.Camera1Session.access$200(this.this$0);
        if (org.webrtc.Camera1Session.access$300(this.this$0) == org.webrtc.Camera1Session$SessionState.RUNNING) {
            if (!org.webrtc.Camera1Session.access$500(this.this$0)) {
                org.webrtc.Camera1Session.access$700().addSample(((int) java.util.concurrent.TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - org.webrtc.Camera1Session.access$600(this.this$0)))));
                org.webrtc.Camera1Session.access$502(this.this$0, 1);
            }
            int v7 = org.webrtc.Camera1Session.access$800(this.this$0);
            if (org.webrtc.Camera1Session.access$900(this.this$0).facing == 1) {
                p13 = org.webrtc.RendererCommon.multiplyMatrices(p13, org.webrtc.RendererCommon.horizontalFlipMatrix());
            }
            org.webrtc.Camera1Session.access$100(this.this$0).onTextureFrameCaptured(this.this$0, org.webrtc.Camera1Session.access$1000(this.this$0).width, org.webrtc.Camera1Session.access$1000(this.this$0).height, p12, p13, v7, p14);
        } else {
            org.webrtc.Logging.d("Camera1Session", "Texture frame captured but camera is no longer running.");
            org.webrtc.Camera1Session.access$400(this.this$0).returnTextureFrame();
        }
        return;
    }
}
