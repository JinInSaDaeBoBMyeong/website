package android.support.v4.content;
public final class Loader$ForceLoadContentObserver extends android.database.ContentObserver {
    final synthetic android.support.v4.content.Loader this$0;

    public Loader$ForceLoadContentObserver(android.support.v4.content.Loader p2)
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
