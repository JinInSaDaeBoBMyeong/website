package android.support.v4.app;
 class NotificationManagerCompat$NotifyTask implements android.support.v4.app.NotificationManagerCompat$Task {
    final int id;
    final android.app.Notification notif;
    final String packageName;
    final String tag;

    public NotificationManagerCompat$NotifyTask(String p1, int p2, String p3, android.app.Notification p4)
    {
        this.packageName = p1;
        this.id = p2;
        this.tag = p3;
        this.notif = p4;
        return;
    }

    public void send(android.support.v4.app.INotificationSideChannel p5)
    {
        p5.notify(this.packageName, this.id, this.tag, this.notif);
        return;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder("NotifyTask[");
        v0_1.append("packageName:").append(this.packageName);
        v0_1.append(", id:").append(this.id);
        v0_1.append(", tag:").append(this.tag);
        v0_1.append("]");
        return v0_1.toString();
    }
}
