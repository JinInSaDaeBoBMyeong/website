package android.support.v4.widget;
final class SearchViewCompatHoneycomb$2 implements android.widget.SearchView$OnCloseListener {
    final synthetic android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge val$listener;

    SearchViewCompatHoneycomb$2(android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge p1)
    {
        this.val$listener = p1;
        return;
    }

    public boolean onClose()
    {
        return this.val$listener.onClose();
    }
}
