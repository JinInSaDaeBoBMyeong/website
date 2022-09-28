package android.support.v4.media;
 class TransportMediatorJellybeanMR2$2 implements android.view.ViewTreeObserver$OnWindowFocusChangeListener {
    final synthetic android.support.v4.media.TransportMediatorJellybeanMR2 this$0;

    TransportMediatorJellybeanMR2$2(android.support.v4.media.TransportMediatorJellybeanMR2 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onWindowFocusChanged(boolean p2)
    {
        if (!p2) {
            this.this$0.loseFocus();
        } else {
            this.this$0.gainFocus();
        }
        return;
    }
}
