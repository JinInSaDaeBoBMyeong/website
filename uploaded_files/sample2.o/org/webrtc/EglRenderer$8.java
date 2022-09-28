package org.webrtc;
 class EglRenderer$8 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic Runnable val$completionCallback;

    EglRenderer$8(org.webrtc.EglRenderer p1, Runnable p2)
    {
        this.this$0 = p1;
        this.val$completionCallback = p2;
        return;
    }

    public void run()
    {
        if (org.webrtc.EglRenderer.access$000(this.this$0) != null) {
            org.webrtc.EglRenderer.access$000(this.this$0).detachCurrent();
            org.webrtc.EglRenderer.access$000(this.this$0).releaseSurface();
        }
        this.val$completionCallback.run();
        return;
    }
}
