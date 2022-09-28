package org.webrtc;
public class VideoEncoder$Settings {
    public final int height;
    public final int maxFramerate;
    public final int numberOfCores;
    public final int startBitrate;
    public final int width;

    public VideoEncoder$Settings(int p1, int p2, int p3, int p4, int p5)
    {
        this.numberOfCores = p1;
        this.width = p2;
        this.height = p3;
        this.startBitrate = p4;
        this.maxFramerate = p5;
        return;
    }
}
