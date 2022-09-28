package android.support.v4.text;
public class TextDirectionHeuristicsCompat {
    public static final android.support.v4.text.TextDirectionHeuristicCompat ANYRTL_LTR = None;
    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_LTR = None;
    public static final android.support.v4.text.TextDirectionHeuristicCompat FIRSTSTRONG_RTL = None;
    public static final android.support.v4.text.TextDirectionHeuristicCompat LOCALE = None;
    public static final android.support.v4.text.TextDirectionHeuristicCompat LTR = None;
    public static final android.support.v4.text.TextDirectionHeuristicCompat RTL = None;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static TextDirectionHeuristicsCompat()
    {
        android.support.v4.text.TextDirectionHeuristicsCompat.LTR = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(0, 0, 0);
        android.support.v4.text.TextDirectionHeuristicsCompat.RTL = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(0, 1, 0);
        android.support.v4.text.TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong.INSTANCE, 0, 0);
        android.support.v4.text.TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong.INSTANCE, 1, 0);
        android.support.v4.text.TextDirectionHeuristicsCompat.ANYRTL_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong.INSTANCE_RTL, 0, 0);
        android.support.v4.text.TextDirectionHeuristicsCompat.LOCALE = android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale.INSTANCE;
        return;
    }

    public TextDirectionHeuristicsCompat()
    {
        return;
    }

    static synthetic int access$100(int p1)
    {
        return android.support.v4.text.TextDirectionHeuristicsCompat.isRtlTextOrFormat(p1);
    }

    static synthetic int access$200(int p1)
    {
        return android.support.v4.text.TextDirectionHeuristicsCompat.isRtlText(p1);
    }

    private static int isRtlText(int p1)
    {
        int v0;
        switch (p1) {
            case 0:
                v0 = 1;
                break;
            case 1:
            case 2:
                v0 = 0;
                break;
            default:
                v0 = 2;
        }
        return v0;
    }

    private static int isRtlTextOrFormat(int p1)
    {
        int v0;
        switch (p1) {
            case 0:
            case 14:
            case 15:
                v0 = 1;
                break;
            case 1:
            case 2:
            case 16:
            case 17:
                v0 = 0;
                break;
            default:
                v0 = 2;
        }
        return v0;
    }
}
