package org.webrtc;
public class GlUtil {

    private GlUtil()
    {
        return;
    }

    public static void checkNoGLES2Error(String p4)
    {
        int v0 = android.opengl.GLES20.glGetError();
        if (v0 == 0) {
            return;
        } else {
            throw new RuntimeException(new StringBuilder().append(p4).append(": GLES20 error: ").append(v0).toString());
        }
    }

    public static java.nio.FloatBuffer createFloatBuffer(float[] p3)
    {
        java.nio.ByteBuffer v0 = java.nio.ByteBuffer.allocateDirect((p3.length * 4));
        v0.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer v1 = v0.asFloatBuffer();
        v1.put(p3);
        v1.position(0);
        return v1;
    }

    public static int generateTexture(int p6)
    {
        int[] v0 = new int[1];
        android.opengl.GLES20.glGenTextures(1, v0, 0);
        int v1 = v0[0];
        android.opengl.GLES20.glBindTexture(p6, v1);
        android.opengl.GLES20.glTexParameterf(p6, 10241, 1175979008);
        android.opengl.GLES20.glTexParameterf(p6, 10240, 1175979008);
        android.opengl.GLES20.glTexParameterf(p6, 10242, 1191259904);
        android.opengl.GLES20.glTexParameterf(p6, 10243, 1191259904);
        org.webrtc.GlUtil.checkNoGLES2Error("generateTexture");
        return v1;
    }
}
