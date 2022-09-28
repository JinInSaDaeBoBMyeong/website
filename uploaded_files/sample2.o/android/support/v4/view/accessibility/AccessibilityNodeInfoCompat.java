package android.support.v4.view.accessibility;
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl IMPL = None;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private final Object mInfo;

    static AccessibilityNodeInfoCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 19) {
            if (android.os.Build$VERSION.SDK_INT < 18) {
                if (android.os.Build$VERSION.SDK_INT < 16) {
                    if (android.os.Build$VERSION.SDK_INT < 14) {
                        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl();
                    } else {
                        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl();
                    }
                } else {
                    android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl();
                }
            } else {
                android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl();
            }
        } else {
            android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl();
        }
        return;
    }

    public AccessibilityNodeInfoCompat(Object p1)
    {
        this.mInfo = p1;
        return;
    }

    private static String getActionSymbolicName(int p1)
    {
        String v0;
        switch (p1) {
            case 1:
                v0 = "ACTION_FOCUS";
                break;
            case 2:
                v0 = "ACTION_CLEAR_FOCUS";
                break;
            case 4:
                v0 = "ACTION_SELECT";
                break;
            case 8:
                v0 = "ACTION_CLEAR_SELECTION";
                break;
            case 16:
                v0 = "ACTION_CLICK";
                break;
            case 32:
                v0 = "ACTION_LONG_CLICK";
                break;
            case 64:
                v0 = "ACTION_ACCESSIBILITY_FOCUS";
                break;
            case 128:
                v0 = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                break;
            case 256:
                v0 = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                break;
            case 512:
                v0 = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                break;
            case 1024:
                v0 = "ACTION_NEXT_HTML_ELEMENT";
                break;
            case 2048:
                v0 = "ACTION_PREVIOUS_HTML_ELEMENT";
                break;
            case 4096:
                v0 = "ACTION_SCROLL_FORWARD";
                break;
            case 8192:
                v0 = "ACTION_SCROLL_BACKWARD";
                break;
            case 16384:
                v0 = "ACTION_COPY";
                break;
            case 32768:
                v0 = "ACTION_PASTE";
                break;
            case 65536:
                v0 = "ACTION_CUT";
                break;
            case 131072:
                v0 = "ACTION_SET_SELECTION";
                break;
            default:
                v0 = "ACTION_UNKNOWN";
        }
        return v0;
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtain());
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat p2)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtain(p2.mInfo));
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View p1)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtain(p1));
    }

    public static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat obtain(android.view.View p1, int p2)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.obtain(p1, p2));
    }

    static android.support.v4.view.accessibility.AccessibilityNodeInfoCompat wrapNonNullInstance(Object p1)
    {
        int v0_0;
        if (p1 == null) {
            v0_0 = 0;
        } else {
            v0_0 = new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat(p1);
        }
        return v0_0;
    }

    public void addAction(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.addAction(this.mInfo, p3);
        return;
    }

    public void addChild(android.view.View p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, p3);
        return;
    }

    public void addChild(android.view.View p3, int p4)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.addChild(this.mInfo, p3, p4);
        return;
    }

    public boolean equals(Object p6)
    {
        int v1 = 1;
        if (this != p6) {
            if (p6 != null) {
                if (this.getClass() == p6.getClass()) {
                    if (this.mInfo != null) {
                        if (!this.mInfo.equals(((android.support.v4.view.accessibility.AccessibilityNodeInfoCompat) p6).mInfo)) {
                            v1 = 0;
                        }
                    } else {
                        if (((android.support.v4.view.accessibility.AccessibilityNodeInfoCompat) p6).mInfo != null) {
                            v1 = 0;
                        }
                    }
                } else {
                    v1 = 0;
                }
            } else {
                v1 = 0;
            }
        }
        return v1;
    }

    public java.util.List findAccessibilityNodeInfosByText(String p8)
    {
        java.util.ArrayList v4_1 = new java.util.ArrayList();
        java.util.List v3 = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.findAccessibilityNodeInfosByText(this.mInfo, p8);
        int v2 = v3.size();
        int v0 = 0;
        while (v0 < v2) {
            v4_1.add(new android.support.v4.view.accessibility.AccessibilityNodeInfoCompat(v3.get(v0)));
            v0++;
        }
        return v4_1;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat findFocus(int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.findFocus(this.mInfo, p3));
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat focusSearch(int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.focusSearch(this.mInfo, p3));
    }

    public int getActions()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getActions(this.mInfo);
    }

    public void getBoundsInParent(android.graphics.Rect p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getBoundsInParent(this.mInfo, p3);
        return;
    }

    public void getBoundsInScreen(android.graphics.Rect p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getBoundsInScreen(this.mInfo, p3);
        return;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getChild(int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getChild(this.mInfo, p3));
    }

    public int getChildCount()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getChildCount(this.mInfo);
    }

    public CharSequence getClassName()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getClassName(this.mInfo);
    }

    public CharSequence getContentDescription()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getContentDescription(this.mInfo);
    }

    public Object getInfo()
    {
        return this.mInfo;
    }

    public int getLiveRegion()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getLiveRegion(this.mInfo);
    }

    public int getMovementGranularities()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getMovementGranularities(this.mInfo);
    }

    public CharSequence getPackageName()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getPackageName(this.mInfo);
    }

    public android.support.v4.view.accessibility.AccessibilityNodeInfoCompat getParent()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.wrapNonNullInstance(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getParent(this.mInfo));
    }

    public CharSequence getText()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getText(this.mInfo);
    }

    public String getViewIdResourceName()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getViewIdResourceName(this.mInfo);
    }

    public int getWindowId()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.getWindowId(this.mInfo);
    }

    public int hashCode()
    {
        int v0_2;
        if (this.mInfo != null) {
            v0_2 = this.mInfo.hashCode();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public boolean isAccessibilityFocused()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isAccessibilityFocused(this.mInfo);
    }

    public boolean isCheckable()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isCheckable(this.mInfo);
    }

    public boolean isChecked()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isChecked(this.mInfo);
    }

    public boolean isClickable()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isClickable(this.mInfo);
    }

    public boolean isEnabled()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isEnabled(this.mInfo);
    }

    public boolean isFocusable()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isFocusable(this.mInfo);
    }

    public boolean isFocused()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isFocused(this.mInfo);
    }

    public boolean isLongClickable()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isLongClickable(this.mInfo);
    }

    public boolean isPassword()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isPassword(this.mInfo);
    }

    public boolean isScrollable()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isScrollable(this.mInfo);
    }

    public boolean isSelected()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isSelected(this.mInfo);
    }

    public boolean isVisibleToUser()
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.isVisibleToUser(this.mInfo);
    }

    public boolean performAction(int p3)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, p3);
    }

    public boolean performAction(int p3, android.os.Bundle p4)
    {
        return android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.performAction(this.mInfo, p3, p4);
    }

    public void recycle()
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.recycle(this.mInfo);
        return;
    }

    public void setAccessibilityFocused(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setAccessibilityFocused(this.mInfo, p3);
        return;
    }

    public void setBoundsInParent(android.graphics.Rect p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setBoundsInParent(this.mInfo, p3);
        return;
    }

    public void setBoundsInScreen(android.graphics.Rect p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setBoundsInScreen(this.mInfo, p3);
        return;
    }

    public void setCheckable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setCheckable(this.mInfo, p3);
        return;
    }

    public void setChecked(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setChecked(this.mInfo, p3);
        return;
    }

    public void setClassName(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setClassName(this.mInfo, p3);
        return;
    }

    public void setClickable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setClickable(this.mInfo, p3);
        return;
    }

    public void setContentDescription(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setContentDescription(this.mInfo, p3);
        return;
    }

    public void setEnabled(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setEnabled(this.mInfo, p3);
        return;
    }

    public void setFocusable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setFocusable(this.mInfo, p3);
        return;
    }

    public void setFocused(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setFocused(this.mInfo, p3);
        return;
    }

    public void setLiveRegion(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setLiveRegion(this.mInfo, p3);
        return;
    }

    public void setLongClickable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setLongClickable(this.mInfo, p3);
        return;
    }

    public void setMovementGranularities(int p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setMovementGranularities(this.mInfo, p3);
        return;
    }

    public void setPackageName(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setPackageName(this.mInfo, p3);
        return;
    }

    public void setParent(android.view.View p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, p3);
        return;
    }

    public void setParent(android.view.View p3, int p4)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setParent(this.mInfo, p3, p4);
        return;
    }

    public void setPassword(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setPassword(this.mInfo, p3);
        return;
    }

    public void setScrollable(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setScrollable(this.mInfo, p3);
        return;
    }

    public void setSelected(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setSelected(this.mInfo, p3);
        return;
    }

    public void setSource(android.view.View p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, p3);
        return;
    }

    public void setSource(android.view.View p3, int p4)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setSource(this.mInfo, p3, p4);
        return;
    }

    public void setText(CharSequence p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setText(this.mInfo, p3);
        return;
    }

    public void setViewIdResourceName(String p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setViewIdResourceName(this.mInfo, p3);
        return;
    }

    public void setVisibleToUser(boolean p3)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.IMPL.setVisibleToUser(this.mInfo, p3);
        return;
    }

    public String toString()
    {
        StringBuilder v3_1 = new StringBuilder();
        v3_1.append(super.toString());
        android.graphics.Rect v2_1 = new android.graphics.Rect();
        this.getBoundsInParent(v2_1);
        v3_1.append(new StringBuilder().append("; boundsInParent: ").append(v2_1).toString());
        this.getBoundsInScreen(v2_1);
        v3_1.append(new StringBuilder().append("; boundsInScreen: ").append(v2_1).toString());
        v3_1.append("; packageName: ").append(this.getPackageName());
        v3_1.append("; className: ").append(this.getClassName());
        v3_1.append("; text: ").append(this.getText());
        v3_1.append("; contentDescription: ").append(this.getContentDescription());
        v3_1.append("; viewId: ").append(this.getViewIdResourceName());
        v3_1.append("; checkable: ").append(this.isCheckable());
        v3_1.append("; checked: ").append(this.isChecked());
        v3_1.append("; focusable: ").append(this.isFocusable());
        v3_1.append("; focused: ").append(this.isFocused());
        v3_1.append("; selected: ").append(this.isSelected());
        v3_1.append("; clickable: ").append(this.isClickable());
        v3_1.append("; longClickable: ").append(this.isLongClickable());
        v3_1.append("; enabled: ").append(this.isEnabled());
        v3_1.append("; password: ").append(this.isPassword());
        v3_1.append(new StringBuilder().append("; scrollable: ").append(this.isScrollable()).toString());
        v3_1.append("; [");
        int v1 = this.getActions();
        while (v1 != 0) {
            int v0 = (1 << Integer.numberOfTrailingZeros(v1));
            v1 &= (v0 ^ -1);
            v3_1.append(android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.getActionSymbolicName(v0));
            if (v1 != 0) {
                v3_1.append(", ");
            }
        }
        v3_1.append("]");
        return v3_1.toString();
    }
}
