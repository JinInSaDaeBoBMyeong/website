package android.support.v4.view;
 class MotionEventCompat$BaseMotionEventVersionImpl implements android.support.v4.view.MotionEventCompat$MotionEventVersionImpl {

    MotionEventCompat$BaseMotionEventVersionImpl()
    {
        return;
    }

    public int findPointerIndex(android.view.MotionEvent p2, int p3)
    {
        int v0;
        if (p3 != 0) {
            v0 = -1;
        } else {
            v0 = 0;
        }
        return v0;
    }

    public int getPointerCount(android.view.MotionEvent p2)
    {
        return 1;
    }

    public int getPointerId(android.view.MotionEvent p3, int p4)
    {
        if (p4 != 0) {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        } else {
            return 0;
        }
    }

    public float getX(android.view.MotionEvent p3, int p4)
    {
        if (p4 != 0) {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        } else {
            return p3.getX();
        }
    }

    public float getY(android.view.MotionEvent p3, int p4)
    {
        if (p4 != 0) {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        } else {
            return p3.getY();
        }
    }
}
