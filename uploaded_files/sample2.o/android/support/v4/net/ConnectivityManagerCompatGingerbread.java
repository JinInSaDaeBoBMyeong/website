package android.support.v4.net;
 class ConnectivityManagerCompatGingerbread {

    ConnectivityManagerCompatGingerbread()
    {
        return;
    }

    public static boolean isActiveNetworkMetered(android.net.ConnectivityManager p3)
    {
        int v2 = 1;
        android.net.NetworkInfo v0 = p3.getActiveNetworkInfo();
        if (v0 != null) {
            switch (v0.getType()) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 1:
                    v2 = 0;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
            }
        }
        return v2;
    }
}
