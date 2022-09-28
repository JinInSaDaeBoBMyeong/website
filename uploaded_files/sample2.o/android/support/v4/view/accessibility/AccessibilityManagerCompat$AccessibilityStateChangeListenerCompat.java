package android.support.v4.view.accessibility;
public abstract class AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat {
    final Object mListener;

    public AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat()
    {
        this.mListener = android.support.v4.view.accessibility.AccessibilityManagerCompat.access$000().newAccessiblityStateChangeListener(this);
        return;
    }

    public abstract void onAccessibilityStateChanged();
}
