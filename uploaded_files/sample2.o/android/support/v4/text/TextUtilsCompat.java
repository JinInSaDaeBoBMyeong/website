package android.support.v4.text;
public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG;
    private static String HEBR_SCRIPT_SUBTAG;
    public static final java.util.Locale ROOT;

    static TextUtilsCompat()
    {
        android.support.v4.text.TextUtilsCompat.ROOT = new java.util.Locale("", "");
        android.support.v4.text.TextUtilsCompat.ARAB_SCRIPT_SUBTAG = "Arab";
        android.support.v4.text.TextUtilsCompat.HEBR_SCRIPT_SUBTAG = "Hebr";
        return;
    }

    public TextUtilsCompat()
    {
        return;
    }

    private static int getLayoutDirectionFromFirstChar(java.util.Locale p2)
    {
        int v0 = 0;
        switch (Character.getDirectionality(p2.getDisplayName(p2).charAt(0))) {
            case 1:
            case 2:
                v0 = 1;
                break;
        }
        return v0;
    }

    public static int getLayoutDirectionFromLocale(java.util.Locale p2)
    {
        if ((p2 == null) || (p2.equals(android.support.v4.text.TextUtilsCompat.ROOT))) {
            int v1_5 = 0;
        } else {
            String v0 = android.support.v4.text.ICUCompat.getScript(android.support.v4.text.ICUCompat.addLikelySubtags(p2.toString()));
            if (v0 != null) {
                if ((!v0.equalsIgnoreCase(android.support.v4.text.TextUtilsCompat.ARAB_SCRIPT_SUBTAG)) && (!v0.equalsIgnoreCase(android.support.v4.text.TextUtilsCompat.HEBR_SCRIPT_SUBTAG))) {
                } else {
                    v1_5 = 1;
                }
            } else {
                v1_5 = android.support.v4.text.TextUtilsCompat.getLayoutDirectionFromFirstChar(p2);
            }
        }
        return v1_5;
    }

    public static String htmlEncode(String p4)
    {
        StringBuilder v2_1 = new StringBuilder();
        int v1 = 0;
        while (v1 < p4.length()) {
            char v0 = p4.charAt(v1);
            switch (v0) {
                case 34:
                    v2_1.append("&quot;");
                    break;
                case 38:
                    v2_1.append("&amp;");
                    break;
                case 39:
                    v2_1.append("&#39;");
                    break;
                case 60:
                    v2_1.append("&lt;");
                    break;
                case 62:
                    v2_1.append("&gt;");
                    break;
                default:
                    v2_1.append(v0);
            }
            v1++;
        }
        return v2_1.toString();
    }
}
