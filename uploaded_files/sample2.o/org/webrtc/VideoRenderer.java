package org.webrtc;
public class VideoRenderer {
    long nativeVideoRenderer;

    public VideoRenderer(org.webrtc.VideoRenderer$Callbacks p3)
    {
        this.nativeVideoRenderer = org.webrtc.VideoRenderer.nativeWrapVideoRenderer(p3);
        return;
    }

    private static native void freeWrappedVideoRenderer();

    public static native void nativeCopyPlane();

    private static native long nativeWrapVideoRenderer();

    private static native void releaseNativeFrame();

    public static void renderFrameDone(org.webrtc.VideoRenderer$I420Frame p4)
    {
        p4.yuvPlanes = 0;
        p4.textureId = 0;
        if (org.webrtc.VideoRenderer$I420Frame.access$000(p4) != 0) {
            org.webrtc.VideoRenderer.releaseNativeFrame(org.webrtc.VideoRenderer$I420Frame.access$000(p4));
            org.webrtc.VideoRenderer$I420Frame.access$002(p4, 0);
        }
        return;
    }

    public void dispose()
    {
        if (this.nativeVideoRenderer != 0) {
            org.webrtc.VideoRenderer.freeWrappedVideoRenderer(this.nativeVideoRenderer);
            this.nativeVideoRenderer = 0;
        }
        return;
    }
}
