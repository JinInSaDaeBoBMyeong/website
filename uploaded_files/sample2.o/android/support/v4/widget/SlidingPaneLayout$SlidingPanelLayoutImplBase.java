package android.support.v4.widget;
 class SlidingPaneLayout$SlidingPanelLayoutImplBase implements android.support.v4.widget.SlidingPaneLayout$SlidingPanelLayoutImpl {

    SlidingPaneLayout$SlidingPanelLayoutImplBase()
    {
        return;
    }

    public void invalidateChildRegion(android.support.v4.widget.SlidingPaneLayout p5, android.view.View p6)
    {
        android.support.v4.view.ViewCompat.postInvalidateOnAnimation(p5, p6.getLeft(), p6.getTop(), p6.getRight(), p6.getBottom());
        return;
    }
}
