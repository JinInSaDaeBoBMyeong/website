package android.support.v4.os;
public class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public EnvironmentCompat()
    {
        return;
    }

    public static String getStorageState(java.io.File p7)
    {
        String v4_3;
        if (android.os.Build$VERSION.SDK_INT < 19) {
            try {
                if (p7.getCanonicalPath().startsWith(android.os.Environment.getExternalStorageDirectory().getCanonicalPath())) {
                    v4_3 = android.os.Environment.getExternalStorageState();
                    return v4_3;
                }
            } catch (java.io.IOException v2) {
                android.util.Log.w("EnvironmentCompat", new StringBuilder().append("Failed to resolve canonical path: ").append(v2).toString());
            }
            v4_3 = "unknown";
        } else {
            v4_3 = android.support.v4.os.EnvironmentCompatKitKat.getStorageState(p7);
        }
        return v4_3;
    }
}
