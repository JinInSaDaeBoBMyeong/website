package android.support.v4.text;
 class ICUCompatIcs {
    private static final String TAG = "ICUCompatIcs";
    private static reflect.Method sAddLikelySubtagsMethod;
    private static reflect.Method sGetScriptMethod;

    static ICUCompatIcs()
    {
        try {
            Class v0 = Class.forName("libcore.icu.ICU");
        } catch (Exception v1) {
            android.util.Log.w("ICUCompatIcs", v1);
            return;
        }
        if (v0 == null) {
            return;
        } else {
            Class[] v3_3 = new Class[1];
            v3_3[0] = String;
            android.support.v4.text.ICUCompatIcs.sGetScriptMethod = v0.getMethod("getScript", v3_3);
            Class[] v3_1 = new Class[1];
            v3_1[0] = String;
            android.support.v4.text.ICUCompatIcs.sAddLikelySubtagsMethod = v0.getMethod("addLikelySubtags", v3_1);
            return;
        }
    }

    ICUCompatIcs()
    {
        return;
    }

    public static String addLikelySubtags(String p4)
    {
        try {
            String v2_1;
            if (android.support.v4.text.ICUCompatIcs.sAddLikelySubtagsMethod == null) {
                v2_1 = p4;
            } else {
                Object[] v0 = new Object[1];
                v0[0] = p4;
                v2_1 = ((String) android.support.v4.text.ICUCompatIcs.sAddLikelySubtagsMethod.invoke(0, v0));
            }
        } catch (reflect.InvocationTargetException v1_1) {
            android.util.Log.w("ICUCompatIcs", v1_1);
        } catch (reflect.InvocationTargetException v1_0) {
            android.util.Log.w("ICUCompatIcs", v1_0);
        }
        return v2_1;
    }

    public static String getScript(String p5)
    {
        try {
            int v2_2;
            if (android.support.v4.text.ICUCompatIcs.sGetScriptMethod == null) {
                v2_2 = 0;
            } else {
                Object[] v0 = new Object[1];
                v0[0] = p5;
                v2_2 = ((String) android.support.v4.text.ICUCompatIcs.sGetScriptMethod.invoke(0, v0));
            }
        } catch (reflect.InvocationTargetException v1_1) {
            android.util.Log.w("ICUCompatIcs", v1_1);
        } catch (reflect.InvocationTargetException v1_0) {
            android.util.Log.w("ICUCompatIcs", v1_0);
        }
        return v2_2;
    }
}
