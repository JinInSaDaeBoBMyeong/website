package android.support.v4.app;
public abstract class INotificationSideChannel$Stub extends android.os.Binder implements android.support.v4.app.INotificationSideChannel {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;

    public INotificationSideChannel$Stub()
    {
        this.attachInterface(this, "android.support.v4.app.INotificationSideChannel");
        return;
    }

    public static android.support.v4.app.INotificationSideChannel asInterface(android.os.IBinder p2)
    {
        android.support.v4.app.INotificationSideChannel v0_0;
        if (p2 != null) {
            android.support.v4.app.INotificationSideChannel v0_1 = p2.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if ((v0_1 == null) || (!(v0_1 instanceof android.support.v4.app.INotificationSideChannel))) {
                v0_0 = new android.support.v4.app.INotificationSideChannel$Stub$Proxy(p2);
            } else {
                v0_0 = ((android.support.v4.app.INotificationSideChannel) v0_1);
            }
        } else {
            v0_0 = 0;
        }
        return v0_0;
    }

    public android.os.IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int p7, android.os.Parcel p8, android.os.Parcel p9, int p10)
    {
        boolean v4 = 1;
        switch (p7) {
            case 1:
                int v3_0;
                p8.enforceInterface("android.support.v4.app.INotificationSideChannel");
                String v0_1 = p8.readString();
                int v1_1 = p8.readInt();
                String v2_1 = p8.readString();
                if (p8.readInt() == 0) {
                    v3_0 = 0;
                } else {
                    v3_0 = ((android.app.Notification) android.app.Notification.CREATOR.createFromParcel(p8));
                }
                this.notify(v0_1, v1_1, v2_1, v3_0);
                break;
            case 2:
                p8.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancel(p8.readString(), p8.readInt(), p8.readString());
                break;
            case 3:
                p8.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancelAll(p8.readString());
                break;
            case 1598968902:
                p9.writeString("android.support.v4.app.INotificationSideChannel");
                break;
            default:
                v4 = super.onTransact(p7, p8, p9, p10);
        }
        return v4;
    }
}
