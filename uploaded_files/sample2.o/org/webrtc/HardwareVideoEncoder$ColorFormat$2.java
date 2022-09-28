package org.webrtc;
final enum class HardwareVideoEncoder$ColorFormat$2 extends org.webrtc.HardwareVideoEncoder$ColorFormat {

    HardwareVideoEncoder$ColorFormat$2(String p2, int p3)
    {
        super(p2, p3, 0);
        return;
    }

    void fillBufferFromI420(java.nio.ByteBuffer p5, org.webrtc.VideoFrame$I420Buffer p6)
    {
        p5.put(p6.getDataY());
        java.nio.ByteBuffer v1 = p6.getDataU();
        java.nio.ByteBuffer v2 = p6.getDataV();
        while ((v1.hasRemaining()) && (v2.hasRemaining())) {
            p5.put(v1.get());
            p5.put(v2.get());
        }
        return;
    }
}
