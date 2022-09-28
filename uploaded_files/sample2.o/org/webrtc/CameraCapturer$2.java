package org.webrtc;
 class CameraCapturer$2 implements org.webrtc.CameraSession$Events {
    final synthetic org.webrtc.CameraCapturer this$0;

    CameraCapturer$2(org.webrtc.CameraCapturer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onByteBufferFrameCaptured(org.webrtc.CameraSession p11, byte[] p12, int p13, int p14, int p15, long p16)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if (p11 == org.webrtc.CameraCapturer.access$800(this.this$0)) {
                if (!org.webrtc.CameraCapturer.access$1200(this.this$0)) {
                    org.webrtc.CameraCapturer.access$1100(this.this$0).onFirstFrameAvailable();
                    org.webrtc.CameraCapturer.access$1202(this.this$0, 1);
                }
                org.webrtc.CameraCapturer.access$900(this.this$0).addFrame();
                org.webrtc.CameraCapturer.access$600(this.this$0).onByteBufferFrameCaptured(p12, p13, p14, p15, p16);
            } else {
                org.webrtc.Logging.w("CameraCapturer", "onByteBufferFrameCaptured from another session.");
            }
        } catch (org.webrtc.CameraCapturer v0_10) {
            throw v0_10;
        }
        return;
    }

    public void onCameraClosed(org.webrtc.CameraSession p4)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if ((p4 == org.webrtc.CameraCapturer.access$800(this.this$0)) || (org.webrtc.CameraCapturer.access$800(this.this$0) == null)) {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraClosed();
            } else {
                org.webrtc.Logging.d("CameraCapturer", "onCameraClosed from another session.");
            }
        } catch (String v0_6) {
            throw v0_6;
        }
        return;
    }

    public void onCameraDisconnected(org.webrtc.CameraSession p4)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if (p4 == org.webrtc.CameraCapturer.access$800(this.this$0)) {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraDisconnected();
                this.this$0.stopCapture();
            } else {
                org.webrtc.Logging.w("CameraCapturer", "onCameraDisconnected from another session.");
            }
        } catch (org.webrtc.CameraCapturer v0_4) {
            throw v0_4;
        }
        return;
    }

    public void onCameraError(org.webrtc.CameraSession p5, String p6)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if (p5 == org.webrtc.CameraCapturer.access$800(this.this$0)) {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraError(p6);
                this.this$0.stopCapture();
            } else {
                org.webrtc.Logging.w("CameraCapturer", new StringBuilder().append("onCameraError from another session: ").append(p6).toString());
            }
        } catch (org.webrtc.CameraCapturer v0_5) {
            throw v0_5;
        }
        return;
    }

    public void onCameraOpening()
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if (org.webrtc.CameraCapturer.access$800(this.this$0) == null) {
                org.webrtc.CameraCapturer.access$1100(this.this$0).onCameraOpening(org.webrtc.CameraCapturer.access$1400(this.this$0));
            } else {
                org.webrtc.Logging.w("CameraCapturer", "onCameraOpening while session was open.");
            }
        } catch (org.webrtc.CameraVideoCapturer$CameraEventsHandler v0_4) {
            throw v0_4;
        }
        return;
    }

    public void onTextureFrameCaptured(org.webrtc.CameraSession p10, int p11, int p12, int p13, float[] p14, int p15, long p16)
    {
        org.webrtc.CameraCapturer.access$000(this.this$0);
        org.webrtc.CameraCapturer.access$500(this.this$0);
        try {
            if (p10 == org.webrtc.CameraCapturer.access$800(this.this$0)) {
                if (!org.webrtc.CameraCapturer.access$1200(this.this$0)) {
                    org.webrtc.CameraCapturer.access$1100(this.this$0).onFirstFrameAvailable();
                    org.webrtc.CameraCapturer.access$1202(this.this$0, 1);
                }
                org.webrtc.CameraCapturer.access$900(this.this$0).addFrame();
                org.webrtc.CameraCapturer.access$600(this.this$0).onTextureFrameCaptured(p11, p12, p13, p14, p15, p16);
            } else {
                org.webrtc.Logging.w("CameraCapturer", "onTextureFrameCaptured from another session.");
                org.webrtc.CameraCapturer.access$1000(this.this$0).returnTextureFrame();
            }
        } catch (org.webrtc.VideoCapturer$CapturerObserver v0_13) {
            throw v0_13;
        }
        return;
    }
}
