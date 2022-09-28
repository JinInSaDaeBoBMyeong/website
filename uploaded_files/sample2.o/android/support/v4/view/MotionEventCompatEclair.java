package android.support.v4.view;
 class MotionEventCompatEclair {

    MotionEventCompatEclair()
    {
        return;
    }

    public static int findPointerIndex(android.view.MotionEvent p1, int p2)
    {
        return p1.findPointerIndex(p2);
    }

    public static int getPointerCount(android.view.MotionEvent p1)
    {
        return p1.getPointerCount();
    }

    public static int getPointerId(android.view.MotionEvent p1, int p2)
    {
        return p1.getPointerId(p2);
    }

    public static float getX(android.view.MotionEvent p1, int p2)
    {
        return p1.getX(p2);
    }

    public static float getY(android.view.MotionEvent p1, int p2)
    {
        return p1.getY(p2);
    }
}
