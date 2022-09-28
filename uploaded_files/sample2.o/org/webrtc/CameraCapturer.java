package org.webrtc;
abstract class CameraCapturer implements org.webrtc.CameraVideoCapturer {
    private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
    private static final int OPEN_CAMERA_DELAY_MS = 500;
    private static final int OPEN_CAMERA_TIMEOUT = 10000;
    private static final String TAG = "CameraCapturer";
    private android.content.Context applicationContext;
    private final org.webrtc.CameraEnumerator cameraEnumerator;
    private String cameraName;
    private final org.webrtc.CameraSession$Events cameraSessionEventsHandler;
    private org.webrtc.CameraVideoCapturer$CameraStatistics cameraStatistics;
    private android.os.Handler cameraThreadHandler;
    private org.webrtc.VideoCapturer$CapturerObserver capturerObserver;
    private final org.webrtc.CameraSession$CreateSessionCallback createSessionCallback;
    private org.webrtc.CameraSession currentSession;
    private final org.webrtc.CameraVideoCapturer$CameraEventsHandler eventsHandler;
    private boolean firstFrameObserved;
    private int framerate;
    private int height;
    private org.webrtc.CameraVideoCapturer$MediaRecorderHandler mediaRecorderEventsHandler;
    private org.webrtc.CameraCapturer$MediaRecorderState mediaRecorderState;
    private int openAttemptsRemaining;
    private final Runnable openCameraTimeoutRunnable;
    private boolean sessionOpening;
    private final Object stateLock;
    private org.webrtc.SurfaceTextureHelper surfaceHelper;
    private org.webrtc.CameraVideoCapturer$CameraSwitchHandler switchEventsHandler;
    private org.webrtc.CameraCapturer$SwitchState switchState;
    private final android.os.Handler uiThreadHandler;
    private int width;

    public CameraCapturer(String p5, org.webrtc.CameraVideoCapturer$CameraEventsHandler p6, org.webrtc.CameraEnumerator p7)
    {
        this.createSessionCallback = new org.webrtc.CameraCapturer$1(this);
        this.cameraSessionEventsHandler = new org.webrtc.CameraCapturer$2(this);
        this.openCameraTimeoutRunnable = new org.webrtc.CameraCapturer$3(this);
        this.stateLock = new Object();
        this.switchState = org.webrtc.CameraCapturer$SwitchState.IDLE;
        this.mediaRecorderState = org.webrtc.CameraCapturer$MediaRecorderState.IDLE;
        if (p6 == null) {
            p6 = new org.webrtc.CameraCapturer$4(this);
        }
        this.eventsHandler = p6;
        this.cameraEnumerator = p7;
        this.cameraName = p5;
        this.uiThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        String[] v0 = p7.getDeviceNames();
        if (v0.length != 0) {
            if (java.util.Arrays.asList(v0).contains(this.cameraName)) {
                return;
            } else {
                throw new IllegalArgumentException(new StringBuilder().append("Camera name ").append(this.cameraName).append(" does not match any known camera device.").toString());
            }
        } else {
            throw new RuntimeException("No cameras attached.");
        }
    }

    static synthetic void access$000(org.webrtc.CameraCapturer p0)
    {
        p0.checkIsOnCameraThread();
        return;
    }

    static synthetic org.webrtc.CameraCapturer$SwitchState access$100(org.webrtc.CameraCapturer p1)
    {
        return p1.switchState;
    }

    static synthetic org.webrtc.SurfaceTextureHelper access$1000(org.webrtc.CameraCapturer p1)
    {
        return p1.surfaceHelper;
    }

