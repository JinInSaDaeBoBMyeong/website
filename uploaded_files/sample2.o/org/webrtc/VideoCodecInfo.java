package org.webrtc;
public class VideoCodecInfo {
    public final String name;
    public final java.util.Map params;
    public final int payload;

    public VideoCodecInfo(int p1, String p2, java.util.Map p3)
    {
        this.payload = p1;
        this.name = p2;
        this.params = p3;
        return;
    }
}
