package android.support.v4.widget;
 class SlidingPaneLayout$SlidingPanelLayoutImplJBMR1 extends android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImplBase {

    SlidingPaneLayout$SlidingPanelLayoutImplJBMR1()
    {
        return;
    }

    public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout p2, android.view.View p3)
    {
        android.support.v4.view.ViewCompat.setLayerPaint(p3, ((android.support.v4.widget.SlidingPaneLayout$LayoutParams) p3.getLayoutParams()).dimPaint);
        return;
    }
}
