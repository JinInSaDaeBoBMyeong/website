package android.support.v4.app;
 class NotificationCompatSideChannelService$NotificationSideChannelStub extends android.support.v4.app.INotificationSideChannel$Stub {
    final synthetic android.support.v4.app.NotificationCompatSideChannelService this$0;

    private NotificationCompatSideChannelService$NotificationSideChannelStub(android.support.v4.app.NotificationCompatSideChannelService p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic NotificationCompatSideChannelService$NotificationSideChannelStub(android.support.v4.app.NotificationCompatSideChannelService p1, android.support.v4.app.NotificationCompatSideChannelService$1 p2)
    {
        this(p1);
        return;
    }

    public void cancel(String p5, int p6, String p7)
    {
        android.support.v4.app.NotificationCompatSideChannelService.access$100(this.this$0, android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.getCallingUid(), p5);
        long v0 = android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.cancel(p5, p6, p7);
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            return;
        } catch (Throwable v2_1) {
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            throw v2_1;
        }
    }

    public void cancelAll(String p5)
    {
        android.support.v4.app.NotificationCompatSideChannelService.access$100(this.this$0, android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.getCallingUid(), p5);
        long v0 = android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.cancelAll(p5);
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            return;
        } catch (Throwable v2_1) {
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            throw v2_1;
        }
    }

    public void notify(String p5, int p6, String p7, android.app.Notification p8)
    {
        android.support.v4.app.NotificationCompatSideChannelService.access$100(this.this$0, android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.getCallingUid(), p5);
        long v0 = android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.clearCallingIdentity();
        try {
            this.this$0.notify(p5, p6, p7, p8);
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            return;
        } catch (Throwable v2_1) {
            android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub.restoreCallingIdentity(v0);
            throw v2_1;
        }
    }
}
