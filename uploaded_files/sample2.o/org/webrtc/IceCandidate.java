package org.webrtc;
public class IceCandidate {
    public final String sdp;
    public final int sdpMLineIndex;
    public final String sdpMid;
    public final String serverUrl;

    public IceCandidate(String p2, int p3, String p4)
    {
        this.sdpMid = p2;
        this.sdpMLineIndex = p3;
        this.sdp = p4;
        this.serverUrl = "";
        return;
    }

    private IceCandidate(String p1, int p2, String p3, String p4)
    {
        this.sdpMid = p1;
        this.sdpMLineIndex = p2;
        this.sdp = p3;
        this.serverUrl = p4;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append(this.sdpMid).append(":").append(this.sdpMLineIndex).append(":").append(this.sdp).append(":").append(this.serverUrl).toString();
    }
}
