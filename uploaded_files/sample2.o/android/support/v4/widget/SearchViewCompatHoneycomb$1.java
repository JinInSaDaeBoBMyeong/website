package android.support.v4.widget;
final class SearchViewCompatHoneycomb$1 implements android.widget.SearchView$OnQueryTextListener {
    final synthetic android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge val$listener;

    SearchViewCompatHoneycomb$1(android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge p1)
    {
        this.val$listener = p1;
        return;
    }

    public boolean onQueryTextChange(String p2)
    {
        return this.val$listener.onQueryTextChange(p2);
    }

    public boolean onQueryTextSubmit(String p2)
    {
        return this.val$listener.onQueryTextSubmit(p2);
    }
}
