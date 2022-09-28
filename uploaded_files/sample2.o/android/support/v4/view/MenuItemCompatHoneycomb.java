package android.support.v4.view;
 class MenuItemCompatHoneycomb {

    MenuItemCompatHoneycomb()
    {
        return;
    }

    public static android.view.View getActionView(android.view.MenuItem p1)
    {
        return p1.getActionView();
    }

    public static android.view.MenuItem setActionView(android.view.MenuItem p1, int p2)
    {
        return p1.setActionView(p2);
    }

    public static android.view.MenuItem setActionView(android.view.MenuItem p1, android.view.View p2)
    {
        return p1.setActionView(p2);
    }

    public static void setShowAsAction(android.view.MenuItem p0, int p1)
    {
        p0.setShowAsAction(p1);
        return;
    }
}
