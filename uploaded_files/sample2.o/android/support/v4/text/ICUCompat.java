package android.support.v4.text;
public class ICUCompat {
    private static final android.support.v4.text.ICUCompat$ICUCompatImpl IMPL;

    static ICUCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 14) {
            android.support.v4.text.ICUCompat.IMPL = new android.support.v4.text.ICUCompat$ICUCompatImplBase();
        } else {
            android.support.v4.text.ICUCompat.IMPL = new android.support.v4.text.ICUCompat$ICUCompatImplIcs();
        }
        return;
    }

    public ICUCompat()
    {
        return;
    }

    public static String addLikelySubtags(String p1)
    {
        return android.support.v4.text.ICUCompat.IMPL.addLikelySubtags(p1);
    }

    public static String getScript(String p1)
    {
        return android.support.v4.text.ICUCompat.IMPL.getScript(p1);
    }
}
