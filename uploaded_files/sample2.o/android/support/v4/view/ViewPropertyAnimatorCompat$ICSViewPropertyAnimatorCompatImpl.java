package android.support.v4.view;
 class ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl extends android.support.v4.view.ViewPropertyAnimatorCompat$BaseViewPropertyAnimatorCompatImpl {

    ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl()
    {
        return;
    }

    public void alpha(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.alpha(p1, p2);
        return;
    }

    public void alphaBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.alphaBy(p1, p2);
        return;
    }

    public void cancel(android.view.View p1)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.cancel(p1);
        return;
    }

    public long getDuration(android.view.View p3)
    {
        return android.support.v4.view.ViewPropertyAnimatorCompatICS.getDuration(p3);
    }

    public long getStartDelay(android.view.View p3)
    {
        return android.support.v4.view.ViewPropertyAnimatorCompatICS.getStartDelay(p3);
    }

    public void rotation(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotation(p1, p2);
        return;
    }

    public void rotationBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotationBy(p1, p2);
        return;
    }

    public void rotationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotationX(p1, p2);
        return;
    }

    public void rotationXBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotationXBy(p1, p2);
        return;
    }

    public void rotationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotationY(p1, p2);
        return;
    }

    public void rotationYBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.rotationYBy(p1, p2);
        return;
    }

    public void scaleX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.scaleX(p1, p2);
        return;
    }

    public void scaleXBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.scaleXBy(p1, p2);
        return;
    }

    public void scaleY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.scaleY(p1, p2);
        return;
    }

    public void scaleYBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.scaleYBy(p1, p2);
        return;
    }

    public void setDuration(android.view.View p1, long p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.setDuration(p1, p2);
        return;
    }

    public void setInterpolator(android.view.View p1, android.view.animation.Interpolator p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.setInterpolator(p1, p2);
        return;
    }

    public void setListener(android.view.View p1, android.support.v4.view.ViewPropertyAnimatorListener p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.setListener(p1, p2);
        return;
    }

    public void setStartDelay(android.view.View p1, long p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.setStartDelay(p1, p2);
        return;
    }

    public void start(android.view.View p1)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.start(p1);
        return;
    }

    public void translationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.translationX(p1, p2);
        return;
    }

    public void translationXBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.translationXBy(p1, p2);
        return;
    }

    public void translationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.translationY(p1, p2);
        return;
    }

    public void translationYBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.translationYBy(p1, p2);
        return;
    }

    public void withEndAction(android.view.View p2, Runnable p3)
    {
        this.setListener(p2, new android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$1(this, p3));
        return;
    }

    public void withLayer(android.view.View p3)
    {
        this.setListener(p3, new android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$3(this, android.support.v4.view.ViewCompat.getLayerType(p3)));
        return;
    }

    public void withStartAction(android.view.View p2, Runnable p3)
    {
        this.setListener(p2, new android.support.v4.view.ViewPropertyAnimatorCompat$ICSViewPropertyAnimatorCompatImpl$2(this, p3));
        return;
    }

    public void x(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.x(p1, p2);
        return;
    }

    public void xBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.xBy(p1, p2);
        return;
    }

    public void y(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.y(p1, p2);
        return;
    }

    public void yBy(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewPropertyAnimatorCompatICS.yBy(p1, p2);
        return;
    }
}
