package org.webrtc;
public class Logging {
    private static final java.util.logging.Logger fallbackLogger;
    private static volatile boolean loggingEnabled;
    private static volatile org.webrtc.Logging$NativeLibStatus nativeLibStatus;
    private static volatile boolean tracingEnabled;

    static Logging()
    {
        org.webrtc.Logging.fallbackLogger = org.webrtc.Logging.createFallbackLogger();
        org.webrtc.Logging.nativeLibStatus = org.webrtc.Logging$NativeLibStatus.UNINITIALIZED;
        return;
    }

    public Logging()
    {
        return;
    }

    private static java.util.logging.Logger createFallbackLogger()
    {
        java.util.logging.Logger v0 = java.util.logging.Logger.getLogger("org.webrtc.Logging");
        v0.setLevel(java.util.logging.Level.ALL);
        return v0;
    }

    public static void d(String p1, String p2)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_INFO, p1, p2);
        return;
    }

    public static void e(String p1, String p2)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_ERROR, p1, p2);
        return;
    }

    public static void e(String p2, String p3, Throwable p4)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_ERROR, p2, p3);
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_ERROR, p2, p4.toString());
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_ERROR, p2, org.webrtc.Logging.getStackTraceString(p4));
        return;
    }

    public static void enableLogThreads()
    {
        if (org.webrtc.Logging.loadNativeLibrary()) {
            org.webrtc.Logging.nativeEnableLogThreads();
        } else {
            org.webrtc.Logging.fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable log thread because native lib not loaded.");
        }
        return;
    }

    public static void enableLogTimeStamps()
    {
        if (org.webrtc.Logging.loadNativeLibrary()) {
            org.webrtc.Logging.nativeEnableLogTimeStamps();
        } else {
            org.webrtc.Logging.fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable log timestamps because native lib not loaded.");
        }
        return;
    }

    public static declared_synchronized void enableLogToDebugOutput(org.webrtc.Logging$Severity p4)
    {
        try {
            if (org.webrtc.Logging.loadNativeLibrary()) {
                org.webrtc.Logging.nativeEnableLogToDebugOutput(p4.ordinal());
                org.webrtc.Logging.loggingEnabled = 1;
            } else {
                org.webrtc.Logging.fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable logging because native lib not loaded.");
            }
        } catch (int v0_0) {
            throw v0_0;
        }
        return;
    }

    public static declared_synchronized void enableTracing(String p6, java.util.EnumSet p7)
    {
        try {
            if (org.webrtc.Logging.loadNativeLibrary()) {
                if (!org.webrtc.Logging.tracingEnabled) {
                    int v1 = 0;
                    int v2_5 = p7.iterator();
                    while (v2_5.hasNext()) {
                        v1 |= ((org.webrtc.Logging$TraceLevel) v2_5.next()).level;
                    }
                    org.webrtc.Logging.nativeEnableTracing(p6, v1);
                    org.webrtc.Logging.tracingEnabled = 1;
                }
            } else {
                org.webrtc.Logging.fallbackLogger.log(java.util.logging.Level.WARNING, "Cannot enable tracing because native lib not loaded.");
            }
        } catch (int v2_3) {
            throw v2_3;
        }
        return;
    }

    private static String getStackTraceString(Throwable p3)
    {
        String v2;
        if (p3 != null) {
            java.io.StringWriter v1_1 = new java.io.StringWriter();
            p3.printStackTrace(new java.io.PrintWriter(v1_1));
            v2 = v1_1.toString();
        } else {
            v2 = "";
        }
        return v2;
    }

    private static boolean loadNativeLibrary()
    {
        if (org.webrtc.Logging.nativeLibStatus == org.webrtc.Logging$NativeLibStatus.UNINITIALIZED) {
            try {
                System.loadLibrary("jingle_peerconnection_so");
                org.webrtc.Logging.nativeLibStatus = org.webrtc.Logging$NativeLibStatus.LOADED;
            } catch (UnsatisfiedLinkError v0) {
                org.webrtc.Logging.nativeLibStatus = org.webrtc.Logging$NativeLibStatus.FAILED;
                org.webrtc.Logging.fallbackLogger.log(java.util.logging.Level.WARNING, "Failed to load jingle_peerconnection_so: ", v0);
            }
        }
        int v1_3;
        if (org.webrtc.Logging.nativeLibStatus != org.webrtc.Logging$NativeLibStatus.LOADED) {
            v1_3 = 0;
        } else {
            v1_3 = 1;
        }
        return v1_3;
    }

    public static void log(org.webrtc.Logging$Severity p4, String p5, String p6)
    {
        if (!org.webrtc.Logging.loggingEnabled) {
            java.util.logging.Level v0;
            switch (org.webrtc.Logging$1.$SwitchMap$org$webrtc$Logging$Severity[p4.ordinal()]) {
                case 1:
                    v0 = java.util.logging.Level.SEVERE;
                    break;
                case 2:
                    v0 = java.util.logging.Level.WARNING;
                    break;
                case 3:
                    v0 = java.util.logging.Level.INFO;
                    break;
                default:
                    v0 = java.util.logging.Level.FINE;
            }
            org.webrtc.Logging.fallbackLogger.log(v0, new StringBuilder().append(p5).append(": ").append(p6).toString());
        } else {
            org.webrtc.Logging.nativeLog(p4.ordinal(), p5, p6);
        }
        return;
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput();

    private static native void nativeEnableTracing();

    private static native void nativeLog();

    public static void v(String p1, String p2)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_VERBOSE, p1, p2);
        return;
    }

    public static void w(String p1, String p2)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_WARNING, p1, p2);
        return;
    }

    public static void w(String p2, String p3, Throwable p4)
    {
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_WARNING, p2, p3);
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_WARNING, p2, p4.toString());
        org.webrtc.Logging.log(org.webrtc.Logging$Severity.LS_WARNING, p2, org.webrtc.Logging.getStackTraceString(p4));
        return;
    }
}
