package org.webrtc;
 class Camera1Session implements org.webrtc.CameraSession {
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "Camera1Session";
    private static final org.webrtc.Histogram camera1ResolutionHistogram;
    private static final org.webrtc.Histogram camera1StartTimeMsHistogram;
    private static final org.webrtc.Histogram camera1StopTimeMsHistogram;
    private final android.content.Context applicationContext;
    private final android.hardware.Camera camera;
    private final int cameraId;
    private final android.os.Handler cameraThreadHandler;
    private final org.webrtc.CameraEnumerationAndroid$CaptureFormat captureFormat;
    private final boolean captureToTexture;
    private final long constructionTimeNs;
    private final org.webrtc.CameraSession$Events events;
    private boolean firstFrameReported;
    private final android.hardware.Camera$CameraInfo info;
    private org.webrtc.Camera1Session$SessionState state;
    private final org.webrtc.SurfaceTextureHelper surfaceTextureHelper;

    static Camera1Session()
    {
        org.webrtc.Camera1Session.camera1StartTimeMsHistogram = org.webrtc.Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
        org.webrtc.Camera1Session.camera1StopTimeMsHistogram = org.webrtc.Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
        org.webrtc.Camera1Session.camera1ResolutionHistogram = org.webrtc.Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", org.webrtc.CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
        return;
    }

    private Camera1Session(org.webrtc.CameraSession$Events p5, boolean p6, android.content.Context p7, org.webrtc.SurfaceTextureHelper p8, android.media.MediaRecorder p9, int p10, android.hardware.Camera p11, android.hardware.Camera$CameraInfo p12, org.webrtc.CameraEnumerationAndroid$CaptureFormat p13, long p14)
    {
        this.firstFrameReported = 0;
        org.webrtc.Logging.d("Camera1Session", new StringBuilder().append("Create new camera1 session on camera ").append(p10).toString());
        this.cameraThreadHandler = new android.os.Handler();
        this.events = p5;
        this.captureToTexture = p6;
        this.applicationContext = p7;
        this.surfaceTextureHelper = p8;
        this.cameraId = p10;
        this.camera = p11;
        this.info = p12;
        this.captureFormat = p13;
        this.constructionTimeNs = p14;
        this.startCapturing();
        if (p9 != null) {
            p11.unlock();
            p9.setCamera(p11);
        }
        return;
    }

    static synthetic void access$000(org.webrtc.Camera1Session p0)
    {
        p0.stopInternal();
        return;
    }

    static synthetic org.webrtc.CameraSession$Events access$100(org.webrtc.Camera1Session p1)
    {
        return p1.events;
    }

    static synthetic org.webrtc.CameraEnumerationAndroid$CaptureFormat access$1000(org.webrtc.Camera1Session p1)
    {
        return p1.captureFormat;
    }

    static synthetic android.hardware.Camera access$1100(org.webrtc.Camera1Session p1)
    {
        return p1.camera;
    }

    static synthetic void access$200(org.webrtc.Camera1Session p0)
    {
        p0.checkIsOnCameraThread();
        return;
    }

    static synthetic org.webrtc.Camera1Session$SessionState access$300(org.webrtc.Camera1Session p1)
    {
        return p1.state;
    }

    static synthetic org.webrtc.SurfaceTextureHelper access$400(org.webrtc.Camera1Session p1)
    {
        return p1.surfaceTextureHelper;
    }

    static synthetic boolean access$500(org.webrtc.Camera1Session p1)
    {
        return p1.firstFrameReported;
    }

    static synthetic boolean access$502(org.webrtc.Camera1Session p0, boolean p1)
    {
        p0.firstFrameReported = p1;
        return p1;
    }

    static synthetic long access$600(org.webrtc.Camera1Session p2)
    {
        return p2.constructionTimeNs;
    }

    static synthetic org.webrtc.Histogram access$700()
    {
        return org.webrtc.Camera1Session.camera1StartTimeMsHistogram;
    }

    static synthetic int access$800(org.webrtc.Camera1Session p1)
    {
        return p1.getFrameOrientation();
    }

    static synthetic android.hardware.Camera$CameraInfo access$900(org.webrtc.Camera1Session p1)
    {
        return p1.info;
    }

    private void checkIsOnCameraThread()
    {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        } else {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(org.webrtc.CameraSession$CreateSessionCallback p22, org.webrtc.CameraSession$Events p23, boolean p24, android.content.Context p25, org.webrtc.SurfaceTextureHelper p26, android.media.MediaRecorder p27, int p28, int p29, int p30, int p31)
    {
        long v14 = System.nanoTime();
        org.webrtc.Logging.d("Camera1Session", new StringBuilder().append("Open camera ").append(p28).toString());
        p23.onCameraOpening();
        try {
            android.hardware.Camera v11 = android.hardware.Camera.open(p28);
            try {
                v11.setPreviewTexture(p26.getSurfaceTexture());
                android.hardware.Camera$CameraInfo v12_1 = new android.hardware.Camera$CameraInfo();
                android.hardware.Camera.getCameraInfo(p28, v12_1);
                android.hardware.Camera$Parameters v20 = v11.getParameters();
                org.webrtc.CameraEnumerationAndroid$CaptureFormat v13 = org.webrtc.Camera1Session.findClosestCaptureFormat(v20, p29, p30, p31);
                org.webrtc.Camera1Session.updateCameraParameters(v11, v20, v13, org.webrtc.Camera1Session.findClosestPictureSize(v20, p29, p30), p24);
            } catch (java.io.IOException v17_1) {
                v11.release();
                p22.onFailure(org.webrtc.CameraSession$FailureType.ERROR, v17_1.getMessage());
                return;
            }
            if (!p24) {
                int v18 = v13.frameSize();
                int v19 = 0;
                while (v19 < 3) {
                    v11.addCallbackBuffer(java.nio.ByteBuffer.allocateDirect(v18).array());
                    v19++;
                }
            }
            v11.setDisplayOrientation(0);
            p22.onDone(new org.webrtc.Camera1Session(p23, p24, p25, p26, p27, p28, v11, v12_1, v13, v14));
            return;
        } catch (java.io.IOException v17_0) {
            p22.onFailure(org.webrtc.CameraSession$FailureType.ERROR, v17_0.getMessage());
            return;
        }
    }

    private static org.webrtc.CameraEnumerationAndroid$CaptureFormat findClosestCaptureFormat(android.hardware.Camera$Parameters p6, int p7, int p8, int p9)
    {
        java.util.List v2 = org.webrtc.Camera1Enumerator.convertFramerates(p6.getSupportedPreviewFpsRange());
        org.webrtc.Logging.d("Camera1Session", new StringBuilder().append("Available fps ranges: ").append(v2).toString());
        org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange v0 = org.webrtc.CameraEnumerationAndroid.getClosestSupportedFramerateRange(v2, p9);
        org.webrtc.Size v1 = org.webrtc.CameraEnumerationAndroid.getClosestSupportedSize(org.webrtc.Camera1Enumerator.convertSizes(p6.getSupportedPreviewSizes()), p7, p8);
        org.webrtc.CameraEnumerationAndroid.reportCameraResolution(org.webrtc.Camera1Session.camera1ResolutionHistogram, v1);
        return new org.webrtc.CameraEnumerationAndroid$CaptureFormat(v1.width, v1.height, v0);
    }

    private static org.webrtc.Size findClosestPictureSize(android.hardware.Camera$Parameters p1, int p2, int p3)
    {
        return org.webrtc.CameraEnumerationAndroid.getClosestSupportedSize(org.webrtc.Camera1Enumerator.convertSizes(p1.getSupportedPictureSizes()), p2, p3);
    }

    private int getDeviceOrientation()
    {
        int v0;
        switch (((android.view.WindowManager) this.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 1:
                v0 = 90;
                break;
            case 2:
                v0 = 180;
                break;
            case 3:
                v0 = 270;
                break;
            default:
                v0 = 0;
        }
        return v0;
    }

    private int getFrameOrientation()
    {
        int v0 = this.getDeviceOrientation();
        if (this.info.facing == 0) {
            v0 = (360 - v0);
        }
        return ((this.info.orientation + v0) % 360);
    }

    private void listenForBytebufferFrames()
    {
        this.camera.setPreviewCallbackWithBuffer(new org.webrtc.Camera1Session$3(this));
        return;
    }

    private void listenForTextureFrames()
    {
        this.surfaceTextureHelper.startListening(new org.webrtc.Camera1Session$2(this));
        return;
    }

    private void startCapturing()
    {
        org.webrtc.Logging.d("Camera1Session", "Start capturing");
        this.checkIsOnCameraThread();
        this.state = org.webrtc.Camera1Session$SessionState.RUNNING;
        this.camera.setErrorCallback(new org.webrtc.Camera1Session$1(this));
        if (!this.captureToTexture) {
            this.listenForBytebufferFrames();
        } else {
            this.listenForTextureFrames();
        }
        try {
            this.camera.startPreview();
        } catch (RuntimeException v0) {
            this.stopInternal();
            this.events.onCameraError(this, v0.getMessage());
        }
        return;
    }

    private void stopInternal()
    {
        org.webrtc.Logging.d("Camera1Session", "Stop internal");
        this.checkIsOnCameraThread();
        if (this.state != org.webrtc.Camera1Session$SessionState.STOPPED) {
            this.state = org.webrtc.Camera1Session$SessionState.STOPPED;
            this.surfaceTextureHelper.stopListening();
            this.camera.stopPreview();
            this.camera.release();
            this.events.onCameraClosed(this);
            org.webrtc.Logging.d("Camera1Session", "Stop done");
        } else {
            org.webrtc.Logging.d("Camera1Session", "Camera is already stopped");
        }
        return;
    }

    private static void updateCameraParameters(android.hardware.Camera p3, android.hardware.Camera$Parameters p4, org.webrtc.CameraEnumerationAndroid$CaptureFormat p5, org.webrtc.Size p6, boolean p7)
    {
        java.util.List v0 = p4.getSupportedFocusModes();
        p4.setPreviewFpsRange(p5.framerate.min, p5.framerate.max);
        p4.setPreviewSize(p5.width, p5.height);
        p4.setPictureSize(p6.width, p6.height);
        if (!p7) {
            p5.getClass();
            p4.setPreviewFormat(17);
        }
        if (p4.isVideoStabilizationSupported()) {
            p4.setVideoStabilization(1);
        }
        if (v0.contains("continuous-video")) {
            p4.setFocusMode("continuous-video");
        }
        p3.setParameters(p4);
        return;
    }

    public void stop()
    {
        org.webrtc.Logging.d("Camera1Session", new StringBuilder().append("Stop camera1 session on camera ").append(this.cameraId).toString());
        this.checkIsOnCameraThread();
        if (this.state != org.webrtc.Camera1Session$SessionState.STOPPED) {
            long v0 = System.nanoTime();
            this.stopInternal();
            org.webrtc.Camera1Session.camera1StopTimeMsHistogram.addSample(((int) java.util.concurrent.TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - v0))));
        }
        return;
    }
}
