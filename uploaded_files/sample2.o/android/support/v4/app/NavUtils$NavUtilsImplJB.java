package android.support.v4.app;
 class NavUtils$NavUtilsImplJB extends android.support.v4.app.NavUtils$NavUtilsImplBase {

    NavUtils$NavUtilsImplJB()
    {
        return;
    }

    public android.content.Intent getParentActivityIntent(android.app.Activity p2)
    {
        android.content.Intent v0 = android.support.v4.app.NavUtilsJB.getParentActivityIntent(p2);
        if (v0 == null) {
            v0 = this.superGetParentActivityIntent(p2);
        }
        return v0;
    }

    public String getParentActivityName(android.content.Context p2, android.content.pm.ActivityInfo p3)
    {
        String v0 = android.support.v4.app.NavUtilsJB.getParentActivityName(p3);
        if (v0 == null) {
            v0 = super.getParentActivityName(p2, p3);
        }
        return v0;
    }

    public void navigateUpTo(android.app.Activity p1, android.content.Intent p2)
    {
        android.support.v4.app.NavUtilsJB.navigateUpTo(p1, p2);
        return;
    }

    public boolean shouldUpRecreateTask(android.app.Activity p2, android.content.Intent p3)
    {
        return android.support.v4.app.NavUtilsJB.shouldUpRecreateTask(p2, p3);
    }

    android.content.Intent superGetParentActivityIntent(android.app.Activity p2)
    {
        return super.getParentActivityIntent(p2);
    }
}
