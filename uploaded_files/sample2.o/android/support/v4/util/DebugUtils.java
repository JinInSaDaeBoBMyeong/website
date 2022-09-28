package android.support.v4.util;
public class DebugUtils {

    public DebugUtils()
    {
        return;
    }

    public static void buildShortClassTag(Object p3, StringBuilder p4)
    {
        if (p3 != null) {
            String v1 = p3.getClass().getSimpleName();
            if ((v1 == null) || (v1.length() <= 0)) {
                v1 = p3.getClass().getName();
                int v0 = v1.lastIndexOf(46);
                if (v0 > 0) {
                    v1 = v1.substring((v0 + 1));
                }
            }
            p4.append(v1);
            p4.append(123);
            p4.append(Integer.toHexString(System.identityHashCode(p3)));
        } else {
            p4.append("null");
        }
        return;
    }
}
