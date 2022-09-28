package android.support.v4.content;
 class ContextCompatHoneycomb {

    ContextCompatHoneycomb()
    {
        return;
    }

    public static java.io.File getObbDir(android.content.Context p1)
    {
        return p1.getObbDir();
    }

    static void startActivities(android.content.Context p0, android.content.Intent[] p1)
    {
        p0.startActivities(p1);
        return;
    }
}
