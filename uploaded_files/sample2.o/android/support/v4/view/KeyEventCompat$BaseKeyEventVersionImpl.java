package android.support.v4.view;
 class KeyEventCompat$BaseKeyEventVersionImpl implements android.support.v4.view.KeyEventCompat$KeyEventVersionImpl {
    private static final int META_ALL_MASK = 247;
    private static final int META_MODIFIER_MASK = 247;

    KeyEventCompat$BaseKeyEventVersionImpl()
    {
        return;
    }

    private static int metaStateFilterDirectionalModifiers(int p5, int p6, int p7, int p8, int p9)
    {
        int v1;
        int v2 = 1;
        if ((p6 & p7) == 0) {
            v1 = 0;
        } else {
            v1 = 1;
        }
        int v0 = (p8 | p9);
        if ((p6 & v0) == 0) {
            v2 = 0;
        }
        if (v1 == 0) {
            if (v2 != 0) {
                p5 &= (p7 ^ -1);
            }
        } else {
            if (v2 == 0) {
                p5 &= (v0 ^ -1);
            } else {
                throw new IllegalArgumentException("bad arguments");
            }
        }
        return p5;
    }

    public boolean dispatch(android.view.KeyEvent p2, android.view.KeyEvent$Callback p3, Object p4, Object p5)
    {
        return p2.dispatch(p3);
    }

    public Object getKeyDispatcherState(android.view.View p2)
    {
        return 0;
    }

    public boolean isTracking(android.view.KeyEvent p2)
    {
        return 0;
    }

    public boolean metaStateHasModifiers(int p5, int p6)
    {
        int v0 = 1;
        if (android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl.metaStateFilterDirectionalModifiers(android.support.v4.view.KeyEventCompat$BaseKeyEventVersionImpl.metaStateFilterDirectionalModifiers((this.normalizeMetaState(p5) & 247), p6, 1, 64, 128), p6, 2, 16, 32) != p6) {
            v0 = 0;
        }
        return v0;
    }

    public boolean metaStateHasNoModifiers(int p2)
    {
        int v0_2;
        if ((this.normalizeMetaState(p2) & 247) != 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public int normalizeMetaState(int p2)
    {
        if ((p2 & 192) != 0) {
            p2 |= 1;
        }
        if ((p2 & 48) != 0) {
            p2 |= 2;
        }
        return (p2 & 247);
    }

    public void startTracking(android.view.KeyEvent p1)
    {
        return;
    }
}
