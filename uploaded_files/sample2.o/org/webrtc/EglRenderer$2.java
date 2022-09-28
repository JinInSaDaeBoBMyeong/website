package org.webrtc;
 class EglRenderer$2 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;

    EglRenderer$2(org.webrtc.EglRenderer p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        org.webrtc.EglRenderer.access$200(this.this$0);
        org.webrtc.EglRenderer.access$300(this.this$0);
        try {
            if (org.webrtc.EglRenderer.access$400(this.this$0) != null) {
                org.webrtc.EglRenderer.access$400(this.this$0).removeCallbacks(org.webrtc.EglRenderer.access$500(this.this$0));
                org.webrtc.EglRenderer.access$400(this.this$0).postDelayed(org.webrtc.EglRenderer.access$500(this.this$0), java.util.concurrent.TimeUnit.SECONDS.toMillis(4));
            }
        } catch (android.os.Handler v0_5) {
            throw v0_5;
        }
        return;
    }
}
