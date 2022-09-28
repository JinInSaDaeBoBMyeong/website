package org.webrtc;
 class Camera1Session$3 implements android.hardware.Camera$PreviewCallback {
    final synthetic org.webrtc.Camera1Session this$0;

    Camera1Session$3(org.webrtc.Camera1Session p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onPreviewFrame(byte[] p10, android.hardware.Camera p11)
    {
        org.webrtc.Camera1Session.access$200(this.this$0);
        if (p11 == org.webrtc.Camera1Session.access$1100(this.this$0)) {
            if (org.webrtc.Camera1Session.access$300(this.this$0) == org.webrtc.Camera1Session$SessionState.RUNNING) {
                long v6 = java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(android.os.SystemClock.elapsedRealtime());
                if (!org.webrtc.Camera1Session.access$500(this.this$0)) {
                    org.webrtc.Camera1Session.access$700().addSample(((int) java.util.concurrent.TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - org.webrtc.Camera1Session.access$600(this.this$0)))));
                    org.webrtc.Camera1Session.access$502(this.this$0, 1);
                }
                org.webrtc.Camera1Session.access$100(this.this$0).onByteBufferFrameCaptured(this.this$0, p10, org.webrtc.Camera1Session.access$1000(this.this$0).width, org.webrtc.Camera1Session.access$1000(this.this$0).height, org.webrtc.Camera1Session.access$800(this.this$0), v6);
                org.webrtc.Camera1Session.access$1100(this.this$0).addCallbackBuffer(p10);
            } else {
                org.webrtc.Logging.d("Camera1Session", "Bytebuffer frame captured but camera is no longer running.");
            }
        } else {
            org.webrtc.Logging.e("Camera1Session", "Callback from a different camera. This should never happen.");
        }
        return;
    }
}
