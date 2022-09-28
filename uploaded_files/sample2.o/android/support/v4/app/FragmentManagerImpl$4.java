package android.support.v4.app;
 class FragmentManagerImpl$4 implements java.lang.Runnable {
    final synthetic android.support.v4.app.FragmentManagerImpl this$0;
    final synthetic int val$flags;
    final synthetic int val$id;

    FragmentManagerImpl$4(android.support.v4.app.FragmentManagerImpl p1, int p2, int p3)
    {
        this.this$0 = p1;
        this.val$id = p2;
        this.val$flags = p3;
        return;
    }

    public void run()
    {
        this.this$0.popBackStackState(this.this$0.mActivity.mHandler, 0, this.val$id, this.val$flags);
        return;
    }
}
