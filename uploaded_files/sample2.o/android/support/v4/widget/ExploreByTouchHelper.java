package android.support.v4.widget;
public abstract class ExploreByTouchHelper extends android.support.v4.view.AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "";
    public static final int INVALID_ID = 2147483648;
    private int mFocusedVirtualViewId;
    private int mHoveredVirtualViewId;
    private final android.view.accessibility.AccessibilityManager mManager;
    private android.support.v4.widget.ExploreByTouchHelper$ExploreByTouchNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final android.graphics.Rect mTempParentRect;
    private final android.graphics.Rect mTempScreenRect;
    private final android.graphics.Rect mTempVisibleRect;
    private final android.view.View mView;

    static ExploreByTouchHelper()
    {
        android.support.v4.widget.ExploreByTouchHelper.DEFAULT_CLASS_NAME = android.view.View.getName();
        return;
    }

    public ExploreByTouchHelper(android.view.View p4)
    {
        this.mTempScreenRect = new android.graphics.Rect();
        this.mTempParentRect = new android.graphics.Rect();
        this.mTempVisibleRect = new android.graphics.Rect();
        android.view.accessibility.AccessibilityManager v1_1 = new int[2];
        this.mTempGlobalRect = v1_1;
        this.mFocusedVirtualViewId = -2147483648;
        this.mHoveredVirtualViewId = -2147483648;
        if (p4 != null) {
            this.mView = p4;
            this.mManager = ((android.view.accessibility.AccessibilityManager) p4.getContext().getSystemService("accessibility"));
            return;
        } else {
            throw new IllegalArgumentException("View may not be null");
        }
    }

    static synthetic android.support.v4.view.accessibility.AccessibilityNodeInfoCompat access$100(android.support.v4.widget.ExploreByTouchHelper p1, int p2)
    {
        return p1.createNode(p2);
    }

    static synthetic boolean access$200(android.support.v4.widget.ExploreByTouchHelper p1, int p2, int p3, android.os.Bundle p4)
    {
        return p1.performAction(p2, p3, p4);
    }

    private boolean clearAccessibilityFocus(int p2)
    {
        int v0_1;
        if (!this.isAccessibilityFocused(p2)) {
            v0_1 = 0;
        } else {
            this.mFocusedVirtualViewId = -2147483648;
            this.mView.invalidate();
            this.sendEventForVirtualView(p2, 65536);
            v0_1 = 1;
        }
        return v0_1;
    }

    private android.view.accessibility.AccessibilityEvent createEvent(int p2, int p3)
    {
        android.view.accessibility.AccessibilityEvent v0;
        switch (p2) {
            case -1:
                v0 = this.createEventForHost(p3);
                break;
            default:
                v0 = this.createEventForChild(p2, p3);
        }
        return v0;
    }

    private android.view.accessibility.AccessibilityEvent createEventForChild(int p5, int p6)
    {
        android.view.accessibility.AccessibilityEvent v0 = android.view.accessibility.AccessibilityEvent.obtain(p6);
        v0.setEnabled(1);
        v0.setClassName(android.support.v4.widget.ExploreByTouchHelper.DEFAULT_CLASS_NAME);
        this.onPopulateEventForVirtualView(p5, v0);
        if ((!v0.getText().isEmpty()) || (v0.getContentDescription() != null)) {
            v0.setPackageName(this.mView.getContext().getPackageName());
            android.support.v4.view.accessibility.AccessibilityEventCompat.asRecord(v0).setSource(this.mView, p5);
            return v0;
        } else {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
    }

    private android.view.accessibility.AccessibilityEvent createEventForHost(int p3)
    {
        android.view.accessibility.AccessibilityEvent v0 = android.view.accessibility.AccessibilityEvent.obtain(p3);
        android.support.v4.view.ViewCompat.onInitializeAccessibilityEvent(this.mView, v0);
        return v0;
    }

    private android.support.v4.view.accessibility.AccessibilityNodeInfoCompat createNode(int p2)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v0;
        switch (p2) {
            case -1:
                v0 = this.createNodeForHost();
                break;
            default:
                v0 = this.createNodeForChild(p2);
        }
        return v0;
    }

    private android.support.v4.view.accessibility.AccessibilityNodeInfoCompat createNodeForChild(int p9)
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v1 = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.obtain();
        v1.setEnabled(1);
        v1.setClassName(android.support.v4.widget.ExploreByTouchHelper.DEFAULT_CLASS_NAME);
        this.onPopulateNodeForVirtualView(p9, v1);
        if ((v1.getText() != null) || (v1.getContentDescription() != null)) {
            v1.getBoundsInParent(this.mTempParentRect);
            if (!this.mTempParentRect.isEmpty()) {
                int v0 = v1.getActions();
                if ((v0 & 64) == 0) {
                    if ((v0 & 128) == 0) {
                        v1.setPackageName(this.mView.getContext().getPackageName());
                        v1.setSource(this.mView, p9);
                        v1.setParent(this.mView);
                        if (this.mFocusedVirtualViewId != p9) {
                            v1.setAccessibilityFocused(0);
                            v1.addAction(64);
                        } else {
                            v1.setAccessibilityFocused(1);
                            v1.addAction(128);
                        }
                        if (this.intersectVisibleToUser(this.mTempParentRect)) {
                            v1.setVisibleToUser(1);
                            v1.setBoundsInParent(this.mTempParentRect);
                        }
                        this.mView.getLocationOnScreen(this.mTempGlobalRect);
                        int v2 = this.mTempGlobalRect[0];
                        int v3 = this.mTempGlobalRect[1];
                        this.mTempScreenRect.set(this.mTempParentRect);
                        this.mTempScreenRect.offset(v2, v3);
                        v1.setBoundsInScreen(this.mTempScreenRect);
                        return v1;
                    } else {
                        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                    }
                } else {
                    throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                }
            } else {
                throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
    }

    private android.support.v4.view.accessibility.AccessibilityNodeInfoCompat createNodeForHost()
    {
        android.support.v4.view.accessibility.AccessibilityNodeInfoCompat v2 = android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.obtain(this.mView);
        android.support.v4.view.ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, v2);
        java.util.LinkedList v3_1 = new java.util.LinkedList();
        this.getVisibleVirtualViews(v3_1);
        java.util.Iterator v1 = v3_1.iterator();
        while (v1.hasNext()) {
            v2.addChild(this.mView, ((Integer) v1.next()).intValue());
        }
        return v2;
    }

    private boolean intersectVisibleToUser(android.graphics.Rect p6)
    {
        boolean v2_0 = 0;
        if ((p6 != null) && ((!p6.isEmpty()) && (this.mView.getWindowVisibility() == 0))) {
            android.view.ViewParent v1 = this.mView.getParent();
            while ((v1 instanceof android.view.View)) {
                android.view.View v0_1 = ((android.view.View) v1);
                if ((android.support.v4.view.ViewCompat.getAlpha(v0_1) > 0) && (v0_1.getVisibility() == 0)) {
                    v1 = v0_1.getParent();
                }
            }
            if ((v1 != null) && (this.mView.getLocalVisibleRect(this.mTempVisibleRect))) {
                v2_0 = p6.intersect(this.mTempVisibleRect);
            }
        }
        return v2_0;
    }

    private boolean isAccessibilityFocused(int p2)
    {
        int v0_1;
        if (this.mFocusedVirtualViewId != p2) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    private boolean manageFocusForChild(int p2, int p3, android.os.Bundle p4)
    {
        boolean v0;
        switch (p3) {
            case 64:
                v0 = this.requestAccessibilityFocus(p2);
                break;
            case 128:
                v0 = this.clearAccessibilityFocus(p2);
                break;
            default:
                v0 = 0;
        }
        return v0;
    }

    private boolean performAction(int p2, int p3, android.os.Bundle p4)
    {
        boolean v0;
        switch (p2) {
            case -1:
                v0 = this.performActionForHost(p3, p4);
                break;
            default:
                v0 = this.performActionForChild(p2, p3, p4);
        }
        return v0;
    }

    private boolean performActionForChild(int p2, int p3, android.os.Bundle p4)
    {
        boolean v0;
        switch (p3) {
            case 64:
            case 128:
                v0 = this.manageFocusForChild(p2, p3, p4);
                break;
            default:
                v0 = this.onPerformActionForVirtualView(p2, p3, p4);
        }
        return v0;
    }

    private boolean performActionForHost(int p2, android.os.Bundle p3)
    {
        return android.support.v4.view.ViewCompat.performAccessibilityAction(this.mView, p2, p3);
    }

    private boolean requestAccessibilityFocus(int p3)
    {
        int v0_0 = 0;
        if ((this.mManager.isEnabled()) && ((android.support.v4.view.accessibility.AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) && (!this.isAccessibilityFocused(p3)))) {
            this.mFocusedVirtualViewId = p3;
            this.mView.invalidate();
            this.sendEventForVirtualView(p3, 32768);
            v0_0 = 1;
        }
        return v0_0;
    }

    private void updateHoveredVirtualView(int p3)
    {
        if (this.mHoveredVirtualViewId != p3) {
            int v0 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = p3;
            this.sendEventForVirtualView(p3, 128);
            this.sendEventForVirtualView(v0, 256);
        }
        return;
    }

    public boolean dispatchHoverEvent(android.view.MotionEvent p7)
    {
        int v1 = 1;
        int v2 = 0;
        if ((this.mManager.isEnabled()) && (android.support.v4.view.accessibility.AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager))) {
            switch (p7.getAction()) {
                case 7:
                case 9:
                    int v0 = this.getVirtualViewAt(p7.getX(), p7.getY());
                    this.updateHoveredVirtualView(v0);
                    if (v0 == -2147483648) {
                        v1 = 0;
                    }
                    v2 = v1;
                    break;
                case 8:
                default:
                    break;
                case 10:
                    if (this.mFocusedVirtualViewId != -2147483648) {
                        this.updateHoveredVirtualView(-2147483648);
                        v2 = 1;
                    }
                    break;
            }
        }
        return v2;
    }

    public android.support.v4.view.accessibility.AccessibilityNodeProviderCompat getAccessibilityNodeProvider(android.view.View p3)
    {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new android.support.v4.widget.ExploreByTouchHelper$ExploreByTouchNodeProvider(this, 0);
        }
        return this.mNodeProvider;
    }

    public int getFocusedVirtualView()
    {
        return this.mFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt();

    protected abstract void getVisibleVirtualViews();

    public void invalidateRoot()
    {
        this.invalidateVirtualView(-1);
        return;
    }

    public void invalidateVirtualView(int p2)
    {
        this.sendEventForVirtualView(p2, 2048);
        return;
    }

    protected abstract boolean onPerformActionForVirtualView();

    protected abstract void onPopulateEventForVirtualView();

    protected abstract void onPopulateNodeForVirtualView();

    public boolean sendEventForVirtualView(int p5, int p6)
    {
        boolean v2_0 = 0;
        if ((p5 != -2147483648) && (this.mManager.isEnabled())) {
            android.view.ViewParent v1 = this.mView.getParent();
            if (v1 != null) {
                v2_0 = android.support.v4.view.ViewParentCompat.requestSendAccessibilityEvent(v1, this.mView, this.createEvent(p5, p6));
            }
        }
        return v2_0;
    }
}
