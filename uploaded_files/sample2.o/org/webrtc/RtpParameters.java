package org.webrtc;
public class RtpParameters {
    public final java.util.LinkedList codecs;
    public final java.util.LinkedList encodings;

    public RtpParameters()
    {
        this.encodings = new java.util.LinkedList();
        this.codecs = new java.util.LinkedList();
        return;
    }
}
