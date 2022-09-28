package android.support.v4.view;
 class ViewCompat$BaseViewCompatImpl implements android.support.v4.view.ViewCompat$ViewCompatImpl {
    private reflect.Method mDispatchFinishTemporaryDetach;
    private reflect.Method mDispatchStartTemporaryDetach;
    private boolean mTempDetachBound;
    java.util.WeakHashMap mViewPropertyAnimatorCompatMap;

    ViewCompat$BaseViewCompatImpl()
    {
        this.mViewPropertyAnimatorCompatMap = 0;
        return;
    }

    private void bindTempDetach()
    {
        try {
            Class[] v3_2 = new Class[0];
            this.mDispatchStartTemporaryDetach = android.view.View.getDeclaredMethod("dispatchStartTemporaryDetach", v3_2);
            Class[] v3_0 = new Class[0];
            this.mDispatchFinishTemporaryDetach = android.view.View.getDeclaredMethod("dispatchFinishTemporaryDetach", v3_0);
        } catch (NoSuchMethodException v0) {
            android.util.Log.e("ViewCompat", "Couldn\'t find method", v0);
        }
        this.mTempDetachBound = 1;
        return;
    }

    public android.support.v4.view.ViewPropertyAnimatorCompat animate(android.view.View p2)
    {
        return new android.support.v4.view.ViewPropertyAnimatorCompat(p2);
    }

    public boolean canScrollHorizontally(android.view.View p2, int p3)
    {
        return 0;
    }

    public boolean canScrollVertically(android.view.View p2, int p3)
    {
        return 0;
    }

    public void dispatchFinishTemporaryDetach(android.view.View p4)
    {
        if (!this.mTempDetachBound) {
            this.bindTempDetach();
        }
        if (this.mDispatchFinishTemporaryDetach == null) {
            p4.onFinishTemporaryDetach();
        } else {
            try {
                String v2_2 = new Object[0];
                this.mDispatchFinishTemporaryDetach.invoke(p4, v2_2);
            } catch (Exception v0) {
                android.util.Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", v0);
            }
        }
        return;
    }

    public void dispatchStartTemporaryDetach(android.view.View p4)
    {
        if (!this.mTempDetachBound) {
            this.bindTempDetach();
        }
        if (this.mDispatchStartTemporaryDetach == null) {
            p4.onStartTemporaryDetach();
        } else {
            try {
                String v2_2 = new Object[0];
                this.mDispatchStartTemporaryDetach.invoke(p4, v2_2);
            } catch (Exception v0) {
                android.util.Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", v0);
            }
        }
        return;
    }

    public int getAccessibilityLiveRegion(android.view.View p2)
    {
        return 0;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View p2)
    {
        return 0;
    }

    public float getAlpha(android.view.View p2)
    {
        return 1065353216;
    }

    long getFrameTime()
    {
        return 10;
    }

    public int getImportantForAccessibility(android.view.View p2)
    {
        return 0;
    }

    public int getLabelFor(android.view.View p2)
    {
        return 0;
    }

    public int getLayerType(android.view.View p2)
    {
        return 0;
    }

    public int getLayoutDirection(android.view.View p2)
    {
        return 0;
    }

    public int getMeasuredHeightAndState(android.view.View p2)
    {
        return p2.getMeasuredHeight();
    }

    public int getMeasuredState(android.view.View p2)
    {
        return 0;
    }

    public int getMeasuredWidthAndState(android.view.View p2)
    {
        return p2.getMeasuredWidth();
    }

    public int getMinimumHeight(android.view.View p2)
    {
        return 0;
    }

    public int getMinimumWidth(android.view.View p2)
    {
        return 0;
    }

    public int getOverScrollMode(android.view.View p2)
    {
        return 2;
    }

    public int getPaddingEnd(android.view.View p2)
    {
        return p2.getPaddingRight();
    }

    public int getPaddingStart(android.view.View p2)
    {
        return p2.getPaddingLeft();
    }

    public android.view.ViewParent getParentForAccessibility(android.view.View p2)
    {
        return p2.getParent();
    }

    public float getPivotX(android.view.View p2)
    {
        return 0;
    }

    public float getPivotY(android.view.View p2)
    {
        return 0;
    }

    public float getRotation(android.view.View p2)
    {
        return 0;
    }

    public float getRotationX(android.view.View p2)
    {
        return 0;
    }

    public float getRotationY(android.view.View p2)
    {
        return 0;
    }

    public float getScaleX(android.view.View p2)
    {
        return 0;
    }

    public float getScaleY(android.view.View p2)
    {
        return 0;
    }

    public float getTranslationX(android.view.View p2)
    {
        return 0;
    }

    public float getTranslationY(android.view.View p2)
    {
        return 0;
    }

    public float getX(android.view.View p2)
    {
        return 0;
    }

    public float getY(android.view.View p2)
    {
        return 0;
    }

    public boolean hasTransientState(android.view.View p2)
    {
        return 0;
    }

    public boolean isOpaque(android.view.View p5)
    {
        int v1 = 0;
        android.graphics.drawable.Drawable v0 = p5.getBackground();
        if ((v0 != null) && (v0.getOpacity() == -1)) {
            v1 = 1;
        }
        return v1;
    }

    public void onInitializeAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        return;
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View p1, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p2)
    {
        return;
    }

    public void onPopulateAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        return;
    }

    public boolean performAccessibilityAction(android.view.View p2, int p3, android.os.Bundle p4)
    {
        return 0;
    }

    public void postInvalidateOnAnimation(android.view.View p1)
    {
        p1.invalidate();
        return;
    }

    public void postInvalidateOnAnimation(android.view.View p1, int p2, int p3, int p4, int p5)
    {
        p1.invalidate(p2, p3, p4, p5);
        return;
    }

    public void postOnAnimation(android.view.View p3, Runnable p4)
    {
        p3.postDelayed(p4, this.getFrameTime());
        return;
    }

    public void postOnAnimationDelayed(android.view.View p4, Runnable p5, long p6)
    {
        p4.postDelayed(p5, (this.getFrameTime() + p6));
        return;
    }

    public int resolveSizeAndState(int p2, int p3, int p4)
    {
        return android.view.View.resolveSize(p2, p3);
    }

    public void setAccessibilityDelegate(android.view.View p1, android.support.v4.view.AccessibilityDelegateCompat p2)
    {
        return;
    }

    public void setAccessibilityLiveRegion(android.view.View p1, int p2)
    {
        return;
    }

    public void setAlpha(android.view.View p1, float p2)
    {
        return;
    }

    public void setHasTransientState(android.view.View p1, boolean p2)
    {
        return;
    }

    public void setImportantForAccessibility(android.view.View p1, int p2)
    {
        return;
    }

    public void setLabelFor(android.view.View p1, int p2)
    {
        return;
    }

    public void setLayerPaint(android.view.View p1, android.graphics.Paint p2)
    {
        return;
    }

    public void setLayerType(android.view.View p1, int p2, android.graphics.Paint p3)
    {
        return;
    }

    public void setLayoutDirection(android.view.View p1, int p2)
    {
        return;
    }

    public void setOverScrollMode(android.view.View p1, int p2)
    {
        return;
    }

    public void setPaddingRelative(android.view.View p1, int p2, int p3, int p4, int p5)
    {
        p1.setPadding(p2, p3, p4, p5);
        return;
    }

    public void setPivotX(android.view.View p1, float p2)
    {
        return;
    }

    public void setPivotY(android.view.View p1, float p2)
    {
        return;
    }

    public void setRotation(android.view.View p1, float p2)
    {
        return;
    }

    public void setRotationX(android.view.View p1, float p2)
    {
        return;
    }

    public void setRotationY(android.view.View p1, float p2)
    {
        return;
    }

    public void setScaleX(android.view.View p1, float p2)
    {
        return;
    }

    public void setScaleY(android.view.View p1, float p2)
    {
        return;
    }

    public void setTranslationX(android.view.View p1, float p2)
    {
        return;
    }

    public void setTranslationY(android.view.View p1, float p2)
    {
        return;
    }

    public void setX(android.view.View p1, float p2)
    {
        return;
    }

    public void setY(android.view.View p1, float p2)
    {
        return;
    }
}
