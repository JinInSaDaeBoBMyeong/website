package android.support.v4.widget;
 class CursorAdapter$ChangeObserver extends android.database.ContentObserver {
    final synthetic android.support.v4.widget.CursorAdapter this$0;

    public CursorAdapter$ChangeObserver(android.support.v4.widget.CursorAdapter p2)
    {
        this.this$0 = p2;
        super(new android.os.Handler());
        return;
    }

    public boolean deliverSelfNotifications()
    {
        return 1;
    }

    public void onChange(boolean p2)
    {
        this.this$0.onContentChanged();
        return;
    }
}
