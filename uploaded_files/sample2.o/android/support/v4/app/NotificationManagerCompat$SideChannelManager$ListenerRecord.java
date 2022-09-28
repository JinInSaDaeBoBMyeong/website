package android.support.v4.app;
 class NotificationManagerCompat$SideChannelManager$ListenerRecord {
    public boolean bound;
    public final android.content.ComponentName componentName;
    public int retryCount;
    public android.support.v4.app.INotificationSideChannel service;
    public java.util.LinkedList taskQueue;

    public NotificationManagerCompat$SideChannelManager$ListenerRecord(android.content.ComponentName p3)
    {
        this.bound = 0;
        this.taskQueue = new java.util.LinkedList();
        this.retryCount = 0;
        this.componentName = p3;
        return;
    }
}
