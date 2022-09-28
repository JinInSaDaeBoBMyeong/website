package android.support.v4.app;
 class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo {
    public reflect.Method setHomeActionContentDescription;
    public reflect.Method setHomeAsUpIndicator;
    public android.widget.ImageView upIndicatorView;

    ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(android.app.Activity p15)
    {
        try {
            Class[] v8_3 = new Class[1];
            v8_3[0] = android.graphics.drawable.Drawable;
            this.setHomeAsUpIndicator = android.app.ActionBar.getDeclaredMethod("setHomeAsUpIndicator", v8_3);
            Class[] v8_1 = new Class[1];
            v8_1[0] = Integer.TYPE;
            this.setHomeActionContentDescription = android.app.ActionBar.getDeclaredMethod("setHomeActionContentDescription", v8_1);
        } catch (boolean v6) {
            android.view.View v2 = p15.findViewById(16908332);
            if (v2 == null) {
            } else {
                android.view.ViewGroup v3_1 = ((android.view.ViewGroup) v2.getParent());
                if (v3_1.getChildCount() != 2) {
                } else {
                    android.view.View v1 = v3_1.getChildAt(0);
                    android.view.View v4 = v3_1.getChildAt(1);
                    if (v1.getId() != 16908332) {
                        android.widget.ImageView v5_0 = v1;
                    } else {
                        v5_0 = v4;
                    }
                    if (!(v5_0 instanceof android.widget.ImageView)) {
                    } else {
                        this.upIndicatorView = ((android.widget.ImageView) v5_0);
                    }
                }
            }
        }
        return;
    }
}
