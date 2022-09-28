package org.webrtc;
public class Camera2Capturer extends org.webrtc.CameraCapturer {
    private final android.hardware.camera2.CameraManager cameraManager;
    private final android.content.Context context;

    public Camera2Capturer(android.content.Context p2, String p3, org.webrtc.CameraVideoCapturer$CameraEventsHandler p4)
    {
        super(p3, p4, new org.webrtc.Camera2Enumerator(p2));
        super.context = p2;
        super.cameraManager = ((android.hardware.camera2.CameraManager) p2.getSystemService("camera"));
        return;
    }

    public bridge synthetic void addMediaRecorderToCamera(android.media.MediaRecorder p1, org.webrtc.CameraVideoCapturer$MediaRecorderHandler p2)
    {
        super.addMediaRecorderToCamera(p1, p2);
        return;
    }

    public bridge synthetic void changeCaptureFormat(int p1, int p2, int p3)
    {
        super.changeCaptureFormat(p1, p2, p3);
        return;
    }

    protected void createCameraSession(org.webrtc.CameraSession$CreateSessionCallback p11, org.webrtc.CameraSession$Events p12, android.content.Context p13, org.webrtc.SurfaceTextureHelper p14, android.media.MediaRecorder p15, String p16, int p17, int p18, int p19)
    {
        org.webrtc.Camera2Session.create(p11, p12, p13, this.cameraManager, p14, p15, p16, p17, p18, p19);
        return;
    }

    public bridge synthetic void dispose()
    {
        super.dispose();
        return;
    }

    public bridge synthetic void initialize(org.webrtc.SurfaceTextureHelper p1, android.content.Context p2, org.webrtc.VideoCapturer$CapturerObserver p3)
    {
        super.initialize(p1, p2, p3);
        return;
    }

    public bridge synthetic boolean isScreencast()
    {
        return super.isScreencast();
    }

    public bridge synthetic void printStackTrace()
    {
        super.printStackTrace();
        return;
    }

    public bridge synthetic void removeMediaRecorderFromCamera(org.webrtc.CameraVideoCapturer$MediaRecorderHandler p1)
    {
        super.removeMediaRecorderFromCamera(p1);
        return;
    }

    public bridge synthetic void startCapture(int p1, int p2, int p3)
    {
        super.startCapture(p1, p2, p3);
        return;
    }

    public bridge synthetic void stopCapture()
    {
        super.stopCapture();
        return;
    }

    public bridge synthetic void switchCamera(org.webrtc.CameraVideoCapturer$CameraSwitchHandler p1)
    {
        super.switchCamera(p1);
        return;
    }
}
