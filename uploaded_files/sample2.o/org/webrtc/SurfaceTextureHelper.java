package org.webrtc;
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private final org.webrtc.EglBase eglBase;
    private final android.os.Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener listener;
    private final int oesTextureId;
    private org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener pendingListener;
    final Runnable setListenerRunnable;
    private final android.graphics.SurfaceTexture surfaceTexture;
    private org.webrtc.YuvConverter yuvConverter;

    private SurfaceTextureHelper(org.webrtc.EglBase$Context p4, android.os.Handler p5)
    {
        this.hasPendingTexture = 0;
        this.isTextureInUse = 0;
        this.isQuitting = 0;
        this.setListenerRunnable = new org.webrtc.SurfaceTextureHelper$2(this);
        if (p5.getLooper().getThread() == Thread.currentThread()) {
            this.handler = p5;
            this.eglBase = org.webrtc.EglBase.create(p4, org.webrtc.EglBase.CONFIG_PIXEL_BUFFER);
            try {
                this.eglBase.createDummyPbufferSurface();
                this.eglBase.makeCurrent();
                this.oesTextureId = org.webrtc.GlUtil.generateTexture(36197);
                this.surfaceTexture = new android.graphics.SurfaceTexture(this.oesTextureId);
                this.surfaceTexture.setOnFrameAvailableListener(new org.webrtc.SurfaceTextureHelper$3(this));
                return;
            } catch (RuntimeException v0) {
                this.eglBase.release();
                p5.getLooper().quit();
                throw v0;
            }
        } else {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
    }

    synthetic SurfaceTextureHelper(org.webrtc.EglBase$Context p1, android.os.Handler p2, org.webrtc.SurfaceTextureHelper$1 p3)
    {
        this(p1, p2);
        return;
    }

    static synthetic org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener access$100(org.webrtc.SurfaceTextureHelper p1)
    {
        return p1.pendingListener;
    }

    static synthetic org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener access$102(org.webrtc.SurfaceTextureHelper p0, org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener p1)
    {
        p0.pendingListener = p1;
        return p1;
    }

    static synthetic org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener access$202(org.webrtc.SurfaceTextureHelper p0, org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener p1)
    {
        p0.listener = p1;
        return p1;
    }

    static synthetic boolean access$300(org.webrtc.SurfaceTextureHelper p1)
    {
        return p1.hasPendingTexture;
    }

    static synthetic boolean access$302(org.webrtc.SurfaceTextureHelper p0, boolean p1)
    {
        p0.hasPendingTexture = p1;
        return p1;
    }

    static synthetic void access$400(org.webrtc.SurfaceTextureHelper p0)
    {
        p0.updateTexImage();
        return;
    }

    static synthetic void access$500(org.webrtc.SurfaceTextureHelper p0)
    {
        p0.tryDeliverTextureFrame();
        return;
    }

    static synthetic boolean access$600(org.webrtc.SurfaceTextureHelper p1)
    {
        return p1.isTextureInUse;
    }

    static synthetic boolean access$602(org.webrtc.SurfaceTextureHelper p0, boolean p1)
    {
        p0.isTextureInUse = p1;
        return p1;
    }

    static synthetic boolean access$700(org.webrtc.SurfaceTextureHelper p1)
    {
        return p1.isQuitting;
    }

    static synthetic boolean access$702(org.webrtc.SurfaceTextureHelper p0, boolean p1)
    {
        p0.isQuitting = p1;
        return p1;
    }

    static synthetic void access$800(org.webrtc.SurfaceTextureHelper p0)
    {
        p0.release();
        return;
    }

    static synthetic org.webrtc.YuvConverter access$900(org.webrtc.SurfaceTextureHelper p1)
    {
        return p1.yuvConverter;
    }

    static synthetic org.webrtc.YuvConverter access$902(org.webrtc.SurfaceTextureHelper p0, org.webrtc.YuvConverter p1)
    {
        p0.yuvConverter = p1;
        return p1;
    }

    public static org.webrtc.SurfaceTextureHelper create(String p3, org.webrtc.EglBase$Context p4)
    {
        android.os.HandlerThread v1_1 = new android.os.HandlerThread(p3);
        v1_1.start();
        android.os.Handler v0_1 = new android.os.Handler(v1_1.getLooper());
        return ((org.webrtc.SurfaceTextureHelper) org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(v0_1, new org.webrtc.SurfaceTextureHelper$1(p4, v0_1, p3)));
    }

    private void release()
    {
        if (this.handler.getLooper().getThread() == Thread.currentThread()) {
            if ((!this.isTextureInUse) && (this.isQuitting)) {
                if (this.yuvConverter != null) {
                    this.yuvConverter.release();
                }
                android.os.Looper v0_4 = new int[1];
                v0_4[0] = this.oesTextureId;
                android.opengl.GLES20.glDeleteTextures(1, v0_4, 0);
                this.surfaceTexture.release();
                this.eglBase.release();
                this.handler.getLooper().quit();
                return;
            } else {
                throw new IllegalStateException("Unexpected release.");
            }
        } else {
            throw new IllegalStateException("Wrong thread.");
        }
    }

    private void tryDeliverTextureFrame()
    {
        if (this.handler.getLooper().getThread() == Thread.currentThread()) {
            if ((!this.isQuitting) && ((this.hasPendingTexture) && ((!this.isTextureInUse) && (this.listener != null)))) {
                this.isTextureInUse = 1;
                this.hasPendingTexture = 0;
                this.updateTexImage();
                float[] v2 = new float[16];
                this.surfaceTexture.getTransformMatrix(v2);
                this.listener.onTextureFrameAvailable(this.oesTextureId, v2, this.surfaceTexture.getTimestamp());
            }
            return;
        } else {
            throw new IllegalStateException("Wrong thread.");
        }
    }

    private void updateTexImage()
    {
        try {
            this.surfaceTexture.updateTexImage();
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public void dispose()
    {
        org.webrtc.Logging.d("SurfaceTextureHelper", "dispose()");
        org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.SurfaceTextureHelper$6(this));
        return;
    }

    public android.os.Handler getHandler()
    {
        return this.handler;
    }

    public android.graphics.SurfaceTexture getSurfaceTexture()
    {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse()
    {
        return this.isTextureInUse;
    }

    public void returnTextureFrame()
    {
        this.handler.post(new org.webrtc.SurfaceTextureHelper$5(this));
        return;
    }

    public void startListening(org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener p3)
    {
        if ((this.listener == null) && (this.pendingListener == null)) {
            this.pendingListener = p3;
            this.handler.post(this.setListenerRunnable);
            return;
        } else {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
    }

    public void stopListening()
    {
        org.webrtc.Logging.d("SurfaceTextureHelper", "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.SurfaceTextureHelper$4(this));
        return;
    }

    public void textureToYUV(java.nio.ByteBuffer p10, int p11, int p12, int p13, int p14, float[] p15)
    {
        if (p14 == this.oesTextureId) {
            org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.SurfaceTextureHelper$7(this, p10, p11, p12, p13, p14, p15));
            return;
        } else {
            throw new IllegalStateException("textureToByteBuffer called with unexpected textureId");
        }
    }
}
