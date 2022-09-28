package android.support.v4.view;
public class GestureDetectorCompat {
    private final android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl mImpl;

    public GestureDetectorCompat(android.content.Context p2, android.view.GestureDetector$OnGestureListener p3)
    {
        this(p2, p3, 0);
        return;
    }

    public GestureDetectorCompat(android.content.Context p3, android.view.GestureDetector$OnGestureListener p4, android.os.Handler p5)
    {
        if (android.os.Build$VERSION.SDK_INT <= 17) {
            this.mImpl = new android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase(p3, p4, p5);
        } else {
            this.mImpl = new android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(p3, p4, p5);
        }
        return;
    }

    public boolean isLongpressEnabled()
    {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(android.view.MotionEvent p2)
    {
        return this.mImpl.onTouchEvent(p2);
    }

    public void setIsLongpressEnabled(boolean p2)
    {
        this.mImpl.setIsLongpressEnabled(p2);
        return;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector$OnDoubleTapListener p2)
    {
        this.mImpl.setOnDoubleTapListener(p2);
        return;
    }
}
