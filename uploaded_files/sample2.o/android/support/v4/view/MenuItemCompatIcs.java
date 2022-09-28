package android.support.v4.view;
 class MenuItemCompatIcs {

    MenuItemCompatIcs()
    {
        return;
    }

    public static boolean collapseActionView(android.view.MenuItem p1)
    {
        return p1.collapseActionView();
    }

    public static boolean expandActionView(android.view.MenuItem p1)
    {
        return p1.expandActionView();
    }

    public static boolean isActionViewExpanded(android.view.MenuItem p1)
    {
        return p1.isActionViewExpanded();
    }

    public static android.view.MenuItem setOnActionExpandListener(android.view.MenuItem p1, android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy p2)
    {
        return p1.setOnActionExpandListener(new android.support.v4.view.MenuItemCompatIcs$OnActionExpandListenerWrapper(p2));
    }
}
