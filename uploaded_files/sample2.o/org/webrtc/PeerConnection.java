package org.webrtc;
public class PeerConnection {
    private final java.util.List localStreams;
    private final long nativeObserver;
    private final long nativePeerConnection;
    private java.util.List receivers;
    private java.util.List senders;

    static PeerConnection()
    {
        System.loadLibrary("jingle_peerconnection_so");
        return;
    }

    PeerConnection(long p2, long p4)
    {
        this.nativePeerConnection = p2;
        this.nativeObserver = p4;
        this.localStreams = new java.util.LinkedList();
        this.senders = new java.util.LinkedList();
        this.receivers = new java.util.LinkedList();
        return;
    }

    private static native void freeObserver();

    private static native void freePeerConnection();

    private native boolean nativeAddIceCandidate();

    private native boolean nativeAddLocalStream();

    private native org.webrtc.RtpSender nativeCreateSender();

    private native java.util.List nativeGetReceivers();

    private native java.util.List nativeGetSenders();

    private native void nativeNewGetStats();

    private native boolean nativeOldGetStats();

    private native boolean nativeRemoveIceCandidates();

    private native void nativeRemoveLocalStream();

    private native boolean nativeStartRtcEventLog();

    private native void nativeStopRtcEventLog();

    public boolean addIceCandidate(org.webrtc.IceCandidate p4)
    {
        return this.nativeAddIceCandidate(p4.sdpMid, p4.sdpMLineIndex, p4.sdp);
    }

    public boolean addStream(org.webrtc.MediaStream p5)
    {
        int v1_1;
        if (this.nativeAddLocalStream(p5.nativeStream)) {
            this.localStreams.add(p5);
            v1_1 = 1;
        } else {
            v1_1 = 0;
        }
        return v1_1;
    }

    public native void close();

    public native void createAnswer();

    public native org.webrtc.DataChannel createDataChannel();

    public native void createOffer();

    public org.webrtc.RtpSender createSender(String p3, String p4)
    {
        org.webrtc.RtpSender v0 = this.nativeCreateSender(p3, p4);
        if (v0 != null) {
            this.senders.add(v0);
        }
        return v0;
    }

    public void dispose()
    {
        this.close();
        java.util.List v3_6 = this.localStreams.iterator();
        while (v3_6.hasNext()) {
            org.webrtc.MediaStream v2_1 = ((org.webrtc.MediaStream) v3_6.next());
            this.nativeRemoveLocalStream(v2_1.nativeStream);
            v2_1.dispose();
        }
        this.localStreams.clear();
        java.util.List v3_1 = this.senders.iterator();
        while (v3_1.hasNext()) {
            ((org.webrtc.RtpSender) v3_1.next()).dispose();
        }
        this.senders.clear();
        java.util.List v3_4 = this.receivers.iterator();
        while (v3_4.hasNext()) {
            ((org.webrtc.RtpReceiver) v3_4.next()).dispose();
        }
        this.receivers.clear();
        org.webrtc.PeerConnection.freePeerConnection(this.nativePeerConnection);
        org.webrtc.PeerConnection.freeObserver(this.nativeObserver);
        return;
    }

    public native org.webrtc.SessionDescription getLocalDescription();

    public java.util.List getReceivers()
    {
        java.util.List v1_2 = this.receivers.iterator();
        while (v1_2.hasNext()) {
            ((org.webrtc.RtpReceiver) v1_2.next()).dispose();
        }
        this.receivers = this.nativeGetReceivers();
        return java.util.Collections.unmodifiableList(this.receivers);
    }

    public native org.webrtc.SessionDescription getRemoteDescription();

    public java.util.List getSenders()
    {
        java.util.List v1_2 = this.senders.iterator();
        while (v1_2.hasNext()) {
            ((org.webrtc.RtpSender) v1_2.next()).dispose();
        }
        this.senders = this.nativeGetSenders();
        return java.util.Collections.unmodifiableList(this.senders);
    }

    public void getStats(org.webrtc.RTCStatsCollectorCallback p1)
    {
        this.nativeNewGetStats(p1);
        return;
    }

    public boolean getStats(org.webrtc.StatsObserver p3, org.webrtc.MediaStreamTrack p4)
    {
        boolean v0_0;
        if (p4 != null) {
            v0_0 = p4.nativeTrack;
        } else {
            v0_0 = 0;
        }
        return this.nativeOldGetStats(p3, v0_0);
    }

    public native org.webrtc.PeerConnection$IceConnectionState iceConnectionState();

    public native org.webrtc.PeerConnection$IceGatheringState iceGatheringState();

    public native boolean nativeSetConfiguration();

    public boolean removeIceCandidates(org.webrtc.IceCandidate[] p2)
    {
        return this.nativeRemoveIceCandidates(p2);
    }

    public void removeStream(org.webrtc.MediaStream p3)
    {
        this.nativeRemoveLocalStream(p3.nativeStream);
        this.localStreams.remove(p3);
        return;
    }

    public boolean setConfiguration(org.webrtc.PeerConnection$RTCConfiguration p3)
    {
        return this.nativeSetConfiguration(p3, this.nativeObserver);
    }

    public native void setLocalDescription();

    public native void setRemoteDescription();

    public native org.webrtc.PeerConnection$SignalingState signalingState();

    public boolean startRtcEventLog(int p2, int p3)
    {
        return this.nativeStartRtcEventLog(p2, p3);
    }

    public void stopRtcEventLog()
    {
        this.nativeStopRtcEventLog();
        return;
    }
}
