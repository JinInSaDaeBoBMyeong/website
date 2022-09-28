package org.webrtc;
public class SessionDescription {
    public final String description;
    public final org.webrtc.SessionDescription$Type type;

    public SessionDescription(org.webrtc.SessionDescription$Type p1, String p2)
    {
        this.type = p1;
        this.description = p2;
        return;
    }
}
