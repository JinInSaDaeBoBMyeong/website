package android.support.v4.widget;
 class CursorAdapter$MyDataSetObserver extends android.database.DataSetObserver {
    final synthetic android.support.v4.widget.CursorAdapter this$0;

    private CursorAdapter$MyDataSetObserver(android.support.v4.widget.CursorAdapter p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic CursorAdapter$MyDataSetObserver(android.support.v4.widget.CursorAdapter p1, android.support.v4.widget.CursorAdapter$1 p2)
    {
        this(p1);
        return;
    }

    public void onChanged()
    {
        this.this$0.mDataValid = 1;
        this.this$0.notifyDataSetChanged();
        return;
    }

    public void onInvalidated()
    {
        this.this$0.mDataValid = 0;
        this.this$0.notifyDataSetInvalidated();
        return;
    }
}
