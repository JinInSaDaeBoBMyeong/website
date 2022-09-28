package org.webrtc;
 class CameraVideoCapturer$CameraStatistics$1 implements java.lang.Runnable {
    final synthetic org.webrtc.CameraVideoCapturer$CameraStatistics this$0;

    CameraVideoCapturer$CameraStatistics$1(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.Logging.d("CameraStatistics", new StringBuilder().append("Camera fps: ").append(Math.round(((((float) org.webrtc.CameraVideoCapturer$CameraStatistics.access$000(this.this$0)) * 1148846080) / 1157234688))).append(".").toString());
        if (org.webrtc.CameraVideoCapturer$CameraStatistics.access$000(this.this$0) != 0) {
            org.webrtc.CameraVideoCapturer$CameraStatistics.access$102(this.this$0, 0);
            org.webrtc.CameraVideoCapturer$CameraStatistics.access$002(this.this$0, 0);
            org.webrtc.CameraVideoCapturer$CameraStatistics.access$300(this.this$0).getHandler().postDelayed(this, 2000);
        } else {
            org.webrtc.CameraVideoCapturer$CameraStatistics.access$104(this.this$0);
            if (((org.webrtc.CameraVideoCapturer$CameraStatistics.access$100(this.this$0) * 2000) < 4000) || (org.webrtc.CameraVideoCapturer$CameraStatistics.access$200(this.this$0) == null)) {
            } else {
                org.webrtc.Logging.e("CameraStatistics", "Camera freezed.");
                if (!org.webrtc.CameraVideoCapturer$CameraStatistics.access$300(this.this$0).isTextureInUse()) {
                    org.webrtc.CameraVideoCapturer$CameraStatistics.access$200(this.this$0).onCameraFreezed("Camera failure.");
                } else {
                    org.webrtc.CameraVideoCapturer$CameraStatistics.access$200(this.this$0).onCameraFreezed("Camera failure. Client must return video buffers.");
                }
            }
        }
        return;
    }
}