    static synthetic org.webrtc.CameraCapturer$SwitchState access$102(org.webrtc.CameraCapturer p0, org.webrtc.CameraCapturer$SwitchState p1)
    {
        p0.switchState = p1;
        return p1;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraEventsHandler access$1100(org.webrtc.CameraCapturer p1)
    {
        return p1.eventsHandler;
    }

    static synthetic boolean access$1200(org.webrtc.CameraCapturer p1)
    {
        return p1.firstFrameObserved;
    }

    static synthetic boolean access$1202(org.webrtc.CameraCapturer p0, boolean p1)
    {
        p0.firstFrameObserved = p1;
        return p1;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraSwitchHandler access$1300(org.webrtc.CameraCapturer p1)
    {
        return p1.switchEventsHandler;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraSwitchHandler access$1302(org.webrtc.CameraCapturer p0, org.webrtc.CameraVideoCapturer$CameraSwitchHandler p1)
    {
        p0.switchEventsHandler = p1;
        return p1;
    }

    static synthetic String access$1400(org.webrtc.CameraCapturer p1)
    {
        return p1.cameraName;
    }

    static synthetic org.webrtc.CameraEnumerator access$1500(org.webrtc.CameraCapturer p1)
    {
        return p1.cameraEnumerator;
    }

    static synthetic void access$1600(org.webrtc.CameraCapturer p0, org.webrtc.CameraVideoCapturer$CameraSwitchHandler p1)
    {
        p0.switchCameraInternal(p1);
        return;
    }

    static synthetic org.webrtc.CameraVideoCapturer$MediaRecorderHandler access$1700(org.webrtc.CameraCapturer p1)
    {
        return p1.mediaRecorderEventsHandler;
    }

    static synthetic org.webrtc.CameraVideoCapturer$MediaRecorderHandler access$1702(org.webrtc.CameraCapturer p0, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p1)
    {
        p0.mediaRecorderEventsHandler = p1;
        return p1;
    }

    static synthetic int access$1800(org.webrtc.CameraCapturer p1)
    {
        return p1.openAttemptsRemaining;
    }

    static synthetic int access$1810(org.webrtc.CameraCapturer p2)
    {
        int v0 = p2.openAttemptsRemaining;
        p2.openAttemptsRemaining = (v0 - 1);
        return v0;
    }

    static synthetic void access$1900(org.webrtc.CameraCapturer p0, int p1, android.media.MediaRecorder p2)
    {
        p0.createSessionInternal(p1, p2);
        return;
    }

    static synthetic org.webrtc.CameraCapturer$MediaRecorderState access$200(org.webrtc.CameraCapturer p1)
    {
        return p1.mediaRecorderState;
    }

    static synthetic org.webrtc.CameraSession$CreateSessionCallback access$2000(org.webrtc.CameraCapturer p1)
    {
        return p1.createSessionCallback;
    }

    static synthetic org.webrtc.CameraCapturer$MediaRecorderState access$202(org.webrtc.CameraCapturer p0, org.webrtc.CameraCapturer$MediaRecorderState p1)
    {
        p0.mediaRecorderState = p1;
        return p1;
    }

    static synthetic org.webrtc.CameraSession$Events access$2100(org.webrtc.CameraCapturer p1)
    {
        return p1.cameraSessionEventsHandler;
    }

    static synthetic android.content.Context access$2200(org.webrtc.CameraCapturer p1)
    {
        return p1.applicationContext;
    }

    static synthetic int access$2300(org.webrtc.CameraCapturer p1)
    {
        return p1.width;
    }

    static synthetic int access$2400(org.webrtc.CameraCapturer p1)
    {
        return p1.height;
    }

    static synthetic int access$2500(org.webrtc.CameraCapturer p1)
    {
        return p1.framerate;
    }

    static synthetic void access$2600(org.webrtc.CameraCapturer p0, android.media.MediaRecorder p1, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p2)
    {
        p0.updateMediaRecorderInternal(p1, p2);
        return;
    }

    static synthetic Runnable access$300(org.webrtc.CameraCapturer p1)
    {
        return p1.openCameraTimeoutRunnable;
    }

    static synthetic android.os.Handler access$400(org.webrtc.CameraCapturer p1)
    {
        return p1.uiThreadHandler;
    }

    static synthetic Object access$500(org.webrtc.CameraCapturer p1)
    {
        return p1.stateLock;
    }

    static synthetic org.webrtc.VideoCapturer$CapturerObserver access$600(org.webrtc.CameraCapturer p1)
    {
        return p1.capturerObserver;
    }

    static synthetic boolean access$702(org.webrtc.CameraCapturer p0, boolean p1)
    {
        p0.sessionOpening = p1;
        return p1;
    }

    static synthetic org.webrtc.CameraSession access$800(org.webrtc.CameraCapturer p1)
    {
        return p1.currentSession;
    }

    static synthetic org.webrtc.CameraSession access$802(org.webrtc.CameraCapturer p0, org.webrtc.CameraSession p1)
    {
        p0.currentSession = p1;
        return p1;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraStatistics access$900(org.webrtc.CameraCapturer p1)
    {
        return p1.cameraStatistics;
    }

    static synthetic org.webrtc.CameraVideoCapturer$CameraStatistics access$902(org.webrtc.CameraCapturer p0, org.webrtc.CameraVideoCapturer$CameraStatistics p1)
    {
        p0.cameraStatistics = p1;
        return p1;
    }

    private void checkIsOnCameraThread()
    {
        if (Thread.currentThread() == this.cameraThreadHandler.getLooper().getThread()) {
            return;
        } else {
            org.webrtc.Logging.e("CameraCapturer", "Check is on camera thread failed.");
            throw new RuntimeException("Not on camera thread.");
        }
    }

    private void createSessionInternal(int p5, android.media.MediaRecorder p6)
    {
        this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, ((long) (p5 + 10000)));
        this.cameraThreadHandler.postDelayed(new org.webrtc.CameraCapturer$5(this, p6), ((long) p5));
        return;
    }

    private void reportCameraSwitchError(String p2, org.webrtc.CameraVideoCapturer$CameraSwitchHandler p3)
    {
        org.webrtc.Logging.e("CameraCapturer", p2);
        if (p3 != null) {
            p3.onCameraSwitchError(p2);
        }
        return;
    }

    private void reportUpdateMediaRecorderError(String p2, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p3)
    {
        this.checkIsOnCameraThread();
        org.webrtc.Logging.e("CameraCapturer", p2);
        if (p3 != null) {
            p3.onMediaRecorderError(p2);
        }
        return;
    }

    private void switchCameraInternal(org.webrtc.CameraVideoCapturer$CameraSwitchHandler p7)
    {
        org.webrtc.Logging.d("CameraCapturer", "switchCamera internal");
        String[] v1 = this.cameraEnumerator.getDeviceNames();
        if (v1.length >= 2) {
            try {
                if (this.switchState == org.webrtc.CameraCapturer$SwitchState.IDLE) {
                    if (this.mediaRecorderState == org.webrtc.CameraCapturer$MediaRecorderState.IDLE) {
                        if ((this.sessionOpening) || (this.currentSession != null)) {
                            this.switchEventsHandler = p7;
                            if (!this.sessionOpening) {
                                this.switchState = org.webrtc.CameraCapturer$SwitchState.IN_PROGRESS;
                                org.webrtc.Logging.d("CameraCapturer", "switchCamera: Stopping session");
                                this.cameraStatistics.release();
                                this.cameraStatistics = 0;
                                this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$10(this, this.currentSession));
                                this.currentSession = 0;
                                this.cameraName = v1[((java.util.Arrays.asList(v1).indexOf(this.cameraName) + 1) % v1.length)];
                                this.sessionOpening = 1;
                                this.openAttemptsRemaining = 1;
                                this.createSessionInternal(0, 0);
                                org.webrtc.Logging.d("CameraCapturer", "switchCamera done");
                            } else {
                                this.switchState = org.webrtc.CameraCapturer$SwitchState.PENDING;
                            }
                        } else {
                            this.reportCameraSwitchError("switchCamera: camera is not running.", p7);
                        }
                    } else {
                        this.reportCameraSwitchError("switchCamera: media recording is active", p7);
                    }
                } else {
                    this.reportCameraSwitchError("Camera switch already in progress.", p7);
                }
            } catch (String v3_26) {
                throw v3_26;
            }
        } else {
            if (p7 != null) {
                p7.onCameraSwitchError("No camera to switch to.");
            }
        }
        return;
    }

    private void updateMediaRecorderInternal(android.media.MediaRecorder p6, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p7)
    {
        String v0 = 1;
        this.checkIsOnCameraThread();
        try {
            if (p6 == null) {
                v0 = 0;
            }
        } catch (String v2_21) {
            throw v2_21;
        }
        org.webrtc.Logging.d("CameraCapturer", new StringBuilder().append("updateMediaRecoderInternal internal. State: ").append(this.mediaRecorderState).append(". Switch state: ").append(this.switchState).append(". Add MediaRecorder: ").append(v0).toString());
        if (((v0 == null) || (this.mediaRecorderState == org.webrtc.CameraCapturer$MediaRecorderState.IDLE)) && ((v0 != null) || (this.mediaRecorderState == org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE))) {
            if (this.switchState == org.webrtc.CameraCapturer$SwitchState.IDLE) {
                if (this.currentSession != null) {
                    if (!this.sessionOpening) {
                        String v2_6;
                        this.mediaRecorderEventsHandler = p7;
                        if (v0 == null) {
                            v2_6 = org.webrtc.CameraCapturer$MediaRecorderState.ACTIVE_TO_IDLE;
                        } else {
                            v2_6 = org.webrtc.CameraCapturer$MediaRecorderState.IDLE_TO_ACTIVE;
                        }
                        this.mediaRecorderState = v2_6;
                        org.webrtc.Logging.d("CameraCapturer", "updateMediaRecoder: Stopping session");
                        this.cameraStatistics.release();
                        this.cameraStatistics = 0;
                        this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$11(this, this.currentSession));
                        this.currentSession = 0;
                        this.sessionOpening = 1;
                        this.openAttemptsRemaining = 1;
                        this.createSessionInternal(0, p6);
                        org.webrtc.Logging.d("CameraCapturer", "updateMediaRecoderInternal done");
                    } else {
                        this.reportUpdateMediaRecorderError("MediaRecorder update while camera is still opening.", p7);
                    }
                } else {
                    this.reportUpdateMediaRecorderError("MediaRecorder update while camera is closed.", p7);
                }
            } else {
                this.reportUpdateMediaRecorderError("MediaRecorder update while camera is switching.", p7);
            }
        } else {
            this.reportUpdateMediaRecorderError("Incorrect state for MediaRecorder update.", p7);
        }
        return;
    }

    public void addMediaRecorderToCamera(android.media.MediaRecorder p3, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p4)
    {
        org.webrtc.Logging.d("CameraCapturer", "addMediaRecorderToCamera");
        this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$8(this, p3, p4));
        return;
    }

