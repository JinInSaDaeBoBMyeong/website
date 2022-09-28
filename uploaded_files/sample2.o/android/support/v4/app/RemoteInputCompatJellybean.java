package android.support.v4.app;
 class RemoteInputCompatJellybean {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_LABEL = "label";
    private static final String KEY_RESULT_KEY = "resultKey";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    RemoteInputCompatJellybean()
    {
        return;
    }

    static void addResultsToIntent(android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p8, android.content.Intent p9, android.os.Bundle p10)
    {
        android.os.Bundle v6_1 = new android.os.Bundle();
        int v3 = p8.length;
        int v2 = 0;
        while (v2 < v3) {
            android.support.v4.app.RemoteInputCompatBase$RemoteInput v4 = p8[v2];
            CharSequence v5_0 = p10.get(v4.getResultKey());
            if ((v5_0 instanceof CharSequence)) {
                v6_1.putCharSequence(v4.getResultKey(), ((CharSequence) v5_0));
            }
            v2++;
        }
        android.content.Intent v1_1 = new android.content.Intent();
        v1_1.putExtra("android.remoteinput.resultsData", v6_1);
        p9.setClipData(android.content.ClipData.newIntent("android.remoteinput.results", v1_1));
        return;
    }

    static android.support.v4.app.RemoteInputCompatBase$RemoteInput fromBundle(android.os.Bundle p6, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p7)
    {
        return p7.build(p6.getString("resultKey"), p6.getCharSequence("label"), p6.getCharSequenceArray("choices"), p6.getBoolean("allowFreeFormInput"), p6.getBundle("extras"));
    }

    static android.support.v4.app.RemoteInputCompatBase$RemoteInput[] fromBundleArray(android.os.Bundle[] p3, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p4)
    {
        android.support.v4.app.RemoteInputCompatBase$RemoteInput[] v1;
        if (p3 != null) {
            v1 = p4.newArray(p3.length);
            int v0 = 0;
            while (v0 < p3.length) {
                v1[v0] = android.support.v4.app.RemoteInputCompatJellybean.fromBundle(p3[v0], p4);
                v0++;
            }
        } else {
            v1 = 0;
        }
        return v1;
    }

    static android.os.Bundle getResultsFromIntent(android.content.Intent p5)
    {
        android.os.Bundle v2_0 = 0;
        android.content.ClipData v0 = p5.getClipData();
        if (v0 != null) {
            android.content.ClipDescription v1 = v0.getDescription();
            if ((v1.hasMimeType("text/vnd.android.intent")) && (v1.getLabel().equals("android.remoteinput.results"))) {
                v2_0 = ((android.os.Bundle) v0.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData"));
            }
        }
        return v2_0;
    }

    static android.os.Bundle toBundle(android.support.v4.app.RemoteInputCompatBase$RemoteInput p3)
    {
        android.os.Bundle v0_1 = new android.os.Bundle();
        v0_1.putString("resultKey", p3.getResultKey());
        v0_1.putCharSequence("label", p3.getLabel());
        v0_1.putCharSequenceArray("choices", p3.getChoices());
        v0_1.putBoolean("allowFreeFormInput", p3.getAllowFreeFormInput());
        v0_1.putBundle("extras", p3.getExtras());
        return v0_1;
    }

    static android.os.Bundle[] toBundleArray(android.support.v4.app.RemoteInputCompatBase$RemoteInput[] p3)
    {
        android.os.Bundle[] v0;
        if (p3 != null) {
            v0 = new android.os.Bundle[p3.length];
            int v1 = 0;
            while (v1 < p3.length) {
                v0[v1] = android.support.v4.app.RemoteInputCompatJellybean.toBundle(p3[v1]);
                v1++;
            }
        } else {
            v0 = 0;
        }
        return v0;
    }
}
