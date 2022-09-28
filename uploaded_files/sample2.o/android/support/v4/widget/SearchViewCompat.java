package android.support.v4.widget;
public class SearchViewCompat {
    private static final android.support.v4.widget.SearchViewCompat$SearchViewCompatImpl IMPL;

    static SearchViewCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            if (android.os.Build$VERSION.SDK_INT < 11) {
                android.support.v4.widget.SearchViewCompat.IMPL = new android.support.v4.widget.SearchViewCompat$SearchViewCompatStubImpl();
            } else {
                android.support.v4.widget.SearchViewCompat.IMPL = new android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl();
            }
        } else {
            android.support.v4.widget.SearchViewCompat.IMPL = new android.support.v4.widget.SearchViewCompat$SearchViewCompatIcsImpl();
        }
        return;
    }

    private SearchViewCompat(android.content.Context p1)
    {
        return;
    }

    static synthetic android.support.v4.widget.SearchViewCompat$SearchViewCompatImpl access$000()
    {
        return android.support.v4.widget.SearchViewCompat.IMPL;
    }

    public static CharSequence getQuery(android.view.View p1)
    {
        return android.support.v4.widget.SearchViewCompat.IMPL.getQuery(p1);
    }

    public static boolean isIconified(android.view.View p1)
    {
        return android.support.v4.widget.SearchViewCompat.IMPL.isIconified(p1);
    }

    public static boolean isQueryRefinementEnabled(android.view.View p1)
    {
        return android.support.v4.widget.SearchViewCompat.IMPL.isQueryRefinementEnabled(p1);
    }

    public static boolean isSubmitButtonEnabled(android.view.View p1)
    {
        return android.support.v4.widget.SearchViewCompat.IMPL.isSubmitButtonEnabled(p1);
    }

    public static android.view.View newSearchView(android.content.Context p1)
    {
        return android.support.v4.widget.SearchViewCompat.IMPL.newSearchView(p1);
    }

    public static void setIconified(android.view.View p1, boolean p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setIconified(p1, p2);
        return;
    }

    public static void setImeOptions(android.view.View p1, int p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setImeOptions(p1, p2);
        return;
    }

    public static void setInputType(android.view.View p1, int p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setInputType(p1, p2);
        return;
    }

    public static void setMaxWidth(android.view.View p1, int p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setMaxWidth(p1, p2);
        return;
    }

    public static void setOnCloseListener(android.view.View p2, android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat p3)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setOnCloseListener(p2, p3.mListener);
        return;
    }

    public static void setOnQueryTextListener(android.view.View p2, android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat p3)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setOnQueryTextListener(p2, p3.mListener);
        return;
    }

    public static void setQuery(android.view.View p1, CharSequence p2, boolean p3)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setQuery(p1, p2, p3);
        return;
    }

    public static void setQueryHint(android.view.View p1, CharSequence p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setQueryHint(p1, p2);
        return;
    }

    public static void setQueryRefinementEnabled(android.view.View p1, boolean p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setQueryRefinementEnabled(p1, p2);
        return;
    }

    public static void setSearchableInfo(android.view.View p1, android.content.ComponentName p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setSearchableInfo(p1, p2);
        return;
    }

    public static void setSubmitButtonEnabled(android.view.View p1, boolean p2)
    {
        android.support.v4.widget.SearchViewCompat.IMPL.setSubmitButtonEnabled(p1, p2);
        return;
    }
}
