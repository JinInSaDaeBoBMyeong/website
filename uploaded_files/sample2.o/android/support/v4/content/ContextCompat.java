package android.support.v4.content;
public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";

    public ContextCompat()
    {
        return;
    }

    private static varargs java.io.File buildPath(java.io.File p6, String[] p7)
    {
        int v4 = p7.length;
        int v3 = 0;
        java.io.File v2 = p6;
        while (v3 < v4) {
            java.io.File v1_1;
            String v5 = p7[v3];
            if (v2 != null) {
                if (v5 == null) {
                    v1_1 = v2;
                } else {
                    v1_1 = new java.io.File(v2, v5);
                }
            } else {
                v1_1 = new java.io.File(v5);
            }
            v3++;
            v2 = v1_1;
        }
        return v2;
    }

    public static java.io.File[] getExternalCacheDirs(android.content.Context p8)
    {
        java.io.File[] v2_0;
        int v1 = android.os.Build$VERSION.SDK_INT;
        if (v1 < 19) {
            java.io.File v0;
            if (v1 < 8) {
                java.io.File[] v2_3 = android.os.Environment.getExternalStorageDirectory();
                String[] v3_0 = new String[4];
                v3_0[0] = "Android";
                v3_0[1] = "data";
                v3_0[2] = p8.getPackageName();
                v3_0[3] = "cache";
                v0 = android.support.v4.content.ContextCompat.buildPath(v2_3, v3_0);
            } else {
                v0 = android.support.v4.content.ContextCompatFroyo.getExternalCacheDir(p8);
            }
            v2_0 = new java.io.File[1];
            v2_0[0] = v0;
        } else {
            v2_0 = android.support.v4.content.ContextCompatKitKat.getExternalCacheDirs(p8);
        }
        return v2_0;
    }

    public static java.io.File[] getExternalFilesDirs(android.content.Context p8, String p9)
    {
        java.io.File[] v2_0;
        int v1 = android.os.Build$VERSION.SDK_INT;
        if (v1 < 19) {
            java.io.File v0;
            if (v1 < 8) {
                java.io.File[] v2_3 = android.os.Environment.getExternalStorageDirectory();
                String[] v3_0 = new String[5];
                v3_0[0] = "Android";
                v3_0[1] = "data";
                v3_0[2] = p8.getPackageName();
                v3_0[3] = "files";
                v3_0[4] = p9;
                v0 = android.support.v4.content.ContextCompat.buildPath(v2_3, v3_0);
            } else {
                v0 = android.support.v4.content.ContextCompatFroyo.getExternalFilesDir(p8, p9);
            }
            v2_0 = new java.io.File[1];
            v2_0[0] = v0;
        } else {
            v2_0 = android.support.v4.content.ContextCompatKitKat.getExternalFilesDirs(p8, p9);
        }
        return v2_0;
    }

    public static java.io.File[] getObbDirs(android.content.Context p8)
    {
        java.io.File[] v2_0;
        int v1 = android.os.Build$VERSION.SDK_INT;
        if (v1 < 19) {
            java.io.File v0;
            if (v1 < 11) {
                java.io.File[] v2_3 = android.os.Environment.getExternalStorageDirectory();
                String[] v3_0 = new String[3];
                v3_0[0] = "Android";
                v3_0[1] = "obb";
                v3_0[2] = p8.getPackageName();
                v0 = android.support.v4.content.ContextCompat.buildPath(v2_3, v3_0);
            } else {
                v0 = android.support.v4.content.ContextCompatHoneycomb.getObbDir(p8);
            }
            v2_0 = new java.io.File[1];
            v2_0[0] = v0;
        } else {
            v2_0 = android.support.v4.content.ContextCompatKitKat.getObbDirs(p8);
        }
        return v2_0;
    }

    public static boolean startActivities(android.content.Context p1, android.content.Intent[] p2)
    {
        return android.support.v4.content.ContextCompat.startActivities(p1, p2, 0);
    }

    public static boolean startActivities(android.content.Context p3, android.content.Intent[] p4, android.os.Bundle p5)
    {
        int v1 = 1;
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 16) {
            if (v0 < 11) {
                v1 = 0;
            } else {
                android.support.v4.content.ContextCompatHoneycomb.startActivities(p3, p4);
            }
        } else {
            android.support.v4.content.ContextCompatJellybean.startActivities(p3, p4, p5);
        }
        return v1;
    }
}
