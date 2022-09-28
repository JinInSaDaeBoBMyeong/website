package android.support.v4.view;
public class MotionEventCompat {
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    static final android.support.v4.view.MotionEventCompat$MotionEventVersionImpl IMPL;

    static MotionEventCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 5) {
            android.support.v4.view.MotionEventCompat.IMPL = new android.support.v4.view.MotionEventCompat$BaseMotionEventVersionImpl();
        } else {
            android.support.v4.view.MotionEventCompat.IMPL = new android.support.v4.view.MotionEventCompat$EclairMotionEventVersionImpl();
        }
        return;
    }

    public MotionEventCompat()
    {
        return;
    }

    public static int findPointerIndex(android.view.MotionEvent p1, int p2)
    {
        return android.support.v4.view.MotionEventCompat.IMPL.findPointerIndex(p1, p2);
    }

    public static int getActionIndex(android.view.MotionEvent p2)
    {
        return ((p2.getAction() & 65280) >> 8);
    }

    public static int getActionMasked(android.view.MotionEvent p1)
    {
        return (p1.getAction() & 255);
    }

    public static int getPointerCount(android.view.MotionEvent p1)
    {
        return android.support.v4.view.MotionEventCompat.IMPL.getPointerCount(p1);
    }

    public static int getPointerId(android.view.MotionEvent p1, int p2)
    {
        return android.support.v4.view.MotionEventCompat.IMPL.getPointerId(p1, p2);
    }

    public static float getX(android.view.MotionEvent p1, int p2)
    {
        return android.support.v4.view.MotionEventCompat.IMPL.getX(p1, p2);
    }

    public static float getY(android.view.MotionEvent p1, int p2)
    {
        return android.support.v4.view.MotionEventCompat.IMPL.getY(p1, p2);
    }
}
