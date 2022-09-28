package org.webrtc;
public final enum class VideoCodecStatus extends java.lang.Enum {
    private static final synthetic org.webrtc.VideoCodecStatus[] $VALUES;
    public static final enum org.webrtc.VideoCodecStatus ERROR;
    public static final enum org.webrtc.VideoCodecStatus ERR_PARAMETER;
    public static final enum org.webrtc.VideoCodecStatus ERR_REQUEST_SLI;
    public static final enum org.webrtc.VideoCodecStatus ERR_SIZE;
    public static final enum org.webrtc.VideoCodecStatus FALLBACK_SOFTWARE;
    public static final enum org.webrtc.VideoCodecStatus LEVEL_EXCEEDED;
    public static final enum org.webrtc.VideoCodecStatus MEMORY;
    public static final enum org.webrtc.VideoCodecStatus NO_OUTPUT;
    public static final enum org.webrtc.VideoCodecStatus OK;
    public static final enum org.webrtc.VideoCodecStatus REQUEST_SLI;
    public static final enum org.webrtc.VideoCodecStatus TARGET_BITRATE_OVERSHOOT;
    public static final enum org.webrtc.VideoCodecStatus TIMEOUT;
    public static final enum org.webrtc.VideoCodecStatus UNINITIALIZED;
    private final int number;

    static VideoCodecStatus()
    {
        org.webrtc.VideoCodecStatus.REQUEST_SLI = new org.webrtc.VideoCodecStatus("REQUEST_SLI", 0, 2);
        org.webrtc.VideoCodecStatus.NO_OUTPUT = new org.webrtc.VideoCodecStatus("NO_OUTPUT", 1, 1);
        org.webrtc.VideoCodecStatus.OK = new org.webrtc.VideoCodecStatus("OK", 2, 0);
        org.webrtc.VideoCodecStatus.ERROR = new org.webrtc.VideoCodecStatus("ERROR", 3, -1);
        org.webrtc.VideoCodecStatus.LEVEL_EXCEEDED = new org.webrtc.VideoCodecStatus("LEVEL_EXCEEDED", 4, -2);
        org.webrtc.VideoCodecStatus.MEMORY = new org.webrtc.VideoCodecStatus("MEMORY", 5, -3);
        org.webrtc.VideoCodecStatus.ERR_PARAMETER = new org.webrtc.VideoCodecStatus("ERR_PARAMETER", 6, -4);
        org.webrtc.VideoCodecStatus.ERR_SIZE = new org.webrtc.VideoCodecStatus("ERR_SIZE", 7, -5);
        org.webrtc.VideoCodecStatus.TIMEOUT = new org.webrtc.VideoCodecStatus("TIMEOUT", 8, -6);
        org.webrtc.VideoCodecStatus.UNINITIALIZED = new org.webrtc.VideoCodecStatus("UNINITIALIZED", 9, -7);
        org.webrtc.VideoCodecStatus.ERR_REQUEST_SLI = new org.webrtc.VideoCodecStatus("ERR_REQUEST_SLI", 10, -12);
        org.webrtc.VideoCodecStatus.FALLBACK_SOFTWARE = new org.webrtc.VideoCodecStatus("FALLBACK_SOFTWARE", 11, -13);
        org.webrtc.VideoCodecStatus.TARGET_BITRATE_OVERSHOOT = new org.webrtc.VideoCodecStatus("TARGET_BITRATE_OVERSHOOT", 12, -14);
        org.webrtc.VideoCodecStatus[] v0_26 = new org.webrtc.VideoCodecStatus[13];
        v0_26[0] = org.webrtc.VideoCodecStatus.REQUEST_SLI;
        v0_26[1] = org.webrtc.VideoCodecStatus.NO_OUTPUT;
        v0_26[2] = org.webrtc.VideoCodecStatus.OK;
        v0_26[3] = org.webrtc.VideoCodecStatus.ERROR;
        v0_26[4] = org.webrtc.VideoCodecStatus.LEVEL_EXCEEDED;
        v0_26[5] = org.webrtc.VideoCodecStatus.MEMORY;
        v0_26[6] = org.webrtc.VideoCodecStatus.ERR_PARAMETER;
        v0_26[7] = org.webrtc.VideoCodecStatus.ERR_SIZE;
        v0_26[8] = org.webrtc.VideoCodecStatus.TIMEOUT;
        v0_26[9] = org.webrtc.VideoCodecStatus.UNINITIALIZED;
        v0_26[10] = org.webrtc.VideoCodecStatus.ERR_REQUEST_SLI;
        v0_26[11] = org.webrtc.VideoCodecStatus.FALLBACK_SOFTWARE;
        v0_26[12] = org.webrtc.VideoCodecStatus.TARGET_BITRATE_OVERSHOOT;
        org.webrtc.VideoCodecStatus.$VALUES = v0_26;
        return;
    }

    private VideoCodecStatus(String p1, int p2, int p3)
    {
        super(p1, p2);
        super.number = p3;
        return;
    }

    public static org.webrtc.VideoCodecStatus valueOf(String p1)
    {
        return ((org.webrtc.VideoCodecStatus) Enum.valueOf(org.webrtc.VideoCodecStatus, p1));
    }

    public static org.webrtc.VideoCodecStatus[] values()
    {
        return ((org.webrtc.VideoCodecStatus[]) org.webrtc.VideoCodecStatus.$VALUES.clone());
    }

    public int getNumber()
    {
        return this.number;
    }
}
