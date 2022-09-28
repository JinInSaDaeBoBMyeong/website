package android.support.v4.widget;
 class SwipeRefreshLayout$6 implements java.lang.Runnable {
    final synthetic android.support.v4.widget.SwipeRefreshLayout this$0;

    SwipeRefreshLayout$6(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        android.support.v4.widget.SwipeRefreshLayout.access$902(this.this$0, 1);
        if (android.support.v4.widget.SwipeRefreshLayout.access$500(this.this$0) != null) {
            android.support.v4.widget.SwipeRefreshLayout.access$402(this.this$0, android.support.v4.widget.SwipeRefreshLayout.access$800(this.this$0));
            android.support.v4.widget.SwipeRefreshLayout.access$1300(this.this$0).setDuration(((long) android.support.v4.widget.SwipeRefreshLayout.access$1200(this.this$0)));
            android.support.v4.widget.SwipeRefreshLayout.access$1300(this.this$0).setAnimationListener(android.support.v4.widget.SwipeRefreshLayout.access$1400(this.this$0));
            android.support.v4.widget.SwipeRefreshLayout.access$1300(this.this$0).reset();
            android.support.v4.widget.SwipeRefreshLayout.access$1300(this.this$0).setInterpolator(android.support.v4.widget.SwipeRefreshLayout.access$1500(this.this$0));
            this.this$0.startAnimation(android.support.v4.widget.SwipeRefreshLayout.access$1300(this.this$0));
        }
        android.support.v4.widget.SwipeRefreshLayout.access$1100(this.this$0, (android.support.v4.widget.SwipeRefreshLayout.access$700(this.this$0) + this.this$0.getPaddingTop()), android.support.v4.widget.SwipeRefreshLayout.access$1000(this.this$0));
        return;
    }
}
