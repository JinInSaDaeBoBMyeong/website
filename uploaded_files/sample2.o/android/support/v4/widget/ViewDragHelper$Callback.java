package android.support.v4.widget;
public abstract class ViewDragHelper$Callback {

    public ViewDragHelper$Callback()
    {
        return;
    }

    public int clampViewPositionHorizontal(android.view.View p2, int p3, int p4)
    {
        return 0;
    }

    public int clampViewPositionVertical(android.view.View p2, int p3, int p4)
    {
        return 0;
    }

    public int getOrderedChildIndex(int p1)
    {
        return p1;
    }

    public int getViewHorizontalDragRange(android.view.View p2)
    {
        return 0;
    }

    public int getViewVerticalDragRange(android.view.View p2)
    {
        return 0;
    }

    public void onEdgeDragStarted(int p1, int p2)
    {
        return;
    }

    public boolean onEdgeLock(int p2)
    {
        return 0;
    }

    public void onEdgeTouched(int p1, int p2)
    {
        return;
    }

    public void onViewCaptured(android.view.View p1, int p2)
    {
        return;
    }

    public void onViewDragStateChanged(int p1)
    {
        return;
    }

    public void onViewPositionChanged(android.view.View p1, int p2, int p3, int p4, int p5)
    {
        return;
    }

    public void onViewReleased(android.view.View p1, float p2, float p3)
    {
        return;
    }

    public abstract boolean tryCaptureView();
}
