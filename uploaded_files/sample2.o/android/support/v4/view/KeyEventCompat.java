package android.support.v4.view;
public class KeyEventCompat {
    static final android.support.v4.view.KeyEventCompat$KeyEventVersionImpl IMPL;

    static KeyEventCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 11) {
            android.support.v4.view.KeyEventCompat.IMPL = new android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl();
        } else {
            android.support.v4.view.KeyEventCompat.IMPL = new android.support.v4.view.KeyEventCompat$HoneycombKeyEventVersionImpl();
        }
        return;
    }

    public KeyEventCompat()
    {
        return;
    }

    public static boolean dispatch(android.view.KeyEvent p1, android.view.KeyEvent$Callback p2, Object p3, Object p4)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.dispatch(p1, p2, p3, p4);
    }

    public static Object getKeyDispatcherState(android.view.View p1)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.getKeyDispatcherState(p1);
    }

    public static boolean hasModifiers(android.view.KeyEvent p2, int p3)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.metaStateHasModifiers(p2.getMetaState(), p3);
    }

    public static boolean hasNoModifiers(android.view.KeyEvent p2)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.metaStateHasNoModifiers(p2.getMetaState());
    }

    public static boolean isTracking(android.view.KeyEvent p1)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.isTracking(p1);
    }

    public static boolean metaStateHasModifiers(int p1, int p2)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.metaStateHasModifiers(p1, p2);
    }

    public static boolean metaStateHasNoModifiers(int p1)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.metaStateHasNoModifiers(p1);
    }

    public static int normalizeMetaState(int p1)
    {
        return android.support.v4.view.KeyEventCompat.IMPL.normalizeMetaState(p1);
    }

    public static void startTracking(android.view.KeyEvent p1)
    {
        android.support.v4.view.KeyEventCompat.IMPL.startTracking(p1);
        return;
    }
}
