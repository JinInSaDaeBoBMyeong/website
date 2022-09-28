package android.support.v4.hardware.display;
 class DisplayManagerCompat$JellybeanMr1Impl extends android.support.v4.hardware.display.DisplayManagerCompat {
    private final Object mDisplayManagerObj;

    public DisplayManagerCompat$JellybeanMr1Impl(android.content.Context p2)
    {
        this.mDisplayManagerObj = android.support.v4.hardware.display.DisplayManagerJellybeanMr1.getDisplayManager(p2);
        return;
    }

    public android.view.Display getDisplay(int p2)
    {
        return android.support.v4.hardware.display.DisplayManagerJellybeanMr1.getDisplay(this.mDisplayManagerObj, p2);
    }

    public android.view.Display[] getDisplays()
    {
        return android.support.v4.hardware.display.DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj);
    }

    public android.view.Display[] getDisplays(String p2)
    {
        return android.support.v4.hardware.display.DisplayManagerJellybeanMr1.getDisplays(this.mDisplayManagerObj, p2);
    }
}