    public void changeCaptureFormat(int p4, int p5, int p6)
    {
        org.webrtc.Logging.d("CameraCapturer", new StringBuilder().append("changeCaptureFormat: ").append(p4).append("x").append(p5).append("@").append(p6).toString());
        try {
            this.stopCapture();
            this.startCapture(p4, p5, p6);
            return;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    protected abstract void createCameraSession();

    public void dispose()
    {
        org.webrtc.Logging.d("CameraCapturer", "dispose");
        this.stopCapture();
        return;
    }

    protected String getCameraName()
    {
        try {
            return this.cameraName;
        } catch (Throwable v0_1) {
            throw v0_1;
        }
    }

    public void initialize(org.webrtc.SurfaceTextureHelper p2, android.content.Context p3, org.webrtc.VideoCapturer$CapturerObserver p4)
    {
        android.os.Handler v0;
        this.applicationContext = p3;
        this.capturerObserver = p4;
        this.surfaceHelper = p2;
        if (p2 != null) {
            v0 = p2.getHandler();
        } else {
            v0 = 0;
        }
        this.cameraThreadHandler = v0;
        return;
    }

    public boolean isScreencast()
    {
        return 0;
    }

    public void printStackTrace()
    {
        Thread v1 = 0;
        if (this.cameraThreadHandler != null) {
            v1 = this.cameraThreadHandler.getLooper().getThread();
        }
        if (v1 != null) {
            StackTraceElement[] v0 = v1.getStackTrace();
            if (v0.length > 0) {
                org.webrtc.Logging.d("CameraCapturer", "CameraCapturer stack trace:");
                int v4_1 = v0.length;
                int v3_3 = 0;
                while (v3_3 < v4_1) {
                    org.webrtc.Logging.d("CameraCapturer", v0[v3_3].toString());
                    v3_3++;
                }
            }
        }
        return;
    }

    public void removeMediaRecorderFromCamera(org.webrtc.CameraVideoCapturer$MediaRecorderHandler p3)
    {
        org.webrtc.Logging.d("CameraCapturer", "removeMediaRecorderFromCamera");
        this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$9(this, p3));
        return;
    }

    public void startCapture(int p4, int p5, int p6)
    {
        org.webrtc.Logging.d("CameraCapturer", new StringBuilder().append("startCapture: ").append(p4).append("x").append(p5).append("@").append(p6).toString());
        if (this.applicationContext != null) {
            try {
                if ((!this.sessionOpening) && (this.currentSession == null)) {
                    this.width = p4;
                    this.height = p5;
                    this.framerate = p6;
                    this.sessionOpening = 1;
                    this.openAttemptsRemaining = 3;
                    this.createSessionInternal(0, 0);
                } else {
                    org.webrtc.Logging.w("CameraCapturer", "Session already open");
                }
            } catch (int v0_8) {
                throw v0_8;
            }
            return;
        } else {
            throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
        }
    }

    public void stopCapture()
    {
        org.webrtc.Logging.d("CameraCapturer", "Stop capture");
        try {
            while (this.sessionOpening) {
                org.webrtc.Logging.d("CameraCapturer", "Stop capture: Waiting for session to open");
                org.webrtc.ThreadUtils.waitUninterruptibly(this.stateLock);
            }
        } catch (String v1_10) {
            throw v1_10;
        }
        if (this.currentSession == null) {
            org.webrtc.Logging.d("CameraCapturer", "Stop capture: No session open");
        } else {
            org.webrtc.Logging.d("CameraCapturer", "Stop capture: Nulling session");
            this.cameraStatistics.release();
            this.cameraStatistics = 0;
            this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$6(this, this.currentSession));
            this.currentSession = 0;
            this.capturerObserver.onCapturerStopped();
        }
        org.webrtc.Logging.d("CameraCapturer", "Stop capture done");
        return;
    }

    public void switchCamera(org.webrtc.CameraVideoCapturer$CameraSwitchHandler p3)
    {
        org.webrtc.Logging.d("CameraCapturer", "switchCamera");
        this.cameraThreadHandler.post(new org.webrtc.CameraCapturer$7(this, p3));
        return;
    }
}
