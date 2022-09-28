package android.support.v4.widget;
 class SwipeRefreshLayout$1 extends android.view.animation.Animation {
    final synthetic android.support.v4.widget.SwipeRefreshLayout this$0;

    SwipeRefreshLayout$1(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        this.this$0 = p1;
        return;
    }

    public void applyTransformation(float p7, android.view.animation.Transformation p8)
    {
        int v2 = 0;
        if (android.support.v4.widget.SwipeRefreshLayout.access$000(this.this$0) != android.support.v4.widget.SwipeRefreshLayout.access$100(this.this$0)) {
            v2 = (android.support.v4.widget.SwipeRefreshLayout.access$000(this.this$0) + ((int) (((float) (android.support.v4.widget.SwipeRefreshLayout.access$100(this.this$0) - android.support.v4.widget.SwipeRefreshLayout.access$000(this.this$0))) * p7)));
        }
        int v1 = (v2 - android.support.v4.widget.SwipeRefreshLayout.access$200(this.this$0).getTop());
        int v0 = android.support.v4.widget.SwipeRefreshLayout.access$200(this.this$0).getTop();
        if ((v1 + v0) < 0) {
            v1 = (0 - v0);
        }
        android.support.v4.widget.SwipeRefreshLayout.access$300(this.this$0, v1);
        return;
    }
}
