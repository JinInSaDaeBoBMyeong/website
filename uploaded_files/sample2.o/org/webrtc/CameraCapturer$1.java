package org.webrtc;
 class CameraCapturer$1 implements org.webrtc.CameraSession$CreateSessionCallback {
    final synthetic org.webrtc.CameraCapturer this$0;

    CameraCapturer$1(org.webrtc.CameraCapturer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onDone(org.webrtc.CameraSession p6)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.Logging.d("CameraCapturer", new StringBuilder().append("Create session done. Switch state: ").append(org.webrtc.CameraCapturer.access$100(this.this$0)).append(". MediaRecorder state: ").append(org.webrtc.CameraCapturer.access$200(this.this$0)).toString());
        org.webrtc.CameraCapturer.access$400(this.this$0).removeCallbacks(org.webrtc.CameraCapturer.access$300(this.this$0));
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            org.webrtc.CameraCapturer.access$600(this.this$0).onCapturerStarted(1);
            org.webrtc.CameraCapturer.access$702(this.this$0, 0);
            org.webrtc.CameraCapturer.access$802(this.this$0, p6);
            org.webrtc.CameraCapturer.access$902(this.this$0, new org.webrtc.CameraVideoCapturer$CameraStatistics(org.webrtc.CameraCapturer.access$1000(this.this$0), org.webrtc.CameraCapturer.access$1100(this.this$0)));
            org.webrtc.CameraCapturer.access$1202(this.this$0, 0);
            org.webrtc.CameraCapturer.access$500(this.this$0).notifyAll();
        } catch (org.webrtc.CameraCapturer v0_14) {
            throw v0_14;
        }
        if (org.webrtc.CameraCapturer.access$100(this.this$0) != org.webrtc.CameraCapturer$SwitchState.IN_PROGRESS) {
            if (org.webrtc.CameraCapturer.access$100(this.this$0) == org.webrtc.CameraCapturer$SwitchState.PENDING) {
                org.webrtc.CameraCapturer.access$102(this.this$0, org.webrtc.CameraCapturer$SwitchState.IDLE);
                org.webrtc.CameraCapturer.access$1600(this.this$0, org.webrtc.CameraCapturer.access$1300(this.this$0));
            }
        } else {
            if (org.webrtc.CameraCapturer.access$1300(this.this$0) != null) {
                org.webrtc.CameraCapturer.access$1300(this.this$0).onCameraSwitchDone(org.webrtc.CameraCapturer.access$1500(this.this$0).isFrontFacing(org.webrtc.CameraCapturer.access$1400(this.this$0)));
                org.webrtc.CameraCapturer.access$1302(this.this$0, 0);
            }
            org.webrtc.CameraCapturer.access$102(this.this$0, org.webrtc.CameraCapturer$SwitchState.IDLE);
        }
        if ((org.webrtc.CameraCapturer.access$200(this.this$0) == org.webrtc.CameraCapturer$MediaRecorderState.IDLE_TO_ACTIVE) || (org.webrtc.CameraCapturer.access$200(this.this$0) == org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE_TO_IDLE)) {
            if (org.webrtc.CameraCapturer.access$1700(this.this$0) != null) {
                org.webrtc.CameraCapturer.access$1700(this.this$0).onMediaRecorderSuccess();
                org.webrtc.CameraCapturer.access$1702(this.this$0, 0);
            }
            if (org.webrtc.CameraCapturer.access$200(this.this$0) != org.webrtc.CameraCapturer$MediaRecorderState.IDLE_TO_ACTIVE) {
                org.webrtc.CameraCapturer.access$202(this.this$0, org.webrtc.CameraCapturer$MediaRecorderState.IDLE);
            } else {
                org.webrtc.CameraCapturer.access$202(this.this$0, org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE);
            }
        }
        return;
    }

    public void onFailure(org.webrtc.CameraSession$FailureType p5, String p6)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$400(this.this$0).removeCallbacks(org.webrtc.CameraCapturer.access$300(this.this$0));
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            org.webrtc.CameraCapturer.access$600(this.this$0).onCapturerStarted(0);
            org.webrtc.CameraCapturer.access$1810(this.this$0);
        } catch (org.webrtc.CameraVideoCapturer$CameraEventsHandler v0_3) {
            throw v0_3;
        }
        if (org.webrtc.CameraCapturer.access$1800(this.this$0) > 0) {
            org.webrtc.Logging.w("CameraCapturer", new StringBuilder().append("Opening camera failed, retry: ").append(p6).toString());
            org.webrtc.CameraCapturer.access$1900(this.this$0, 500, 0);
        } else {
            org.webrtc.Logging.w("CameraCapturer", new StringBuilder().append("Opening camera failed, passing: ").append(p6).toString());
            org.webrtc.CameraCapturer.access$702(this.this$0, 0);
            org.webrtc.CameraCapturer.access$500(this.this$0).notifyAll();
            if (org.webrtc.CameraCapturer.access$100(this.this$0) != org.webrtc.CameraCapturer$SwitchState.IDLE) {
                if (org.webrtc.CameraCapturer.access$1300(this.this$0) != null) {
                    org.webrtc.CameraCapturer.access$1300(this.this$0).onCameraSwitchError(p6);
                    org.webrtc.CameraCapturer.access$1302(this.this$0, 0);
                }
                org.webrtc.CameraCapturer.access$102(this.this$0, org.webrtc.CameraCapturer$SwitchState.IDLE);
            }
            if (org.webrtc.CameraCapturer.access$200(this.this$0) != org.webrtc.CameraCapturer$MediaRecorderState.IDLE) {
                if (org.webrtc.CameraCapturer.access$1700(this.this$0) != null) {
                    org.webrtc.CameraCapturer.access$1700(this.this$0).onMediaRecorderError(p6);
                    org.webrtc.CameraCapturer.access$1702(this.this$0, 0);
                }
                org.webrtc.CameraCapturer.access$202(this.this$0, org.webrtc.CameraCapturer$MediaRecorderState.IDLE);
            }
            if (p5 != org.webrtc.CameraSession$FailureType.DISCONNECTED) {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraError(p6);
            } else {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraDisconnected();
            }
        }
        return;
    }
}
