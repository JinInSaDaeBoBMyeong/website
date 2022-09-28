package org.webrtc;
 class CameraCapturer$8 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;
    final synthetic org.webrtc.CameraVideoCapturer$MediaRecorderHandler val$mediaRecoderEventsHandler;
    final synthetic android.media.MediaRecorder val$mediaRecorder;

    CameraCapturer$8(org.webrtc.CameraCapturer p1, android.media.MediaRecorder p2, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p3)
    {
        this.this$0 = p1;
        this.val$mediaRecorder = p2;
        this.val$mediaRecoderEventsHandler = p3;
        return;
    }

    public void run()
    {
        org.webrtc.CameraCapturer.access$2600(this.this$0, this.val$mediaRecorder, this.val$mediaRecoderEventsHandler);
        return;
    }
}
