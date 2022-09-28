package android.support.v4.widget;
 class SearchViewCompat$SearchViewCompatHoneycombImpl$1 implements android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge {
    final synthetic android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl this$0;
    final synthetic android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat val$listener;

    SearchViewCompat$SearchViewCompatHoneycombImpl$1(android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl p1, android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat p2)
    {
        this.this$0 = p1;
        this.val$listener = p2;
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
