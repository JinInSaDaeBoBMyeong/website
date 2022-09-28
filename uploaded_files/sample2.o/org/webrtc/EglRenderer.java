package org.webrtc;
public class EglRenderer implements org.webrtc.VideoRenderer$Callbacks {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final int MAX_SURFACE_CLEAR_COUNT = 3;
    private static final String TAG = "EglRenderer";
    private org.webrtc.GlTextureFrameBuffer bitmapTextureFramebuffer;
    private org.webrtc.RendererCommon$GlDrawer drawer;
    private org.webrtc.EglBase eglBase;
    private final org.webrtc.EglRenderer$EglSurfaceCreation eglSurfaceCreationRunnable;
    private final Object fpsReductionLock;
    private final java.util.ArrayList frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final Object handlerLock;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private final Runnable logStatisticsRunnable;
    private long minRenderPeriodNs;
    private boolean mirror;
    private final String name;
    private long nextFrameTimeNs;
    private org.webrtc.VideoRenderer$I420Frame pendingFrame;
    private final Runnable renderFrameRunnable;
    private long renderSwapBufferTimeNs;
    private android.os.Handler renderThreadHandler;
    private long renderTimeNs;
    private final Object statisticsLock;
    private long statisticsStartTimeNs;
    private final org.webrtc.RendererCommon$YuvUploader yuvUploader;

    public EglRenderer(String p3)
    {
        this.handlerLock = new Object();
        this.frameListeners = new java.util.ArrayList();
        this.fpsReductionLock = new Object();
        this.yuvUploader = new org.webrtc.RendererCommon$YuvUploader();
        this.frameLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.renderFrameRunnable = new org.webrtc.EglRenderer$1(this);
        this.logStatisticsRunnable = new org.webrtc.EglRenderer$2(this);
        this.eglSurfaceCreationRunnable = new org.webrtc.EglRenderer$EglSurfaceCreation(this, 0);
        this.name = p3;
        return;
    }

    static synthetic org.webrtc.EglBase access$000(org.webrtc.EglRenderer p1)
    {
        return p1.eglBase;
    }

    static synthetic org.webrtc.EglBase access$002(org.webrtc.EglRenderer p0, org.webrtc.EglBase p1)
    {
        p0.eglBase = p1;
        return p1;
    }

    static synthetic void access$100(org.webrtc.EglRenderer p0)
    {
        p0.renderFrameOnRenderThread();
        return;
    }

    static synthetic org.webrtc.GlTextureFrameBuffer access$1000(org.webrtc.EglRenderer p1)
    {
        return p1.bitmapTextureFramebuffer;
    }

    static synthetic org.webrtc.GlTextureFrameBuffer access$1002(org.webrtc.EglRenderer p0, org.webrtc.GlTextureFrameBuffer p1)
    {
        p0.bitmapTextureFramebuffer = p1;
        return p1;
    }

    static synthetic java.util.ArrayList access$1100(org.webrtc.EglRenderer p1)
    {
        return p1.frameListeners;
    }

    static synthetic void access$1200(org.webrtc.EglRenderer p0, float p1, float p2, float p3, float p4)
    {
        p0.clearSurfaceOnRenderThread(p1, p2, p3, p4);
        return;
    }

    static synthetic void access$200(org.webrtc.EglRenderer p0)
    {
        p0.logStatistics();
        return;
    }

    static synthetic Object access$300(org.webrtc.EglRenderer p1)
    {
        return p1.handlerLock;
    }

    static synthetic android.os.Handler access$400(org.webrtc.EglRenderer p1)
    {
        return p1.renderThreadHandler;
    }

    static synthetic Runnable access$500(org.webrtc.EglRenderer p1)
    {
        return p1.logStatisticsRunnable;
    }

    static synthetic void access$700(org.webrtc.EglRenderer p0, String p1)
    {
        p0.logD(p1);
        return;
    }

    static synthetic org.webrtc.RendererCommon$GlDrawer access$800(org.webrtc.EglRenderer p1)
    {
        return p1.drawer;
    }

    static synthetic org.webrtc.RendererCommon$GlDrawer access$802(org.webrtc.EglRenderer p0, org.webrtc.RendererCommon$GlDrawer p1)
    {
        p0.drawer = p1;
        return p1;
    }

