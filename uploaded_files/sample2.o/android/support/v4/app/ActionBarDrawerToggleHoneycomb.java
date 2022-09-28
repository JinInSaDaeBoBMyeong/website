package android.support.v4.app;
 class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS;

    static ActionBarDrawerToggleHoneycomb()
    {
        int[] v0_1 = new int[1];
        v0_1[0] = 16843531;
        android.support.v4.app.ActionBarDrawerToggleHoneycomb.THEME_ATTRS = v0_1;
        return;
    }

    ActionBarDrawerToggleHoneycomb()
    {
        return;
    }

    public static android.graphics.drawable.Drawable getThemeUpIndicator(android.app.Activity p3)
    {
        android.content.res.TypedArray v0 = p3.obtainStyledAttributes(android.support.v4.app.ActionBarDrawerToggleHoneycomb.THEME_ATTRS);
        android.graphics.drawable.Drawable v1 = v0.getDrawable(0);
        v0.recycle();
        return v1;
    }

    public static Object setActionBarDescription(Object p7, android.app.Activity p8, int p9)
    {
        if (p7 == null) {
            p7 = new android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(p8);
        }
        if (((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).setHomeAsUpIndicator != null) {
            try {
                android.app.ActionBar v0 = p8.getActionBar();
                CharSequence v3_4 = ((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).setHomeActionContentDescription;
                String v4_1 = new Object[1];
                v4_1[0] = Integer.valueOf(p9);
                v3_4.invoke(v0, v4_1);
            } catch (Exception v1) {
                android.util.Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", v1);
            }
            if (android.os.Build$VERSION.SDK_INT <= 19) {
                v0.setSubtitle(v0.getSubtitle());
            }
        }
        return p7;
    }

    public static Object setActionBarUpIndicator(Object p7, android.app.Activity p8, android.graphics.drawable.Drawable p9, int p10)
    {
        if (p7 == null) {
            p7 = new android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(p8);
        }
        if (((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).setHomeAsUpIndicator == null) {
            if (((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).upIndicatorView == null) {
                android.util.Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
            } else {
                ((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).upIndicatorView.setImageDrawable(p9);
            }
        } else {
            try {
                android.app.ActionBar v0 = p8.getActionBar();
                String v3_1 = ((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).setHomeAsUpIndicator;
                String v4_2 = new Object[1];
                v4_2[0] = p9;
                v3_1.invoke(v0, v4_2);
                String v3_2 = ((android.support.v4.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo) p7).setHomeActionContentDescription;
                String v4_4 = new Object[1];
                v4_4[0] = Integer.valueOf(p10);
                v3_2.invoke(v0, v4_4);
            } catch (Exception v1) {
                android.util.Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", v1);
            }
        }
        return p7;
    }
}
