package org.webrtc;
 class CameraCapturer$7 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraCapturer this$0;
    final synthetic org.webrtc.CameraVideoCapturer$CameraSwitchHandler val$switchEventsHandler;

    CameraCapturer$7(org.webrtc.CameraCapturer p1, org.webrtc.CameraVideoCapturer$CameraSwitchHandler p2)
    {
        this.this$0 = p1;
        this.val$switchEventsHandler = p2;
        return;
    }

    public void run()
    {
        org.webrtc.CameraCapturer.access$1600(this.this$0, this.val$switchEventsHandler);
        return;
    }
}
