package android.support.v4.os;
 class EnvironmentCompatKitKat {

    EnvironmentCompatKitKat()
    {
        return;
    }

    public static String getStorageState(java.io.File p1)
    {
        return android.os.Environment.getStorageState(p1);
    }
}
