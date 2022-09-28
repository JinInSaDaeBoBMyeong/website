package android.support.v4.widget;
 class SwipeRefreshLayout$2 extends android.view.animation.Animation {
    final synthetic android.support.v4.widget.SwipeRefreshLayout this$0;

    SwipeRefreshLayout$2(android.support.v4.widget.SwipeRefreshLayout p1)
    {
        this.this$0 = p1;
        return;
    }

    public void applyTransformation(float p5, android.view.animation.Transformation p6)
    {
        android.support.v4.widget.SwipeRefreshLayout.access$500(this.this$0).setTriggerPercentage((android.support.v4.widget.SwipeRefreshLayout.access$400(this.this$0) + ((0 - android.support.v4.widget.SwipeRefreshLayout.access$400(this.this$0)) * p5)));
        return;
    }
}
