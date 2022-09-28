package org.webrtc;
 class EglRenderer$9 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic float val$a;
    final synthetic float val$b;
    final synthetic float val$g;
    final synthetic float val$r;

    EglRenderer$9(org.webrtc.EglRenderer p1, float p2, float p3, float p4, float p5)
    {
        this.this$0 = p1;
        this.val$r = p2;
        this.val$g = p3;
        this.val$b = p4;
        this.val$a = p5;
        return;
    }

    public void run()
    {
        org.webrtc.EglRenderer.access$1200(this.this$0, this.val$r, this.val$g, this.val$b, this.val$a);
        return;
    }
}
