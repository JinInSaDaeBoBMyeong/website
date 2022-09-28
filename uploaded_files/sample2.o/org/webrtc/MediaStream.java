package org.webrtc;
public class MediaStream {
    public final java.util.LinkedList audioTracks;
    final long nativeStream;
    public final java.util.LinkedList preservedVideoTracks;
    public final java.util.LinkedList videoTracks;

    public MediaStream(long p2)
    {
        this.audioTracks = new java.util.LinkedList();
        this.videoTracks = new java.util.LinkedList();
        this.preservedVideoTracks = new java.util.LinkedList();
        this.nativeStream = p2;
        return;
    }

    private static native void free();

    private static native boolean nativeAddAudioTrack();

    private static native boolean nativeAddVideoTrack();

    private static native String nativeLabel();

    private static native boolean nativeRemoveAudioTrack();

    private static native boolean nativeRemoveVideoTrack();

    public boolean addPreservedTrack(org.webrtc.VideoTrack p5)
    {
        int v0_2;
        if (!org.webrtc.MediaStream.nativeAddVideoTrack(this.nativeStream, p5.nativeTrack)) {
            v0_2 = 0;
        } else {
            this.preservedVideoTracks.add(p5);
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean addTrack(org.webrtc.AudioTrack p5)
    {
        int v0_2;
        if (!org.webrtc.MediaStream.nativeAddAudioTrack(this.nativeStream, p5.nativeTrack)) {
            v0_2 = 0;
        } else {
            this.audioTracks.add(p5);
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean addTrack(org.webrtc.VideoTrack p5)
    {
        int v0_2;
        if (!org.webrtc.MediaStream.nativeAddVideoTrack(this.nativeStream, p5.nativeTrack)) {
            v0_2 = 0;
        } else {
            this.videoTracks.add(p5);
            v0_2 = 1;
        }
        return v0_2;
    }

    public void dispose()
    {
        while (!this.audioTracks.isEmpty()) {
            org.webrtc.VideoTrack v0_3 = ((org.webrtc.AudioTrack) this.audioTracks.getFirst());
            this.removeTrack(v0_3);
            v0_3.dispose();
        }
        while (!this.videoTracks.isEmpty()) {
            org.webrtc.VideoTrack v0_1 = ((org.webrtc.VideoTrack) this.videoTracks.getFirst());
            this.removeTrack(v0_1);
            v0_1.dispose();
        }
        while (!this.preservedVideoTracks.isEmpty()) {
            this.removeTrack(((org.webrtc.VideoTrack) this.preservedVideoTracks.getFirst()));
        }
        org.webrtc.MediaStream.free(this.nativeStream);
        return;
    }

    public String label()
    {
        return org.webrtc.MediaStream.nativeLabel(this.nativeStream);
    }

    public boolean removeTrack(org.webrtc.AudioTrack p5)
    {
        this.audioTracks.remove(p5);
        return org.webrtc.MediaStream.nativeRemoveAudioTrack(this.nativeStream, p5.nativeTrack);
    }

    public boolean removeTrack(org.webrtc.VideoTrack p5)
    {
        this.videoTracks.remove(p5);
        this.preservedVideoTracks.remove(p5);
        return org.webrtc.MediaStream.nativeRemoveVideoTrack(this.nativeStream, p5.nativeTrack);
    }

    public String toString()
    {
        return new StringBuilder().append("[").append(this.label()).append(":A=").append(this.audioTracks.size()).append(":V=").append(this.videoTracks.size()).append("]").toString();
    }
}
