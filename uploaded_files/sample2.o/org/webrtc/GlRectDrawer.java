package org.webrtc;
public class GlRectDrawer implements org.webrtc.RendererCommon$GlDrawer {
    private static final java.nio.FloatBuffer FULL_RECTANGLE_BUF = None;
    private static final java.nio.FloatBuffer FULL_RECTANGLE_TEX_BUF = None;
    private static final String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
    private static final String RGB_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n";
    private static final String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private static final String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n";
    private final java.util.Map shaders;

    static GlRectDrawer()
    {
        java.nio.FloatBuffer v0_0 = new float[8];
        v0_0 = {-1082130432, -1082130432, 1065353216, -1082130432, -1082130432, 1065353216, 1065353216, 1065353216};
        org.webrtc.GlRectDrawer.FULL_RECTANGLE_BUF = org.webrtc.GlUtil.createFloatBuffer(v0_0);
        java.nio.FloatBuffer v0_2 = new float[8];
        v0_2 = {0, 0, 1065353216, 0, 0, 1065353216, 1065353216, 1065353216};
        org.webrtc.GlRectDrawer.FULL_RECTANGLE_TEX_BUF = org.webrtc.GlUtil.createFloatBuffer(v0_2);
        return;
    }

    public GlRectDrawer()
    {
        this.shaders = new java.util.IdentityHashMap();
        return;
    }

    private void drawRectangle(int p4, int p5, int p6, int p7)
    {
        android.opengl.GLES20.glViewport(p4, p5, p6, p7);
        android.opengl.GLES20.glDrawArrays(5, 0, 4);
        return;
    }

    private void prepareShader(String p8, float[] p9)
    {
        org.webrtc.GlRectDrawer$Shader v0_1;
        if (!this.shaders.containsKey(p8)) {
            v0_1 = new org.webrtc.GlRectDrawer$Shader(p8);
            this.shaders.put(p8, v0_1);
            v0_1.glShader.useProgram();
            if (p8 != "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n") {
                if (p8 != "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n") {
                    if (p8 != "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n") {
                        throw new IllegalStateException(new StringBuilder().append("Unknown fragment shader: ").append(p8).toString());
                    } else {
                        android.opengl.GLES20.glUniform1i(v0_1.glShader.getUniformLocation("oes_tex"), 0);
                    }
                } else {
                    android.opengl.GLES20.glUniform1i(v0_1.glShader.getUniformLocation("rgb_tex"), 0);
                }
            } else {
                android.opengl.GLES20.glUniform1i(v0_1.glShader.getUniformLocation("y_tex"), 0);
                android.opengl.GLES20.glUniform1i(v0_1.glShader.getUniformLocation("u_tex"), 1);
                android.opengl.GLES20.glUniform1i(v0_1.glShader.getUniformLocation("v_tex"), 2);
            }
            org.webrtc.GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            v0_1.glShader.setVertexAttribArray("in_pos", 2, org.webrtc.GlRectDrawer.FULL_RECTANGLE_BUF);
            v0_1.glShader.setVertexAttribArray("in_tc", 2, org.webrtc.GlRectDrawer.FULL_RECTANGLE_TEX_BUF);
        } else {
            v0_1 = ((org.webrtc.GlRectDrawer$Shader) this.shaders.get(p8));
        }
        v0_1.glShader.useProgram();
        android.opengl.GLES20.glUniformMatrix4fv(v0_1.texMatrixLocation, 1, 0, p9, 0);
        return;
    }

    public void drawOes(int p3, float[] p4, int p5, int p6, int p7, int p8, int p9, int p10)
    {
        this.prepareShader("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n", p4);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(36197, p3);
        this.drawRectangle(p7, p8, p9, p10);
        android.opengl.GLES20.glBindTexture(36197, 0);
        return;
    }

    public void drawRgb(int p3, float[] p4, int p5, int p6, int p7, int p8, int p9, int p10)
    {
        this.prepareShader("precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n", p4);
        android.opengl.GLES20.glActiveTexture(33984);
        android.opengl.GLES20.glBindTexture(3553, p3);
        this.drawRectangle(p7, p8, p9, p10);
        android.opengl.GLES20.glBindTexture(3553, 0);
        return;
    }

    public void drawYuv(int[] p6, float[] p7, int p8, int p9, int p10, int p11, int p12, int p13)
    {
        this.prepareShader("precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r;\n  float u = texture2D(u_tex, interp_tc).r - 0.5;\n  float v = texture2D(v_tex, interp_tc).r - 0.5;\n  gl_FragColor = vec4(y + 1.403 * v,                       y - 0.344 * u - 0.714 * v,                       y + 1.77 * u, 1);\n}\n", p7);
        int v0_1 = 0;
        while (v0_1 < 3) {
            android.opengl.GLES20.glActiveTexture((33984 + v0_1));
            android.opengl.GLES20.glBindTexture(3553, p6[v0_1]);
            v0_1++;
        }
        this.drawRectangle(p10, p11, p12, p13);
        int v0_0 = 0;
        while (v0_0 < 3) {
            android.opengl.GLES20.glActiveTexture((33984 + v0_0));
            android.opengl.GLES20.glBindTexture(3553, 0);
            v0_0++;
        }
        return;
    }

    public void release()
    {
        java.util.Map v1_2 = this.shaders.values().iterator();
        while (v1_2.hasNext()) {
            ((org.webrtc.GlRectDrawer$Shader) v1_2.next()).glShader.release();
        }
        this.shaders.clear();
        return;
    }
}
