package android.support.v4.view;
 class KeyEventCompatHoneycomb {

    KeyEventCompatHoneycomb()
    {
        return;
    }

    public static boolean metaStateHasModifiers(int p1, int p2)
    {
        return android.view.KeyEvent.metaStateHasModifiers(p1, p2);
    }

    public static boolean metaStateHasNoModifiers(int p1)
    {
        return android.view.KeyEvent.metaStateHasNoModifiers(p1);
    }

    public static int normalizeMetaState(int p1)
    {
        return android.view.KeyEvent.normalizeMetaState(p1);
    }
}
