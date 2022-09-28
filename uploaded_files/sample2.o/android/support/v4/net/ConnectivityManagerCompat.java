package android.support.v4.net;
public class ConnectivityManagerCompat {
    private static final android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl IMPL;

    static ConnectivityManagerCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 16) {
            if (android.os.Build$VERSION.SDK_INT < 13) {
                if (android.os.Build$VERSION.SDK_INT < 8) {
                    android.support.v4.net.ConnectivityManagerCompat.IMPL = new android.support.v4.net.ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl();
                } else {
                    android.support.v4.net.ConnectivityManagerCompat.IMPL = new android.support.v4.net.ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl();
                }
            } else {
                android.support.v4.net.ConnectivityManagerCompat.IMPL = new android.support.v4.net.ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl();
            }
        } else {
            android.support.v4.net.ConnectivityManagerCompat.IMPL = new android.support.v4.net.ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl();
        }
        return;
    }

    public ConnectivityManagerCompat()
    {
        return;
    }

    public static android.net.NetworkInfo getNetworkInfoFromBroadcast(android.net.ConnectivityManager p2, android.content.Intent p3)
    {
        int v1_1;
        android.net.NetworkInfo v0_1 = ((android.net.NetworkInfo) p3.getParcelableExtra("networkInfo"));
        if (v0_1 == null) {
            v1_1 = 0;
        } else {
            v1_1 = p2.getNetworkInfo(v0_1.getType());
        }
        return v1_1;
    }

    public static boolean isActiveNetworkMetered(android.net.ConnectivityManager p1)
    {
        return android.support.v4.net.ConnectivityManagerCompat.IMPL.isActiveNetworkMetered(p1);
    }
}
