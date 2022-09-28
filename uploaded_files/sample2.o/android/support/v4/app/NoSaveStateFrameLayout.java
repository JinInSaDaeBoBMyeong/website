package android.support.v4.app;
 class NoSaveStateFrameLayout extends android.widget.FrameLayout {

    public NoSaveStateFrameLayout(android.content.Context p1)
    {
        super(p1);
        return;
    }

    static android.view.ViewGroup wrap(android.view.View p5)
    {
        android.support.v4.app.NoSaveStateFrameLayout v2_1 = new android.support.v4.app.NoSaveStateFrameLayout(p5.getContext());
        android.view.ViewGroup$LayoutParams v0 = p5.getLayoutParams();
        if (v0 != null) {
            v2_1.setLayoutParams(v0);
        }
        p5.setLayoutParams(new android.widget.FrameLayout$LayoutParams(-1, -1));
        v2_1.addView(p5);
        return v2_1;
    }

    protected void dispatchRestoreInstanceState(android.util.SparseArray p1)
    {
        this.dispatchThawSelfOnly(p1);
        return;
    }

    protected void dispatchSaveInstanceState(android.util.SparseArray p1)
    {
        this.dispatchFreezeSelfOnly(p1);
        return;
    }
}
