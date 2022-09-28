package org.webrtc.voiceengine;
public final class BuildInfo {

    public BuildInfo()
    {
        return;
    }

    public static String getAndroidBuildId()
    {
        return android.os.Build.ID;
    }

    public static String getBrand()
    {
        return android.os.Build.BRAND;
    }

    public static String getBuildRelease()
    {
        return android.os.Build$VERSION.RELEASE;
    }

    public static String getBuildType()
    {
        return android.os.Build.TYPE;
    }

    public static String getDevice()
    {
        return android.os.Build.DEVICE;
    }

    public static String getDeviceManufacturer()
    {
        return android.os.Build.MANUFACTURER;
    }

    public static String getDeviceModel()
    {
        return android.os.Build.MODEL;
    }

    public static String getProduct()
    {
        return android.os.Build.PRODUCT;
    }

    public static int getSdkVersion()
    {
        return android.os.Build$VERSION.SDK_INT;
    }
}
