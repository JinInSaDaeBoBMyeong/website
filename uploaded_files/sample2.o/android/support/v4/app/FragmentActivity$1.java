package android.support.v4.app;
 class FragmentActivity$1 extends android.os.Handler {
    final synthetic android.support.v4.app.FragmentActivity this$0;

    FragmentActivity$1(android.support.v4.app.FragmentActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p3)
    {
        switch (p3.what) {
            case 1:
                if (!this.this$0.mStopped) {
                } else {
                    this.this$0.doReallyStop(0);
                }
                break;
            case 2:
                this.this$0.onResumeFragments();
                this.this$0.mFragments.execPendingActions();
                break;
            default:
                super.handleMessage(p3);
        }
        return;
    }
}
