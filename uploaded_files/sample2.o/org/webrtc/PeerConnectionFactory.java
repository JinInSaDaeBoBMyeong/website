package org.webrtc;
public class PeerConnectionFactory {
    private static final String TAG = "PeerConnectionFactory";
    private static final String VIDEO_CAPTURER_THREAD_NAME = "VideoCapturerThread";
    private static android.content.Context applicationContext;
    private static volatile boolean nativeLibLoaded;
    private static Thread networkThread;
    private static Thread signalingThread;
    private static Thread workerThread;
    private org.webrtc.EglBase localEglbase;
    private final long nativeFactory;
    private org.webrtc.EglBase remoteEglbase;

    static PeerConnectionFactory()
    {
        try {
            System.loadLibrary("jingle_peerconnection_so");
            org.webrtc.PeerConnectionFactory.nativeLibLoaded = 1;
        } catch (UnsatisfiedLinkError v0) {
            org.webrtc.PeerConnectionFactory.nativeLibLoaded = 0;
        }
        return;
    }

    public PeerConnectionFactory()
    {
        this(0);
        return;
    }

    public PeerConnectionFactory(org.webrtc.PeerConnectionFactory$Options p2)
    {
        this(p2, 0, 0);
        return;
    }

    public PeerConnectionFactory(org.webrtc.PeerConnectionFactory$Options p5, org.webrtc.VideoEncoderFactory p6, org.webrtc.VideoDecoderFactory p7)
    {
        this.nativeFactory = org.webrtc.PeerConnectionFactory.nativeCreatePeerConnectionFactory(p5, p6, p7);
        if (this.nativeFactory != 0) {
            return;
        } else {
            throw new RuntimeException("Failed to initialize PeerConnectionFactory!");
        }
    }

    public static String fieldTrialsFindFullName(String p1)
    {
        String v0_1;
        if (!org.webrtc.PeerConnectionFactory.nativeLibLoaded) {
            v0_1 = "";
        } else {
            v0_1 = org.webrtc.PeerConnectionFactory.nativeFieldTrialsFindFullName(p1);
        }
        return v0_1;
    }

    public static void initializeAndroidGlobals(android.content.Context p0, boolean p1)
    {
        org.webrtc.ContextUtils.initialize(p0);
        org.webrtc.PeerConnectionFactory.nativeInitializeAndroidGlobals(p0, p1);
        return;
    }

    public static boolean initializeAndroidGlobals(Object p1, boolean p2, boolean p3, boolean p4)
    {
        org.webrtc.PeerConnectionFactory.initializeAndroidGlobals(((android.content.Context) p1), p4);
        return 1;
    }

    public static native void initializeFieldTrials();

    public static native void initializeInternalTracer();

    private static native long nativeCreateAudioSource();

    private static native long nativeCreateAudioTrack();

    private static native long nativeCreateLocalMediaStream();

    private static native long nativeCreateObserver();

    private static native long nativeCreatePeerConnection();

    private static native long nativeCreatePeerConnectionFactory();

    private static native long nativeCreateVideoSource();

    private static native long nativeCreateVideoTrack();

    private static native String nativeFieldTrialsFindFullName();

    private static native void nativeFreeFactory();

    public static native void nativeInitializeAndroidGlobals();

    private static native void nativeSetVideoHwAccelerationOptions();

    private static native boolean nativeStartAecDump();

    private static native void nativeStopAecDump();

    private static native void nativeThreadsCallbacks();

    private static void onNetworkThreadReady()
    {
        org.webrtc.PeerConnectionFactory.networkThread = Thread.currentThread();
        org.webrtc.Logging.d("PeerConnectionFactory", "onNetworkThreadReady");
        return;
    }

    private static void onSignalingThreadReady()
    {
        org.webrtc.PeerConnectionFactory.signalingThread = Thread.currentThread();
        org.webrtc.Logging.d("PeerConnectionFactory", "onSignalingThreadReady");
        return;
    }

    private static void onWorkerThreadReady()
    {
        org.webrtc.PeerConnectionFactory.workerThread = Thread.currentThread();
        org.webrtc.Logging.d("PeerConnectionFactory", "onWorkerThreadReady");
        return;
    }

    private static void printStackTrace(Thread p6, String p7)
    {
        if (p6 != null) {
            StackTraceElement[] v1 = p6.getStackTrace();
            if (v1.length > 0) {
                org.webrtc.Logging.d("PeerConnectionFactory", new StringBuilder().append(p7).append(" stacks trace:").toString());
                int v3_2 = v1.length;
                int v2_0 = 0;
                while (v2_0 < v3_2) {
                    org.webrtc.Logging.d("PeerConnectionFactory", v1[v2_0].toString());
                    v2_0++;
                }
            }
        }
        return;
    }

    public static void printStackTraces()
    {
        org.webrtc.PeerConnectionFactory.printStackTrace(org.webrtc.PeerConnectionFactory.networkThread, "Network thread");
        org.webrtc.PeerConnectionFactory.printStackTrace(org.webrtc.PeerConnectionFactory.workerThread, "Worker thread");
        org.webrtc.PeerConnectionFactory.printStackTrace(org.webrtc.PeerConnectionFactory.signalingThread, "Signaling thread");
        return;
    }

