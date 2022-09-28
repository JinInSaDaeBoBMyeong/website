package org.webrtc;
 class EglBase10 extends org.webrtc.EglBase {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private final javax.microedition.khronos.egl.EGL10 egl;
    private javax.microedition.khronos.egl.EGLConfig eglConfig;
    private javax.microedition.khronos.egl.EGLContext eglContext;
    private javax.microedition.khronos.egl.EGLDisplay eglDisplay;
    private javax.microedition.khronos.egl.EGLSurface eglSurface;

    public EglBase10(org.webrtc.EglBase10$Context p3, int[] p4)
    {
        this.eglSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        this.egl = ((javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL());
        this.eglDisplay = this.getEglDisplay();
        this.eglConfig = this.getEglConfig(this.eglDisplay, p4);
        this.eglContext = this.createEglContext(p3, this.eglDisplay, this.eglConfig);
        return;
    }

    private void checkIsNotReleased()
    {
        if ((this.eglDisplay != javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) && ((this.eglContext != javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) && (this.eglConfig != null))) {
            return;
        } else {
            throw new RuntimeException("This object has been released");
        }
    }

    private javax.microedition.khronos.egl.EGLContext createEglContext(org.webrtc.EglBase10$Context p7, javax.microedition.khronos.egl.EGLDisplay p8, javax.microedition.khronos.egl.EGLConfig p9)
    {
        if ((p7 == null) || (org.webrtc.EglBase10$Context.access$000(p7) != javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT)) {
            javax.microedition.khronos.egl.EGLContext v2;
            int[] v0 = new int[3];
            v0 = {12440, 2, 12344};
            if (p7 != null) {
                v2 = org.webrtc.EglBase10$Context.access$000(p7);
            } else {
                v2 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
            }
            javax.microedition.khronos.egl.EGLContext v1 = this.egl.eglCreateContext(p8, p9, v2, v0);
            if (v1 != javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT) {
                return v1;
            } else {
                throw new RuntimeException(new StringBuilder().append("Failed to create EGL context: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
            }
        } else {
            throw new RuntimeException("Invalid sharedContext");
        }
    }

    private void createSurfaceInternal(Object p5)
    {
        if (((p5 instanceof android.view.SurfaceHolder)) || ((p5 instanceof android.graphics.SurfaceTexture))) {
            this.checkIsNotReleased();
            if (this.eglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                int[] v0 = new int[1];
                v0[0] = 12344;
                this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, p5, v0);
                if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                    return;
                } else {
                    throw new RuntimeException(new StringBuilder().append("Failed to create window surface: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
                }
            } else {
                throw new RuntimeException("Already has an EGLSurface");
            }
        } else {
            throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
        }
    }

    private javax.microedition.khronos.egl.EGLConfig getEglConfig(javax.microedition.khronos.egl.EGLDisplay p9, int[] p10)
    {
        javax.microedition.khronos.egl.EGLConfig[] v3 = new javax.microedition.khronos.egl.EGLConfig[1];
        int[] v5 = new int[1];
        if (this.egl.eglChooseConfig(p9, p10, v3, v3.length, v5)) {
            if (v5[0] > 0) {
                javax.microedition.khronos.egl.EGLConfig v6 = v3[0];
                if (v6 != null) {
                    return v6;
                } else {
                    throw new RuntimeException("eglChooseConfig returned null");
                }
            } else {
                throw new RuntimeException("Unable to find any matching EGL config");
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("eglChooseConfig failed: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
        }
    }

    private javax.microedition.khronos.egl.EGLDisplay getEglDisplay()
    {
        javax.microedition.khronos.egl.EGLDisplay v0 = this.egl.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
        if (v0 != javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) {
            int[] v1 = new int[2];
            if (this.egl.eglInitialize(v0, v1)) {
                return v0;
            } else {
                throw new RuntimeException(new StringBuilder().append("Unable to initialize EGL10: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
            }
        } else {
            throw new RuntimeException(new StringBuilder().append("Unable to get EGL10 display: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
        }
    }

    public void createDummyPbufferSurface()
    {
        this.createPbufferSurface(1, 1);
        return;
    }

    public void createPbufferSurface(int p5, int p6)
    {
        this.checkIsNotReleased();
        if (this.eglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            int[] v0 = new int[5];
            v0[0] = 12375;
            v0[1] = p5;
            v0[2] = 12374;
            v0[3] = p6;
            v0[4] = 12344;
            this.eglSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, v0);
            if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
                return;
            } else {
                throw new RuntimeException(new StringBuilder().append("Failed to create pixel buffer surface with size ").append(p5).append("x").append(p6).append(": 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
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

    public void createSurface(android.view.Surface p2)
    {
        this.createSurfaceInternal(new org.webrtc.EglBase10$1FakeSurfaceHolder(this, p2));
        return;
    }

    public void detachCurrent()
    {
        try {
            if (this.egl.eglMakeCurrent(this.eglDisplay, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT)) {
                return;
            } else {
                throw new RuntimeException(new StringBuilder().append("eglDetachCurrent failed: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
            }
        } catch (RuntimeException v0_3) {
            throw v0_3;
        }
    }

    public org.webrtc.EglBase$Context getEglBaseContext()
    {
        return new org.webrtc.EglBase10$Context(this.eglContext);
    }

    public boolean hasSurface()
    {
        int v0_1;
        if (this.eglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public void makeCurrent()
    {
        this.checkIsNotReleased();
        if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            try {
                if (this.egl.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
                    return;
                } else {
                    throw new RuntimeException(new StringBuilder().append("eglMakeCurrent failed: 0x").append(Integer.toHexString(this.egl.eglGetError())).toString());
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
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
        this.eglConfig = 0;
        return;
    }

    public void releaseSurface()
    {
        if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.eglSurface = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE;
        }
        return;
    }

    public int surfaceHeight()
    {
        int[] v0 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, v0);
        return v0[0];
    }

    public int surfaceWidth()
    {
        int[] v0 = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, v0);
        return v0[0];
    }

    public void swapBuffers()
    {
        this.checkIsNotReleased();
        if (this.eglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) {
            try {
                this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                return;
            } catch (Throwable v0_1) {
                throw v0_1;
            }
        } else {
            throw new RuntimeException("No EGLSurface - can\'t swap buffers");
        }
    }
}
