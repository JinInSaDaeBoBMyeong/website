package android.support.v4.view;
 class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$2 implements android.support.v4.view.ViewPropertyAnimatorListener {
    final synthetic android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl this$0;
    final synthetic Runnable val$runnable;

    ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$2(android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl p1, Runnable p2)
    {
        this.this$0 = p1;
        this.val$runnable = p2;
        return;
    }

    public void onAnimationCancel(android.view.View p1)
    {
        return;
    }

    public void onAnimationEnd(android.view.View p1)
    {
        return;
    }

    public void onAnimationStart(android.view.View p3)
    {
        this.val$runnable.run();
        this.this$0.setListener(p3, 0);
        return;
    }
}
