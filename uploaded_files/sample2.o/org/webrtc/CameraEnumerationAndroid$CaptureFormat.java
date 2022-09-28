package org.webrtc;
public class CameraEnumerationAndroid$CaptureFormat {
    public final org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange framerate;
    public final int height;
    public final int imageFormat;
    public final int width;

    public CameraEnumerationAndroid$CaptureFormat(int p2, int p3, int p4, int p5)
    {
        this.imageFormat = 17;
        this.width = p2;
        this.height = p3;
        this.framerate = new org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange(p4, p5);
        return;
    }

    public CameraEnumerationAndroid$CaptureFormat(int p2, int p3, org.webrtc.CameraEnumerationAndroid$CaptureFormat$FramerateRange p4)
    {
        this.imageFormat = 17;
        this.width = p2;
        this.height = p3;
        this.framerate = p4;
        return;
    }

    public static int frameSize(int p2, int p3, int p4)
    {
        if (p4 == 17) {
            return (((p2 * p3) * android.graphics.ImageFormat.getBitsPerPixel(p4)) / 8);
        } else {
            throw new UnsupportedOperationException("Don\'t know how to calculate the frame size of non-NV21 image formats.");
        }
    }

    public boolean equals(Object p5)
    {
        int v1 = 0;
        if (((p5 instanceof org.webrtc.CameraEnumerationAndroid$CaptureFormat)) && ((this.width == ((org.webrtc.CameraEnumerationAndroid$CaptureFormat) p5).width) && ((this.height == ((org.webrtc.CameraEnumerationAndroid$CaptureFormat) p5).height) && (this.framerate.equals(((org.webrtc.CameraEnumerationAndroid$CaptureFormat) p5).framerate))))) {
            v1 = 1;
        }
        return v1;
    }

    public int frameSize()
    {
        return org.webrtc.CameraEnumerationAndroid$CaptureFormat.frameSize(this.width, this.height, 17);
    }

    public int hashCode()
    {
        return (((((this.width * 65497) + this.height) * 251) + 1) + this.framerate.hashCode());
    }

    public String toString()
    {
        return new StringBuilder().append(this.width).append("x").append(this.height).append("@").append(this.framerate).toString();
    }
}
