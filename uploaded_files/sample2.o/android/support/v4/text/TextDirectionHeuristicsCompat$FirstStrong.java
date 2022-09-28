package android.support.v4.text;
 class TextDirectionHeuristicsCompat$FirstStrong implements android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong INSTANCE;

    static TextDirectionHeuristicsCompat$FirstStrong()
    {
        android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong.INSTANCE = new android.support.v4.text.TextDirectionHeuristicsCompat$FirstStrong();
        return;
    }

    private TextDirectionHeuristicsCompat$FirstStrong()
    {
        return;
    }

    public int checkRtl(CharSequence p5, int p6, int p7)
    {
        int v2 = 2;
        int v1 = p6;
        int v0 = (p6 + p7);
        while ((v1 < v0) && (v2 == 2)) {
            v2 = android.support.v4.text.TextDirectionHeuristicsCompat.access$100(Character.getDirectionality(p5.charAt(v1)));
            v1++;
        }
        return v2;
    }
}
