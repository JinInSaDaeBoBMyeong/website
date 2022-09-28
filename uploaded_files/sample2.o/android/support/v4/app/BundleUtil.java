package android.support.v4.app;
 class BundleUtil {

    BundleUtil()
    {
        return;
    }

    public static android.os.Bundle[] getBundleArrayFromBundle(android.os.Bundle p4, String p5)
    {
        android.os.Bundle[] v1_0;
        android.os.Bundle[] v0_0 = p4.getParcelableArray(p5);
        if ((!(v0_0 instanceof android.os.Bundle[])) && (v0_0 != null)) {
            v1_0 = ((android.os.Bundle[]) java.util.Arrays.copyOf(v0_0, v0_0.length, android.os.Bundle[]));
            p4.putParcelableArray(p5, v1_0);
        } else {
            v1_0 = ((android.os.Bundle[]) ((android.os.Bundle[]) v0_0));
        }
        return v1_0;
    }
}
