package org.webrtc;
 class EglBase14 extends org.webrtc.EglBase {
    private static final int CURRENT_SDK_VERSION = 0;
    private static final int EGLExt_SDK_VERSION = 18;
    private static final String TAG = "EglBase14";
    private android.opengl.EGLConfig eglConfig;
    private android.opengl.EGLContext eglContext;
    private android.opengl.EGLDisplay eglDisplay;
    private android.opengl.EGLSurface eglSurface;

    static EglBase14()
    {
        org.webrtc.EglBase14.CURRENT_SDK_VERSION = android.os.Build$VERSION.SDK_INT;
        return;
    }

    public EglBase14(org.webrtc.EglBase14$Context p3, int[] p4)
    {
        this.eglSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        this.eglDisplay = org.webrtc.EglBase14.getEglDisplay();
        this.eglConfig = org.webrtc.EglBase14.getEglConfig(this.eglDisplay, p4);
        this.eglContext = org.webrtc.EglBase14.createEglContext(p3, this.eglDisplay, this.eglConfig);
        return;
    }

    private void checkIsNotReleased()
    {
        if ((this.eglDisplay != android.opengl.EGL14.EGL_NO_DISPLAY) && ((this.eglContext != android.opengl.EGL14.EGL_NO_CONTEXT) && (this.eglConfig != null))) {
            return;
        } else {
            throw new RuntimeException("This object has been released");
        }
    }

    private static android.opengl.EGLContext createEglContext(org.webrtc.EglBase14$Context p6, android.opengl.EGLDisplay p7, android.opengl.EGLConfig p8)
    {
        if ((p6 == null) || (org.webrtc.EglBase14$Context.access$000(p6) != android.opengl.EGL14.EGL_NO_CONTEXT)) {
            android.opengl.EGLContext v2;
            int[] v0 = new int[3];
            v0 = {12440, 2, 12344};
            if (p6 != null) {
                v2 = org.webrtc.EglBase14$Context.access$000(p6);
            } else {
                v2 = android.opengl.EGL14.EGL_NO_CONTEXT;
            }
            android.opengl.EGLContext v1 = android.opengl.EGL14.eglCreateContext(p7, p8, v2, v0, 0);
            if (v1 != android.opengl.EGL14.EGL_NO_CONTEXT) {
                return v1;
            } else {
                throw new RuntimeException(new StringBuilder().append("Failed to create EGL context: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
            }
        } else {
            throw new RuntimeException("Invalid sharedContext");
        }
    }

    private void createSurfaceInternal(Object p5)
    {
        if (((p5 instanceof android.view.Surface)) || ((p5 instanceof android.graphics.SurfaceTexture))) {
            this.checkIsNotReleased();
            if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
                int[] v0 = new int[1];
                v0[0] = 12344;
                this.eglSurface = android.opengl.EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, p5, v0, 0);
                if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
                    return;
                } else {
                    throw new RuntimeException(new StringBuilder().append("Failed to create window surface: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
                }
            } else {
                throw new RuntimeException("Already has an EGLSurface");
            }
        } else {
            throw new IllegalStateException("Input must be either a Surface or SurfaceTexture");
        }
    }

    private static android.opengl.EGLConfig getEglConfig(android.opengl.EGLDisplay p9, int[] p10)
    {
        android.opengl.EGLConfig[] v3 = new android.opengl.EGLConfig[1];
        int[] v6 = new int[1];
        if (android.opengl.EGL14.eglChooseConfig(p9, p10, 0, v3, 0, v3.length, v6, 0)) {
            if (v6[0] > 0) {
                android.opengl.EGLConfig v8 = v3[0];
                if (v8 != null) {
                    return v8;
                } else {
                    throw new RuntimeException("eglChooseConfig returned null");
                }
            } else {
                throw new RuntimeException("Unable to find any matching EGL config");
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("eglChooseConfig failed: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
        }
    }

    private static android.opengl.EGLDisplay getEglDisplay()
    {
        android.opengl.EGLDisplay v0 = android.opengl.EGL14.eglGetDisplay(0);
        if (v0 != android.opengl.EGL14.EGL_NO_DISPLAY) {
            int[] v1 = new int[2];
            if (android.opengl.EGL14.eglInitialize(v0, v1, 0, v1, 1)) {
                return v0;
            } else {
                throw new RuntimeException(new StringBuilder().append("Unable to initialize EGL14: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("Unable to get EGL14 display: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
        }
    }

    public static boolean isEGL14Supported()
    {
        int v0_2;
        int v1 = 1;
        StringBuilder vtmp3 = new StringBuilder().append("SDK version: ").append(org.webrtc.EglBase14.CURRENT_SDK_VERSION).append(". isEGL14Supported: ");
        if (org.webrtc.EglBase14.CURRENT_SDK_VERSION < 18) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        org.webrtc.Logging.d("EglBase14", vtmp3.append(v0_2).toString());
        if (org.webrtc.EglBase14.CURRENT_SDK_VERSION < 18) {
            v1 = 0;
        }
        return v1;
    }

    public void createDummyPbufferSurface()
    {
        this.createPbufferSurface(1, 1);
        return;
    }

    public void createPbufferSurface(int p5, int p6)
    {
        this.checkIsNotReleased();
        if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
            int[] v0 = new int[5];
            v0[0] = 12375;
            v0[1] = p5;
            v0[2] = 12374;
            v0[3] = p6;
            v0[4] = 12344;
            this.eglSurface = android.opengl.EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, v0, 0);
            if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
                return;
            } else {
                throw new RuntimeException(new StringBuilder().append("Failed to create pixel buffer surface with size ").append(p5).append("x").append(p6).append(": 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
            }
        } else {
            throw new RuntimeException("Already has an EGLSurface");
        }
    }

    public void createSurface(android.graphics.SurfaceTexture p1)
    {
        this.createSurfaceInternal(p1);
        return;
    }

    public void createSurface(android.view.Surface p1)
    {
        this.createSurfaceInternal(p1);
        return;
    }

    public void detachCurrent()
    {
        try {
            if (android.opengl.EGL14.eglMakeCurrent(this.eglDisplay, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_SURFACE, android.opengl.EGL14.EGL_NO_CONTEXT)) {
                return;
            } else {
                throw new RuntimeException(new StringBuilder().append("eglDetachCurrent failed: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
            }
        } catch (RuntimeException v0_2) {
            throw v0_2;
        }
    }

    public bridge synthetic org.webrtc.EglBase$Context getEglBaseContext()
    {
        return this.getEglBaseContext();
    }

    public org.webrtc.EglBase14$Context getEglBaseContext()
    {
        return new org.webrtc.EglBase14$Context(this.eglContext);
    }

    public boolean hasSurface()
    {
        int v0_1;
        if (this.eglSurface == android.opengl.EGL14.EGL_NO_SURFACE) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public void makeCurrent()
    {
        this.checkIsNotReleased();
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            try {
                if (android.opengl.EGL14.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
                    return;
                } else {
                    throw new RuntimeException(new StringBuilder().append("eglMakeCurrent failed: 0x").append(Integer.toHexString(android.opengl.EGL14.eglGetError())).toString());
                }
            } catch (RuntimeException v0_4) {
                throw v0_4;
            }
        } else {
            throw new RuntimeException("No EGLSurface - can\'t make current");
        }
    }

    public void release()
    {
        this.checkIsNotReleased();
        this.releaseSurface();
        this.detachCurrent();
        android.opengl.EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        android.opengl.EGL14.eglReleaseThread();
        android.opengl.EGL14.eglTerminate(this.eglDisplay);
        this.eglContext = android.opengl.EGL14.EGL_NO_CONTEXT;
        this.eglDisplay = android.opengl.EGL14.EGL_NO_DISPLAY;
        this.eglConfig = 0;
        return;
    }

    public void releaseSurface()
    {
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            android.opengl.EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = android.opengl.EGL14.EGL_NO_SURFACE;
        }
        return;
    }

    public int surfaceHeight()
    {
        int[] v0 = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, v0, 0);
        return v0[0];
    }

    public int surfaceWidth()
    {
        int[] v0 = new int[1];
        android.opengl.EGL14.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, v0, 0);
        return v0[0];
    }

    public void swapBuffers()
    {
        this.checkIsNotReleased();
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            try {
                android.opengl.EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                return;
            } catch (Throwable v0_4) {
                throw v0_4;
            }
        } else {
            throw new RuntimeException("No EGLSurface - can\'t swap buffers");
        }
    }

    public void swapBuffers(long p4)
    {
        this.checkIsNotReleased();
        if (this.eglSurface != android.opengl.EGL14.EGL_NO_SURFACE) {
            try {
                android.opengl.EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, p4);
                android.opengl.EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                return;
            } catch (Throwable v0_1) {
                throw v0_1;
            }
        } else {
            throw new RuntimeException("No EGLSurface - can\'t swap buffers");
        }
    }
}
