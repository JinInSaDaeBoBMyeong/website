package android.support.v4.view;
 class MenuItemCompat$IcsMenuVersionImpl$1 implements android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy {
    final synthetic android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl this$0;
    final synthetic android.support.v4.view.MenuItemCompat$OnActionExpandListener val$listener;

    MenuItemCompat$IcsMenuVersionImpl$1(android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl p1, android.support.v4.view.MenuItemCompat$OnActionExpandListener p2)
    {
        this.this$0 = p1;
        this.val$listener = p2;
        return;
    }

    public boolean onMenuItemActionCollapse(android.view.MenuItem p2)
    {
        return this.val$listener.onMenuItemActionCollapse(p2);
    }

    public boolean onMenuItemActionExpand(android.view.MenuItem p2)
    {
        return this.val$listener.onMenuItemActionExpand(p2);
    }
}
