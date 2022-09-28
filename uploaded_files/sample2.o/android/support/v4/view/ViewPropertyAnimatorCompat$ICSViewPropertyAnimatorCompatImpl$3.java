package android.support.v4.view;
 class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$3 implements android.support.v4.view.ViewPropertyAnimatorListener {
    final synthetic android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl this$0;
    final synthetic int val$currentLayerType;

    ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$3(android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl p1, int p2)
    {
        this.this$0 = p1;
        this.val$currentLayerType = p2;
        return;
    }

    public void onAnimationCancel(android.view.View p1)
    {
        return;
    }

    public void onAnimationEnd(android.view.View p3)
    {
        android.support.v4.view.ViewCompat.setLayerType(p3, this.val$currentLayerType, 0);
        this.this$0.setListener(p3, 0);
        return;
    }

    public void onAnimationStart(android.view.View p3)
    {
        android.support.v4.view.ViewCompat.setLayerType(p3, 2, 0);
        return;
    }
}
