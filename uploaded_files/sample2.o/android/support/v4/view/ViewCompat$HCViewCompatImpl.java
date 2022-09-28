package android.support.v4.view;
 class ViewCompat$HCViewCompatImpl extends android.support.v4.view.ViewCompat$GBViewCompatImpl {

    ViewCompat$HCViewCompatImpl()
    {
        return;
    }

    public float getAlpha(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getAlpha(p2);
    }

    long getFrameTime()
    {
        return android.support.v4.view.ViewCompatHC.getFrameTime();
    }

    public int getLayerType(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getLayerType(p2);
    }

    public int getMeasuredHeightAndState(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getMeasuredHeightAndState(p2);
    }

    public int getMeasuredState(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getMeasuredState(p2);
    }

    public int getMeasuredWidthAndState(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getMeasuredWidthAndState(p2);
    }

    public float getPivotX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getPivotX(p2);
    }

    public float getPivotY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getPivotY(p2);
    }

    public float getRotation(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getRotation(p2);
    }

    public float getRotationX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getRotationX(p2);
    }

    public float getRotationY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getRotationY(p2);
    }

    public float getScaleX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getScaleX(p2);
    }

    public float getScaleY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getScaleY(p2);
    }

    public float getTranslationX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getTranslationX(p2);
    }

    public float getTranslationY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getTranslationY(p2);
    }

    public float getX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getX(p2);
    }

    public float getY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompatHC.getY(p2);
    }

    public int resolveSizeAndState(int p2, int p3, int p4)
    {
        return android.support.v4.view.ViewCompatHC.resolveSizeAndState(p2, p3, p4);
    }

    public void setAlpha(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setAlpha(p1, p2);
        return;
    }

    public void setLayerPaint(android.view.View p2, android.graphics.Paint p3)
    {
        this.setLayerType(p2, this.getLayerType(p2), p3);
        p2.invalidate();
        return;
    }

    public void setLayerType(android.view.View p1, int p2, android.graphics.Paint p3)
    {
        android.support.v4.view.ViewCompatHC.setLayerType(p1, p2, p3);
        return;
    }

    public void setPivotX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setPivotX(p1, p2);
        return;
    }

    public void setPivotY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setPivotY(p1, p2);
        return;
    }

    public void setRotation(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setRotation(p1, p2);
        return;
    }

    public void setRotationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setRotationX(p1, p2);
        return;
    }

    public void setRotationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setRotationY(p1, p2);
        return;
    }

    public void setScaleX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setScaleX(p1, p2);
        return;
    }

    public void setScaleY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setScaleY(p1, p2);
        return;
    }

    public void setTranslationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setTranslationX(p1, p2);
        return;
    }

    public void setTranslationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setTranslationY(p1, p2);
        return;
    }

    public void setX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setX(p1, p2);
        return;
    }

    public void setY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompatHC.setY(p1, p2);
        return;
    }
}
