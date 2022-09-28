package android.support.v4.app;
 class NotificationManagerCompat$CancelTask implements android.support.v4.app.NotificationManagerCompat$Task {
    final boolean all;
    final int id;
    final String packageName;
    final String tag;

    public NotificationManagerCompat$CancelTask(String p2)
    {
        this.packageName = p2;
        this.id = 0;
        this.tag = 0;
        this.all = 1;
        return;
    }

    public NotificationManagerCompat$CancelTask(String p2, int p3, String p4)
    {
        this.packageName = p2;
        this.id = p3;
        this.tag = p4;
        this.all = 0;
        return;
    }

    public void send(android.support.v4.app.INotificationSideChannel p4)
    {
        if (!this.all) {
            p4.cancel(this.packageName, this.id, this.tag);
        } else {
            p4.cancelAll(this.packageName);
        }
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder("CancelTask[");
        v0_1.append("packageName:").append(this.packageName);
        v0_1.append(", id:").append(this.id);
        v0_1.append(", tag:").append(this.tag);
        v0_1.append(", all:").append(this.all);
        v0_1.append("]");
        return v0_1.toString();
    }
}
