package org.webrtc;
 class EglRenderer$FrameListenerAndParams {
    public final boolean applyFpsReduction;
    public final org.webrtc.RendererCommon$GlDrawer drawer;
    public final org.webrtc.EglRenderer$FrameListener listener;
    public final float scale;

    public EglRenderer$FrameListenerAndParams(org.webrtc.EglRenderer$FrameListener p1, float p2, org.webrtc.RendererCommon$GlDrawer p3, boolean p4)
    {
        this.listener = p1;
        this.scale = p2;
        this.drawer = p3;
        this.applyFpsReduction = p4;
        return;
    }
}
