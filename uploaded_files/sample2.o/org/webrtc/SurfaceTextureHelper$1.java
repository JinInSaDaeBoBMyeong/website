package org.webrtc;
final class SurfaceTextureHelper$1 implements java.util.concurrent.Callable {
    final synthetic android.os.Handler val$handler;
    final synthetic org.webrtc.EglBase$Context val$sharedContext;
    final synthetic String val$threadName;

    SurfaceTextureHelper$1(org.webrtc.EglBase$Context p1, android.os.Handler p2, String p3)
    {
        this.val$sharedContext = p1;
        this.val$handler = p2;
        this.val$threadName = p3;
        return;
    }

    public bridge synthetic Object call()
    {
        return this.call();
    }

    public org.webrtc.SurfaceTextureHelper call()
    {
        try {
            int v1_1 = new org.webrtc.SurfaceTextureHelper(this.val$sharedContext, this.val$handler, 0);
        } catch (RuntimeException v0) {
            org.webrtc.Logging.e("SurfaceTextureHelper", new StringBuilder().append(this.val$threadName).append(" create failure").toString(), v0);
            v1_1 = 0;
        }
        return v1_1;
    }
}
