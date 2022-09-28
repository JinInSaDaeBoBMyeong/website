package org.webrtc;
final enum class HardwareVideoEncoder$ColorFormat$1 extends org.webrtc.HardwareVideoEncoder$ColorFormat {

    HardwareVideoEncoder$ColorFormat$1(String p2, int p3)
    {
        super(p2, p3, 0);
        return;
    }

    void fillBufferFromI420(java.nio.ByteBuffer p2, org.webrtc.VideoFrame$I420Buffer p3)
    {
        p2.put(p3.getDataY());
        p2.put(p3.getDataU());
        p2.put(p3.getDataV());
        return;
    }
}
