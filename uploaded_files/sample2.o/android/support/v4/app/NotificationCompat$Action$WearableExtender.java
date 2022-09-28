package android.support.v4.app;
public final class NotificationCompat$Action$WearableExtender implements android.support.v4.app.NotificationCompat$Action$Extender {
    private static final int DEFAULT_FLAGS = 1;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    private static final String KEY_FLAGS = "flags";
    private int mFlags;

    public NotificationCompat$Action$WearableExtender()
    {
        this.mFlags = 1;
        return;
    }

    public NotificationCompat$Action$WearableExtender(android.support.v4.app.NotificationCompat$Action p5)
    {
        this.mFlags = 1;
        android.os.Bundle v0 = p5.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (v0 != null) {
            this.mFlags = v0.getInt("flags", 1);
        }
        return;
    }

    private void setFlag(int p3, boolean p4)
    {
        if (!p4) {
            this.mFlags = (this.mFlags & (p3 ^ -1));
        } else {
            this.mFlags = (this.mFlags | p3);
        }
        return;
    }

    public android.support.v4.app.NotificationCompat$Action$WearableExtender clone()
    {
        android.support.v4.app.NotificationCompat$Action$WearableExtender v0_1 = new android.support.v4.app.NotificationCompat$Action$WearableExtender();
        v0_1.mFlags = this.mFlags;
        return v0_1;
    }

    public bridge synthetic Object clone()
    {
        return this.clone();
    }

    public android.support.v4.app.NotificationCompat$Action$Builder extend(android.support.v4.app.NotificationCompat$Action$Builder p4)
    {
        android.os.Bundle v0_1 = new android.os.Bundle();
        if (this.mFlags != 1) {
            v0_1.putInt("flags", this.mFlags);
        }
        p4.getExtras().putBundle("android.wearable.EXTENSIONS", v0_1);
        return p4;
    }

    public boolean isAvailableOffline()
    {
        int v0_2;
        if ((this.mFlags & 1) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public android.support.v4.app.NotificationCompat$Action$WearableExtender setAvailableOffline(boolean p2)
    {
        this.setFlag(1, p2);
        return this;
    }
}
