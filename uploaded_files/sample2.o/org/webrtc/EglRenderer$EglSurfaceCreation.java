package org.webrtc;
 class EglRenderer$EglSurfaceCreation implements java.lang.Runnable {
    private Object surface;
    final synthetic org.webrtc.EglRenderer this$0;

    private EglRenderer$EglSurfaceCreation(org.webrtc.EglRenderer p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic EglRenderer$EglSurfaceCreation(org.webrtc.EglRenderer p1, org.webrtc.EglRenderer$1 p2)
    {
        this(p1);
        return;
    }

    public declared_synchronized void run()
    {
        try {
            if ((this.surface != null) && ((org.webrtc.EglRenderer.access$000(this.this$0) != null) && (!org.webrtc.EglRenderer.access$000(this.this$0).hasSurface()))) {
                if (!(this.surface instanceof android.view.Surface)) {
                    if (!(this.surface instanceof android.graphics.SurfaceTexture)) {
                        throw new IllegalStateException(new StringBuilder().append("Invalid surface: ").append(this.surface).toString());
                    } else {
                        org.webrtc.EglRenderer.access$000(this.this$0).createSurface(((android.graphics.SurfaceTexture) this.surface));
                    }
                } else {
                    org.webrtc.EglRenderer.access$000(this.this$0).createSurface(((android.view.Surface) this.surface));
                }
                org.webrtc.EglRenderer.access$000(this.this$0).makeCurrent();
                android.opengl.GLES20.glPixelStorei(3317, 1);
            }
        } catch (IllegalStateException v0_19) {
            throw v0_19;
        }
        return;
    }

    public declared_synchronized void setSurface(Object p2)
    {
        try {
            this.surface = p2;
            return;
        } catch (Throwable v0) {
            throw v0;
        }
    }
}
