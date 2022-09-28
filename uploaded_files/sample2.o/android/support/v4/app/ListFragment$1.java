package android.support.v4.app;
 class ListFragment$1 implements java.lang.Runnable {
    final synthetic android.support.v4.app.ListFragment this$0;

    ListFragment$1(android.support.v4.app.ListFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        this.this$0.mList.focusableViewAvailable(this.this$0.mList);
        return;
    }
}
