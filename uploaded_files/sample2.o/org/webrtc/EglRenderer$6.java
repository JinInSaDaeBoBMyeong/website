package org.webrtc;
 class EglRenderer$6 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic boolean val$applyFpsReduction;
    final synthetic org.webrtc.RendererCommon$GlDrawer val$drawerParam;
    final synthetic org.webrtc.EglRenderer$FrameListener val$listener;
    final synthetic float val$scale;

    EglRenderer$6(org.webrtc.EglRenderer p1, org.webrtc.RendererCommon$GlDrawer p2, org.webrtc.EglRenderer$FrameListener p3, float p4, boolean p5)
    {
        this.this$0 = p1;
        this.val$drawerParam = p2;
        this.val$listener = p3;
        this.val$scale = p4;
        this.val$applyFpsReduction = p5;
        return;
    }

    public void run()
    {
        org.webrtc.RendererCommon$GlDrawer v0;
        if (this.val$drawerParam != null) {
            v0 = this.val$drawerParam;
        } else {
            v0 = org.webrtc.EglRenderer.access$800(this.this$0);
        }
        org.webrtc.EglRenderer.access$1100(this.this$0).add(new org.webrtc.EglRenderer$FrameListenerAndParams(this.val$listener, this.val$scale, v0, this.val$applyFpsReduction));
        return;
    }
}
