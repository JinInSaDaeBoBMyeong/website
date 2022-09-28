package android.support.v4.widget;
 class SearchViewCompatHoneycomb {

    SearchViewCompatHoneycomb()
    {
        return;
    }

    public static CharSequence getQuery(android.view.View p1)
    {
        return ((android.widget.SearchView) p1).getQuery();
    }

    public static boolean isIconified(android.view.View p1)
    {
        return ((android.widget.SearchView) p1).isIconified();
    }

    public static boolean isQueryRefinementEnabled(android.view.View p1)
    {
        return ((android.widget.SearchView) p1).isQueryRefinementEnabled();
    }

    public static boolean isSubmitButtonEnabled(android.view.View p1)
    {
        return ((android.widget.SearchView) p1).isSubmitButtonEnabled();
    }

    public static Object newOnCloseListener(android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge p1)
    {
        return new android.support.v4.widget.SearchViewCompatHoneycomb$2(p1);
    }

    public static Object newOnQueryTextListener(android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge p1)
    {
        return new android.support.v4.widget.SearchViewCompatHoneycomb$1(p1);
    }

    public static android.view.View newSearchView(android.content.Context p1)
    {
        return new android.widget.SearchView(p1);
    }

    public static void setIconified(android.view.View p0, boolean p1)
    {
        ((android.widget.SearchView) p0).setIconified(p1);
        return;
    }

    public static void setMaxWidth(android.view.View p0, int p1)
    {
        ((android.widget.SearchView) p0).setMaxWidth(p1);
        return;
    }

    public static void setOnCloseListener(Object p0, Object p1)
    {
        ((android.widget.SearchView) p0).setOnCloseListener(((android.widget.SearchView$OnCloseListener) p1));
        return;
    }

    public static void setOnQueryTextListener(Object p0, Object p1)
    {
        ((android.widget.SearchView) p0).setOnQueryTextListener(((android.widget.SearchView$OnQueryTextListener) p1));
        return;
    }

    public static void setQuery(android.view.View p0, CharSequence p1, boolean p2)
    {
        ((android.widget.SearchView) p0).setQuery(p1, p2);
        return;
    }

    public static void setQueryHint(android.view.View p0, CharSequence p1)
    {
        ((android.widget.SearchView) p0).setQueryHint(p1);
        return;
    }

    public static void setQueryRefinementEnabled(android.view.View p0, boolean p1)
    {
        ((android.widget.SearchView) p0).setQueryRefinementEnabled(p1);
        return;
    }

    public static void setSearchableInfo(android.view.View p4, android.content.ComponentName p5)
    {
        ((android.widget.SearchView) p4).setSearchableInfo(((android.app.SearchManager) ((android.widget.SearchView) p4).getContext().getSystemService("search")).getSearchableInfo(p5));
        return;
    }

    public static void setSubmitButtonEnabled(android.view.View p0, boolean p1)
    {
        ((android.widget.SearchView) p0).setSubmitButtonEnabled(p1);
        return;
    }
}
