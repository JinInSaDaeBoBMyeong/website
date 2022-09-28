package org.webrtc;
 class Camera2Session$CaptureSessionCallback extends android.hardware.camera2.CameraCaptureSession$StateCallback {
    final synthetic org.webrtc.Camera2Session this$0;

    private Camera2Session$CaptureSessionCallback(org.webrtc.Camera2Session p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic Camera2Session$CaptureSessionCallback(org.webrtc.Camera2Session p1, org.webrtc.Camera2Session$1 p2)
    {
        this(p1);
        return;
    }

    private void chooseFocusMode(android.hardware.camera2.CaptureRequest$Builder p6)
    {
        int[] v0_1 = ((int[]) org.webrtc.Camera2Session.access$2200(this.this$0).get(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES));
        int v2_2 = 0;
        while (v2_2 < v0_1.length) {
            if (v0_1[v2_2] != 3) {
                v2_2++;
            } else {
                p6.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
                org.webrtc.Logging.d("Camera2Session", "Using continuous video auto-focus.");
            }
            return;
        }
        org.webrtc.Logging.d("Camera2Session", "Auto-focus is not available.");
        return;
    }

    private void chooseStabilizationMode(android.hardware.camera2.CaptureRequest$Builder p8)
    {
        int[] v0_1 = ((int[]) org.webrtc.Camera2Session.access$2200(this.this$0).get(android.hardware.camera2.CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION));
        if (v0_1 == null) {
            int[] v1_1 = ((int[]) org.webrtc.Camera2Session.access$2200(this.this$0).get(android.hardware.camera2.CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES));
            int v3_4 = 0;
            while (v3_4 < v1_1.length) {
                if (v1_1[v3_4] != 1) {
                    v3_4++;
                } else {
                    p8.set(android.hardware.camera2.CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(1));
                    p8.set(android.hardware.camera2.CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(0));
                    org.webrtc.Logging.d("Camera2Session", "Using video stabilization.");
                }
            }
            org.webrtc.Logging.d("Camera2Session", "Stabilization not available.");
        } else {
            int v3_0 = 0;
            while (v3_0 < v0_1.length) {
                if (v0_1[v3_0] != 1) {
                    v3_0++;
                } else {
                    p8.set(android.hardware.camera2.CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
                    p8.set(android.hardware.camera2.CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(0));
                    org.webrtc.Logging.d("Camera2Session", "Using optical stabilization.");
                }
            }
        }
        return;
    }

    public void onConfigureFailed(android.hardware.camera2.CameraCaptureSession p3)
    {
        org.webrtc.Camera2Session.access$000(this.this$0);
        p3.close();
        org.webrtc.Camera2Session.access$600(this.this$0, "Failed to configure capture session.");
        return;
    }

    public void onConfigured(android.hardware.camera2.CameraCaptureSession p8)
    {
        org.webrtc.Camera2Session.access$000(this.this$0);
        org.webrtc.Logging.d("Camera2Session", "Camera capture session configured.");
        org.webrtc.Camera2Session.access$102(this.this$0, p8);
        try {
            android.hardware.camera2.CaptureRequest$Builder v0 = org.webrtc.Camera2Session.access$700(this.this$0).createCaptureRequest(3);
            v0.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new android.util.Range(Integer.valueOf((org.webrtc.Camera2Session.access$900(this.this$0).framerate.min / org.webrtc.Camera2Session.access$1400(this.this$0))), Integer.valueOf((org.webrtc.Camera2Session.access$900(this.this$0).framerate.max / org.webrtc.Camera2Session.access$1400(this.this$0)))));
            v0.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            v0.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(0));
            this.chooseStabilizationMode(v0);
            this.chooseFocusMode(v0);
            v0.addTarget(org.webrtc.Camera2Session.access$1000(this.this$0));
        } catch (android.hardware.camera2.CameraAccessException v1) {
            org.webrtc.Camera2Session.access$600(this.this$0, new StringBuilder().append("Failed to start capture request. ").append(v1).toString());
            return;
        }
        if (org.webrtc.Camera2Session.access$1100(this.this$0) != null) {
            org.webrtc.Logging.d("Camera2Session", "Add MediaRecorder surface to CaptureRequest.Builder");
            v0.addTarget(org.webrtc.Camera2Session.access$1100(this.this$0));
        }
        p8.setRepeatingRequest(v0.build(), new org.webrtc.Camera2Session$CameraCaptureCallback(this.this$0, 0), org.webrtc.Camera2Session.access$1300(this.this$0));
        org.webrtc.Camera2Session.access$800(this.this$0).startListening(new org.webrtc.Camera2Session$CaptureSessionCallback$1(this));
        org.webrtc.Logging.d("Camera2Session", "Camera device successfully started.");
        org.webrtc.Camera2Session.access$400(this.this$0).onDone(this.this$0);
        return;
    }
}
