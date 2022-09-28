package android.support.v4.view.accessibility;
 class AccessibilityNodeInfoCompatIcs {

    AccessibilityNodeInfoCompatIcs()
    {
        return;
    }

    public static void addAction(Object p0, int p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).addAction(p1);
        return;
    }

    public static void addChild(Object p0, android.view.View p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).addChild(p1);
        return;
    }

    public static java.util.List findAccessibilityNodeInfosByText(Object p1, String p2)
    {
        return ((java.util.List) ((android.view.accessibility.AccessibilityNodeInfo) p1).findAccessibilityNodeInfosByText(p2));
    }

    public static int getActions(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getActions();
    }

    public static void getBoundsInParent(Object p0, android.graphics.Rect p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).getBoundsInParent(p1);
        return;
    }

    public static void getBoundsInScreen(Object p0, android.graphics.Rect p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).getBoundsInScreen(p1);
        return;
    }

    public static Object getChild(Object p1, int p2)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getChild(p2);
    }

    public static int getChildCount(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getChildCount();
    }

    public static CharSequence getClassName(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getClassName();
    }

    public static CharSequence getContentDescription(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getContentDescription();
    }

    public static CharSequence getPackageName(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getPackageName();
    }

    public static Object getParent(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getParent();
    }

    public static CharSequence getText(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getText();
    }

    public static int getWindowId(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).getWindowId();
    }

    public static boolean isCheckable(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isCheckable();
    }

    public static boolean isChecked(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isChecked();
    }

    public static boolean isClickable(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isClickable();
    }

    public static boolean isEnabled(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isEnabled();
    }

    public static boolean isFocusable(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isFocusable();
    }

    public static boolean isFocused(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isFocused();
    }

    public static boolean isLongClickable(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isLongClickable();
    }

    public static boolean isPassword(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isPassword();
    }

    public static boolean isScrollable(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isScrollable();
    }

    public static boolean isSelected(Object p1)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).isSelected();
    }

    public static Object obtain()
    {
        return android.view.accessibility.AccessibilityNodeInfo.obtain();
    }

    public static Object obtain(android.view.View p1)
    {
        return android.view.accessibility.AccessibilityNodeInfo.obtain(p1);
    }

    public static Object obtain(Object p1)
    {
        return android.view.accessibility.AccessibilityNodeInfo.obtain(((android.view.accessibility.AccessibilityNodeInfo) p1));
    }

    public static boolean performAction(Object p1, int p2)
    {
        return ((android.view.accessibility.AccessibilityNodeInfo) p1).performAction(p2);
    }

    public static void recycle(Object p0)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).recycle();
        return;
    }

    public static void setBoundsInParent(Object p0, android.graphics.Rect p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setBoundsInParent(p1);
        return;
    }

    public static void setBoundsInScreen(Object p0, android.graphics.Rect p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setBoundsInScreen(p1);
        return;
    }

    public static void setCheckable(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setCheckable(p1);
        return;
    }

    public static void setChecked(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setChecked(p1);
        return;
    }

    public static void setClassName(Object p0, CharSequence p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setClassName(p1);
        return;
    }

    public static void setClickable(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setClickable(p1);
        return;
    }

    public static void setContentDescription(Object p0, CharSequence p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setContentDescription(p1);
        return;
    }

    public static void setEnabled(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setEnabled(p1);
        return;
    }

    public static void setFocusable(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setFocusable(p1);
        return;
    }

    public static void setFocused(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setFocused(p1);
        return;
    }

    public static void setLongClickable(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setLongClickable(p1);
        return;
    }

    public static void setPackageName(Object p0, CharSequence p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setPackageName(p1);
        return;
    }

    public static void setParent(Object p0, android.view.View p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setParent(p1);
        return;
    }

    public static void setPassword(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setPassword(p1);
        return;
    }

    public static void setScrollable(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setScrollable(p1);
        return;
    }

    public static void setSelected(Object p0, boolean p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setSelected(p1);
        return;
    }

    public static void setSource(Object p0, android.view.View p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setSource(p1);
        return;
    }

    public static void setText(Object p0, CharSequence p1)
    {
        ((android.view.accessibility.AccessibilityNodeInfo) p0).setText(p1);
        return;
    }
}
