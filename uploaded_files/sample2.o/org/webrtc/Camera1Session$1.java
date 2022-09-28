package org.webrtc;
 class Camera1Session$1 implements android.hardware.Camera$ErrorCallback {
    final synthetic org.webrtc.Camera1Session this$0;

    Camera1Session$1(org.webrtc.Camera1Session p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onError(int p4, android.hardware.Camera p5)
    {
        String v0;
        if (p4 != 100) {
            v0 = new StringBuilder().append("Camera error: ").append(p4).toString();
        } else {
            v0 = "Camera server died!";
        }
        org.webrtc.Logging.e("Camera1Session", v0);
        org.webrtc.Camera1Session.access$000(this.this$0);
        if (p4 != 2) {
            org.webrtc.Camera1Session.access$100(this.this$0).onCameraError(this.this$0, v0);
        } else {
            org.webrtc.Camera1Session.access$100(this.this$0).onCameraDisconnected(this.this$0);
        }
        return;
    }
}
