package org.webrtc;
public final enum class Logging$TraceLevel extends java.lang.Enum {
    private static final synthetic org.webrtc.Logging$TraceLevel[] $VALUES;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_ALL;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_APICALL;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_CRITICAL;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_DEBUG;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_DEFAULT;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_ERROR;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_INFO;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_MEMORY;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_MODULECALL;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_NONE;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_STATEINFO;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_STREAM;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_TERSEINFO;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_TIMER;
    public static final enum org.webrtc.Logging$TraceLevel TRACE_WARNING;
    public final int level;

    static Logging$TraceLevel()
    {
        org.webrtc.Logging$TraceLevel.TRACE_NONE = new org.webrtc.Logging$TraceLevel("TRACE_NONE", 0, 0);
        org.webrtc.Logging$TraceLevel.TRACE_STATEINFO = new org.webrtc.Logging$TraceLevel("TRACE_STATEINFO", 1, 1);
        org.webrtc.Logging$TraceLevel.TRACE_WARNING = new org.webrtc.Logging$TraceLevel("TRACE_WARNING", 2, 2);
        org.webrtc.Logging$TraceLevel.TRACE_ERROR = new org.webrtc.Logging$TraceLevel("TRACE_ERROR", 3, 4);
        org.webrtc.Logging$TraceLevel.TRACE_CRITICAL = new org.webrtc.Logging$TraceLevel("TRACE_CRITICAL", 4, 8);
        org.webrtc.Logging$TraceLevel.TRACE_APICALL = new org.webrtc.Logging$TraceLevel("TRACE_APICALL", 5, 16);
        org.webrtc.Logging$TraceLevel.TRACE_DEFAULT = new org.webrtc.Logging$TraceLevel("TRACE_DEFAULT", 6, 255);
        org.webrtc.Logging$TraceLevel.TRACE_MODULECALL = new org.webrtc.Logging$TraceLevel("TRACE_MODULECALL", 7, 32);
        org.webrtc.Logging$TraceLevel.TRACE_MEMORY = new org.webrtc.Logging$TraceLevel("TRACE_MEMORY", 8, 256);
        org.webrtc.Logging$TraceLevel.TRACE_TIMER = new org.webrtc.Logging$TraceLevel("TRACE_TIMER", 9, 512);
        org.webrtc.Logging$TraceLevel.TRACE_STREAM = new org.webrtc.Logging$TraceLevel("TRACE_STREAM", 10, 1024);
        org.webrtc.Logging$TraceLevel.TRACE_DEBUG = new org.webrtc.Logging$TraceLevel("TRACE_DEBUG", 11, 2048);
        org.webrtc.Logging$TraceLevel.TRACE_INFO = new org.webrtc.Logging$TraceLevel("TRACE_INFO", 12, 4096);
        org.webrtc.Logging$TraceLevel.TRACE_TERSEINFO = new org.webrtc.Logging$TraceLevel("TRACE_TERSEINFO", 13, 8192);
        org.webrtc.Logging$TraceLevel.TRACE_ALL = new org.webrtc.Logging$TraceLevel("TRACE_ALL", 14, 65535);
        org.webrtc.Logging$TraceLevel[] v0_30 = new org.webrtc.Logging$TraceLevel[15];
        v0_30[0] = org.webrtc.Logging$TraceLevel.TRACE_NONE;
        v0_30[1] = org.webrtc.Logging$TraceLevel.TRACE_STATEINFO;
        v0_30[2] = org.webrtc.Logging$TraceLevel.TRACE_WARNING;
        v0_30[3] = org.webrtc.Logging$TraceLevel.TRACE_ERROR;
        v0_30[4] = org.webrtc.Logging$TraceLevel.TRACE_CRITICAL;
        v0_30[5] = org.webrtc.Logging$TraceLevel.TRACE_APICALL;
        v0_30[6] = org.webrtc.Logging$TraceLevel.TRACE_DEFAULT;
        v0_30[7] = org.webrtc.Logging$TraceLevel.TRACE_MODULECALL;
        v0_30[8] = org.webrtc.Logging$TraceLevel.TRACE_MEMORY;
        v0_30[9] = org.webrtc.Logging$TraceLevel.TRACE_TIMER;
        v0_30[10] = org.webrtc.Logging$TraceLevel.TRACE_STREAM;
        v0_30[11] = org.webrtc.Logging$TraceLevel.TRACE_DEBUG;
        v0_30[12] = org.webrtc.Logging$TraceLevel.TRACE_INFO;
        v0_30[13] = org.webrtc.Logging$TraceLevel.TRACE_TERSEINFO;
        v0_30[14] = org.webrtc.Logging$TraceLevel.TRACE_ALL;
        org.webrtc.Logging$TraceLevel.$VALUES = v0_30;
        return;
    }

    private Logging$TraceLevel(String p1, int p2, int p3)
    {
        super(p1, p2);
        super.level = p3;
        return;
    }

    public static org.webrtc.Logging$TraceLevel valueOf(String p1)
    {
        return ((org.webrtc.Logging$TraceLevel) Enum.valueOf(org.webrtc.Logging$TraceLevel, p1));
    }

    public static org.webrtc.Logging$TraceLevel[] values()
    {
        return ((org.webrtc.Logging$TraceLevel[]) org.webrtc.Logging$TraceLevel.$VALUES.clone());
    }
}
