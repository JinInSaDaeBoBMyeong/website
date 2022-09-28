package android.support.v4.view;
 class MenuItemCompat$IcsMenuVersionImpl extends android.support.v4.view.MenuItemCompat$HoneycombMenuVersionImpl {

    MenuItemCompat$IcsMenuVersionImpl()
    {
        return;
    }

    public boolean collapseActionView(android.view.MenuItem p2)
    {
        return android.support.v4.view.MenuItemCompatIcs.collapseActionView(p2);
    }

    public boolean expandActionView(android.view.MenuItem p2)
    {
        return android.support.v4.view.MenuItemCompatIcs.expandActionView(p2);
    }

    public boolean isActionViewExpanded(android.view.MenuItem p2)
    {
        return android.support.v4.view.MenuItemCompatIcs.isActionViewExpanded(p2);
    }

    public android.view.MenuItem setOnActionExpandListener(android.view.MenuItem p2, android.support.v4.view.MenuItemCompat$OnActionExpandListener p3)
    {
        android.view.MenuItem v0_2;
        if (p3 != null) {
            v0_2 = android.support.v4.view.MenuItemCompatIcs.setOnActionExpandListener(p2, new android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl$1(this, p3));
        } else {
            v0_2 = android.support.v4.view.MenuItemCompatIcs.setOnActionExpandListener(p2, 0);
        }
        return v0_2;
    }
}
