package org.webrtc;
public class FileVideoCapturer implements org.webrtc.VideoCapturer {
    private static final String TAG = "FileVideoCapturer";
    private org.webrtc.VideoCapturer$CapturerObserver capturerObserver;
    private final java.util.TimerTask tickTask;
    private final java.util.Timer timer;
    private final org.webrtc.FileVideoCapturer$VideoReader videoReader;

    static FileVideoCapturer()
    {
        System.loadLibrary("jingle_peerconnection_so");
        return;
    }

    public FileVideoCapturer(String p5)
    {
        this.timer = new java.util.Timer();
        this.tickTask = new org.webrtc.FileVideoCapturer$1(this);
        try {
            this.videoReader = new org.webrtc.FileVideoCapturer$VideoReaderY4M(p5);
            return;
        } catch (java.io.IOException v0) {
            org.webrtc.Logging.d("FileVideoCapturer", new StringBuilder().append("Could not open video file: ").append(p5).toString());
            throw v0;
        }
    }

    private int getFrameHeight()
    {
        return this.videoReader.getFrameHeight();
    }

    private int getFrameWidth()
    {
        return this.videoReader.getFrameWidth();
    }

    private byte[] getNextFrame()
    {
        return this.videoReader.getNextFrame();
    }

    public static native void nativeI420ToNV21();

    public void changeCaptureFormat(int p1, int p2, int p3)
    {
        return;
    }

    public void dispose()
    {
        this.videoReader.close();
        return;
    }

    public void initialize(org.webrtc.SurfaceTextureHelper p1, android.content.Context p2, org.webrtc.VideoCapturer$CapturerObserver p3)
    {
        this.capturerObserver = p3;
        return;
    }

    public boolean isScreencast()
    {
        return 0;
    }

    public void startCapture(int p7, int p8, int p9)
    {
        this.timer.schedule(this.tickTask, 0, ((long) (1000 / p9)));
        return;
    }

    public void stopCapture()
    {
        this.timer.cancel();
        return;
    }

    public void tick()
    {
        this.capturerObserver.onByteBufferFrameCaptured(this.getNextFrame(), this.getFrameWidth(), this.getFrameHeight(), 0, java.util.concurrent.TimeUnit.MILLISECONDS.toNanos(android.os.SystemClock.elapsedRealtime()));
        return;
    }
}
