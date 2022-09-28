package org.webrtc;
 class CameraCapturer$3 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;

    CameraCapturer$3(org.webrtc.CameraCapturer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraError("Camera failed to start within timeout.");
        return;
    }
}
