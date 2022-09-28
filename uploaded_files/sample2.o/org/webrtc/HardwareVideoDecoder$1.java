package org.webrtc;
 class HardwareVideoDecoder$1 extends java.lang.Thread {
    final synthetic org.webrtc.HardwareVideoDecoder this$0;

    HardwareVideoDecoder$1(org.webrtc.HardwareVideoDecoder p1, String p2)
    {
        this.this$0 = p1;
        super(p2);
        return;
    }

    public void run()
    {
        org.webrtc.HardwareVideoDecoder.access$002(this.this$0, new org.webrtc.ThreadUtils$ThreadChecker());
        while (org.webrtc.HardwareVideoDecoder.access$100(this.this$0)) {
            org.webrtc.HardwareVideoDecoder.access$200(this.this$0);
        }
        org.webrtc.HardwareVideoDecoder.access$300(this.this$0);
        return;
    }
}
