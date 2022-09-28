package android.support.v4.text;
 class TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal extends android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl {
    private final boolean mDefaultIsRtl;

    private TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm p1, boolean p2)
    {
        super(p1);
        super.mDefaultIsRtl = p2;
        return;
    }

    synthetic TextDirectionHeuristicsCompat$TextDirectionHeuristicInternal(android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm p1, boolean p2, android.support.v4.text.TextDirectionHeuristicsCompat$1 p3)
    {
        this(p1, p2);
        return;
    }

    protected boolean defaultIsRtl()
    {
        return this.mDefaultIsRtl;
    }
}
