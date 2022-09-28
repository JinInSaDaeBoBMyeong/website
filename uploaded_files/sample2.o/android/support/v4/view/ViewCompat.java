package android.support.v4.view;
public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10;
    static final android.support.v4.view.ViewCompat$ViewCompatImpl IMPL = None;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = 4278190080;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    private static final String TAG = "ViewCompat";

    static ViewCompat()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 19) {
            if (v0 < 17) {
                if (v0 < 16) {
                    if (v0 < 14) {
                        if (v0 < 11) {
                            if (v0 < 9) {
                                android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$BaseViewCompatImpl();
                            } else {
                                android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$GBViewCompatImpl();
                            }
                        } else {
                            android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$HCViewCompatImpl();
                        }
                    } else {
                        android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$ICSViewCompatImpl();
                    }
                } else {
                    android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$JBViewCompatImpl();
                }
            } else {
                android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl();
            }
        } else {
            android.support.v4.view.ViewCompat.IMPL = new android.support.v4.view.ViewCompat$KitKatViewCompatImpl();
        }
        return;
    }

    public ViewCompat()
    {
        return;
    }

    public static android.support.v4.view.ViewPropertyAnimatorCompat animate(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.animate(p1);
    }

    public static boolean canScrollHorizontally(android.view.View p1, int p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.canScrollHorizontally(p1, p2);
    }

    public static boolean canScrollVertically(android.view.View p1, int p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.canScrollVertically(p1, p2);
    }

    public static void dispatchFinishTemporaryDetach(android.view.View p1)
    {
        android.support.v4.view.ViewCompat.IMPL.dispatchFinishTemporaryDetach(p1);
        return;
    }

    public static void dispatchStartTemporaryDetach(android.view.View p1)
    {
        android.support.v4.view.ViewCompat.IMPL.dispatchStartTemporaryDetach(p1);
        return;
    }

    public static int getAccessibilityLiveRegion(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getAccessibilityLiveRegion(p1);
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getAccessibilityNodeProvider(p1);
    }

    public static float getAlpha(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getAlpha(p1);
    }

    public static int getImportantForAccessibility(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getImportantForAccessibility(p1);
    }

    public static int getLabelFor(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getLabelFor(p1);
    }

    public static int getLayerType(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getLayerType(p1);
    }

    public static int getLayoutDirection(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getLayoutDirection(p1);
    }

    public static int getMeasuredHeightAndState(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getMeasuredHeightAndState(p1);
    }

    public static int getMeasuredState(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getMeasuredState(p1);
    }

    public static int getMeasuredWidthAndState(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getMeasuredWidthAndState(p1);
    }

    public static int getMinimumHeight(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getMinimumHeight(p1);
    }

    public static int getMinimumWidth(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getMinimumWidth(p1);
    }

    public static int getOverScrollMode(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getOverScrollMode(p1);
    }

    public static int getPaddingEnd(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getPaddingEnd(p1);
    }

    public static int getPaddingStart(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getPaddingStart(p1);
    }

    public static android.view.ViewParent getParentForAccessibility(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getParentForAccessibility(p1);
    }

    public static float getTranslationX(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getTranslationX(p1);
    }

    public static float getTranslationY(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.getTranslationY(p1);
    }

    public static boolean hasTransientState(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.hasTransientState(p1);
    }

    public static boolean isOpaque(android.view.View p1)
    {
        return android.support.v4.view.ViewCompat.IMPL.isOpaque(p1);
    }

    public static void onInitializeAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        android.support.v4.view.ViewCompat.IMPL.onInitializeAccessibilityEvent(p1, p2);
        return;
    }

    public static void onInitializeAccessibilityNodeInfo(android.view.View p1, android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p2)
    {
        android.support.v4.view.ViewCompat.IMPL.onInitializeAccessibilityNodeInfo(p1, p2);
        return;
    }

    public static void onPopulateAccessibilityEvent(android.view.View p1, android.view.accessibility.AccessibilityEvent p2)
    {
        android.support.v4.view.ViewCompat.IMPL.onPopulateAccessibilityEvent(p1, p2);
        return;
    }

    public static boolean performAccessibilityAction(android.view.View p1, int p2, android.os.Bundle p3)
    {
        return android.support.v4.view.ViewCompat.IMPL.performAccessibilityAction(p1, p2, p3);
    }

    public static void postInvalidateOnAnimation(android.view.View p1)
    {
        android.support.v4.view.ViewCompat.IMPL.postInvalidateOnAnimation(p1);
        return;
    }

    public static void postInvalidateOnAnimation(android.view.View p6, int p7, int p8, int p9, int p10)
    {
        android.support.v4.view.ViewCompat.IMPL.postInvalidateOnAnimation(p6, p7, p8, p9, p10);
        return;
    }

    public static void postOnAnimation(android.view.View p1, Runnable p2)
    {
        android.support.v4.view.ViewCompat.IMPL.postOnAnimation(p1, p2);
        return;
    }

    public static void postOnAnimationDelayed(android.view.View p2, Runnable p3, long p4)
    {
        android.support.v4.view.ViewCompat.IMPL.postOnAnimationDelayed(p2, p3, p4);
        return;
    }

    public static int resolveSizeAndState(int p1, int p2, int p3)
    {
        return android.support.v4.view.ViewCompat.IMPL.resolveSizeAndState(p1, p2, p3);
    }

    public static void setAccessibilityDelegate(android.view.View p1, android.support.v4.view.AccessibilityDelegateCompat p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setAccessibilityDelegate(p1, p2);
        return;
    }

    public static void setAccessibilityLiveRegion(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setAccessibilityLiveRegion(p1, p2);
        return;
    }

    public static void setAlpha(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setAlpha(p1, p2);
        return;
    }

    public static void setHasTransientState(android.view.View p1, boolean p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setHasTransientState(p1, p2);
        return;
    }

    public static void setImportantForAccessibility(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setImportantForAccessibility(p1, p2);
        return;
    }

    public static void setLabelFor(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setLabelFor(p1, p2);
        return;
    }

    public static void setLayerPaint(android.view.View p1, android.graphics.Paint p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setLayerPaint(p1, p2);
        return;
    }

    public static void setLayerType(android.view.View p1, int p2, android.graphics.Paint p3)
    {
        android.support.v4.view.ViewCompat.IMPL.setLayerType(p1, p2, p3);
        return;
    }

    public static void setLayoutDirection(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setLayoutDirection(p1, p2);
        return;
    }

    public static void setOverScrollMode(android.view.View p1, int p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setOverScrollMode(p1, p2);
        return;
    }

    public static void setPaddingRelative(android.view.View p6, int p7, int p8, int p9, int p10)
    {
        android.support.v4.view.ViewCompat.IMPL.setPaddingRelative(p6, p7, p8, p9, p10);
        return;
    }

    public static void setRotation(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setRotation(p1, p2);
        return;
    }

    public static void setRotationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setRotationX(p1, p2);
        return;
    }

    public static void setRotationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setRotationY(p1, p2);
        return;
    }

    public static void setScaleX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setScaleX(p1, p2);
        return;
    }

    public static void setScaleY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setScaleY(p1, p2);
        return;
    }

    public static void setTranslationX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setTranslationX(p1, p2);
        return;
    }

    public static void setTranslationY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setTranslationY(p1, p2);
        return;
    }

    public static void setX(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setX(p1, p2);
        return;
    }

    public static void setY(android.view.View p1, float p2)
    {
        android.support.v4.view.ViewCompat.IMPL.setY(p1, p2);
        return;
    }

    public float getPivotX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getPivotX(p2);
    }

    public float getPivotY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getPivotY(p2);
    }

    public float getRotation(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getRotation(p2);
    }

    public float getRotationX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getRotationX(p2);
    }

    public float getRotationY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getRotationY(p2);
    }

    public float getScaleX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getScaleX(p2);
    }

    public float getScaleY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getScaleY(p2);
    }

    public float getX(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getX(p2);
    }

    public float getY(android.view.View p2)
    {
        return android.support.v4.view.ViewCompat.IMPL.getY(p2);
    }

    public void setPivotX(android.view.View p2, float p3)
    {
        android.support.v4.view.ViewCompat.IMPL.setPivotX(p2, p3);
        return;
    }

    public void setPivotY(android.view.View p2, float p3)
    {
        android.support.v4.view.ViewCompat.IMPL.setPivotX(p2, p3);
        return;
    }
}
