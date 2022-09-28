package android.support.v4.app;
 class FragmentManagerImpl$2 implements java.lang.Runnable {
    final synthetic android.support.v4.app.FragmentManagerImpl this$0;

    FragmentManagerImpl$2(android.support.v4.app.FragmentManagerImpl p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        this.this$0.popBackStackState(this.this$0.mActivity.mHandler, 0, -1, 0);
        return;
    }
}
