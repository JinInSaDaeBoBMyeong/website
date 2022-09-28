package org.webrtc;
public class ContextUtils {
    private static final String TAG = "ContextUtils";
    private static android.content.Context applicationContext;

    public ContextUtils()
    {
        return;
    }

    public static android.content.Context getApplicationContext()
    {
        return org.webrtc.ContextUtils.applicationContext;
    }

    public static void initialize(android.content.Context p2)
    {
        if (org.webrtc.ContextUtils.applicationContext != null) {
            org.webrtc.Logging.e("ContextUtils", "Calling ContextUtils.initialize multiple times, this will crash in the future!");
        }
        if (p2 != null) {
            org.webrtc.ContextUtils.applicationContext = p2;
            return;
        } else {
            throw new RuntimeException("Application context cannot be null for ContextUtils.initialize.");
        }
    }
}
