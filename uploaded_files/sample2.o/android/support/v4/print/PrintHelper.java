package android.support.v4.print;
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    android.support.v4.print.PrintHelper$PrintHelperVersionImpl mImpl;

    public PrintHelper(android.content.Context p3)
    {
        if (!android.support.v4.print.PrintHelper.systemSupportsPrint()) {
            this.mImpl = new android.support.v4.print.PrintHelper$PrintHelperStubImpl(0);
        } else {
            this.mImpl = new android.support.v4.print.PrintHelper$PrintHelperKitkatImpl(p3);
        }
        return;
    }

    public static boolean systemSupportsPrint()
    {
        int v0_1;
        if (android.os.Build$VERSION.SDK_INT < 19) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public int getColorMode()
    {
        return this.mImpl.getColorMode();
    }

    public int getOrientation()
    {
        return this.mImpl.getOrientation();
    }

    public int getScaleMode()
    {
        return this.mImpl.getScaleMode();
    }

    public void printBitmap(String p2, android.graphics.Bitmap p3)
    {
        this.mImpl.printBitmap(p2, p3);
        return;
    }

    public void printBitmap(String p2, android.net.Uri p3)
    {
        this.mImpl.printBitmap(p2, p3);
        return;
    }

    public void setColorMode(int p2)
    {
        this.mImpl.setColorMode(p2);
        return;
    }

    public void setOrientation(int p2)
    {
        this.mImpl.setOrientation(p2);
        return;
    }

    public void setScaleMode(int p2)
    {
        this.mImpl.setScaleMode(p2);
        return;
    }
}
