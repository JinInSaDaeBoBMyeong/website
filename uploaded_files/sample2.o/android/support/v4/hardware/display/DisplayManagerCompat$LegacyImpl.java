package android.support.v4.hardware.display;
 class DisplayManagerCompat$LegacyImpl extends android.support.v4.hardware.display.DisplayManagerCompat {
    private final android.view.WindowManager mWindowManager;

    public DisplayManagerCompat$LegacyImpl(android.content.Context p2)
    {
        this.mWindowManager = ((android.view.WindowManager) p2.getSystemService("window"));
        return;
    }

    public android.view.Display getDisplay(int p3)
    {
        int v0 = this.mWindowManager.getDefaultDisplay();
        if (v0.getDisplayId() != p3) {
            v0 = 0;
        }
        return v0;
    }

    public android.view.Display[] getDisplays()
    {
        android.view.Display[] v0_1 = new android.view.Display[1];
        v0_1[0] = this.mWindowManager.getDefaultDisplay();
        return v0_1;
    }

    public android.view.Display[] getDisplays(String p2)
    {
        android.view.Display[] v0_1;
        if (p2 != null) {
            v0_1 = new android.view.Display[0];
        } else {
            v0_1 = this.getDisplays();
        }
        return v0_1;
    }
}
