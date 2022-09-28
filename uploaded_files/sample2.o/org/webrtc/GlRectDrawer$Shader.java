package org.webrtc;
 class GlRectDrawer$Shader {
    public final org.webrtc.GlShader glShader;
    public final int texMatrixLocation;

    public GlRectDrawer$Shader(String p3)
    {
        this.glShader = new org.webrtc.GlShader("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", p3);
        this.texMatrixLocation = this.glShader.getUniformLocation("texMatrix");
        return;
    }
}
