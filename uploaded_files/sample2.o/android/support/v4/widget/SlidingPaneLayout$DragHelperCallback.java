package android.support.v4.widget;
 class SlidingPaneLayout$DragHelperCallback extends android.support.v4.widget.ViewDragHelper$Callback {
    final synthetic android.support.v4.widget.SlidingPaneLayout this$0;

    private SlidingPaneLayout$DragHelperCallback(android.support.v4.widget.SlidingPaneLayout p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic SlidingPaneLayout$DragHelperCallback(android.support.v4.widget.SlidingPaneLayout p1, android.support.v4.widget.SlidingPaneLayout$1 p2)
    {
        this(p1);
        return;
    }

    public int clampViewPositionHorizontal(android.view.View p8, int p9, int p10)
    {
        int v2;
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v1_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0).getLayoutParams());
        if (!android.support.v4.widget.SlidingPaneLayout.access$700(this.this$0)) {
            int v3_0 = (this.this$0.getPaddingLeft() + v1_1.leftMargin);
            v2 = Math.min(Math.max(p9, v3_0), (v3_0 + android.support.v4.widget.SlidingPaneLayout.access$800(this.this$0)));
        } else {
            int v3_1 = (this.this$0.getWidth() - ((this.this$0.getPaddingRight() + v1_1.rightMargin) + android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0).getWidth()));
            v2 = Math.max(Math.min(p9, v3_1), (v3_1 - android.support.v4.widget.SlidingPaneLayout.access$800(this.this$0)));
        }
        return v2;
    }

    public int clampViewPositionVertical(android.view.View p2, int p3, int p4)
    {
        return p2.getTop();
    }

    public int getViewHorizontalDragRange(android.view.View p2)
    {
        return android.support.v4.widget.SlidingPaneLayout.access$800(this.this$0);
    }

    public void onEdgeDragStarted(int p3, int p4)
    {
        android.support.v4.widget.SlidingPaneLayout.access$200(this.this$0).captureChildView(android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0), p4);
        return;
    }

    public void onViewCaptured(android.view.View p2, int p3)
    {
        this.this$0.setAllChildrenVisible();
        return;
    }

    public void onViewDragStateChanged(int p3)
    {
        if (android.support.v4.widget.SlidingPaneLayout.access$200(this.this$0).getViewDragState() == 0) {
            if (android.support.v4.widget.SlidingPaneLayout.access$300(this.this$0) != 0) {
                this.this$0.dispatchOnPanelOpened(android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0));
                android.support.v4.widget.SlidingPaneLayout.access$502(this.this$0, 1);
            } else {
                this.this$0.updateObscuredViewsVisibility(android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0));
                this.this$0.dispatchOnPanelClosed(android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0));
                android.support.v4.widget.SlidingPaneLayout.access$502(this.this$0, 0);
            }
        }
        return;
    }

    public void onViewPositionChanged(android.view.View p2, int p3, int p4, int p5, int p6)
    {
        android.support.v4.widget.SlidingPaneLayout.access$600(this.this$0, p3);
        this.this$0.invalidate();
        return;
    }

    public void onViewReleased(android.view.View p9, float p10, float p11)
    {
        int v1;
        android.support.v4.widget.SlidingPaneLayout$LayoutParams v2_1 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) p9.getLayoutParams());
        if (!android.support.v4.widget.SlidingPaneLayout.access$700(this.this$0)) {
            v1 = (this.this$0.getPaddingLeft() + v2_1.leftMargin);
            if ((p10 > 0) || ((p10 == 0) && (android.support.v4.widget.SlidingPaneLayout.access$300(this.this$0) > 1056964608))) {
                v1 += android.support.v4.widget.SlidingPaneLayout.access$800(this.this$0);
            }
        } else {
            int v3 = (this.this$0.getPaddingRight() + v2_1.rightMargin);
            if ((p10 < 0) || ((p10 == 0) && (android.support.v4.widget.SlidingPaneLayout.access$300(this.this$0) > 1056964608))) {
                v3 += android.support.v4.widget.SlidingPaneLayout.access$800(this.this$0);
            }
            v1 = ((this.this$0.getWidth() - v3) - android.support.v4.widget.SlidingPaneLayout.access$400(this.this$0).getWidth());
        }
        android.support.v4.widget.SlidingPaneLayout.access$200(this.this$0).settleCapturedViewAt(v1, p9.getTop());
        this.this$0.invalidate();
        return;
    }

    public boolean tryCaptureView(android.view.View p2, int p3)
    {
        boolean v0_4;
        if (!android.support.v4.widget.SlidingPaneLayout.access$100(this.this$0)) {
            v0_4 = ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) p2.getLayoutParams()).slideable;
        } else {
            v0_4 = 0;
        }
        return v0_4;
    }
}
