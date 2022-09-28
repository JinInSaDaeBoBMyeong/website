package android.support.v4.view;
 class ViewPropertyAnimatorCompatICS {

    ViewPropertyAnimatorCompatICS()
    {
        return;
    }

    public static void alpha(android.view.View p1, float p2)
    {
        p1.animate().alpha(p2);
        return;
    }

    public static void alphaBy(android.view.View p1, float p2)
    {
        p1.animate().alphaBy(p2);
        return;
    }

    public static void cancel(android.view.View p1)
    {
        p1.animate().cancel();
        return;
    }

    public static long getDuration(android.view.View p2)
    {
        return p2.animate().getDuration();
    }

    public static long getStartDelay(android.view.View p2)
    {
        return p2.animate().getStartDelay();
    }

    public static void rotation(android.view.View p1, float p2)
    {
        p1.animate().rotation(p2);
        return;
    }

    public static void rotationBy(android.view.View p1, float p2)
    {
        p1.animate().rotationBy(p2);
        return;
    }

    public static void rotationX(android.view.View p1, float p2)
    {
        p1.animate().rotationX(p2);
        return;
    }

    public static void rotationXBy(android.view.View p1, float p2)
    {
        p1.animate().rotationXBy(p2);
        return;
    }

    public static void rotationY(android.view.View p1, float p2)
    {
        p1.animate().rotationY(p2);
        return;
    }

    public static void rotationYBy(android.view.View p1, float p2)
    {
        p1.animate().rotationYBy(p2);
        return;
    }

    public static void scaleX(android.view.View p1, float p2)
    {
        p1.animate().scaleX(p2);
        return;
    }

    public static void scaleXBy(android.view.View p1, float p2)
    {
        p1.animate().scaleXBy(p2);
        return;
    }

    public static void scaleY(android.view.View p1, float p2)
    {
        p1.animate().scaleY(p2);
        return;
    }

    public static void scaleYBy(android.view.View p1, float p2)
    {
        p1.animate().scaleYBy(p2);
        return;
    }

    public static void setDuration(android.view.View p1, long p2)
    {
        p1.animate().setDuration(p2);
        return;
    }

    public static void setInterpolator(android.view.View p1, android.view.animation.Interpolator p2)
    {
        p1.animate().setInterpolator(p2);
        return;
    }

    public static void setListener(android.view.View p2, android.support.v4.view.ViewPropertyAnimatorListener p3)
    {
        p2.animate().setListener(new android.support.v4.view.ViewPropertyAnimatorCompatICS$1(p3, p2));
        return;
    }

    public static void setStartDelay(android.view.View p1, long p2)
    {
        p1.animate().setStartDelay(p2);
        return;
    }

    public static void start(android.view.View p1)
    {
        p1.animate().start();
        return;
    }

    public static void translationX(android.view.View p1, float p2)
    {
        p1.animate().translationX(p2);
        return;
    }

    public static void translationXBy(android.view.View p1, float p2)
    {
        p1.animate().translationXBy(p2);
        return;
    }

    public static void translationY(android.view.View p1, float p2)
    {
        p1.animate().translationY(p2);
        return;
    }

    public static void translationYBy(android.view.View p1, float p2)
    {
        p1.animate().translationYBy(p2);
        return;
    }

    public static void x(android.view.View p1, float p2)
    {
        p1.animate().x(p2);
        return;
    }

    public static void xBy(android.view.View p1, float p2)
    {
        p1.animate().xBy(p2);
        return;
    }

    public static void y(android.view.View p1, float p2)
    {
        p1.animate().y(p2);
        return;
    }

    public static void yBy(android.view.View p1, float p2)
    {
        p1.animate().yBy(p2);
        return;
    }
}
