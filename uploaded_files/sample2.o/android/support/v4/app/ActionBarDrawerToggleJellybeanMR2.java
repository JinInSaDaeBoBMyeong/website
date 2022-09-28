package android.support.v4.app;
 class ActionBarDrawerToggleJellybeanMR2 {
    private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
    private static final int[] THEME_ATTRS;

    static ActionBarDrawerToggleJellybeanMR2()
    {
        int[] v0_1 = new int[1];
        v0_1[0] = 16843531;
        android.support.v4.app.ActionBarDrawerToggleJellybeanMR2.THEME_ATTRS = v0_1;
        return;
    }

    ActionBarDrawerToggleJellybeanMR2()
    {
        return;
    }

    public static android.graphics.drawable.Drawable getThemeUpIndicator(android.app.Activity p3)
    {
        android.content.res.TypedArray v0 = p3.obtainStyledAttributes(android.support.v4.app.ActionBarDrawerToggleJellybeanMR2.THEME_ATTRS);
        android.graphics.drawable.Drawable v1 = v0.getDrawable(0);
        v0.recycle();
        return v1;
    }

    public static Object setActionBarDescription(Object p1, android.app.Activity p2, int p3)
    {
        android.app.ActionBar v0 = p2.getActionBar();
        if (v0 != null) {
            v0.setHomeActionContentDescription(p3);
        }
        return p1;
    }

    public static Object setActionBarUpIndicator(Object p1, android.app.Activity p2, android.graphics.drawable.Drawable p3, int p4)
    {
        android.app.ActionBar v0 = p2.getActionBar();
        if (v0 != null) {
            v0.setHomeAsUpIndicator(p3);
            v0.setHomeActionContentDescription(p4);
        }
        return p1;
    }
}
