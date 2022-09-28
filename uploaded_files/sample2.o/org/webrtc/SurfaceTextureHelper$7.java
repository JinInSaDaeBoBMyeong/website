package org.webrtc;
 class SurfaceTextureHelper$7 implements java.lang.Runnable {
    final synthetic org.webrtc.SurfaceTextureHelper this$0;
    final synthetic java.nio.ByteBuffer val$buf;
    final synthetic int val$height;
    final synthetic int val$stride;
    final synthetic int val$textureId;
    final synthetic float[] val$transformMatrix;
    final synthetic int val$width;

    SurfaceTextureHelper$7(org.webrtc.SurfaceTextureHelper p1, java.nio.ByteBuffer p2, int p3, int p4, int p5, int p6, float[] p7)
    {
        this.this$0 = p1;
        this.val$buf = p2;
        this.val$width = p3;
        this.val$height = p4;
        this.val$stride = p5;
        this.val$textureId = p6;
        this.val$transformMatrix = p7;
        return;
    }

    public void run()
    {
        if (org.webrtc.SurfaceTextureHelper.access$900(this.this$0) == null) {
            org.webrtc.SurfaceTextureHelper.access$902(this.this$0, new org.webrtc.YuvConverter());
        }
        org.webrtc.SurfaceTextureHelper.access$900(this.this$0).convert(this.val$buf, this.val$width, this.val$height, this.val$stride, this.val$textureId, this.val$transformMatrix);
        return;
    }
}
