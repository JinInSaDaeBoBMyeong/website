package android.support.v4.text;
abstract class TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl implements android.support.v4.text.TextDirectionHeuristicCompat {
    private final android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm mAlgorithm;

    public TextDirectionHeuristicsCompat$TextDirectionHeuristicImpl(android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm p1)
    {
        this.mAlgorithm = p1;
        return;
    }

    private boolean doCheck(CharSequence p2, int p3, int p4)
    {
        int v0_2;
        switch (this.mAlgorithm.checkRtl(p2, p3, p4)) {
            case 0:
                v0_2 = 1;
                break;
            case 1:
                v0_2 = 0;
                break;
            default:
                v0_2 = this.defaultIsRtl();
        }
        return v0_2;
    }

    protected abstract boolean defaultIsRtl();

    public boolean isRtl(CharSequence p2, int p3, int p4)
    {
        if ((p2 != null) && ((p3 >= 0) && ((p4 >= 0) && ((p2.length() - p4) >= p3)))) {
            boolean v0_0;
            if (this.mAlgorithm != null) {
                v0_0 = this.doCheck(p2, p3, p4);
            } else {
                v0_0 = this.defaultIsRtl();
            }
            return v0_0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean isRtl(char[] p2, int p3, int p4)
    {
        return this.isRtl(java.nio.CharBuffer.wrap(p2), p3, p4);
    }
}
