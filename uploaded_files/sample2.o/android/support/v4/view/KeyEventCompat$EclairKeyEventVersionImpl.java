package android.support.v4.view;
 class KeyEventCompat$EclairKeyEventVersionImpl extends android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl {

    KeyEventCompat$EclairKeyEventVersionImpl()
    {
        return;
    }

    public boolean dispatch(android.view.KeyEvent p2, android.view.KeyEvent$Callback p3, Object p4, Object p5)
    {
        return android.support.v4.view.KeyEventCompatEclair.dispatch(p2, p3, p4, p5);
    }

    public Object getKeyDispatcherState(android.view.View p2)
    {
        return android.support.v4.view.KeyEventCompatEclair.getKeyDispatcherState(p2);
    }

    public boolean isTracking(android.view.KeyEvent p2)
    {
        return android.support.v4.view.KeyEventCompatEclair.isTracking(p2);
    }

    public void startTracking(android.view.KeyEvent p1)
    {
        android.support.v4.view.KeyEventCompatEclair.startTracking(p1);
        return;
    }
}
