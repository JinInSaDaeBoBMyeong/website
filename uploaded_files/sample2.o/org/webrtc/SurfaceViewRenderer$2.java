package org.webrtc;
 class SurfaceViewRenderer$2 implements java.lang.Runnable {
    final synthetic org.webrtc.SurfaceViewRenderer this$0;

    SurfaceViewRenderer$2(org.webrtc.SurfaceViewRenderer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.SurfaceViewRenderer.access$000(this.this$0);
        this.this$0.requestLayout();
        return;
    }
}
