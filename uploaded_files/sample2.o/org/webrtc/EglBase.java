package org.webrtc;
public abstract class EglBase {
    public static final int[] CONFIG_PIXEL_BUFFER = None;
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = None;
    public static final int[] CONFIG_PLAIN = None;
    public static final int[] CONFIG_RECORDABLE = None;
    public static final int[] CONFIG_RGBA = None;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final Object lock;

    static EglBase()
    {
        org.webrtc.EglBase.lock = new Object();
        int[] v0_7 = new int[9];
        v0_7 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
        org.webrtc.EglBase.CONFIG_PLAIN = v0_7;
        int[] v0_8 = new int[11];
        v0_8 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        org.webrtc.EglBase.CONFIG_RGBA = v0_8;
        int[] v0_1 = new int[11];
        v0_1 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
        org.webrtc.EglBase.CONFIG_PIXEL_BUFFER = v0_1;
        int[] v0_3 = new int[13];
        v0_3 = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
        org.webrtc.EglBase.CONFIG_PIXEL_RGBA_BUFFER = v0_3;
        int[] v0_4 = new int[11];
        v0_4 = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344};
        org.webrtc.EglBase.CONFIG_RECORDABLE = v0_4;
        return;
    }

    public EglBase()
    {
        return;
    }

    public static org.webrtc.EglBase create()
    {
        return org.webrtc.EglBase.create(0, org.webrtc.EglBase.CONFIG_PLAIN);
    }

    public static org.webrtc.EglBase create(org.webrtc.EglBase$Context p1)
    {
        return org.webrtc.EglBase.create(p1, org.webrtc.EglBase.CONFIG_PLAIN);
    }

    public static org.webrtc.EglBase create(org.webrtc.EglBase$Context p1, int[] p2)
    {
        if ((!org.webrtc.EglBase14.isEGL14Supported()) || ((p1 != null) && (!(p1 instanceof org.webrtc.EglBase14$Context)))) {
            org.webrtc.EglBase14 v0_1 = new org.webrtc.EglBase10(((org.webrtc.EglBase10$Context) p1), p2);
        } else {
            v0_1 = new org.webrtc.EglBase14(((org.webrtc.EglBase14$Context) p1), p2);
        }
        return v0_1;
    }

    public static org.webrtc.EglBase createEgl10(javax.microedition.khronos.egl.EGLContext p2, int[] p3)
    {
        return new org.webrtc.EglBase10(new org.webrtc.EglBase10$Context(p2), p3);
    }

    public static org.webrtc.EglBase createEgl10(int[] p2)
    {
        return new org.webrtc.EglBase10(0, p2);
    }

    public static org.webrtc.EglBase createEgl14(android.opengl.EGLContext p2, int[] p3)
    {
        return new org.webrtc.EglBase14(new org.webrtc.EglBase14$Context(p2), p3);
    }

    public static org.webrtc.EglBase createEgl14(int[] p2)
    {
        return new org.webrtc.EglBase14(0, p2);
    }

    public abstract void createDummyPbufferSurface();

    public abstract void createPbufferSurface();

    public abstract void createSurface();

    public abstract void createSurface();

    public abstract void detachCurrent();

    public abstract org.webrtc.EglBase$Context getEglBaseContext();

    public abstract boolean hasSurface();

    public abstract void makeCurrent();

    public abstract void release();

    public abstract void releaseSurface();

    public abstract int surfaceHeight();

    public abstract int surfaceWidth();

    public abstract void swapBuffers();
}
