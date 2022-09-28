package org.webrtc;
public class PeerConnection$IceServer {
    public final String hostname;
    public final String password;
    public final org.webrtc.PeerConnection$TlsCertPolicy tlsCertPolicy;
    public final String uri;
    public final String username;

    public PeerConnection$IceServer(String p3)
    {
        this(p3, "", "");
        return;
    }

    public PeerConnection$IceServer(String p2, String p3, String p4)
    {
        this(p2, p3, p4, org.webrtc.PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_SECURE);
        return;
    }

    public PeerConnection$IceServer(String p7, String p8, String p9, org.webrtc.PeerConnection$TlsCertPolicy p10)
    {
        this(p7, p8, p9, p10, "");
        return;
    }

    public PeerConnection$IceServer(String p1, String p2, String p3, org.webrtc.PeerConnection$TlsCertPolicy p4, String p5)
    {
        this.uri = p1;
        this.username = p2;
        this.password = p3;
        this.tlsCertPolicy = p4;
        this.hostname = p5;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append(this.uri).append(" [").append(this.username).append(":").append(this.password).append("] [").append(this.tlsCertPolicy).append("] [").append(this.hostname).append("]").toString();
    }
}
