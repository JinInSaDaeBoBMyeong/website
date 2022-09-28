package android.support.v4.text;
public final class BidiFormatter$Builder {
    private int mFlags;
    private boolean mIsRtlContext;
    private android.support.v4.text.TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

    public BidiFormatter$Builder()
    {
        this.initialize(android.support.v4.text.BidiFormatter.access$000(java.util.Locale.getDefault()));
        return;
    }

    public BidiFormatter$Builder(java.util.Locale p2)
    {
        this.initialize(android.support.v4.text.BidiFormatter.access$000(p2));
        return;
    }

    public BidiFormatter$Builder(boolean p1)
    {
        this.initialize(p1);
        return;
    }

    private static android.support.v4.text.BidiFormatter getDefaultInstanceFromContext(boolean p1)
    {
        android.support.v4.text.BidiFormatter v0;
        if (!p1) {
            v0 = android.support.v4.text.BidiFormatter.access$300();
        } else {
            v0 = android.support.v4.text.BidiFormatter.access$200();
        }
        return v0;
    }

    private void initialize(boolean p2)
    {
        this.mIsRtlContext = p2;
        this.mTextDirectionHeuristicCompat = android.support.v4.text.BidiFormatter.access$100();
        this.mFlags = 2;
        return;
    }

    public android.support.v4.text.BidiFormatter build()
    {
        if ((this.mFlags != 2) || (this.mTextDirectionHeuristicCompat != android.support.v4.text.BidiFormatter.access$100())) {
            android.support.v4.text.BidiFormatter v0_1 = new android.support.v4.text.BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat, 0);
        } else {
            v0_1 = android.support.v4.text.BidiFormatter$Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
        }
        return v0_1;
    }

    public android.support.v4.text.BidiFormatter$Builder setTextDirectionHeuristic(android.support.v4.text.TextDirectionHeuristicCompat p1)
    {
        this.mTextDirectionHeuristicCompat = p1;
        return this;
    }

    public android.support.v4.text.BidiFormatter$Builder stereoReset(boolean p2)
    {
        if (!p2) {
            this.mFlags = (this.mFlags & -3);
        } else {
            this.mFlags = (this.mFlags | 2);
        }
        return this;
    }
}
