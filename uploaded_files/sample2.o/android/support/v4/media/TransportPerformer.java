package android.support.v4.media;
public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = 255;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = 254;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = 253;

    public TransportPerformer()
    {
        return;
    }

    public void onAudioFocusChange(int p10)
    {
        int v7 = 0;
        switch (p10) {
            case -1:
                v7 = 127;
                break;
        }
        if (v7 != 0) {
            long v2 = android.os.SystemClock.uptimeMillis();
            this.onMediaButtonDown(v7, new android.view.KeyEvent(v2, v2, 0, v7, 0));
            this.onMediaButtonUp(v7, new android.view.KeyEvent(v2, v2, 1, v7, 0));
        }
        return;
    }

    public int onGetBufferPercentage()
    {
        return 100;
    }

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public int onGetTransportControlFlags()
    {
        return 60;
    }

    public abstract boolean onIsPlaying();

    public boolean onMediaButtonDown(int p3, android.view.KeyEvent p4)
    {
        switch (p3) {
            case 79:
            case 85:
                if (!this.onIsPlaying()) {
                    this.onStart();
                } else {
                    this.onPause();
                }
                break;
            case 86:
                this.onStop();
                break;
            case 126:
                this.onStart();
                break;
            case 127:
                this.onPause();
                break;
        }
        return 1;
    }

    public boolean onMediaButtonUp(int p2, android.view.KeyEvent p3)
    {
        return 1;
    }

    public abstract void onPause();

    public abstract void onSeekTo();

    public abstract void onStart();

    public abstract void onStop();
}
