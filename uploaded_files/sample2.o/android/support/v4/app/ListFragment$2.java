package android.support.v4.app;
 class ListFragment$2 implements android.widget.AdapterView$OnItemClickListener {
    final synthetic android.support.v4.app.ListFragment this$0;

    ListFragment$2(android.support.v4.app.ListFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onItemClick(android.widget.AdapterView p7, android.view.View p8, int p9, long p10)
    {
        this.this$0.onListItemClick(((android.widget.ListView) p7), p8, p9, p10);
        return;
    }
}
