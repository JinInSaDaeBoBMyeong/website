package android.support.v4.media;
 class TransportMediatorJellybeanMR2$4 implements android.media.AudioManager$OnAudioFocusChangeListener {
    final synthetic android.support.v4.media.TransportMediatorJellybeanMR2 this$0;

    TransportMediatorJellybeanMR2$4(android.support.v4.media.TransportMediatorJellybeanMR2 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onAudioFocusChange(int p2)
    {
        this.this$0.mTransportCallback.handleAudioFocusChange(p2);
        return;
    }
}
