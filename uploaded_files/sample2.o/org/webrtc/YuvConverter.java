package org.webrtc;
 class YuvConverter {
    private static final java.nio.FloatBuffer DEVICE_RECTANGLE = None;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n";
    private static final java.nio.FloatBuffer TEXTURE_RECTANGLE = None;
    private static final String VERTEX_SHADER = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private final int coeffsLoc;
    private boolean released;
    private final org.webrtc.GlShader shader;
    private final int texMatrixLoc;
    private final org.webrtc.GlTextureFrameBuffer textureFrameBuffer;
    private final org.webrtc.ThreadUtils$ThreadChecker threadChecker;
    private final int xUnitLoc;

    static YuvConverter()
    {
        java.nio.FloatBuffer v0_0 = new float[8];
        v0_0 = {-1082130432, -1082130432, 1065353216, -1082130432, -1082130432, 1065353216, 1065353216, 1065353216};
        org.webrtc.YuvConverter.DEVICE_RECTANGLE = org.webrtc.GlUtil.createFloatBuffer(v0_0);
        java.nio.FloatBuffer v0_2 = new float[8];
        v0_2 = {0, 0, 1065353216, 0, 0, 1065353216, 1065353216, 1065353216};
        org.webrtc.YuvConverter.TEXTURE_RECTANGLE = org.webrtc.GlUtil.createFloatBuffer(v0_2);
        return;
    }

    public YuvConverter()
    {
        this.threadChecker = new org.webrtc.ThreadUtils$ThreadChecker();
        this.released = 0;
        this.threadChecker.checkIsOnValidThread();
        this.textureFrameBuffer = new org.webrtc.GlTextureFrameBuffer(6408);
        this.shader = new org.webrtc.GlShader("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
        this.shader.useProgram();
        this.texMatrixLoc = this.shader.getUniformLocation("texMatrix");
        this.xUnitLoc = this.shader.getUniformLocation("xUnit");
        this.coeffsLoc = this.shader.getUniformLocation("coeffs");
        android.opengl.GLES20.glUniform1i(this.shader.getUniformLocation("oesTex"), 0);
        org.webrtc.GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
        this.shader.setVertexAttribArray("in_pos", 2, org.webrtc.YuvConverter.DEVICE_RECTANGLE);
        this.shader.setVertexAttribArray("in_tc", 2, org.webrtc.YuvConverter.TEXTURE_RECTANGLE);
        return;
    }

    public void convert(java.nio.ByteBuffer p14, int p15, int p16, int p17, int p18, float[] p19)
    {
        this.threadChecker.checkIsOnValidThread();
        if (!this.released) {
            if ((p17 % 8) == 0) {
                if (p17 >= p15) {
                    int v12 = ((p15 + 3) / 4);
                    int v11 = ((p15 + 7) / 8);
                    int v10 = ((p16 + 1) / 2);
                    int v9 = (p16 + v10);
                    if (p14.capacity() >= (p17 * v9)) {
                        float[] v19_1 = org.webrtc.RendererCommon.multiplyMatrices(p19, org.webrtc.RendererCommon.verticalFlipMatrix());
                        int v3 = (p17 / 4);
                        int v4 = v9;
                        this.textureFrameBuffer.setSize(v3, v4);
                        android.opengl.GLES20.glBindFramebuffer(36160, this.textureFrameBuffer.getFrameBufferId());
                        org.webrtc.GlUtil.checkNoGLES2Error("glBindFramebuffer");
                        android.opengl.GLES20.glActiveTexture(33984);
                        android.opengl.GLES20.glBindTexture(36197, p18);
                        android.opengl.GLES20.glUniformMatrix4fv(this.texMatrixLoc, 1, 0, v19_1, 0);
                        android.opengl.GLES20.glViewport(0, 0, v12, p16);
                        android.opengl.GLES20.glUniform2f(this.xUnitLoc, (v19_1[0] / ((float) p15)), (v19_1[1] / ((float) p15)));
                        android.opengl.GLES20.glUniform4f(this.coeffsLoc, 1050220167, 1058424226, 1038710997, 0);
                        android.opengl.GLES20.glDrawArrays(5, 0, 4);
                        android.opengl.GLES20.glViewport(0, p16, v11, v10);
                        android.opengl.GLES20.glUniform2f(this.xUnitLoc, ((1073741824 * v19_1[0]) / ((float) p15)), ((1073741824 * v19_1[1]) / ((float) p15)));
                        android.opengl.GLES20.glUniform4f(this.coeffsLoc, -1104343466, -1096189739, 1056931054, 1056964608);
                        android.opengl.GLES20.glDrawArrays(5, 0, 4);
                        android.opengl.GLES20.glViewport((p17 / 8), p16, v11, v10);
                        android.opengl.GLES20.glUniform4f(this.coeffsLoc, 1056931054, -1093270503, -1113161571, 1056964608);
                        android.opengl.GLES20.glDrawArrays(5, 0, 4);
                        android.opengl.GLES20.glReadPixels(0, 0, v3, v4, 6408, 5121, p14);
                        org.webrtc.GlUtil.checkNoGLES2Error("YuvConverter.convert");
                        android.opengl.GLES20.glBindFramebuffer(36160, 0);
                        android.opengl.GLES20.glBindTexture(3553, 0);
                        android.opengl.GLES20.glBindTexture(36197, 0);
                        return;
                    } else {
                        throw new IllegalArgumentException("YuvConverter.convert called with too small buffer");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid stride, must >= width");
                }
            } else {
                throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
            }
        } else {
            throw new IllegalStateException("YuvConverter.convert called on released object");
        }
    }

    public void release()
    {
        this.threadChecker.checkIsOnValidThread();
        this.released = 1;
        this.shader.release();
        this.textureFrameBuffer.release();
        return;
    }
}
