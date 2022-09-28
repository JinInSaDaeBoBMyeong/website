package android.support.v4.media;
 class TransportMediator$2 implements android.view.KeyEvent$Callback {
    final synthetic android.support.v4.media.TransportMediator this$0;

    TransportMediator$2(android.support.v4.media.TransportMediator p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onKeyDown(int p2, android.view.KeyEvent p3)
    {
        int v0_1;
        if (!android.support.v4.media.TransportMediator.isMediaKey(p2)) {
            v0_1 = 0;
        } else {
            v0_1 = this.this$0.mCallbacks.onMediaButtonDown(p2, p3);
        }
        return v0_1;
    }

    public boolean onKeyLongPress(int p2, android.view.KeyEvent p3)
    {
        return 0;
    }

    public boolean onKeyMultiple(int p2, int p3, android.view.KeyEvent p4)
    {
        return 0;
    }

    public boolean onKeyUp(int p2, android.view.KeyEvent p3)
    {
        int v0_1;
        if (!android.support.v4.media.TransportMediator.isMediaKey(p2)) {
            v0_1 = 0;
        } else {
            v0_1 = this.this$0.mCallbacks.onMediaButtonUp(p2, p3);
        }
        return v0_1;
    }
}
