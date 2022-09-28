package android.support.v4.view;
 class GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 implements android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl {
    private final android.view.GestureDetector mDetector;

    public GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(android.content.Context p2, android.view.GestureDetector$OnGestureListener p3, android.os.Handler p4)
    {
        this.mDetector = new android.view.GestureDetector(p2, p3, p4);
        return;
    }

    public boolean isLongpressEnabled()
    {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(android.view.MotionEvent p2)
    {
        return this.mDetector.onTouchEvent(p2);
    }

    public void setIsLongpressEnabled(boolean p2)
    {
        this.mDetector.setIsLongpressEnabled(p2);
        return;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector$OnDoubleTapListener p2)
    {
        this.mDetector.setOnDoubleTapListener(p2);
        return;
    }
}
