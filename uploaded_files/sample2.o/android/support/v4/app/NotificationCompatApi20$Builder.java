package android.support.v4.app;
public class NotificationCompatApi20$Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
    private android.app.Notification$Builder b;

    public NotificationCompatApi20$Builder(android.content.Context p9, android.app.Notification p10, CharSequence p11, CharSequence p12, CharSequence p13, android.widget.RemoteViews p14, int p15, android.app.PendingIntent p16, android.app.PendingIntent p17, android.graphics.Bitmap p18, int p19, int p20, boolean p21, boolean p22, int p23, CharSequence p24, boolean p25, android.os.Bundle p26, String p27, boolean p28, String p29)
    {
        android.app.Notification$Builder v4_10;
        android.app.Notification$Builder vtmp7 = new android.app.Notification$Builder(p9).setWhen(p10.when).setSmallIcon(p10.icon, p10.iconLevel).setContent(p10.contentView).setTicker(p10.tickerText, p14).setSound(p10.sound, p10.audioStreamType).setVibrate(p10.vibrate).setLights(p10.ledARGB, p10.ledOnMS, p10.ledOffMS);
        if ((p10.flags & 2) == 0) {
            v4_10 = 0;
        } else {
            v4_10 = 1;
        }
        android.app.Notification$Builder v4_13;
        android.app.Notification$Builder v5_6 = vtmp7.setOngoing(v4_10);
        if ((p10.flags & 8) == 0) {
            v4_13 = 0;
        } else {
            v4_13 = 1;
        }
        android.app.Notification$Builder v4_16;
        android.app.Notification$Builder v5_7 = v5_6.setOnlyAlertOnce(v4_13);
        if ((p10.flags & 16) == 0) {
            v4_16 = 0;
        } else {
            v4_16 = 1;
        }
        android.app.Notification$Builder v4_27;
        android.app.Notification$Builder vtmp17 = v5_7.setAutoCancel(v4_16).setDefaults(p10.defaults).setContentTitle(p11).setContentText(p12).setSubText(p24).setContentInfo(p13).setContentIntent(p16).setDeleteIntent(p10.deleteIntent);
        if ((p10.flags & 128) == 0) {
            v4_27 = 0;
        } else {
            v4_27 = 1;
        }
        this.b = vtmp17.setFullScreenIntent(p17, v4_27).setLargeIcon(p18).setNumber(p15).setUsesChronometer(p22).setPriority(p23).setProgress(p19, p20, p21).setLocalOnly(p25).setExtras(p26).setGroup(p27).setGroupSummary(p28).setSortKey(p29);
        return;
    }

    public void addAction(android.support.v4.app.NotificationCompatBase$Action p9)
    {
        android.app.Notification$Action$Builder v0_1 = new android.app.Notification$Action$Builder(p9.getIcon(), p9.getTitle(), p9.getActionIntent());
        if (p9.getRemoteInputs() != null) {
            android.app.RemoteInput[] v1 = android.support.v4.app.RemoteInputCompatApi20.fromCompat(p9.getRemoteInputs());
            int v3 = v1.length;
            int v2 = 0;
            while (v2 < v3) {
                v0_1.addRemoteInput(v1[v2]);
                v2++;
            }
        }
        if (p9.getExtras() != null) {
            v0_1.addExtras(p9.getExtras());
        }
        this.b.addAction(v0_1.build());
        return;
    }

    public android.app.Notification build()
    {
        return this.b.build();
    }

    public android.app.Notification$Builder getBuilder()
    {
        return this.b;
    }
}
