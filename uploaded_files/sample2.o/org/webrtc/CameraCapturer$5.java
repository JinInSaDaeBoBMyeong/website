package org.webrtc;
 class CameraCapturer$5 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;
    final synthetic android.media.MediaRecorder val$mediaRecorder;

    CameraCapturer$5(org.webrtc.CameraCapturer p1, android.media.MediaRecorder p2)
    {
        this.this$0 = p1;
        this.val$mediaRecorder = p2;
        return;
    }

    public void run()
    {
        this.this$0.createCameraSession(org.webrtc.CameraCapturer.access$2000(this.this$0), org.webrtc.CameraCapturer.access$2100(this.this$0), org.webrtc.CameraCapturer.access$2200(this.this$0), org.webrtc.CameraCapturer.access$1000(this.this$0), this.val$mediaRecorder, org.webrtc.CameraCapturer.access$1400(this.this$0), org.webrtc.CameraCapturer.access$2300(this.this$0), org.webrtc.CameraCapturer.access$2400(this.this$0), org.webrtc.CameraCapturer.access$2500(this.this$0));
        return;
    }
}
