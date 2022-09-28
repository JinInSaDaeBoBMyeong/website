package android.support.v4.widget;
 class SearchViewCompatIcs {

    SearchViewCompatIcs()
    {
        return;
    }

    public static android.view.View newSearchView(android.content.Context p1)
    {
        return new android.support.v4.widget.SearchViewCompatIcs$MySearchView(p1);
    }

    public static void setImeOptions(android.view.View p0, int p1)
    {
        ((android.widget.SearchView) p0).setImeOptions(p1);
        return;
    }

    public static void setInputType(android.view.View p0, int p1)
    {
        ((android.widget.SearchView) p0).setInputType(p1);
        return;
    }
}
