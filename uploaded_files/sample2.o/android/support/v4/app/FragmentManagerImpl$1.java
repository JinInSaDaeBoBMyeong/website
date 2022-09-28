package android.support.v4.app;
 class FragmentManagerImpl$1 implements java.lang.Runnable {
    final synthetic android.support.v4.app.FragmentManagerImpl this$0;

    FragmentManagerImpl$1(android.support.v4.app.FragmentManagerImpl p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        this.this$0.execPendingActions();
        return;
    }
}
