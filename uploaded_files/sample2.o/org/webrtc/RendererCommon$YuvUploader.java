package org.webrtc;
public class RendererCommon$YuvUploader {
    private java.nio.ByteBuffer copyBuffer;
    private int[] yuvTextures;

    public RendererCommon$YuvUploader()
    {
        return;
    }

    public void release()
    {
        this.copyBuffer = 0;
        if (this.yuvTextures != null) {
            android.opengl.GLES20.glDeleteTextures(3, this.yuvTextures, 0);
            this.yuvTextures = 0;
        }
        return;
    }

    public int[] uploadYuvData(int p14, int p15, int[] p16, java.nio.ByteBuffer[] p17)
    {
        int[] v12 = new int[3];
        v12[0] = p14;
        v12[1] = (p14 / 2);
        v12[2] = (p14 / 2);
        int[] v11 = new int[3];
        v11[0] = p15;
        v11[1] = (p15 / 2);
        v11[2] = (p15 / 2);
        int v9 = 0;
        int v10_0 = 0;
        while (v10_0 < 3) {
            if (p16[v10_0] > v12[v10_0]) {
                v9 = Math.max(v9, (v12[v10_0] * v11[v10_0]));
            }
            v10_0++;
        }
        if ((v9 > 0) && ((this.copyBuffer == null) || (this.copyBuffer.capacity() < v9))) {
            this.copyBuffer = java.nio.ByteBuffer.allocateDirect(v9);
        }
        if (this.yuvTextures == null) {
            int v0_13 = new int[3];
            this.yuvTextures = v0_13;
            int v10_1 = 0;
            while (v10_1 < 3) {
                this.yuvTextures[v10_1] = org.webrtc.GlUtil.generateTexture(3553);
                v10_1++;
            }
        }
        int v10_2 = 0;
        while (v10_2 < 3) {
            java.nio.ByteBuffer v8;
            android.opengl.GLES20.glActiveTexture((33984 + v10_2));
            android.opengl.GLES20.glBindTexture(3553, this.yuvTextures[v10_2]);
            if (p16[v10_2] != v12[v10_2]) {
                org.webrtc.VideoRenderer.nativeCopyPlane(p17[v10_2], v12[v10_2], v11[v10_2], p16[v10_2], this.copyBuffer, v12[v10_2]);
                v8 = this.copyBuffer;
            } else {
                v8 = p17[v10_2];
            }
            android.opengl.GLES20.glTexImage2D(3553, 0, 6409, v12[v10_2], v11[v10_2], 0, 6409, 5121, v8);
            v10_2++;
        }
        return this.yuvTextures;
    }
}
