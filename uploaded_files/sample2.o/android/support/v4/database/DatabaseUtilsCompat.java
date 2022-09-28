package android.support.v4.database;
public class DatabaseUtilsCompat {

    private DatabaseUtilsCompat()
    {
        return;
    }

    public static String[] appendSelectionArgs(String[] p4, String[] p5)
    {
        if ((p4 != null) && (p4.length != 0)) {
            String[] v0 = new String[(p4.length + p5.length)];
            System.arraycopy(p4, 0, v0, 0, p4.length);
            System.arraycopy(p5, 0, v0, p4.length, p5.length);
        } else {
            v0 = p5;
        }
        return v0;
    }

    public static String concatenateWhere(String p2, String p3)
    {
        if (!android.text.TextUtils.isEmpty(p2)) {
            if (!android.text.TextUtils.isEmpty(p3)) {
                p3 = new StringBuilder().append("(").append(p2).append(") AND (").append(p3).append(")").toString();
            } else {
                p3 = p2;
            }
        }
        return p3;
    }
}
