package org.webrtc;
public class ScreenCapturerAndroid implements org.webrtc.VideoCapturer, org.webrtc.SurfaceTextureHelper$OnTextureFrameAvailableListener {
    private static final int DISPLAY_FLAGS = 3;
    private static final int VIRTUAL_DISPLAY_DPI = 400;
    private org.webrtc.VideoCapturer$CapturerObserver capturerObserver;
    private int height;
    private boolean isDisposed;
    private android.media.projection.MediaProjection mediaProjection;
    private final android.media.projection.MediaProjection$Callback mediaProjectionCallback;
    private android.media.projection.MediaProjectionManager mediaProjectionManager;
    private final android.content.Intent mediaProjectionPermissionResultData;
    private long numCapturedFrames;
    private org.webrtc.SurfaceTextureHelper surfaceTextureHelper;
    private android.hardware.display.VirtualDisplay virtualDisplay;
    private int width;

    public ScreenCapturerAndroid(android.content.Intent p3, android.media.projection.MediaProjection$Callback p4)
    {
        this.numCapturedFrames = 0;
        this.isDisposed = 0;
        this.mediaProjectionPermissionResultData = p3;
        this.mediaProjectionCallback = p4;
        return;
    }

    static synthetic org.webrtc.SurfaceTextureHelper access$000(org.webrtc.ScreenCapturerAndroid p1)
    {
        return p1.surfaceTextureHelper;
    }

    static synthetic org.webrtc.VideoCapturer$CapturerObserver access$100(org.webrtc.ScreenCapturerAndroid p1)
    {
        return p1.capturerObserver;
    }

    static synthetic android.hardware.display.VirtualDisplay access$200(org.webrtc.ScreenCapturerAndroid p1)
    {
        return p1.virtualDisplay;
    }

    static synthetic android.hardware.display.VirtualDisplay access$202(org.webrtc.ScreenCapturerAndroid p0, android.hardware.display.VirtualDisplay p1)
    {
        p0.virtualDisplay = p1;
        return p1;
    }

    static synthetic android.media.projection.MediaProjection access$300(org.webrtc.ScreenCapturerAndroid p1)
    {
        return p1.mediaProjection;
    }

    static synthetic android.media.projection.MediaProjection access$302(org.webrtc.ScreenCapturerAndroid p0, android.media.projection.MediaProjection p1)
    {
        p0.mediaProjection = p1;
        return p1;
    }

    static synthetic android.media.projection.MediaProjection$Callback access$400(org.webrtc.ScreenCapturerAndroid p1)
    {
        return p1.mediaProjectionCallback;
    }

    static synthetic void access$500(org.webrtc.ScreenCapturerAndroid p0)
    {
        p0.createVirtualDisplay();
        return;
    }

    private void checkNotDisposed()
    {
        if (!this.isDisposed) {
            return;
        } else {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    private void createVirtualDisplay()
    {
        this.surfaceTextureHelper.getSurfaceTexture().setDefaultBufferSize(this.width, this.height);
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, 400, 3, new android.view.Surface(this.surfaceTextureHelper.getSurfaceTexture()), 0, 0);
        return;
    }

    public declared_synchronized void changeCaptureFormat(int p3, int p4, int p5)
    {
        try {
            this.checkNotDisposed();
            this.width = p3;
            this.height = p4;
        } catch (android.os.Handler v0_0) {
            throw v0_0;
        }
        if (this.virtualDisplay != null) {
            org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new org.webrtc.ScreenCapturerAndroid$2(this));
        }
        return;
    }

    public declared_synchronized void dispose()
    {
        try {
            this.isDisposed = 1;
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public long getNumCapturedFrames()
    {
        return this.numCapturedFrames;
    }

    public declared_synchronized void initialize(org.webrtc.SurfaceTextureHelper p3, android.content.Context p4, org.webrtc.VideoCapturer$CapturerObserver p5)
    {
        try {
            this.checkNotDisposed();
        } catch (android.media.projection.MediaProjectionManager v0_4) {
            throw v0_4;
        }
        if (p5 != null) {
            this.capturerObserver = p5;
            if (p3 != null) {
                this.surfaceTextureHelper = p3;
                this.mediaProjectionManager = ((android.media.projection.MediaProjectionManager) p4.getSystemService("media_projection"));
                return;
            } else {
                throw new RuntimeException("surfaceTextureHelper not set.");
            }
        } else {
            throw new RuntimeException("capturerObserver not set.");
        }
    }

    public boolean isScreencast()
    {
        return 1;
    }

    public void onTextureFrameAvailable(int p10, float[] p11, long p12)
    {
        this.numCapturedFrames = (this.numCapturedFrames + 1);
        this.capturerObserver.onTextureFrameCaptured(this.width, this.height, p10, p11, 0, p12);
        return;
    }

    public declared_synchronized void startCapture(int p4, int p5, int p6)
    {
        try {
            this.checkNotDisposed();
            this.width = p4;
            this.height = p5;
            this.mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
            this.mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
            this.createVirtualDisplay();
            this.capturerObserver.onCapturerStarted(1);
            this.surfaceTextureHelper.startListening(this);
            return;
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }

    public declared_synchronized void stopCapture()
    {
        try {
            this.checkNotDisposed();
            org.webrtc.ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new org.webrtc.ScreenCapturerAndroid$1(this));
            return;
        } catch (Throwable v0_2) {
            throw v0_2;
        }
    }
}
