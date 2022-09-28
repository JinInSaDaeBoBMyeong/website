package android.support.v4.text;
 class TextDirectionHeuristicsCompat$AnyStrong implements android.support.v4.text.TextDirectionHeuristicsCompat$TextDirectionAlgorithm {
    public static final android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong INSTANCE_LTR;
    public static final android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong INSTANCE_RTL;
    private final boolean mLookForRtl;

    static TextDirectionHeuristicsCompat$AnyStrong()
    {
        android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong.INSTANCE_RTL = new android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong(1);
        android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong.INSTANCE_LTR = new android.support.v4.text.TextDirectionHeuristicsCompat$AnyStrong(0);
        return;
    }

    private TextDirectionHeuristicsCompat$AnyStrong(boolean p1)
    {
        this.mLookForRtl = p1;
        return;
    }

    public int checkRtl(CharSequence p7, int p8, int p9)
    {
        int v3 = 1;
        int v1 = 0;
        int v2 = p8;
        while (v2 < (p8 + p9)) {
            switch (android.support.v4.text.TextDirectionHeuristicsCompat.access$200(Character.getDirectionality(p7.charAt(v2)))) {
                case 0:
                    if (!this.mLookForRtl) {
                        v1 = 1;
                    } else {
                        v3 = 0;
                    }
                    return v3;
                case 1:
                    if (this.mLookForRtl) {
                        v1 = 1;
                    }
                    return v3;
            }
            v2++;
        }
        if (v1 == 0) {
            v3 = 2;
        } else {
            if (!this.mLookForRtl) {
                v3 = 0;
            }
        }
        return v3;
    }
}
