package android.support.v4.text;
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final android.support.v4.text.BidiFormatter DEFAULT_LTR_INSTANCE = None;
    private static final android.support.v4.text.BidiFormatter DEFAULT_RTL_INSTANCE = None;
    private static android.support.v4.text.TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = None;
    private static final int DIR_LTR = 255;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = 8234;
    private static final char LRM = 8206;
    private static final String LRM_STRING = "";
    private static final char PDF = 8236;
    private static final char RLE = 8235;
    private static final char RLM = 8207;
    private static final String RLM_STRING;
    private final android.support.v4.text.TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    static BidiFormatter()
    {
        android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC = android.support.v4.text.TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        android.support.v4.text.BidiFormatter.LRM_STRING = Character.toString(8206);
        android.support.v4.text.BidiFormatter.RLM_STRING = Character.toString(8207);
        android.support.v4.text.BidiFormatter.DEFAULT_LTR_INSTANCE = new android.support.v4.text.BidiFormatter(0, 2, android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
        android.support.v4.text.BidiFormatter.DEFAULT_RTL_INSTANCE = new android.support.v4.text.BidiFormatter(1, 2, android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC);
        return;
    }

    private BidiFormatter(boolean p1, int p2, android.support.v4.text.TextDirectionHeuristicCompat p3)
    {
        this.mIsRtlContext = p1;
        this.mFlags = p2;
        this.mDefaultTextDirectionHeuristicCompat = p3;
        return;
    }

    synthetic BidiFormatter(boolean p1, int p2, android.support.v4.text.TextDirectionHeuristicCompat p3, android.support.v4.text.BidiFormatter$1 p4)
    {
        this(p1, p2, p3);
        return;
    }

    static synthetic boolean access$000(java.util.Locale p1)
    {
        return android.support.v4.text.BidiFormatter.isRtlLocale(p1);
    }

    static synthetic android.support.v4.text.TextDirectionHeuristicCompat access$100()
    {
        return android.support.v4.text.BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
    }

    static synthetic android.support.v4.text.BidiFormatter access$200()
    {
        return android.support.v4.text.BidiFormatter.DEFAULT_RTL_INSTANCE;
    }

    static synthetic android.support.v4.text.BidiFormatter access$300()
    {
        return android.support.v4.text.BidiFormatter.DEFAULT_LTR_INSTANCE;
    }

    private static int getEntryDir(String p2)
    {
        return new android.support.v4.text.BidiFormatter$DirectionalityEstimator(p2, 0).getEntryDir();
    }

    private static int getExitDir(String p2)
    {
        return new android.support.v4.text.BidiFormatter$DirectionalityEstimator(p2, 0).getExitDir();
    }

    public static android.support.v4.text.BidiFormatter getInstance()
    {
        return new android.support.v4.text.BidiFormatter$Builder().build();
    }

    public static android.support.v4.text.BidiFormatter getInstance(java.util.Locale p1)
    {
        return new android.support.v4.text.BidiFormatter$Builder(p1).build();
    }

    public static android.support.v4.text.BidiFormatter getInstance(boolean p1)
    {
        return new android.support.v4.text.BidiFormatter$Builder(p1).build();
    }

    private static boolean isRtlLocale(java.util.Locale p2)
    {
        int v0 = 1;
        if (android.support.v4.text.TextUtilsCompat.getLayoutDirectionFromLocale(p2) != 1) {
            v0 = 0;
        }
        return v0;
    }

    private String markAfter(String p4, android.support.v4.text.TextDirectionHeuristicCompat p5)
    {
        String v1_3;
        boolean v0 = p5.isRtl(p4, 0, p4.length());
        if ((this.mIsRtlContext) || ((!v0) && (android.support.v4.text.BidiFormatter.getExitDir(p4) != 1))) {
            if ((!this.mIsRtlContext) || ((v0) && (android.support.v4.text.BidiFormatter.getExitDir(p4) != -1))) {
                v1_3 = "";
            } else {
                v1_3 = android.support.v4.text.BidiFormatter.RLM_STRING;
            }
        } else {
            v1_3 = android.support.v4.text.BidiFormatter.LRM_STRING;
        }
        return v1_3;
    }

    private String markBefore(String p4, android.support.v4.text.TextDirectionHeuristicCompat p5)
    {
        String v1_3;
        boolean v0 = p5.isRtl(p4, 0, p4.length());
        if ((this.mIsRtlContext) || ((!v0) && (android.support.v4.text.BidiFormatter.getEntryDir(p4) != 1))) {
            if ((!this.mIsRtlContext) || ((v0) && (android.support.v4.text.BidiFormatter.getEntryDir(p4) != -1))) {
                v1_3 = "";
            } else {
                v1_3 = android.support.v4.text.BidiFormatter.RLM_STRING;
            }
        } else {
            v1_3 = android.support.v4.text.BidiFormatter.LRM_STRING;
        }
        return v1_3;
    }

    public boolean getStereoReset()
    {
        int v0_2;
        if ((this.mFlags & 2) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean isRtl(String p4)
    {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(p4, 0, p4.length());
    }

    public boolean isRtlContext()
    {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String p3)
    {
        return this.unicodeWrap(p3, this.mDefaultTextDirectionHeuristicCompat, 1);
    }

    public String unicodeWrap(String p2, android.support.v4.text.TextDirectionHeuristicCompat p3)
    {
        return this.unicodeWrap(p2, p3, 1);
    }

    public String unicodeWrap(String p5, android.support.v4.text.TextDirectionHeuristicCompat p6, boolean p7)
    {
        boolean v0 = p6.isRtl(p5, 0, p5.length());
        StringBuilder v1_1 = new StringBuilder();
        if ((this.getStereoReset()) && (p7)) {
            String v2_1;
            if (!v0) {
                v2_1 = android.support.v4.text.TextDirectionHeuristicsCompat.LTR;
            } else {
                v2_1 = android.support.v4.text.TextDirectionHeuristicsCompat.RTL;
            }
            v1_1.append(this.markBefore(p5, v2_1));
        }
        if (v0 == this.mIsRtlContext) {
            v1_1.append(p5);
        } else {
            String v2_4;
            if (!v0) {
                v2_4 = 8234;
            } else {
                v2_4 = 8235;
            }
            v1_1.append(v2_4);
            v1_1.append(p5);
            v1_1.append(8236);
        }
        if (p7) {
            String v2_6;
            if (!v0) {
                v2_6 = android.support.v4.text.TextDirectionHeuristicsCompat.LTR;
            } else {
                v2_6 = android.support.v4.text.TextDirectionHeuristicsCompat.RTL;
            }
            v1_1.append(this.markAfter(p5, v2_6));
        }
        return v1_1.toString();
    }

    public String unicodeWrap(String p2, boolean p3)
    {
        return this.unicodeWrap(p2, this.mDefaultTextDirectionHeuristicCompat, p3);
    }
}
