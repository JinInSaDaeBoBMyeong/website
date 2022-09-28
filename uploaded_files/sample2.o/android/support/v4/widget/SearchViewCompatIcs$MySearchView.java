package android.support.v4.widget;
public class SearchViewCompatIcs$MySearchView extends android.widget.SearchView {

    public SearchViewCompatIcs$MySearchView(android.content.Context p1)
    {
        super(p1);
        return;
    }

    public void onActionViewCollapsed()
    {
        this.setQuery("", 0);
        super.onActionViewCollapsed();
        return;
    }
}
