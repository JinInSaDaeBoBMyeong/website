package org.webrtc;
public class GlTextureFrameBuffer {
    private final int frameBufferId;
    private int height;
    private final int pixelFormat;
    private final int textureId;
    private int width;

    public GlTextureFrameBuffer(int p5)
    {
        switch (p5) {
            case 6407:
            case 6408:
            case 6409:
                this.pixelFormat = p5;
                this.textureId = org.webrtc.GlUtil.generateTexture(3553);
                this.width = 0;
                this.height = 0;
                int[] v0 = new int[1];
                android.opengl.GLES20.glGenFramebuffers(1, v0, 0);
                this.frameBufferId = v0[0];
                return;
            default:
                throw new IllegalArgumentException(new StringBuilder().append("Invalid pixel format: ").append(p5).toString());
        }
    }

    public int getFrameBufferId()
    {
        return this.frameBufferId;
    }

    public int getHeight()
    {
        return this.height;
    }

    public int getTextureId()
    {
        return this.textureId;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void release()
    {
        int[] v0_0 = new int[1];
        v0_0[0] = this.textureId;
        android.opengl.GLES20.glDeleteTextures(1, v0_0, 0);
        int[] v0_1 = new int[1];
        v0_1[0] = this.frameBufferId;
        android.opengl.GLES20.glDeleteFramebuffers(1, v0_1, 0);
        this.width = 0;
        this.height = 0;
        return;
    }

    public void setSize(int p12, int p13)
    {
        if ((p12 != 0) && (p13 != 0)) {
            if ((p12 != this.width) || (p13 != this.height)) {
                this.width = p12;
                this.height = p13;
                android.opengl.GLES20.glActiveTexture(33984);
                android.opengl.GLES20.glBindTexture(3553, this.textureId);
                android.opengl.GLES20.glTexImage2D(3553, 0, this.pixelFormat, p12, p13, 0, this.pixelFormat, 5121, 0);
                android.opengl.GLES20.glBindTexture(3553, 0);
                org.webrtc.GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
                android.opengl.GLES20.glBindFramebuffer(36160, this.frameBufferId);
                android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
                int v9 = android.opengl.GLES20.glCheckFramebufferStatus(36160);
                if (v9 == 36053) {
                    android.opengl.GLES20.glBindFramebuffer(36160, 0);
                } else {
                    throw new IllegalStateException(new StringBuilder().append("Framebuffer not complete, status: ").append(v9).toString());
                }
            }
            return;
        } else {
            throw new IllegalArgumentException(new StringBuilder().append("Invalid size: ").append(p12).append("x").append(p13).toString());
        }
    }
}
