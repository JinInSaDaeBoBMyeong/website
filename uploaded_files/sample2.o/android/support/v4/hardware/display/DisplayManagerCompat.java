package android.support.v4.hardware.display;
public abstract class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final java.util.WeakHashMap sInstances;

    static DisplayManagerCompat()
    {
        android.support.v4.hardware.display.DisplayManagerCompat.sInstances = new java.util.WeakHashMap();
        return;
    }

    DisplayManagerCompat()
    {
        return;
    }

    public static android.support.v4.hardware.display.DisplayManagerCompat getInstance(android.content.Context p4)
    {
        try {
            android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl v0_0 = ((android.support.v4.hardware.display.DisplayManagerCompat) android.support.v4.hardware.display.DisplayManagerCompat.sInstances.get(p4));
        } catch (java.util.WeakHashMap v2_2) {
            throw v2_2;
        }
        if (v0_0 == null) {
            if (android.os.Build$VERSION.SDK_INT < 17) {
                v0_0 = new android.support.v4.hardware.display.DisplayManagerCompat$LegacyImpl(p4);
            } else {
                v0_0 = new android.support.v4.hardware.display.DisplayManagerCompat$JellybeanMr1Impl(p4);
            }
            android.support.v4.hardware.display.DisplayManagerCompat.sInstances.put(p4, v0_0);
        }
        return v0_0;
    }

    public abstract android.view.Display getDisplay();

    public abstract android.view.Display[] getDisplays();

    public abstract android.view.Display[] getDisplays();
}
