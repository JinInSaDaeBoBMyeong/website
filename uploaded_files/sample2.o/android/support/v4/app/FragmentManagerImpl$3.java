package android.support.v4.app;
 class FragmentManagerImpl$3 implements java.lang.Runnable {
    final synthetic android.support.v4.app.FragmentManagerImpl this$0;
    final synthetic int val$flags;
    final synthetic String val$name;

    FragmentManagerImpl$3(android.support.v4.app.FragmentManagerImpl p1, String p2, int p3)
    {
        this.this$0 = p1;
        this.val$name = p2;
        this.val$flags = p3;
        return;
    }

    public void run()
    {
        this.this$0.popBackStackState(this.this$0.mActivity.mHandler, this.val$name, -1, this.val$flags);
        return;
    }
}
