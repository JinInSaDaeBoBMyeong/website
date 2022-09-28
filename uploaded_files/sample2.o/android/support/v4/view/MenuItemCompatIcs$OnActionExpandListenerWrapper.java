package android.support.v4.view;
 class MenuItemCompatIcs$OnActionExpandListenerWrapper implements android.view.MenuItem$OnActionExpandListener {
    private android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy mWrapped;

    public MenuItemCompatIcs$OnActionExpandListenerWrapper(android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy p1)
    {
        this.mWrapped = p1;
        return;
    }

    public boolean onMenuItemActionCollapse(android.view.MenuItem p2)
    {
        return this.mWrapped.onMenuItemActionCollapse(p2);
    }

    public boolean onMenuItemActionExpand(android.view.MenuItem p2)
    {
        return this.mWrapped.onMenuItemActionExpand(p2);
    }
}
