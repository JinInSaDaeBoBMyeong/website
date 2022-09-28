package android.support.v4.app;
public abstract class NotificationCompatSideChannelService extends android.app.Service {
    private static final int BUILD_VERSION_CODE_KITKAT_WATCH = 20;

    public NotificationCompatSideChannelService()
    {
        return;
    }

    static synthetic void access$100(android.support.v4.app.NotificationCompatSideChannelService p0, int p1, String p2)
    {
        p0.checkPermission(p1, p2);
        return;
    }

    private void checkPermission(int p8, String p9)
    {
        String[] v0 = this.getPackageManager().getPackagesForUid(p8);
        int v1 = 0;
        while (v1 < v0.length) {
            if (!v0[v1].equals(p9)) {
                v1++;
            } else {
                return;
            }
        }
        throw new SecurityException(new StringBuilder().append("NotificationSideChannelService: Uid ").append(p8).append(" is not authorized for package ").append(p9).toString());
    }

    public abstract void cancel();

    public abstract void cancelAll();

    public abstract void notify();

    public android.os.IBinder onBind(android.content.Intent p4)
    {
        android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub v0 = 0;
        if ((p4.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) && (android.os.Build$VERSION.SDK_INT < 20)) {
            v0 = new android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub(this, 0);
        }
        return v0;
    }
}
