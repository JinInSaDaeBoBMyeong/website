package android.support.v4.print;
final class PrintHelper$PrintHelperKitkatImpl implements android.support.v4.print.PrintHelper$PrintHelperVersionImpl {
    private final android.support.v4.print.PrintHelperKitkat mPrintHelper;

    PrintHelper$PrintHelperKitkatImpl(android.content.Context p2)
    {
        this.mPrintHelper = new android.support.v4.print.PrintHelperKitkat(p2);
        return;
    }

    public int getColorMode()
    {
        return this.mPrintHelper.getColorMode();
    }

    public int getOrientation()
    {
        return this.mPrintHelper.getOrientation();
    }

    public int getScaleMode()
    {
        return this.mPrintHelper.getScaleMode();
    }

    public void printBitmap(String p2, android.graphics.Bitmap p3)
    {
        this.mPrintHelper.printBitmap(p2, p3);
        return;
    }

    public void printBitmap(String p2, android.net.Uri p3)
    {
        this.mPrintHelper.printBitmap(p2, p3);
        return;
    }

    public void setColorMode(int p2)
    {
        this.mPrintHelper.setColorMode(p2);
        return;
    }

    public void setOrientation(int p2)
    {
        this.mPrintHelper.setOrientation(p2);
        return;
    }

    public void setScaleMode(int p2)
    {
        this.mPrintHelper.setScaleMode(p2);
        return;
    }
}
