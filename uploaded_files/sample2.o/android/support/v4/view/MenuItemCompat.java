package android.support.v4.view;
public class MenuItemCompat {
    static final android.support.v4.view.MenuItemCompat$MenuVersionImpl IMPL = None;
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    static MenuItemCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 14) {
            if (v0 < 11) {
                android.support.v4.view.MenuItemCompat.IMPL = new android.support.v4.view.MenuItemCompat$BaseMenuVersionImpl();
            } else {
                android.support.v4.view.MenuItemCompat.IMPL = new android.support.v4.view.MenuItemCompat$HoneycombMenuVersionImpl();
            }
        } else {
            android.support.v4.view.MenuItemCompat.IMPL = new android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl();
        }
        return;
    }

    public MenuItemCompat()
    {
        return;
    }

    public static boolean collapseActionView(android.view.MenuItem p1)
    {
        boolean v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.collapseActionView(p1);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).collapseActionView();
        }
        return v0_2;
    }

    public static boolean expandActionView(android.view.MenuItem p1)
    {
        boolean v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.expandActionView(p1);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).expandActionView();
        }
        return v0_2;
    }

    public static android.support.v4.view.ActionProvider getActionProvider(android.view.MenuItem p2)
    {
        int v0_2;
        if (!(p2 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            android.util.Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
            v0_2 = 0;
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p2).getSupportActionProvider();
        }
        return v0_2;
    }

    public static android.view.View getActionView(android.view.MenuItem p1)
    {
        android.view.View v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.getActionView(p1);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).getActionView();
        }
        return v0_2;
    }

    public static boolean isActionViewExpanded(android.view.MenuItem p1)
    {
        boolean v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.isActionViewExpanded(p1);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).isActionViewExpanded();
        }
        return v0_2;
    }

    public static android.view.MenuItem setActionProvider(android.view.MenuItem p2, android.support.v4.view.ActionProvider p3)
    {
        if (!(p2 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            android.util.Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        } else {
            p2 = ((android.support.v4.internal.view.SupportMenuItem) p2).setSupportActionProvider(p3);
        }
        return p2;
    }

    public static android.view.MenuItem setActionView(android.view.MenuItem p1, int p2)
    {
        android.view.MenuItem v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.setActionView(p1, p2);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).setActionView(p2);
        }
        return v0_2;
    }

    public static android.view.MenuItem setActionView(android.view.MenuItem p1, android.view.View p2)
    {
        android.view.MenuItem v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.setActionView(p1, p2);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).setActionView(p2);
        }
        return v0_2;
    }

    public static android.view.MenuItem setOnActionExpandListener(android.view.MenuItem p1, android.support.v4.view.MenuItemCompat$OnActionExpandListener p2)
    {
        android.view.MenuItem v0_2;
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            v0_2 = android.support.v4.view.MenuItemCompat.IMPL.setOnActionExpandListener(p1, p2);
        } else {
            v0_2 = ((android.support.v4.internal.view.SupportMenuItem) p1).setSupportOnActionExpandListener(p2);
        }
        return v0_2;
    }

    public static void setShowAsAction(android.view.MenuItem p1, int p2)
    {
        if (!(p1 instanceof android.support.v4.internal.view.SupportMenuItem)) {
            android.support.v4.view.MenuItemCompat.IMPL.setShowAsAction(p1, p2);
        } else {
            ((android.support.v4.internal.view.SupportMenuItem) p1).setShowAsAction(p2);
        }
        return;
    }
}
