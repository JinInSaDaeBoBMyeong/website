package org.webrtc;
synthetic class Logging$1 {
    static final synthetic int[] $SwitchMap$org$webrtc$Logging$Severity;

    static Logging$1()
    {
        NoSuchFieldError v0_4 = new int[org.webrtc.Logging$Severity.values().length];
        org.webrtc.Logging$1.$SwitchMap$org$webrtc$Logging$Severity = v0_4;
        try {
            org.webrtc.Logging$Severity.LS_ERROR.ordinal()[int v1_5] = 1;
            try {
                org.webrtc.Logging$Severity.LS_WARNING.ordinal()[int v1_1] = 2;
                try {
                    org.webrtc.Logging$Severity.LS_INFO.ordinal()[int v1_3] = 3;
                } catch (NoSuchFieldError v0) {
                }
                return;
            } catch (NoSuchFieldError v0) {
            }
        } catch (NoSuchFieldError v0) {
        }
    }
}
