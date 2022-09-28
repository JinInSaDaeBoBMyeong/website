package org.webrtc;
 class SurfaceTextureHelper$2 implements java.lang.Runnable {
    final synthetic org.webrtc.SurfaceTextureHelper this$0;

    SurfaceTextureHelper$2(org.webrtc.SurfaceTextureHelper p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.Logging.d("SurfaceTextureHelper", new StringBuilder().append("Setting listener to ").append(org.webrtc.SurfaceTextureHelper.access$100(this.this$0)).toString());
        org.webrtc.SurfaceTextureHelper.access$202(this.this$0, org.webrtc.SurfaceTextureHelper.access$100(this.this$0));
        org.webrtc.SurfaceTextureHelper.access$102(this.this$0, 0);
        if (org.webrtc.SurfaceTextureHelper.access$300(this.this$0)) {
            org.webrtc.SurfaceTextureHelper.access$400(this.this$0);
            org.webrtc.SurfaceTextureHelper.access$302(this.this$0, 0);
        }
        return;
    }
}
