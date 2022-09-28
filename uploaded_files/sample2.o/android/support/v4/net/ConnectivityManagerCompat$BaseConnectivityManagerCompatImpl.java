package android.support.v4.net;
 class ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl implements android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl {

    ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl()
    {
        return;
    }

    public boolean isActiveNetworkMetered(android.net.ConnectivityManager p4)
    {
        int v2 = 1;
        android.net.NetworkInfo v0 = p4.getActiveNetworkInfo();
        if (v0 != null) {
            switch (v0.getType()) {
                case 0:
                    break;
                case 1:
                    v2 = 0;
                    break;
                default:
            }
        }
        return v2;
    }
}
