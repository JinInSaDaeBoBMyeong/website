package org.webrtc;
 class Camera2Session implements org.webrtc.CameraSession {
    private static final String TAG = "Camera2Session";
    private static final org.webrtc.Histogram camera2ResolutionHistogram;
    private static final org.webrtc.Histogram camera2StartTimeMsHistogram;
    private static final org.webrtc.Histogram camera2StopTimeMsHistogram;
    private final android.content.Context applicationContext;
    private final org.webrtc.CameraSession$CreateSessionCallback callback;
    private android.hardware.camera2.CameraCharacteristics cameraCharacteristics;
    private android.hardware.camera2.CameraDevice cameraDevice;
    private final String cameraId;
    private final android.hardware.camera2.CameraManager cameraManager;
    private int cameraOrientation;
    private final android.os.Handler cameraThreadHandler;
    private org.webrtc.CameraEnumerationAndroid$CaptureFormat captureFormat;
    private android.hardware.camera2.CameraCaptureSession captureSession;
    private final long constructionTimeNs;
    private final org.webrtc.CameraSession$Events events;
    private boolean firstFrameReported;
    private int fpsUnitFactor;
    private final int framerate;
    private final int height;
    private boolean isCameraFrontFacing;
    private final android.view.Surface mediaRecorderSurface;
    private org.webrtc.Camera2Session$SessionState state;
    private android.view.Surface surface;
    private final org.webrtc.SurfaceTextureHelper surfaceTextureHelper;
    private final int width;

    static Camera2Session()
    {
        org.webrtc.Camera2Session.camera2StartTimeMsHistogram = org.webrtc.Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
        org.webrtc.Camera2Session.camera2StopTimeMsHistogram = org.webrtc.Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
        org.webrtc.Camera2Session.camera2ResolutionHistogram = org.webrtc.Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", org.webrtc.CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
        return;
    }

    private Camera2Session(org.webrtc.CameraSession$CreateSessionCallback p4, org.webrtc.CameraSession$Events p5, android.content.Context p6, android.hardware.camera2.CameraManager p7, org.webrtc.SurfaceTextureHelper p8, android.media.MediaRecorder p9, String p10, int p11, int p12, int p13)
    {
        int v0_4;
        this.state = org.webrtc.Camera2Session$SessionState.RUNNING;
        this.firstFrameReported = 0;
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Create new camera2 session on camera ").append(p10).toString());
        this.constructionTimeNs = System.nanoTime();
        this.cameraThreadHandler = new android.os.Handler();
        this.callback = p4;
        this.events = p5;
        this.applicationContext = p6;
        this.cameraManager = p7;
        this.surfaceTextureHelper = p8;
        if (p9 == null) {
            v0_4 = 0;
        } else {
            v0_4 = p9.getSurface();
        }
        this.mediaRecorderSurface = v0_4;
        this.cameraId = p10;
        this.width = p11;
        this.height = p12;
        this.framerate = p13;
        this.start();
        return;
    }

    static synthetic void access$000(org.webrtc.Camera2Session p0)
    {
        p0.checkIsOnCameraThread();
        return;
    }

    static synthetic android.hardware.camera2.CameraCaptureSession access$100(org.webrtc.Camera2Session p1)
    {
        return p1.captureSession;
    }

    static synthetic android.view.Surface access$1000(org.webrtc.Camera2Session p1)
    {
        return p1.surface;
    }

    static synthetic android.view.Surface access$1002(org.webrtc.Camera2Session p0, android.view.Surface p1)
    {
        p0.surface = p1;
        return p1;
    }

    static synthetic android.hardware.camera2.CameraCaptureSession access$102(org.webrtc.Camera2Session p0, android.hardware.camera2.CameraCaptureSession p1)
    {
        p0.captureSession = p1;
        return p1;
    }

    static synthetic android.view.Surface access$1100(org.webrtc.Camera2Session p1)
    {
        return p1.mediaRecorderSurface;
    }

    static synthetic android.os.Handler access$1300(org.webrtc.Camera2Session p1)
    {
        return p1.cameraThreadHandler;
    }

    static synthetic int access$1400(org.webrtc.Camera2Session p1)
    {
        return p1.fpsUnitFactor;
    }

    static synthetic boolean access$1600(org.webrtc.Camera2Session p1)
    {
        return p1.firstFrameReported;
    }

    static synthetic boolean access$1602(org.webrtc.Camera2Session p0, boolean p1)
    {
        p0.firstFrameReported = p1;
        return p1;
    }

    static synthetic long access$1700(org.webrtc.Camera2Session p2)
    {
        return p2.constructionTimeNs;
    }

    static synthetic org.webrtc.Histogram access$1800()
    {
        return org.webrtc.Camera2Session.camera2StartTimeMsHistogram;
    }

    static synthetic int access$1900(org.webrtc.Camera2Session p1)
    {
        return p1.getFrameOrientation();
    }

    static synthetic org.webrtc.Camera2Session$SessionState access$200(org.webrtc.Camera2Session p1)
    {
        return p1.state;
    }

    static synthetic boolean access$2000(org.webrtc.Camera2Session p1)
    {
        return p1.isCameraFrontFacing;
    }

    static synthetic org.webrtc.Camera2Session$SessionState access$202(org.webrtc.Camera2Session p0, org.webrtc.Camera2Session$SessionState p1)
    {
        p0.state = p1;
        return p1;
    }

    static synthetic int access$2100(org.webrtc.Camera2Session p1)
    {
        return p1.cameraOrientation;
    }

    static synthetic android.hardware.camera2.CameraCharacteristics access$2200(org.webrtc.Camera2Session p1)
    {
        return p1.cameraCharacteristics;
    }

    static synthetic void access$300(org.webrtc.Camera2Session p0)
    {
        p0.stopInternal();
        return;
    }

    static synthetic org.webrtc.CameraSession$CreateSessionCallback access$400(org.webrtc.Camera2Session p1)
    {
        return p1.callback;
    }

    static synthetic org.webrtc.CameraSession$Events access$500(org.webrtc.Camera2Session p1)
    {
        return p1.events;
    }

    static synthetic void access$600(org.webrtc.Camera2Session p0, String p1)
    {
        p0.reportError(p1);
        return;
    }

    static synthetic android.hardware.camera2.CameraDevice access$700(org.webrtc.Camera2Session p1)
    {
        return p1.cameraDevice;
    }

    static synthetic android.hardware.camera2.CameraDevice access$702(org.webrtc.Camera2Session p0, android.hardware.camera2.CameraDevice p1)
    {
        p0.cameraDevice = p1;
        return p1;
    }

    static synthetic org.webrtc.SurfaceTextureHelper access$800(org.webrtc.Camera2Session p1)
    {
        return p1.surfaceTextureHelper;
    }

    static synthetic org.webrtc.CameraEnumerationAndroid$CaptureFormat access$900(org.webrtc.Camera2Session p1)
    {
        return p1.captureFormat;
    }

    private void checkIsOnCameraThread()
    {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        } else {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(org.webrtc.CameraSession$CreateSessionCallback p11, org.webrtc.CameraSession$Events p12, android.content.Context p13, android.hardware.camera2.CameraManager p14, org.webrtc.SurfaceTextureHelper p15, android.media.MediaRecorder p16, String p17, int p18, int p19, int p20)
    {
        new org.webrtc.Camera2Session(p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
        return;
    }

    private void findCaptureFormat()
    {
        this.checkIsOnCameraThread();
        android.util.Range[] v2_1 = ((android.util.Range[]) this.cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
        this.fpsUnitFactor = org.webrtc.Camera2Enumerator.getFpsUnitFactor(v2_1);
        java.util.List v3 = org.webrtc.Camera2Enumerator.convertFramerates(v2_1, this.fpsUnitFactor);
        java.util.List v4 = org.webrtc.Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Available preview sizes: ").append(v4).toString());
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Available fps ranges: ").append(v3).toString());
        if ((!v3.isEmpty()) && (!v4.isEmpty())) {
            org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange v0 = org.webrtc.CameraEnumerationAndroid.getClosestSupportedFramerateRange(v3, this.framerate);
            org.webrtc.Size v1 = org.webrtc.CameraEnumerationAndroid.getClosestSupportedSize(v4, this.width, this.height);
            org.webrtc.CameraEnumerationAndroid.reportCameraResolution(org.webrtc.Camera2Session.camera2ResolutionHistogram, v1);
            this.captureFormat = new org.webrtc.CameraEnumerationAndroid$CaptureFormat(v1.width, v1.height, v0);
            org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Using capture format: ").append(this.captureFormat).toString());
        } else {
            this.reportError("No supported capture formats.");
        }
        return;
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
        if (!this.isCameraFrontFacing) {
            v0 = (360 - v0);
        }
        return ((this.cameraOrientation + v0) % 360);
    }

    private void openCamera()
    {
        this.checkIsOnCameraThread();
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Opening camera ").append(this.cameraId).toString());
        this.events.onCameraOpening();
        try {
            this.cameraManager.openCamera(this.cameraId, new org.webrtc.Camera2Session$CameraStateCallback(this, 0), this.cameraThreadHandler);
        } catch (android.hardware.camera2.CameraAccessException v0) {
            this.reportError(new StringBuilder().append("Failed to open camera: ").append(v0).toString());
        }
        return;
    }

    private void reportError(String p5)
    {
        int v0;
        this.checkIsOnCameraThread();
        org.webrtc.Logging.e("Camera2Session", new StringBuilder().append("Error: ").append(p5).toString());
        if ((this.captureSession != null) || (this.state == org.webrtc.Camera2Session$SessionState.STOPPED)) {
            v0 = 0;
        } else {
            v0 = 1;
        }
        this.state = org.webrtc.Camera2Session$SessionState.STOPPED;
        this.stopInternal();
        if (v0 == 0) {
            this.events.onCameraError(this, p5);
        } else {
            this.callback.onFailure(org.webrtc.CameraSession$FailureType.ERROR, p5);
        }
        return;
    }

    private void start()
    {
        this.checkIsOnCameraThread();
        org.webrtc.Logging.d("Camera2Session", "start");
        try {
            int v1_13;
            this.cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
            this.cameraOrientation = ((Integer) this.cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (android.hardware.camera2.CameraAccessException v0) {
            this.reportError(new StringBuilder().append("getCameraCharacteristics(): ").append(v0.getMessage()).toString());
            return;
        }
        if (((Integer) this.cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING)).intValue() != 0) {
            v1_13 = 0;
        } else {
            v1_13 = 1;
        }
        this.isCameraFrontFacing = v1_13;
        this.findCaptureFormat();
        this.openCamera();
        return;
    }

    private void stopInternal()
    {
        org.webrtc.Logging.d("Camera2Session", "Stop internal");
        this.checkIsOnCameraThread();
        this.surfaceTextureHelper.stopListening();
        if (this.captureSession != null) {
            this.captureSession.close();
            this.captureSession = 0;
        }
        if (this.surface != null) {
            this.surface.release();
            this.surface = 0;
        }
        if (this.cameraDevice != null) {
            this.cameraDevice.close();
            this.cameraDevice = 0;
        }
        org.webrtc.Logging.d("Camera2Session", "Stop done");
        return;
    }

    public void stop()
    {
        org.webrtc.Logging.d("Camera2Session", new StringBuilder().append("Stop camera2 session on camera ").append(this.cameraId).toString());
        this.checkIsOnCameraThread();
        if (this.state != org.webrtc.Camera2Session$SessionState.STOPPED) {
            long v0 = System.nanoTime();
            this.state = org.webrtc.Camera2Session$SessionState.STOPPED;
            this.stopInternal();
            org.webrtc.Camera2Session.camera2StopTimeMsHistogram.addSample(((int) java.util.concurrent.TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - v0))));
        }
        return;
    }
}
