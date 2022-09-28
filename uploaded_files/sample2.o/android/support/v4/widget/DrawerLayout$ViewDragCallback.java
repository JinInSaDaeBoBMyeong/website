package android.support.v4.widget;
 class DrawerLayout$ViewDragCallback extends android.support.v4.widget.ViewDragHelper$Callback {
    private final int mAbsGravity;
    private android.support.v4.widget.ViewDragHelper mDragger;
    private final Runnable mPeekRunnable;
    final synthetic android.support.v4.widget.DrawerLayout this$0;

    public DrawerLayout$ViewDragCallback(android.support.v4.widget.DrawerLayout p2, int p3)
    {
        this.this$0 = p2;
        this.mPeekRunnable = new android.support.v4.widget.DrawerLayout$ViewDragCallback$1(this);
        this.mAbsGravity = p3;
        return;
    }

    static synthetic void access$000(android.support.v4.widget.DrawerLayout$ViewDragCallback p0)
    {
        p0.peekDrawer();
        return;
    }

    private void closeOtherDrawer()
    {
        int v0 = 3;
        if (this.mAbsGravity == 3) {
            v0 = 5;
        }
        android.view.View v1 = this.this$0.findDrawerWithGravity(v0);
        if (v1 != null) {
            this.this$0.closeDrawer(v1);
        }
        return;
    }

    private void peekDrawer()
    {
        int v1;
        android.support.v4.widget.DrawerLayout v5_3 = 0;
        int v3 = this.mDragger.getEdgeSize();
        if (this.mAbsGravity != 3) {
            v1 = 0;
        } else {
            v1 = 1;
        }
        android.view.View v4;
        int v0;
        if (v1 == 0) {
            v4 = this.this$0.findDrawerWithGravity(5);
            v0 = (this.this$0.getWidth() - v3);
        } else {
            v4 = this.this$0.findDrawerWithGravity(3);
            if (v4 != null) {
                v5_3 = (- v4.getWidth());
            }
            v0 = (v5_3 + v3);
        }
        if (((v4 != null) && (((v1 != 0) && (v4.getLeft() < v0)) || ((v1 == 0) && (v4.getLeft() > v0)))) && (this.this$0.getDrawerLockMode(v4) == 0)) {
            android.support.v4.widget.DrawerLayout$LayoutParams v2_1 = ((android.support.v4.widget.DrawerLayout$LayoutParams) v4.getLayoutParams());
            this.mDragger.smoothSlideViewTo(v4, v0, v4.getTop());
            v2_1.isPeeking = 1;
            this.this$0.invalidate();
            this.closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
        }
        return;
    }

    public int clampViewPositionHorizontal(android.view.View p4, int p5, int p6)
    {
        int v1_2;
        if (!this.this$0.checkDrawerViewAbsoluteGravity(p4, 3)) {
            int v0 = this.this$0.getWidth();
            v1_2 = Math.max((v0 - p4.getWidth()), Math.min(p5, v0));
        } else {
            v1_2 = Math.max((- p4.getWidth()), Math.min(p5, 0));
        }
        return v1_2;
    }

    public int clampViewPositionVertical(android.view.View p2, int p3, int p4)
    {
        return p2.getTop();
    }

    public int getViewHorizontalDragRange(android.view.View p2)
    {
        return p2.getWidth();
    }

    public void onEdgeDragStarted(int p4, int p5)
    {
        android.view.View v0;
        if ((p4 & 1) != 1) {
            v0 = this.this$0.findDrawerWithGravity(5);
        } else {
            v0 = this.this$0.findDrawerWithGravity(3);
        }
        if ((v0 != null) && (this.this$0.getDrawerLockMode(v0) == 0)) {
            this.mDragger.captureChildView(v0, p5);
        }
        return;
    }

    public boolean onEdgeLock(int p2)
    {
        return 0;
    }

    public void onEdgeTouched(int p5, int p6)
    {
        this.this$0.postDelayed(this.mPeekRunnable, 160);
        return;
    }

    public void onViewCaptured(android.view.View p3, int p4)
    {
        ((android.support.v4.widget.DrawerLayout$LayoutParams) p3.getLayoutParams()).isPeeking = 0;
        this.closeOtherDrawer();
        return;
    }

    public void onViewDragStateChanged(int p4)
    {
        this.this$0.updateDrawerState(this.mAbsGravity, p4, this.mDragger.getCapturedView());
        return;
    }

    public void onViewPositionChanged(android.view.View p6, int p7, int p8, int p9, int p10)
    {
        float v1;
        int v0 = p6.getWidth();
        if (!this.this$0.checkDrawerViewAbsoluteGravity(p6, 3)) {
            v1 = (((float) (this.this$0.getWidth() - p7)) / ((float) v0));
        } else {
            v1 = (((float) (v0 + p7)) / ((float) v0));
        }
        android.support.v4.widget.DrawerLayout v3_8;
        this.this$0.setDrawerViewOffset(p6, v1);
        if (v1 != 0) {
            v3_8 = 0;
        } else {
            v3_8 = 4;
        }
        p6.setVisibility(v3_8);
        this.this$0.invalidate();
        return;
    }

    public void onViewReleased(android.view.View p9, float p10, float p11)
    {
        int v1;
        float v2 = this.this$0.getDrawerViewOffset(p9);
        int v0 = p9.getWidth();
        if (!this.this$0.checkDrawerViewAbsoluteGravity(p9, 3)) {
            int v3 = this.this$0.getWidth();
            if ((p10 >= 0) && ((p10 != 0) || (v2 <= 1056964608))) {
                v1 = v3;
            } else {
                v1 = (v3 - v0);
            }
        } else {
            if ((p10 <= 0) && ((p10 != 0) || (v2 <= 1056964608))) {
                v1 = (- v0);
            } else {
                v1 = 0;
            }
        }
        this.mDragger.settleCapturedViewAt(v1, p9.getTop());
        this.this$0.invalidate();
        return;
    }

    public void removeCallbacks()
    {
        this.this$0.removeCallbacks(this.mPeekRunnable);
        return;
    }

    public void setDragger(android.support.v4.widget.ViewDragHelper p1)
    {
        this.mDragger = p1;
        return;
    }

    public boolean tryCaptureView(android.view.View p3, int p4)
    {
        if ((!this.this$0.isDrawerView(p3)) || ((!this.this$0.checkDrawerViewAbsoluteGravity(p3, this.mAbsGravity)) || (this.this$0.getDrawerLockMode(p3) != 0))) {
            int v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
