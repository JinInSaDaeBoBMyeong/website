package org.webrtc;
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    public GlShader(String p8, String p9)
    {
        int v2 = org.webrtc.GlShader.compileShader(35633, p8);
        int v0 = org.webrtc.GlShader.compileShader(35632, p9);
        this.program = android.opengl.GLES20.glCreateProgram();
        if (this.program != 0) {
            android.opengl.GLES20.glAttachShader(this.program, v2);
            android.opengl.GLES20.glAttachShader(this.program, v0);
            android.opengl.GLES20.glLinkProgram(this.program);
            int[] v1 = new int[1];
            v1[0] = 0;
            android.opengl.GLES20.glGetProgramiv(this.program, 35714, v1, 0);
            if (v1[0] == 1) {
                android.opengl.GLES20.glDeleteShader(v2);
                android.opengl.GLES20.glDeleteShader(v0);
                org.webrtc.GlUtil.checkNoGLES2Error("Creating GlShader");
                return;
            } else {
                org.webrtc.Logging.e("GlShader", new StringBuilder().append("Could not link program: ").append(android.opengl.GLES20.glGetProgramInfoLog(this.program)).toString());
                throw new RuntimeException(android.opengl.GLES20.glGetProgramInfoLog(this.program));
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("glCreateProgram() failed. GLES20 error: ").append(android.opengl.GLES20.glGetError()).toString());
        }
    }

    private static int compileShader(int p5, String p6)
    {
        int v1 = android.opengl.GLES20.glCreateShader(p5);
        if (v1 != 0) {
            android.opengl.GLES20.glShaderSource(v1, p6);
            android.opengl.GLES20.glCompileShader(v1);
            int[] v0 = new int[1];
            v0[0] = 0;
            android.opengl.GLES20.glGetShaderiv(v1, 35713, v0, 0);
            if (v0[0] == 1) {
                org.webrtc.GlUtil.checkNoGLES2Error("compileShader");
                return v1;
            } else {
                org.webrtc.Logging.e("GlShader", new StringBuilder().append("Could not compile shader ").append(p5).append(":").append(android.opengl.GLES20.glGetShaderInfoLog(v1)).toString());
                throw new RuntimeException(android.opengl.GLES20.glGetShaderInfoLog(v1));
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("glCreateShader() failed. GLES20 error: ").append(android.opengl.GLES20.glGetError()).toString());
        }
    }

    public int getAttribLocation(String p5)
    {
        if (this.program != -1) {
            int v0 = android.opengl.GLES20.glGetAttribLocation(this.program, p5);
            if (v0 >= 0) {
                return v0;
            } else {
                throw new RuntimeException(new StringBuilder().append("Could not locate \'").append(p5).append("\' in program").toString());
            }
        } else {
            throw new RuntimeException("The program has been released");
        }
    }

    public int getUniformLocation(String p5)
    {
        if (this.program != -1) {
            int v0 = android.opengl.GLES20.glGetUniformLocation(this.program, p5);
            if (v0 >= 0) {
                return v0;
            } else {
                throw new RuntimeException(new StringBuilder().append("Could not locate uniform \'").append(p5).append("\' in program").toString());
            }
        } else {
            throw new RuntimeException("The program has been released");
        }
    }

    public void release()
    {
        org.webrtc.Logging.d("GlShader", "Deleting shader.");
        if (this.program != -1) {
            android.opengl.GLES20.glDeleteProgram(this.program);
            this.program = -1;
        }
        return;
    }

    public void setVertexAttribArray(String p7, int p8, java.nio.FloatBuffer p9)
    {
        if (this.program != -1) {
            int v0 = this.getAttribLocation(p7);
            android.opengl.GLES20.glEnableVertexAttribArray(v0);
            android.opengl.GLES20.glVertexAttribPointer(v0, p8, 5126, 0, 0, p9);
            org.webrtc.GlUtil.checkNoGLES2Error("setVertexAttribArray");
            return;
        } else {
            throw new RuntimeException("The program has been released");
        }
    }

    public void useProgram()
    {
        if (this.program != -1) {
            android.opengl.GLES20.glUseProgram(this.program);
            org.webrtc.GlUtil.checkNoGLES2Error("glUseProgram");
            return;
        } else {
            throw new RuntimeException("The program has been released");
        }
    }
}
