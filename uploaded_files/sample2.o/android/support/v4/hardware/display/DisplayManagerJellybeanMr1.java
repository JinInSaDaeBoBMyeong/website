package android.support.v4.hardware.display;
final class DisplayManagerJellybeanMr1 {

    DisplayManagerJellybeanMr1()
    {
        return;
    }

    public static android.view.Display getDisplay(Object p1, int p2)
    {
        return ((android.hardware.display.DisplayManager) p1).getDisplay(p2);
    }

    public static Object getDisplayManager(android.content.Context p1)
    {
        return p1.getSystemService("display");
    }

    public static android.view.Display[] getDisplays(Object p1)
    {
        return ((android.hardware.display.DisplayManager) p1).getDisplays();
    }

    public static android.view.Display[] getDisplays(Object p1, String p2)
    {
        return ((android.hardware.display.DisplayManager) p1).getDisplays(p2);
    }
}
