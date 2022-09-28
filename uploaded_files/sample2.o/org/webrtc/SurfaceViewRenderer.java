package org.webrtc;
public class SurfaceViewRenderer extends android.view.SurfaceView implements android.view.SurfaceHolder$Callback, org.webrtc.VideoRenderer$Callbacks {
    private static final String TAG = "SurfaceViewRenderer";
    private final org.webrtc.EglRenderer eglRenderer;
    private boolean enableFixedSize;
    private int frameRotation;
    private boolean isFirstFrameRendered;
    private boolean isRenderingPaused;
    private final Object layoutLock;
    private org.webrtc.RendererCommon$RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final org.webrtc.RendererCommon$VideoLayoutMeasure videoLayoutMeasure;

    public SurfaceViewRenderer(android.content.Context p3)
    {
        super(p3);
        super.videoLayoutMeasure = new org.webrtc.RendererCommon$VideoLayoutMeasure();
        super.layoutLock = new Object();
        super.isRenderingPaused = 0;
        super.resourceName = super.getResourceName();
        super.eglRenderer = new org.webrtc.EglRenderer(super.resourceName);
        super.getHolder().addCallback(super);
        return;
    }

    public SurfaceViewRenderer(android.content.Context p3, android.util.AttributeSet p4)
    {
        super(p3, p4);
        super.videoLayoutMeasure = new org.webrtc.RendererCommon$VideoLayoutMeasure();
        super.layoutLock = new Object();
        super.isRenderingPaused = 0;
        super.resourceName = super.getResourceName();
        super.eglRenderer = new org.webrtc.EglRenderer(super.resourceName);
        super.getHolder().addCallback(super);
        return;
    }

    static synthetic void access$000(org.webrtc.SurfaceViewRenderer p0)
    {
        p0.updateSurfaceSize();
        return;
    }

    private String getResourceName()
    {
        try {
            String v1_3 = new StringBuilder().append(this.getResources().getResourceEntryName(this.getId())).append(": ").toString();
        } catch (android.content.res.Resources$NotFoundException v0) {
            v1_3 = "";
        }
        return v1_3;
    }

    private void logD(String p4)
    {
        org.webrtc.Logging.d("SurfaceViewRenderer", new StringBuilder().append(this.resourceName).append(p4).toString());
        return;
    }

    private void updateFrameDimensionsAndReportEvents(org.webrtc.VideoRenderer$I420Frame p6)
    {
        try {
            if (!this.isRenderingPaused) {
                if (!this.isFirstFrameRendered) {
                    this.isFirstFrameRendered = 1;
                    this.logD("Reporting first rendered frame.");
                    if (this.rendererEvents != null) {
                        this.rendererEvents.onFirstFrameRendered();
                    }
                }
                if ((this.rotatedFrameWidth != p6.rotatedWidth()) || ((this.rotatedFrameHeight != p6.rotatedHeight()) || (this.frameRotation != p6.rotationDegree))) {
                    this.logD(new StringBuilder().append("Reporting frame resolution changed to ").append(p6.width).append("x").append(p6.height).append(" with rotation ").append(p6.rotationDegree).toString());
                    if (this.rendererEvents != null) {
                        this.rendererEvents.onFrameResolutionChanged(p6.width, p6.height, p6.rotationDegree);
                    }
                    this.rotatedFrameWidth = p6.rotatedWidth();
                    this.rotatedFrameHeight = p6.rotatedHeight();
                    this.frameRotation = p6.rotationDegree;
                    this.post(new org.webrtc.SurfaceViewRenderer$2(this));
                }
            } else {
            }
        } catch (org.webrtc.SurfaceViewRenderer$2 v0_23) {
            throw v0_23;
        }
        return;
    }

