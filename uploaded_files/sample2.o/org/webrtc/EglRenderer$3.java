package org.webrtc;
 class EglRenderer$3 implements java.lang.Runnable {
    final synthetic org.webrtc.EglRenderer this$0;
    final synthetic int[] val$configAttributes;
    final synthetic org.webrtc.EglBase$Context val$sharedContext;

    EglRenderer$3(org.webrtc.EglRenderer p1, org.webrtc.EglBase$Context p2, int[] p3)
    {
        this.this$0 = p1;
        this.val$sharedContext = p2;
        this.val$configAttributes = p3;
        return;
    }

    public void run()
    {
        if (this.val$sharedContext != null) {
            org.webrtc.EglRenderer.access$700(this.this$0, "EglBase.create shared context");
            org.webrtc.EglRenderer.access$002(this.this$0, org.webrtc.EglBase.create(this.val$sharedContext, this.val$configAttributes));
        } else {
            org.webrtc.EglRenderer.access$700(this.this$0, "EglBase10.create context");
            org.webrtc.EglRenderer.access$002(this.this$0, org.webrtc.EglBase.createEgl10(this.val$configAttributes));
        }
        return;
    }
}
