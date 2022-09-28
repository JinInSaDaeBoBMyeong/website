package android.support.v4.widget;
 class SearchViewCompat$SearchViewCompatHoneycombImpl$2 implements android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge {
    final synthetic android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl this$0;
    final synthetic android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat val$listener;

    SearchViewCompat$SearchViewCompatHoneycombImpl$2(android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl p1, android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat p2)
    {
        this.this$0 = p1;
        this.val$listener = p2;
        return;
    }

    public boolean onClose()
    {
        return this.val$listener.onClose();
    }
}