    private void updateSurfaceSize()
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        try {
            if ((!this.enableFixedSize) || ((this.rotatedFrameWidth == 0) || ((this.rotatedFrameHeight == 0) || ((this.getWidth() == 0) || (this.getHeight() == 0))))) {
                this.surfaceHeight = 0;
                this.surfaceWidth = 0;
                this.getHolder().setSizeFromLayout();
            } else {
                int v1;
                int v0;
                float v4 = (((float) this.getWidth()) / ((float) this.getHeight()));
                if ((((float) this.rotatedFrameWidth) / ((float) this.rotatedFrameHeight)) <= v4) {
                    v1 = this.rotatedFrameWidth;
                    v0 = ((int) (((float) this.rotatedFrameWidth) / v4));
                } else {
                    v1 = ((int) (((float) this.rotatedFrameHeight) * v4));
                    v0 = this.rotatedFrameHeight;
                }
                int v5 = Math.min(this.getWidth(), v1);
                int v3 = Math.min(this.getHeight(), v0);
                this.logD(new StringBuilder().append("updateSurfaceSize. Layout size: ").append(this.getWidth()).append("x").append(this.getHeight()).append(", frame size: ").append(this.rotatedFrameWidth).append("x").append(this.rotatedFrameHeight).append(", requested surface size: ").append(v5).append("x").append(v3).append(", old surface size: ").append(this.surfaceWidth).append("x").append(this.surfaceHeight).toString());
                if ((v5 != this.surfaceWidth) || (v3 != this.surfaceHeight)) {
                    this.surfaceWidth = v5;
                    this.surfaceHeight = v3;
                    this.getHolder().setFixedSize(v5, v3);
                }
            }
        } catch (android.view.SurfaceHolder v6_5) {
            throw v6_5;
        }
        return;
    }

    public void addFrameListener(org.webrtc.EglRenderer$FrameListener p2, float p3)
    {
        this.eglRenderer.addFrameListener(p2, p3);
        return;
    }

    public void addFrameListener(org.webrtc.EglRenderer$FrameListener p2, float p3, org.webrtc.RendererCommon$GlDrawer p4)
    {
        this.eglRenderer.addFrameListener(p2, p3, p4);
        return;
    }

    public void clearImage()
    {
        this.eglRenderer.clearImage();
        return;
    }

    public void disableFpsReduction()
    {
        this.isRenderingPaused = 0;
        this.eglRenderer.disableFpsReduction();
        return;
    }

    public void init(org.webrtc.EglBase$Context p3, org.webrtc.RendererCommon$RendererEvents p4)
    {
        this.init(p3, p4, org.webrtc.EglBase.CONFIG_PLAIN, new org.webrtc.GlRectDrawer());
        return;
    }

    public void init(org.webrtc.EglBase$Context p3, org.webrtc.RendererCommon$RendererEvents p4, int[] p5, org.webrtc.RendererCommon$GlDrawer p6)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = p4;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.frameRotation = 0;
        this.eglRenderer.init(p3, p5, p6);
        return;
    }

    protected void onLayout(boolean p4, int p5, int p6, int p7, int p8)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((((float) (p7 - p5)) / ((float) (p8 - p6))));
        this.updateSurfaceSize();
        return;
    }

    protected void onMeasure(int p6, int p7)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        android.graphics.Point v0 = this.videoLayoutMeasure.measure(p6, p7, this.rotatedFrameWidth, this.rotatedFrameHeight);
        this.setMeasuredDimension(v0.x, v0.y);
        this.logD(new StringBuilder().append("onMeasure(). New size: ").append(v0.x).append("x").append(v0.y).toString());
        return;
    }

    public void pauseVideo()
    {
        this.isRenderingPaused = 1;
        this.eglRenderer.pauseVideo();
        return;
    }

    public void release()
    {
        this.eglRenderer.release();
        return;
    }

    public void removeFrameListener(org.webrtc.EglRenderer$FrameListener p2)
    {
        this.eglRenderer.removeFrameListener(p2);
        return;
    }

    public void renderFrame(org.webrtc.VideoRenderer$I420Frame p2)
    {
        this.updateFrameDimensionsAndReportEvents(p2);
        this.eglRenderer.renderFrame(p2);
        return;
    }

    public void setEnableHardwareScaler(boolean p1)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = p1;
        this.updateSurfaceSize();
        return;
    }

    public void setFpsReduction(float p3)
    {
        Throwable v0_3;
        if (p3 != 0) {
            v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        this.isRenderingPaused = v0_3;
        this.eglRenderer.setFpsReduction(p3);
        return;
    }

    public void setMirror(boolean p2)
    {
        this.eglRenderer.setMirror(p2);
        return;
    }

    public void setScalingType(org.webrtc.RendererCommon$ScalingType p2)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(p2);
        return;
    }

    public void setScalingType(org.webrtc.RendererCommon$ScalingType p2, org.webrtc.RendererCommon$ScalingType p3)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(p2, p3);
        return;
    }

    public void surfaceChanged(android.view.SurfaceHolder p3, int p4, int p5, int p6)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.logD(new StringBuilder().append("surfaceChanged: format: ").append(p4).append(" size: ").append(p5).append("x").append(p6).toString());
        return;
    }

    public void surfaceCreated(android.view.SurfaceHolder p3)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(p3.getSurface());
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        this.updateSurfaceSize();
        return;
    }

    public void surfaceDestroyed(android.view.SurfaceHolder p4)
    {
        org.webrtc.ThreadUtils.checkIsOnMainThread();
        java.util.concurrent.CountDownLatch v0_1 = new java.util.concurrent.CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new org.webrtc.SurfaceViewRenderer$1(this, v0_1));
        org.webrtc.ThreadUtils.awaitUninterruptibly(v0_1);
        return;
    }
}
