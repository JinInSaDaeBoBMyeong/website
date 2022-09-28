package org.webrtc;
public class CameraEnumerationAndroid {
    static final java.util.ArrayList COMMON_RESOLUTIONS = None;
    private static final String TAG = "CameraEnumerationAndroid";

    static CameraEnumerationAndroid()
    {
        java.util.List v1_2 = new org.webrtc.Size[20];
        v1_2[0] = new org.webrtc.Size(160, 120);
        v1_2[1] = new org.webrtc.Size(240, 160);
        v1_2[2] = new org.webrtc.Size(320, 240);
        v1_2[3] = new org.webrtc.Size(400, 240);
        v1_2[4] = new org.webrtc.Size(480, 320);
        v1_2[5] = new org.webrtc.Size(640, 360);
        v1_2[6] = new org.webrtc.Size(640, 480);
        v1_2[7] = new org.webrtc.Size(768, 480);
        v1_2[8] = new org.webrtc.Size(854, 480);
        v1_2[9] = new org.webrtc.Size(800, 600);
        v1_2[10] = new org.webrtc.Size(960, 540);
        v1_2[11] = new org.webrtc.Size(960, 640);
        v1_2[12] = new org.webrtc.Size(1024, 576);
        v1_2[13] = new org.webrtc.Size(1024, 600);
        v1_2[14] = new org.webrtc.Size(1280, 720);
        v1_2[15] = new org.webrtc.Size(1280, 1024);
        v1_2[16] = new org.webrtc.Size(1920, 1080);
        v1_2[17] = new org.webrtc.Size(1920, 1440);
        v1_2[18] = new org.webrtc.Size(2560, 1440);
        v1_2[19] = new org.webrtc.Size(3840, 2160);
        org.webrtc.CameraEnumerationAndroid.COMMON_RESOLUTIONS = new java.util.ArrayList(java.util.Arrays.asList(v1_2));
        return;
    }

    public CameraEnumerationAndroid()
    {
        return;
    }

    public static org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange getClosestSupportedFramerateRange(java.util.List p1, int p2)
    {
        return ((org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange) java.util.Collections.min(p1, new org.webrtc.CameraEnumerationAndroid$1(p2)));
    }

    public static org.webrtc.Size getClosestSupportedSize(java.util.List p1, int p2, int p3)
    {
        return ((org.webrtc.Size) java.util.Collections.min(p1, new org.webrtc.CameraEnumerationAndroid$2(p2, p3)));
    }

    static void reportCameraResolution(org.webrtc.Histogram p2, org.webrtc.Size p3)
    {
        p2.addSample((org.webrtc.CameraEnumerationAndroid.COMMON_RESOLUTIONS.indexOf(p3) + 1));
        return;
    }
}
