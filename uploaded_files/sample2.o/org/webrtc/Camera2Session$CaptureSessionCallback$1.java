package org.webrtc;
 class Camera2Session$CaptureSessionCallback$1 implements org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener {
    final synthetic org.webrtc.Camera2Session$CaptureSessionCallback this$1;

    Camera2Session$CaptureSessionCallback$1(org.webrtc.Camera2Session$CaptureSessionCallback p1)
    {
        this.this$1 = p1;
        return;
    }

    public void onTextureFrameAvailable(int p12, float[] p13, long p14)
    {
        org.webrtc.Camera2Session.access$000(this.this$1.this$0);
        if (org.webrtc.Camera2Session.access$200(this.this$1.this$0) == org.webrtc.Camera2Session$SessionState.RUNNING) {
            if (!org.webrtc.Camera2Session.access$1600(this.this$1.this$0)) {
                org.webrtc.Camera2Session.access$1602(this.this$1.this$0, 1);
                org.webrtc.Camera2Session.access$1800().addSample(((int) java.util.concurrent.TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - org.webrtc.Camera2Session.access$1700(this.this$1.this$0)))));
            }
            int v7 = org.webrtc.Camera2Session.access$1900(this.this$1.this$0);
            if (org.webrtc.Camera2Session.access$2000(this.this$1.this$0)) {
                p13 = org.webrtc.RendererCommon.multiplyMatrices(p13, org.webrtc.RendererCommon.horizontalFlipMatrix());
            }
            org.webrtc.Camera2Session.access$500(this.this$1.this$0).onTextureFrameCaptured(this.this$1.this$0, org.webrtc.Camera2Session.access$900(this.this$1.this$0).width, org.webrtc.Camera2Session.access$900(this.this$1.this$0).height, p12, org.webrtc.RendererCommon.rotateTextureMatrix(p13, ((float) (- org.webrtc.Camera2Session.access$2100(this.this$1.this$0)))), v7, p14);
        } else {
            org.webrtc.Logging.d("Camera2Session", "Texture frame captured but camera is no longer running.");
            org.webrtc.Camera2Session.access$800(this.this$1.this$0).returnTextureFrame();
        }
        return;
    }
}
