package android.support.v4.content;
 class ContextCompatKitKat {

    ContextCompatKitKat()
    {
        return;
    }

    public static java.io.File[] getExternalCacheDirs(android.content.Context p1)
    {
        return p1.getExternalCacheDirs();
    }

    public static java.io.File[] getExternalFilesDirs(android.content.Context p1, String p2)
    {
        return p1.getExternalFilesDirs(p2);
    }

    public static java.io.File[] getObbDirs(android.content.Context p1)
    {
        return p1.getObbDirs();
    }
}
