package org.webrtc;
 class CameraCapturer$9 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;
    final synthetic org.webrtc.CameraVideoCapturer$MediaRecorderHandler val$mediaRecoderEventsHandler;

    CameraCapturer$9(org.webrtc.CameraCapturer p1, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p2)
    {
        this.this$0 = p1;
        this.val$mediaRecoderEventsHandler = p2;
        return;
    }

    public void run()
    {
        org.webrtc.CameraCapturer.access$2600(this.this$0, 0, this.val$mediaRecoderEventsHandler);
        return;
    }
}