    static synthetic org.webrtc.RendererCommon$YuvUploader access$900(org.webrtc.EglRenderer p1)
    {
        return p1.yuvUploader;
    }

    private String averageTimeAsString(long p6, int p8)
    {
        String v0_2;
        if (p8 > 0) {
            v0_2 = new StringBuilder().append(java.util.concurrent.TimeUnit.NANOSECONDS.toMicros((p6 / ((long) p8)))).append(" \u03bcs").toString();
        } else {
            v0_2 = "NA";
        }
        return v0_2;
    }

    private void clearSurfaceOnRenderThread(float p2, float p3, float p4, float p5)
    {
        if ((this.eglBase != null) && (this.eglBase.hasSurface())) {
            this.logD("clearSurface");
            android.opengl.GLES20.glClearColor(p2, p3, p4, p5);
            android.opengl.GLES20.glClear(16384);
            this.eglBase.swapBuffers();
        }
        return;
    }

    private void createEglSurfaceInternal(Object p2)
    {
        this.eglSurfaceCreationRunnable.setSurface(p2);
        this.postToRenderThread(this.eglSurfaceCreationRunnable);
        return;
    }

    private void logD(String p4)
    {
        org.webrtc.Logging.d("EglRenderer", new StringBuilder().append(this.name).append(p4).toString());
        return;
    }

