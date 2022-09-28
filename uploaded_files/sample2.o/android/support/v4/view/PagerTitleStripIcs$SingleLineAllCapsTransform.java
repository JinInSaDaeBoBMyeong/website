package android.support.v4.view;
 class PagerTitleStripIcs$SingleLineAllCapsTransform extends android.text.method.SingleLineTransformationMethod {
    private static final String TAG = "SingleLineAllCapsTransform";
    private java.util.Locale mLocale;

    public PagerTitleStripIcs$SingleLineAllCapsTransform(android.content.Context p2)
    {
        this.mLocale = p2.getResources().getConfiguration().locale;
        return;
    }

    public CharSequence getTransformation(CharSequence p3, android.view.View p4)
    {
        int v0_0;
        CharSequence v3_1 = super.getTransformation(p3, p4);
        if (v3_1 == null) {
            v0_0 = 0;
        } else {
            v0_0 = v3_1.toString().toUpperCase(this.mLocale);
        }
        return v0_0;
    }
}
