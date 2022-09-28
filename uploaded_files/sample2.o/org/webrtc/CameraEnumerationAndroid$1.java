package org.webrtc;
final class CameraEnumerationAndroid$1 extends org.webrtc.CameraEnumerationAndroid$ClosestComparator {
    private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
    private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
    private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
    private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
    private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
    private static final int MIN_FPS_THRESHOLD = 8000;
    final synthetic int val$requestedFps;

    CameraEnumerationAndroid$1(int p2)
    {
        this.val$requestedFps = p2;
        super(0);
        return;
    }

    private int progressivePenalty(int p3, int p4, int p5, int p6)
    {
        int v0_1;
        if (p3 >= p4) {
            v0_1 = ((p4 * p5) + ((p3 - p4) * p6));
        } else {
            v0_1 = (p3 * p5);
        }
        return v0_1;
    }

    bridge synthetic int diff(Object p2)
    {
        return this.diff(((org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange) p2));
    }

    int diff(org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange p7)
    {
        return (this.progressivePenalty(p7.min, 8000, 1, 4) + this.progressivePenalty(Math.abs(((this.val$requestedFps * 1000) - p7.max)), 5000, 1, 3));
    }
}
