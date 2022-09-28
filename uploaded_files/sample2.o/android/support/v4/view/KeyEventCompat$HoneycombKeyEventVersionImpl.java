package android.support.v4.view;
 class KeyEventCompat$HoneycombKeyEventVersionImpl extends android.support.v4.view.KeyEventCompat$EclairKeyEventVersionImpl {

    KeyEventCompat$HoneycombKeyEventVersionImpl()
    {
        return;
    }

    public boolean metaStateHasModifiers(int p2, int p3)
    {
        return android.support.v4.view.KeyEventCompatHoneycomb.metaStateHasModifiers(p2, p3);
    }

    public boolean metaStateHasNoModifiers(int p2)
    {
        return android.support.v4.view.KeyEventCompatHoneycomb.metaStateHasNoModifiers(p2);
    }

    public int normalizeMetaState(int p2)
    {
        return android.support.v4.view.KeyEventCompatHoneycomb.normalizeMetaState(p2);
    }
}
