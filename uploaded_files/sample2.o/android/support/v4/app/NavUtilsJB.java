package android.support.v4.app;
 class NavUtilsJB {

    NavUtilsJB()
    {
        return;
    }

    public static android.content.Intent getParentActivityIntent(android.app.Activity p1)
    {
        return p1.getParentActivityIntent();
    }

    public static String getParentActivityName(android.content.pm.ActivityInfo p1)
    {
        return p1.parentActivityName;
    }

    public static void navigateUpTo(android.app.Activity p0, android.content.Intent p1)
    {
        p0.navigateUpTo(p1);
        return;
    }

    public static boolean shouldUpRecreateTask(android.app.Activity p1, android.content.Intent p2)
    {
        return p1.shouldUpRecreateTask(p2);
    }
}
