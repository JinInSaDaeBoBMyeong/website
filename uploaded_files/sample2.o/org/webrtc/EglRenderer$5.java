package org.webrtc;
 class EglRenderer$5 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic android.os.Looper val$renderLooper;

    EglRenderer$5(org.webrtc.EglRenderer p1, android.os.Looper p2)
    {
        this.this$0 = p1;
        this.val$renderLooper = p2;
        return;
    }

    public void run()
    {
        org.webrtc.EglRenderer.access$700(this.this$0, "Quitting render thread.");
        this.val$renderLooper.quit();
        return;
    }
}
