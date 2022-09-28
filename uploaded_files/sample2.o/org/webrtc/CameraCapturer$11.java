package org.webrtc;
 class CameraCapturer$11 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;
    final synthetic org.webrtc.CameraSession val$oldSession;

    CameraCapturer$11(org.webrtc.CameraCapturer p1, org.webrtc.CameraSession p2)
    {
        this.this$0 = p1;
        this.val$oldSession = p2;
        return;
    }

    public void run()
    {
        this.val$oldSession.stop();
        return;
    }
}
