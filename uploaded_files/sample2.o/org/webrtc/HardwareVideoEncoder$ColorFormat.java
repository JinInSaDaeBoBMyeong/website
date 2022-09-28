package org.webrtc;
abstract enum class HardwareVideoEncoder$ColorFormat extends java.lang.Enum {
    private static final synthetic org.webrtc.HardwareVideoEncoder$ColorFormat[] $VALUES;
    public static final enum org.webrtc.HardwareVideoEncoder$ColorFormat I420;
    public static final enum org.webrtc.HardwareVideoEncoder$ColorFormat NV12;

    static HardwareVideoEncoder$ColorFormat()
    {
        org.webrtc.HardwareVideoEncoder$ColorFormat.I420 = new org.webrtc.HardwareVideoEncoder$ColorFormat$1("I420", 0);
        org.webrtc.HardwareVideoEncoder$ColorFormat.NV12 = new org.webrtc.HardwareVideoEncoder$ColorFormat$2("NV12", 1);
        org.webrtc.HardwareVideoEncoder$ColorFormat[] v0_1 = new org.webrtc.HardwareVideoEncoder$ColorFormat[2];
        v0_1[0] = org.webrtc.HardwareVideoEncoder$ColorFormat.I420;
        v0_1[1] = org.webrtc.HardwareVideoEncoder$ColorFormat.NV12;
        org.webrtc.HardwareVideoEncoder$ColorFormat.$VALUES = v0_1;
        return;
    }

    private HardwareVideoEncoder$ColorFormat(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    synthetic HardwareVideoEncoder$ColorFormat(String p1, int p2, org.webrtc.HardwareVideoEncoder$1 p3)
    {
        this(p1, p2);
        return;
    }

    static org.webrtc.HardwareVideoEncoder$ColorFormat valueOf(int p3)
    {
        org.webrtc.HardwareVideoEncoder$ColorFormat v0_0;
        switch (p3) {
            case 19:
                v0_0 = org.webrtc.HardwareVideoEncoder$ColorFormat.I420;
                break;
            case 21:
            case 2141391872:
            case 2141391876:
                v0_0 = org.webrtc.HardwareVideoEncoder$ColorFormat.NV12;
                break;
            default:
                throw new IllegalArgumentException(new StringBuilder().append("Unsupported colorFormat: ").append(p3).toString());
        }
        return v0_0;
    }

    public static org.webrtc.HardwareVideoEncoder$ColorFormat valueOf(String p1)
    {
        return ((org.webrtc.HardwareVideoEncoder$ColorFormat) Enum.valueOf(org.webrtc.HardwareVideoEncoder$ColorFormat, p1));
    }

    public static org.webrtc.HardwareVideoEncoder$ColorFormat[] values()
    {
        return ((org.webrtc.HardwareVideoEncoder$ColorFormat[]) org.webrtc.HardwareVideoEncoder$ColorFormat.$VALUES.clone());
    }

    abstract void fillBufferFromI420();
}
