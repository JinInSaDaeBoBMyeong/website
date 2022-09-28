package android.support.v4.app;
 class INotificationSideChannel$Stub$Proxy implements android.support.v4.app.INotificationSideChannel {
    private android.os.IBinder mRemote;

    INotificationSideChannel$Stub$Proxy(android.os.IBinder p1)
    {
        this.mRemote = p1;
        return;
    }

    public android.os.IBinder asBinder()
    {
        return this.mRemote;
    }

    public void cancel(String p6, int p7, String p8)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            v0.writeString(p6);
            v0.writeInt(p7);
            v0.writeString(p8);
            this.mRemote.transact(2, v0, 0, 1);
            v0.recycle();
            return;
        } catch (Throwable v1_0) {
            v0.recycle();
            throw v1_0;
        }
    }

    public void cancelAll(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            v0.writeString(p6);
            this.mRemote.transact(3, v0, 0, 1);
            v0.recycle();
            return;
        } catch (Throwable v1_0) {
            v0.recycle();
            throw v1_0;
        }
    }

    public String getInterfaceDescriptor()
    {
        return "android.support.v4.app.INotificationSideChannel";
    }

    public void notify(String p6, int p7, String p8, android.app.Notification p9)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            v0.writeString(p6);
            v0.writeInt(p7);
            v0.writeString(p8);
        } catch (android.os.IBinder v1_2) {
            v0.recycle();
            throw v1_2;
        }
        if (p9 == null) {
            v0.writeInt(0);
        } else {
            v0.writeInt(1);
            p9.writeToParcel(v0, 0);
        }
        this.mRemote.transact(1, v0, 0, 1);
        v0.recycle();
        return;
    }
}
