package android.support.v4.app;
 class ActivityCompatHoneycomb {

    ActivityCompatHoneycomb()
    {
        return;
    }

    static void dump(android.app.Activity p0, String p1, java.io.FileDescriptor p2, java.io.PrintWriter p3, String[] p4)
    {
        p0.dump(p1, p2, p3, p4);
        return;
    }

    static void invalidateOptionsMenu(android.app.Activity p0)
    {
        p0.invalidateOptionsMenu();
        return;
    }
}
