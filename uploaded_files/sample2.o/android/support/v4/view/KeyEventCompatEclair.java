package android.support.v4.view;
 class KeyEventCompatEclair {

    KeyEventCompatEclair()
    {
        return;
    }

    public static boolean dispatch(android.view.KeyEvent p1, android.view.KeyEvent$Callback p2, Object p3, Object p4)
    {
        return p1.dispatch(p2, ((android.view.KeyEvent$DispatcherState) p3), p4);
    }

    public static Object getKeyDispatcherState(android.view.View p1)
    {
        return p1.getKeyDispatcherState();
    }

    public static boolean isTracking(android.view.KeyEvent p1)
    {
        return p1.isTracking();
    }

    public static void startTracking(android.view.KeyEvent p0)
    {
        p0.startTracking();
        return;
    }
}
