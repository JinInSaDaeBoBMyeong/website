package org.webrtc;
 class Camera2Session$CameraStateCallback extends android.hardware.camera2.CameraDevice$StateCallback {
    final synthetic org.webrtc.Camera2Session this$0;

    private Camera2Session$CameraStateCallback(org.webrtc.Camera2Session p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic Camera2Session$CameraStateCallback(org.webrtc.Camera2Session p1, org.webrtc.Camera2Session$1 p2)
    {
        this(p1);
        return;
    }

    private String getErrorDescription(int p3)
    {
        String v0_0;
        switch (p3) {
            case 1:
                v0_0 = "Camera device is in use already.";
                break;
            case 2:
                v0_0 = "Camera device could not be opened because there are too many other open camera devices.";
                break;
            case 3:
                v0_0 = "Camera device could not be opened due to a device policy.";
                break;
            case 4:
                v0_0 = "Camera device has encountered a fatal error.";
                break;
            case 5:
                v0_0 = "Camera service has encountered a fatal error.";
                break;
            default:
                v0_0 = new StringBuilder().append("Unknown camera error: ").append(p3).toString();
        }
        return v0_0;
    }

    public void onClosed(android.hardware.camera2.CameraDevice p3)
    {
        org.webrtc.Camera2Session.access$000(this.this$0);
        org.webrtc.Logging.d("Camera2Session", "Camera device closed.");
        org.webrtc.Camera2Session.access$500(this.this$0).onCameraClosed(this.this$0);
        return;
    }

    public void onDisconnected(android.hardware.camera2.CameraDevice p5)
    {
        int v0;
        org.webrtc.Camera2Session.access$000(this.this$0);
        if ((org.webrtc.Camera2Session.access$100(this.this$0) != null) || (org.webrtc.Camera2Session.access$200(this.this$0) == org.webrtc.Camera2Session$SessionState.STOPPED)) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        org.webrtc.Camera2Session.access$202(this.this$0, org.webrtc.Camera2Session$SessionState.STOPPED);
        org.webrtc.Camera2Session.access$300(this.this$0);
        if (v0 == 0) {
            org.webrtc.Camera2Session.access$500(this.this$0).onCameraDisconnected(this.this$0);
        } else {
            org.webrtc.Camera2Session.access$400(this.this$0).onFailure(org.webrtc.CameraSession$FailureType.DISCONNECTED, "Camera disconnected / evicted.");
        }
        return;
    }

    public void onError(android.hardware.camera2.CameraDevice p3, int p4)
    {
        org.webrtc.Camera2Session.access$000(this.this$0);
        org.webrtc.Camera2Session.access$600(this.this$0, this.getErrorDescription(p4));
        return;
    }

    public void onOpened(android.hardware.camera2.CameraDevice p7)
    {
        org.webrtc.Camera2Session.access$000(this.this$0);
        org.webrtc.Logging.d("Camera2Session", "Camera opened.");
        org.webrtc.Camera2Session.access$702(this.this$0, p7);
        android.graphics.SurfaceTexture v1 = org.webrtc.Camera2Session.access$800(this.this$0).getSurfaceTexture();
        v1.setDefaultBufferSize(org.webrtc.Camera2Session.access$900(this.this$0).width, org.webrtc.Camera2Session.access$900(this.this$0).height);
        org.webrtc.Camera2Session.access$1002(this.this$0, new android.view.Surface(v1));
        java.util.ArrayList v2_1 = new java.util.ArrayList();
        v2_1.add(org.webrtc.Camera2Session.access$1000(this.this$0));
        if (org.webrtc.Camera2Session.access$1100(this.this$0) != null) {
            org.webrtc.Logging.d("Camera2Session", "Add MediaRecorder surface to capture session.");
            v2_1.add(org.webrtc.Camera2Session.access$1100(this.this$0));
        }
        try {
            p7.createCaptureSession(v2_1, new org.webrtc.Camera2Session$CaptureSessionCallback(this.this$0, 0), org.webrtc.Camera2Session.access$1300(this.this$0));
        } catch (android.hardware.camera2.CameraAccessException v0) {
            org.webrtc.Camera2Session.access$600(this.this$0, new StringBuilder().append("Failed to create capture session. ").append(v0).toString());
        }
        return;
    }
}
