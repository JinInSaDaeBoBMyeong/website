package org.webrtc;
 class Camera2Session$CameraCaptureCallback extends android.hardware.camera2.CameraCaptureSession$CaptureCallback {
    final synthetic org.webrtc.Camera2Session this$0;

    private Camera2Session$CameraCaptureCallback(org.webrtc.Camera2Session p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic Camera2Session$CameraCaptureCallback(org.webrtc.Camera2Session p1, org.webrtc.Camera2Session$1 p2)
    {
        this(p1);
        return;
    }

    public void onCaptureFailed(android.hardware.camera2.CameraCaptureSession p4, android.hardware.camera2.CaptureRequest p5, android.hardware.camera2.CaptureFailure p6)
    {
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Capture failed: ").append(p6).toString());
        return;
    }
}
