package android.support.v4.content;
 class ContextCompatFroyo {

    ContextCompatFroyo()
    {
        return;
    }

    public static java.io.File getExternalCacheDir(android.content.Context p1)
    {
        return p1.getExternalCacheDir();
    }

    public static java.io.File getExternalFilesDir(android.content.Context p1, String p2)
    {
        return p1.getExternalFilesDir(p2);
    }
}
