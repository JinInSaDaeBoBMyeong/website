package android.support.v4.text;
 class TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale extends android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    public static final android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale INSTANCE;

    static TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale()
    {
        android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale.INSTANCE = new android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale();
        return;
    }

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale()
    {
        super(0);
        return;
    }

    protected boolean defaultIsRtl()
    {
        int v1 = 1;
        if (android.support.v4.text.TextUtilsCompat.getLayoutDirectionFromLocale(java.util.Locale.getDefault()) != 1) {
            v1 = 0;
        }
        return v1;
    }
}
