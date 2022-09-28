package android.support.v4.widget;
 class SlidingPaneLayout$DisableLayerRunnable implements java.lang.Runnable {
    final android.view.View mChildView;
    final synthetic android.support.v4.widget.SlidingPaneLayout this$0;

    SlidingPaneLayout$DisableLayerRunnable(android.support.v4.widget.SlidingPaneLayout p1, android.view.View p2)
    {
        this.this$0 = p1;
        this.mChildView = p2;
        return;
    }

    public void run()
    {
        if (this.mChildView.getParent() == this.this$0) {
            android.support.v4.view.ViewCompat.setLayerType(this.mChildView, 0, 0);
            android.support.v4.widget.SlidingPaneLayout.access$1000(this.this$0, this.mChildView);
        }
        android.support.v4.widget.SlidingPaneLayout.access$1100(this.this$0).remove(this);
        return;
    }
}
