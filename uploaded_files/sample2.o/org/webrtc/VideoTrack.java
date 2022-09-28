package org.webrtc;
public class VideoTrack extends org.webrtc.MediaStreamTrack {
    private final java.util.LinkedList renderers;

    public VideoTrack(long p2)
    {
        super(p2);
        super.renderers = new java.util.LinkedList();
        return;
    }

    private static native void nativeAddRenderer();

    private static native void nativeRemoveRenderer();

    public void addRenderer(org.webrtc.VideoRenderer p5)
    {
        this.renderers.add(p5);
        org.webrtc.VideoTrack.nativeAddRenderer(this.nativeTrack, p5.nativeVideoRenderer);
        return;
    }

    public void dispose()
    {
        while (!this.renderers.isEmpty()) {
            this.removeRenderer(((org.webrtc.VideoRenderer) this.renderers.getFirst()));
        }
        super.dispose();
        return;
    }

    public void removeRenderer(org.webrtc.VideoRenderer p5)
    {
        if (this.renderers.remove(p5)) {
            org.webrtc.VideoTrack.nativeRemoveRenderer(this.nativeTrack, p5.nativeVideoRenderer);
            p5.dispose();
        }
        return;
    }
}