    private void logStatistics()
    {
        long v0 = System.nanoTime();
        try {
            long v2 = (v0 - this.statisticsStartTimeNs);
        } catch (String v5_22) {
            throw v5_22;
        }
        if (v2 > 0) {
            float v4 = (((float) (((long) this.framesRendered) * java.util.concurrent.TimeUnit.SECONDS.toNanos(1))) / ((float) v2));
            String v5_12 = new StringBuilder().append("Duration: ").append(java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(v2)).append(" ms. Frames received: ").append(this.framesReceived).append(". Dropped: ").append(this.framesDropped).append(". Rendered: ").append(this.framesRendered).append(". Render fps: ");
            Object[] v9_1 = new Object[1];
            v9_1[0] = Float.valueOf(v4);
            this.logD(v5_12.append(String.format(java.util.Locale.US, "%.1f", v9_1)).append(". Average render time: ").append(this.averageTimeAsString(this.renderTimeNs, this.framesRendered)).append(". Average swapBuffer time: ").append(this.averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered)).append(".").toString());
            this.resetStatistics(v0);
        } else {
        }
        return;
    }

    private void notifyCallbacks(org.webrtc.VideoRenderer$I420Frame p17, int[] p18, float[] p19, boolean p20)
    {
        if (!this.frameListeners.isEmpty()) {
            org.webrtc.EglRenderer$FrameListener v1_4;
            if (!this.mirror) {
                v1_4 = org.webrtc.RendererCommon.identityMatrix();
            } else {
                v1_4 = org.webrtc.RendererCommon.horizontalFlipMatrix();
            }
            float[] v3 = org.webrtc.RendererCommon.multiplyMatrices(org.webrtc.RendererCommon.multiplyMatrices(p19, v1_4), org.webrtc.RendererCommon.verticalFlipMatrix());
            java.util.Iterator v14 = this.frameListeners.iterator();
            while (v14.hasNext()) {
                org.webrtc.EglRenderer$FrameListenerAndParams v15_1 = ((org.webrtc.EglRenderer$FrameListenerAndParams) v14.next());
                if ((p20) || (!v15_1.applyFpsReduction)) {
                    v14.remove();
                    int v8 = ((int) (v15_1.scale * ((float) p17.rotatedWidth())));
                    int v9 = ((int) (v15_1.scale * ((float) p17.rotatedHeight())));
                    if ((v8 != 0) && (v9 != 0)) {
                        if (this.bitmapTextureFramebuffer == null) {
                            this.bitmapTextureFramebuffer = new org.webrtc.GlTextureFrameBuffer(6408);
                        }
                        this.bitmapTextureFramebuffer.setSize(v8, v9);
                        android.opengl.GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                        android.opengl.GLES20.glClearColor(0, 0, 0, 0);
                        android.opengl.GLES20.glClear(16384);
                        if (!p17.yuvFrame) {
                            v15_1.drawer.drawOes(p17.textureId, v3, p17.rotatedWidth(), p17.rotatedHeight(), 0, 0, v8, v9);
                        } else {
                            v15_1.drawer.drawYuv(p18, v3, p17.rotatedWidth(), p17.rotatedHeight(), 0, 0, v8, v9);
                        }
                        java.nio.ByteBuffer v12 = java.nio.ByteBuffer.allocateDirect(((v8 * v9) * 4));
                        android.opengl.GLES20.glViewport(0, 0, v8, v9);
                        android.opengl.GLES20.glReadPixels(0, 0, v8, v9, 6408, 5121, v12);
                        android.opengl.GLES20.glBindFramebuffer(36160, 0);
                        org.webrtc.GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                        android.graphics.Bitmap v13 = android.graphics.Bitmap.createBitmap(v8, v9, android.graphics.Bitmap$Config.ARGB_8888);
                        v13.copyPixelsFromBuffer(v12);
                        v15_1.listener.onFrame(v13);
                    } else {
                        v15_1.listener.onFrame(0);
                    }
                }
            }
        }
        return;
    }

    private void postToRenderThread(Runnable p3)
    {
        try {
            if (this.renderThreadHandler != null) {
                this.renderThreadHandler.post(p3);
            }
        } catch (android.os.Handler v0_2) {
            throw v0_2;
        }
        return;
    }

    private void renderFrameOnRenderThread()
    {
        if (this.pendingFrame != null) {
            org.webrtc.VideoRenderer$I420Frame v20 = this.pendingFrame;
            this.pendingFrame = 0;
            if ((this.eglBase != null) && (this.eglBase.hasSurface())) {
                try {
                    int v24;
                    if (this.minRenderPeriodNs != nan) {
                        if (this.minRenderPeriodNs > 0) {
                            long v18_1 = System.nanoTime();
                            if (v18_1 >= this.nextFrameTimeNs) {
                                this.nextFrameTimeNs = (this.nextFrameTimeNs + this.minRenderPeriodNs);
                                this.nextFrameTimeNs = Math.max(this.nextFrameTimeNs, v18_1);
                                v24 = 1;
                            } else {
                                this.logD("Skipping frame rendering - fps reduction is active.");
                                v24 = 0;
                            }
                        } else {
                            v24 = 1;
                        }
                    } else {
                        v24 = 0;
                    }
                } catch (Throwable v4_33) {
                    throw v4_33;
                }
                long v26 = System.nanoTime();
                float[] v30 = org.webrtc.RendererCommon.rotateTextureMatrix(v20.samplingMatrix, ((float) v20.rotationDegree));
                try {
                    int v7;
                    int v8;
                    float[] v22;
                    if (this.layoutAspectRatio <= 0) {
                        if (!this.mirror) {
                            v22 = org.webrtc.RendererCommon.identityMatrix();
                        } else {
                            v22 = org.webrtc.RendererCommon.horizontalFlipMatrix();
                        }
                        v7 = v20.rotatedWidth();
                        v8 = v20.rotatedHeight();
                    } else {
                        float v21 = (((float) v20.rotatedWidth()) / ((float) v20.rotatedHeight()));
                        v22 = org.webrtc.RendererCommon.getLayoutMatrix(this.mirror, v21, this.layoutAspectRatio);
                        if (v21 <= this.layoutAspectRatio) {
                            v7 = v20.rotatedWidth();
                            v8 = ((int) (((float) v20.rotatedWidth()) / this.layoutAspectRatio));
                        } else {
                            v7 = ((int) (((float) v20.rotatedHeight()) * this.layoutAspectRatio));
                            v8 = v20.rotatedHeight();
                        }
                    }
                } catch (Throwable v4_9) {
                    throw v4_9;
                }
                float[] v6 = org.webrtc.RendererCommon.multiplyMatrices(v30, v22);
                int v25 = 0;
                if (v20.yuvFrame) {
                    v25 = v24;
                    if (v25 == 0) {
                        Throwable v4_12 = this.frameListeners.iterator();
                        while (v4_12.hasNext()) {
                            org.webrtc.EglRenderer$FrameListenerAndParams v23_1 = ((org.webrtc.EglRenderer$FrameListenerAndParams) v4_12.next());
                            if ((v23_1.scale != 0) && ((v24 != 0) || (!v23_1.applyFpsReduction))) {
                                v25 = 1;
                                break;
                            }
                        }
                    }
                }
                int v5;
                if (v25 == 0) {
                    v5 = 0;
                } else {
                    v5 = this.yuvUploader.uploadYuvData(v20.width, v20.height, v20.yuvStrides, v20.yuvPlanes);
                }
                if (v24 != 0) {
                    android.opengl.GLES20.glClearColor(0, 0, 0, 0);
                    android.opengl.GLES20.glClear(16384);
                    if (!v20.yuvFrame) {
                        this.drawer.drawOes(v20.textureId, v6, v7, v8, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                    } else {
                        this.drawer.drawYuv(v5, v6, v7, v8, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                    }
                    long v28 = System.nanoTime();
                    this.eglBase.swapBuffers();
                    long v18_0 = System.nanoTime();
                    this.framesRendered = (this.framesRendered + 1);
                    this.renderTimeNs = (this.renderTimeNs + (v18_0 - v26));
                    this.renderSwapBufferTimeNs = (this.renderSwapBufferTimeNs + (v18_0 - v28));
                }
                this.notifyCallbacks(v20, v5, v30, v24);
                org.webrtc.VideoRenderer.renderFrameDone(v20);
            } else {
                this.logD("Dropping frame - No surface");
                org.webrtc.VideoRenderer.renderFrameDone(v20);
            }
        } else {
        }
        return;
    }

    private void resetStatistics(long p6)
    {
        try {
            this.statisticsStartTimeNs = p6;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0;
            this.renderSwapBufferTimeNs = 0;
            return;
        } catch (Throwable v0_0) {
            throw v0_0;
        }
    }

    public void addFrameListener(org.webrtc.EglRenderer$FrameListener p3, float p4)
    {
        this.addFrameListener(p3, p4, 0, 0);
        return;
    }

    public void addFrameListener(org.webrtc.EglRenderer$FrameListener p2, float p3, org.webrtc.RendererCommon$GlDrawer p4)
    {
        this.addFrameListener(p2, p3, p4, 0);
        return;
    }

    public void addFrameListener(org.webrtc.EglRenderer$FrameListener p7, float p8, org.webrtc.RendererCommon$GlDrawer p9, boolean p10)
    {
        this.postToRenderThread(new org.webrtc.EglRenderer$6(this, p9, p7, p8, p10));
        return;
    }

    public void clearImage()
    {
        this.clearImage(0, 0, 0, 0);
        return;
    }

    public void clearImage(float p9, float p10, float p11, float p12)
    {
        try {
            if (this.renderThreadHandler != null) {
                this.renderThreadHandler.postAtFrontOfQueue(new org.webrtc.EglRenderer$9(this, p9, p10, p11, p12));
            } else {
            }
        } catch (org.webrtc.EglRenderer$9 v0_2) {
            throw v0_2;
        }
        return;
    }

    public void createEglSurface(android.graphics.SurfaceTexture p1)
    {
        this.createEglSurfaceInternal(p1);
        return;
    }

    public void createEglSurface(android.view.Surface p1)
    {
        this.createEglSurfaceInternal(p1);
        return;
    }

    public void disableFpsReduction()
    {
        this.setFpsReduction(2139095040);
        return;
    }

    public void init(org.webrtc.EglBase$Context p11, int[] p12, org.webrtc.RendererCommon$GlDrawer p13)
    {
        try {
            if (this.renderThreadHandler == null) {
                this.logD("Initializing EglRenderer");
                this.drawer = p13;
                android.os.HandlerThread v2_0 = new android.os.HandlerThread(new StringBuilder().append(this.name).append("EglRenderer").toString());
                v2_0.start();
                this.renderThreadHandler = new android.os.Handler(v2_0.getLooper());
                org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new org.webrtc.EglRenderer$3(this, p11, p12));
                this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
                this.resetStatistics(System.nanoTime());
                this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, java.util.concurrent.TimeUnit.SECONDS.toMillis(4));
                return;
            } else {
                throw new IllegalStateException(new StringBuilder().append(this.name).append("Already initialized").toString());
            }
        } catch (android.os.Handler v3_12) {
            throw v3_12;
        }
    }

    public void pauseVideo()
    {
        this.setFpsReduction(0);
        return;
    }

    public void printStackTrace()
    {
        try {
            Thread v1;
            if (this.renderThreadHandler != null) {
                v1 = this.renderThreadHandler.getLooper().getThread();
            } else {
                v1 = 0;
            }
        } catch (int v3_4) {
            throw v3_4;
        }
        if (v1 != null) {
            StackTraceElement[] v0 = v1.getStackTrace();
            if (v0.length > 0) {
                this.logD("EglRenderer stack trace:");
                int v5 = v0.length;
                int v3_3 = 0;
                while (v3_3 < v5) {
                    this.logD(v0[v3_3].toString());
                    v3_3++;
                }
            }
        }
        return;
    }

    public void release()
    {
        this.logD("Releasing.");
        java.util.concurrent.CountDownLatch v0_1 = new java.util.concurrent.CountDownLatch(1);
        if (this.renderThreadHandler != null) {
            this.renderThreadHandler.removeCallbacks(this.logStatisticsRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new org.webrtc.EglRenderer$4(this, v0_1));
            this.renderThreadHandler.post(new org.webrtc.EglRenderer$5(this, this.renderThreadHandler.getLooper()));
            this.renderThreadHandler = 0;
            org.webrtc.ThreadUtils.awaitUninterruptibly(v0_1);
            if (this.pendingFrame != null) {
                org.webrtc.VideoRenderer.renderFrameDone(this.pendingFrame);
                this.pendingFrame = 0;
            }
            this.logD("Releasing done.");
        } else {
            this.logD("Already released");
        }
        return;
    }

    public void releaseEglSurface(Runnable p4)
    {
        this.eglSurfaceCreationRunnable.setSurface(0);
        if (this.renderThreadHandler == null) {
            p4.run();
        } else {
            this.renderThreadHandler.removeCallbacks(this.eglSurfaceCreationRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new org.webrtc.EglRenderer$8(this, p4));
        }
        return;
    }

    public void removeFrameListener(org.webrtc.EglRenderer$FrameListener p4)
    {
        if (Thread.currentThread() != this.renderThreadHandler.getLooper().getThread()) {
            java.util.concurrent.CountDownLatch v0_0 = new java.util.concurrent.CountDownLatch(1);
            this.postToRenderThread(new org.webrtc.EglRenderer$7(this, v0_0, p4));
            org.webrtc.ThreadUtils.awaitUninterruptibly(v0_0);
            return;
        } else {
            throw new RuntimeException("removeFrameListener must not be called on the render thread.");
        }
    }

    public void renderFrame(org.webrtc.VideoRenderer$I420Frame p6)
    {
        this.framesReceived = (this.framesReceived + 1);
        try {
            if (this.renderThreadHandler != null) {
                int v0;
                if (this.pendingFrame == null) {
                    v0 = 0;
                } else {
                    v0 = 1;
                }
                if (v0 != 0) {
                    org.webrtc.VideoRenderer.renderFrameDone(this.pendingFrame);
                }
                this.pendingFrame = p6;
                this.renderThreadHandler.post(this.renderFrameRunnable);
                if (v0 != 0) {
                    try {
                        this.framesDropped = (this.framesDropped + 1);
                    } catch (Throwable v1_8) {
                        throw v1_8;
                    }
                }
            } else {
                this.logD("Dropping frame - Not initialized or already released.");
                org.webrtc.VideoRenderer.renderFrameDone(p6);
            }
        } catch (Throwable v1_10) {
            throw v1_10;
        }
        return;
    }

    public void setFpsReduction(float p7)
    {
        this.logD(new StringBuilder().append("setFpsReduction: ").append(p7).toString());
        try {
            long v0 = this.minRenderPeriodNs;
        } catch (long v2_8) {
            throw v2_8;
        }
        if (p7 > 0) {
            this.minRenderPeriodNs = ((long) (((float) java.util.concurrent.TimeUnit.SECONDS.toNanos(1)) / p7));
        } else {
            this.minRenderPeriodNs = nan;
        }
        if (this.minRenderPeriodNs != v0) {
            this.nextFrameTimeNs = System.nanoTime();
        }
        return;
    }

    public void setLayoutAspectRatio(float p3)
    {
        this.logD(new StringBuilder().append("setLayoutAspectRatio: ").append(p3).toString());
        try {
            this.layoutAspectRatio = p3;
            return;
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }

    public void setMirror(boolean p3)
    {
        this.logD(new StringBuilder().append("setMirror: ").append(p3).toString());
        try {
            this.mirror = p3;
            return;
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }
}
