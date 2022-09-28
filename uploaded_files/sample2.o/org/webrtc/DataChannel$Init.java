package org.webrtc;
public class DataChannel$Init {
    public int id;
    public int maxRetransmitTimeMs;
    public int maxRetransmits;
    public boolean negotiated;
    public boolean ordered;
    public String protocol;

    public DataChannel$Init()
    {
        this.ordered = 1;
        this.maxRetransmitTimeMs = -1;
        this.maxRetransmits = -1;
        this.protocol = "";
        this.negotiated = 0;
        this.id = -1;
        return;
    }

    private DataChannel$Init(boolean p3, int p4, int p5, String p6, boolean p7, int p8)
    {
        this.ordered = 1;
        this.maxRetransmitTimeMs = -1;
        this.maxRetransmits = -1;
        this.protocol = "";
        this.negotiated = 0;
        this.id = -1;
        this.ordered = p3;
        this.maxRetransmitTimeMs = p4;
        this.maxRetransmits = p5;
        this.protocol = p6;
        this.negotiated = p7;
        this.id = p8;
        return;
    }
}
