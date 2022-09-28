package org.webrtc;
public class PeerConnection$RTCConfiguration {
    public boolean audioJitterBufferFastAccelerate;
    public int audioJitterBufferMaxPackets;
    public org.webrtc.PeerConnection$BundlePolicy bundlePolicy;
    public org.webrtc.PeerConnection$CandidateNetworkPolicy candidateNetworkPolicy;
    public org.webrtc.PeerConnection$ContinualGatheringPolicy continualGatheringPolicy;
    public boolean disableIPv6OnWifi;
    public int iceBackupCandidatePairPingInterval;
    public int iceCandidatePoolSize;
    public Integer iceCheckMinInterval;
    public int iceConnectionReceivingTimeout;
    public java.util.List iceServers;
    public org.webrtc.PeerConnection$IceTransportsType iceTransportsType;
    public org.webrtc.PeerConnection$KeyType keyType;
    public boolean presumeWritableWhenFullyRelayed;
    public boolean pruneTurnPorts;
    public org.webrtc.PeerConnection$RtcpMuxPolicy rtcpMuxPolicy;
    public org.webrtc.PeerConnection$TcpCandidatePolicy tcpCandidatePolicy;

    public PeerConnection$RTCConfiguration(java.util.List p4)
    {
        this.iceTransportsType = org.webrtc.PeerConnection$IceTransportsType.ALL;
        this.bundlePolicy = org.webrtc.PeerConnection$BundlePolicy.BALANCED;
        this.rtcpMuxPolicy = org.webrtc.PeerConnection$RtcpMuxPolicy.REQUIRE;
        this.tcpCandidatePolicy = org.webrtc.PeerConnection$TcpCandidatePolicy.ENABLED;
        this.candidateNetworkPolicy = org.webrtc.PeerConnection$CandidateNetworkPolicy.ALL;
        this.iceServers = p4;
        this.audioJitterBufferMaxPackets = 50;
        this.audioJitterBufferFastAccelerate = 0;
        this.iceConnectionReceivingTimeout = -1;
        this.iceBackupCandidatePairPingInterval = -1;
        this.keyType = org.webrtc.PeerConnection$KeyType.ECDSA;
        this.continualGatheringPolicy = org.webrtc.PeerConnection$ContinualGatheringPolicy.GATHER_ONCE;
        this.iceCandidatePoolSize = 0;
        this.pruneTurnPorts = 0;
        this.presumeWritableWhenFullyRelayed = 0;
        this.iceCheckMinInterval = 0;
        this.disableIPv6OnWifi = 0;
        return;
    }
}
