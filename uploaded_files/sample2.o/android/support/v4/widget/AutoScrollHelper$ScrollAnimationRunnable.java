package android.support.v4.widget;
 class AutoScrollHelper$ScrollAnimationRunnable implements java.lang.Runnable {
    final synthetic android.support.v4.widget.AutoScrollHelper this$0;

    private AutoScrollHelper$ScrollAnimationRunnable(android.support.v4.widget.AutoScrollHelper p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic AutoScrollHelper$ScrollAnimationRunnable(android.support.v4.widget.AutoScrollHelper p1, android.support.v4.widget.AutoScrollHelper$1 p2)
    {
        this(p1);
        return;
    }

    public void run()
    {
        if (android.support.v4.widget.AutoScrollHelper.access$100(this.this$0)) {
            if (android.support.v4.widget.AutoScrollHelper.access$200(this.this$0)) {
                android.support.v4.widget.AutoScrollHelper.access$202(this.this$0, 0);
                android.support.v4.widget.AutoScrollHelper.access$300(this.this$0).start();
            }
            android.support.v4.widget.AutoScrollHelper$ClampedScroller v2 = android.support.v4.widget.AutoScrollHelper.access$300(this.this$0);
            if ((!v2.isFinished()) && (android.support.v4.widget.AutoScrollHelper.access$400(this.this$0))) {
                if (android.support.v4.widget.AutoScrollHelper.access$500(this.this$0)) {
                    android.support.v4.widget.AutoScrollHelper.access$502(this.this$0, 0);
                    android.support.v4.widget.AutoScrollHelper.access$600(this.this$0);
                }
                v2.computeScrollDelta();
                this.this$0.scrollTargetBy(v2.getDeltaX(), v2.getDeltaY());
                android.support.v4.view.ViewCompat.postOnAnimation(android.support.v4.widget.AutoScrollHelper.access$700(this.this$0), this);
            } else {
                android.support.v4.widget.AutoScrollHelper.access$102(this.this$0, 0);
            }
        }
        return;
    }
}
