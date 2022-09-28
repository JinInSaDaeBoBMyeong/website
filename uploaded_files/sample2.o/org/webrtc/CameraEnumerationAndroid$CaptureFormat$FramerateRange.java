package org.webrtc;
public class CameraEnumerationAndroid$CaptureFormat$FramerateRange {
    public int max;
    public int min;

    public CameraEnumerationAndroid$CaptureFormat$FramerateRange(int p1, int p2)
    {
        this.min = p1;
        this.max = p2;
        return;
    }

    public boolean equals(Object p5)
    {
        int v1 = 0;
        if (((p5 instanceof org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange)) && ((this.min == ((org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange) p5).min) && (this.max == ((org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange) p5).max))) {
            v1 = 1;
        }
        return v1;
    }

    public int hashCode()
    {
        return (((65537 * this.min) + 1) + this.max);
    }

    public String toString()
    {
        return new StringBuilder().append("[").append((((float) this.min) / 1148846080)).append(":").append((((float) this.max) / 1148846080)).append("]").toString();
    }
}
