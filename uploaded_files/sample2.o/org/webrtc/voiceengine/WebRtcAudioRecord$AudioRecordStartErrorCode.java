package org.webrtc.voiceengine;
public final enum class WebRtcAudioRecord$AudioRecordStartErrorCode extends java.lang.Enum {
    private static final synthetic org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode[] $VALUES;
    public static final enum org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode AUDIO_RECORD_START_EXCEPTION;
    public static final enum org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode AUDIO_RECORD_START_STATE_MISMATCH;

    static WebRtcAudioRecord$AudioRecordStartErrorCode()
    {
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION = new org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode("AUDIO_RECORD_START_EXCEPTION", 0);
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH = new org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode("AUDIO_RECORD_START_STATE_MISMATCH", 1);
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode[] v0_1 = new org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode[2];
        v0_1[0] = org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
        v0_1[1] = org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
        org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.$VALUES = v0_1;
        return;
    }

    private WebRtcAudioRecord$AudioRecordStartErrorCode(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode valueOf(String p1)
    {
        return ((org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode) Enum.valueOf(org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode, p1));
    }

    public static org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode[] values()
    {
        return ((org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode[]) org.webrtc.voiceengine.WebRtcAudioRecord$AudioRecordStartErrorCode.$VALUES.clone());
    }
}
