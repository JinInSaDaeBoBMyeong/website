package org.webrtc;
public class CameraVideoCapturer$CameraStatistics {
    private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
    private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
    private static final String TAG = "CameraStatistics";
    private final Runnable cameraObserver;
    private final org.webrtc.CameraVideoCapturer$CameraEventsHandler eventsHandler;
    private int frameCount;
    private int freezePeriodCount;
    private final org.webrtc.SurfaceTextureHelper surfaceTextureHelper;

    public CameraVideoCapturer$CameraStatistics(org.webrtc.SurfaceTextureHelper p5, org.webrtc.CameraVideoCapturer$CameraEventsHandler p6)
    {
        this.cameraObserver = new org.webrtc.CameraVideoCapturer$CameraStatistics$1(this);
        if (p5 != null) {
            this.surfaceTextureHelper = p5;
            this.eventsHandler = p6;
            this.frameCount = 0;
            this.freezePeriodCount = 0;
            p5.getHandler().postDelayed(this.cameraObserver, 2000);
            return;
        } else {
            throw new IllegalArgumentException("SurfaceTextureHelper is null");
        }
    }

    static synthetic int access$000(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        return p1.frameCount;
    }

    static synthetic int access$002(org.webrtc.CameraVideoCapturer$CameraStatistics p0, int p1)
    {
        p0.frameCount = p1;
        return p1;
    }

    static synthetic int access$100(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        return p1.freezePeriodCount;
    }

    static synthetic int access$102(org.webrtc.CameraVideoCapturer$CameraStatistics p0, int p1)
    {
        p0.freezePeriodCount = p1;
        return p1;
    }

    static synthetic int access$104(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        int v0_1 = (p1.freezePeriodCount + 1);
        p1.freezePeriodCount = v0_1;
        return v0_1;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraEventsHandler access$200(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        return p1.eventsHandler;
    }

    static synthetic org.webrtc.SurfaceTextureHelper access$300(org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        return p1.surfaceTextureHelper;
    }

    private void checkThread()
    {
        if (Thread.currentThread() == this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
            return;
        } else {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public void addFrame()
    {
        this.checkThread();
        this.frameCount = (this.frameCount + 1);
        return;
    }

    public void release()
    {
        this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
        return;
    }
}