    public static native void shutdownInternalTracer();

    public static native boolean startInternalTracingCapture();

    public static native void stopInternalTracingCapture();

    public org.webrtc.AudioSource createAudioSource(org.webrtc.MediaConstraints p5)
    {
        return new org.webrtc.AudioSource(org.webrtc.PeerConnectionFactory.nativeCreateAudioSource(this.nativeFactory, p5));
    }

    public org.webrtc.AudioTrack createAudioTrack(String p7, org.webrtc.AudioSource p8)
    {
        return new org.webrtc.AudioTrack(org.webrtc.PeerConnectionFactory.nativeCreateAudioTrack(this.nativeFactory, p7, p8.nativeSource));
    }

    public org.webrtc.MediaStream createLocalMediaStream(String p5)
    {
        return new org.webrtc.MediaStream(org.webrtc.PeerConnectionFactory.nativeCreateLocalMediaStream(this.nativeFactory, p5));
    }

    public org.webrtc.PeerConnection createPeerConnection(java.util.List p3, org.webrtc.MediaConstraints p4, org.webrtc.PeerConnection$Observer p5)
    {
        return this.createPeerConnection(new org.webrtc.PeerConnection$RTCConfiguration(p3), p4, p5);
    }

    public org.webrtc.PeerConnection createPeerConnection(org.webrtc.PeerConnection$RTCConfiguration p13, org.webrtc.MediaConstraints p14, org.webrtc.PeerConnection$Observer p15)
    {
        org.webrtc.PeerConnection v0_2;
        long v4 = org.webrtc.PeerConnectionFactory.nativeCreateObserver(p15);
        if (v4 != 0) {
            long v6 = org.webrtc.PeerConnectionFactory.nativeCreatePeerConnection(this.nativeFactory, p13, p14, v4);
            if (v6 != 0) {
                v0_2 = new org.webrtc.PeerConnection(v6, v4);
            } else {
                v0_2 = 0;
            }
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public org.webrtc.VideoSource createVideoSource(org.webrtc.VideoCapturer p9)
    {
        org.webrtc.EglBase$Context v1;
        if (this.localEglbase != null) {
            v1 = this.localEglbase.getEglBaseContext();
        } else {
            v1 = 0;
        }
        org.webrtc.SurfaceTextureHelper v4 = org.webrtc.SurfaceTextureHelper.create("VideoCapturerThread", v1);
        long v2 = org.webrtc.PeerConnectionFactory.nativeCreateVideoSource(this.nativeFactory, v4, p9.isScreencast());
        p9.initialize(v4, org.webrtc.ContextUtils.getApplicationContext(), new org.webrtc.AndroidVideoTrackSourceObserver(v2));
        return new org.webrtc.VideoSource(v2);
    }

    public org.webrtc.VideoTrack createVideoTrack(String p7, org.webrtc.VideoSource p8)
    {
        return new org.webrtc.VideoTrack(org.webrtc.PeerConnectionFactory.nativeCreateVideoTrack(this.nativeFactory, p7, p8.nativeSource));
    }

    public void dispose()
    {
        org.webrtc.PeerConnectionFactory.nativeFreeFactory(this.nativeFactory);
        org.webrtc.PeerConnectionFactory.networkThread = 0;
        org.webrtc.PeerConnectionFactory.workerThread = 0;
        org.webrtc.PeerConnectionFactory.signalingThread = 0;
        if (this.localEglbase != null) {
            this.localEglbase.release();
        }
        if (this.remoteEglbase != null) {
            this.remoteEglbase.release();
        }
        return;
    }

    public native void nativeSetOptions();

    public void setOptions(org.webrtc.PeerConnectionFactory$Options p3)
    {
        this.nativeSetOptions(this.nativeFactory, p3);
        return;
    }

    public void setVideoHwAccelerationOptions(org.webrtc.EglBase$Context p5, org.webrtc.EglBase$Context p6)
    {
        if (this.localEglbase != null) {
            org.webrtc.Logging.w("PeerConnectionFactory", "Egl context already set.");
            this.localEglbase.release();
        }
        if (this.remoteEglbase != null) {
            org.webrtc.Logging.w("PeerConnectionFactory", "Egl context already set.");
            this.remoteEglbase.release();
        }
        this.localEglbase = org.webrtc.EglBase.create(p5);
        this.remoteEglbase = org.webrtc.EglBase.create(p6);
        org.webrtc.PeerConnectionFactory.nativeSetVideoHwAccelerationOptions(this.nativeFactory, this.localEglbase.getEglBaseContext(), this.remoteEglbase.getEglBaseContext());
        return;
    }

    public boolean startAecDump(int p3, int p4)
    {
        return org.webrtc.PeerConnectionFactory.nativeStartAecDump(this.nativeFactory, p3, p4);
    }

    public void stopAecDump()
    {
        org.webrtc.PeerConnectionFactory.nativeStopAecDump(this.nativeFactory);
        return;
    }

    public void threadsCallbacks()
    {
        org.webrtc.PeerConnectionFactory.nativeThreadsCallbacks(this.nativeFactory);
        return;
    }
}
