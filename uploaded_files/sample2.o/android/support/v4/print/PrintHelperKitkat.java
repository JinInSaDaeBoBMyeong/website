package android.support.v4.print;
 class PrintHelperKitkat {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    private static final String LOG_TAG = "PrintHelperKitkat";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final android.content.Context mContext;
    android.graphics.BitmapFactory$Options mDecodeOptions;
    private final Object mLock;
    int mOrientation;
    int mScaleMode;

    PrintHelperKitkat(android.content.Context p3)
    {
        this.mDecodeOptions = 0;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = p3;
        return;
    }

    static synthetic android.graphics.Matrix access$000(android.support.v4.print.PrintHelperKitkat p1, int p2, int p3, android.graphics.RectF p4, int p5)
    {
        return p1.getMatrix(p2, p3, p4, p5);
    }

    static synthetic android.graphics.Bitmap access$200(android.support.v4.print.PrintHelperKitkat p1, android.net.Uri p2, int p3)
    {
        return p1.loadConstrainedBitmap(p2, p3);
    }

    static synthetic Object access$300(android.support.v4.print.PrintHelperKitkat p1)
    {
        return p1.mLock;
    }

    private android.graphics.Matrix getMatrix(int p8, int p9, android.graphics.RectF p10, int p11)
    {
        float v1_0;
        android.graphics.Matrix v0_1 = new android.graphics.Matrix();
        float v1_1 = (p10.width() / ((float) p8));
        if (p11 != 2) {
            v1_0 = Math.min(v1_1, (p10.height() / ((float) p9)));
        } else {
            v1_0 = Math.max(v1_1, (p10.height() / ((float) p9)));
        }
        v0_1.postScale(v1_0, v1_0);
        v0_1.postTranslate(((p10.width() - (((float) p8) * v1_0)) / 1073741824), ((p10.height() - (((float) p9) * v1_0)) / 1073741824));
        return v0_1;
    }

    private android.graphics.Bitmap loadBitmap(android.net.Uri p6, android.graphics.BitmapFactory$Options p7)
    {
        if ((p6 != null) && (this.mContext != null)) {
            try {
                java.io.InputStream v0 = this.mContext.getContentResolver().openInputStream(p6);
                Throwable v2_1 = android.graphics.BitmapFactory.decodeStream(v0, 0, p7);
            } catch (Throwable v2_2) {
                if (v0 != null) {
                    try {
                        v0.close();
                    } catch (java.io.IOException v1_0) {
                        android.util.Log.w("PrintHelperKitkat", "close fail ", v1_0);
                    }
                }
                throw v2_2;
            }
            if (v0 != null) {
                try {
                    v0.close();
                } catch (java.io.IOException v1_1) {
                    android.util.Log.w("PrintHelperKitkat", "close fail ", v1_1);
                }
            }
            return v2_1;
        } else {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
    }

    private android.graphics.Bitmap loadConstrainedBitmap(android.net.Uri p10, int p11)
    {
        Throwable v6_0 = 0;
        if ((p11 > 0) && ((p10 != null) && (this.mContext != null))) {
            android.graphics.BitmapFactory$Options v3_1 = new android.graphics.BitmapFactory$Options();
            v3_1.inJustDecodeBounds = 1;
            this.loadBitmap(p10, v3_1);
            int v5 = v3_1.outWidth;
            int v1 = v3_1.outHeight;
            if ((v5 > 0) && (v1 > 0)) {
                int v2 = Math.max(v5, v1);
                int v4 = 1;
                while (v2 > p11) {
                    v2 >>= 1;
                    v4 <<= 1;
                }
                if ((v4 > 0) && ((Math.min(v5, v1) / v4) > 0)) {
                    Object v7 = this.mLock;
                    this.mDecodeOptions = new android.graphics.BitmapFactory$Options();
                    this.mDecodeOptions.inMutable = 1;
                    this.mDecodeOptions.inSampleSize = v4;
                    try {
                        v6_0 = this.loadBitmap(p10, this.mDecodeOptions);
                        try {
                            this.mDecodeOptions = 0;
                        } catch (Throwable v6_8) {
                            throw v6_8;
                        }
                    } catch (Throwable v6_6) {
                        this.mDecodeOptions = 0;
                        throw v6_6;
                    }
                }
            }
            return v6_0;
        } else {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
    }

    public int getColorMode()
    {
        return this.mColorMode;
    }

    public int getOrientation()
    {
        return this.mOrientation;
    }

    public int getScaleMode()
    {
        return this.mScaleMode;
    }

    public void printBitmap(String p7, android.graphics.Bitmap p8)
    {
        if (p8 != null) {
            android.print.PrintAttributes$MediaSize v2 = android.print.PrintAttributes$MediaSize.UNKNOWN_PORTRAIT;
            if (p8.getWidth() > p8.getHeight()) {
                v2 = android.print.PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE;
            }
            ((android.print.PrintManager) this.mContext.getSystemService("print")).print(p7, new android.support.v4.print.PrintHelperKitkat$1(this, p7, p8, this.mScaleMode), new android.print.PrintAttributes$Builder().setMediaSize(v2).setColorMode(this.mColorMode).build());
        }
        return;
    }

    public void printBitmap(String p8, android.net.Uri p9)
    {
        android.support.v4.print.PrintHelperKitkat$2 v3_1 = new android.support.v4.print.PrintHelperKitkat$2(this, p8, p9, this.mScaleMode);
        android.print.PrintManager v4_1 = ((android.print.PrintManager) this.mContext.getSystemService("print"));
        android.print.PrintAttributes$Builder v1_1 = new android.print.PrintAttributes$Builder();
        v1_1.setColorMode(this.mColorMode);
        if (this.mOrientation != 1) {
            if (this.mOrientation == 2) {
                v1_1.setMediaSize(android.print.PrintAttributes$MediaSize.UNKNOWN_PORTRAIT);
            }
        } else {
            v1_1.setMediaSize(android.print.PrintAttributes$MediaSize.UNKNOWN_LANDSCAPE);
        }
        v4_1.print(p8, v3_1, v1_1.build());
        return;
    }

    public void setColorMode(int p1)
    {
        this.mColorMode = p1;
        return;
    }

    public void setOrientation(int p1)
    {
        this.mOrientation = p1;
        return;
    }

    public void setScaleMode(int p1)
    {
        this.mScaleMode = p1;
        return;
    }
}
