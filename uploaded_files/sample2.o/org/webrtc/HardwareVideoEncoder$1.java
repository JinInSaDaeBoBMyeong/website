package org.webrtc;
 class HardwareVideoEncoder$1 extends java.lang.Thread {
    final synthetic org.webrtc.HardwareVideoEncoder this$0;

    HardwareVideoEncoder$1(org.webrtc.HardwareVideoEncoder p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        while (org.webrtc.HardwareVideoEncoder.access$000(this.this$0)) {
            org.webrtc.HardwareVideoEncoder.access$100(this.this$0);
        }
        org.webrtc.HardwareVideoEncoder.access$200(this.this$0);
        return;
    }
}
