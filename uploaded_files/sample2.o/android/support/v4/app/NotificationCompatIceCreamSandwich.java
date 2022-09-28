package android.support.v4.app;
 class NotificationCompatIceCreamSandwich {

    NotificationCompatIceCreamSandwich()
    {
        return;
    }

    static android.app.Notification add(android.content.Context p9, android.app.Notification p10, CharSequence p11, CharSequence p12, CharSequence p13, android.widget.RemoteViews p14, int p15, android.app.PendingIntent p16, android.app.PendingIntent p17, android.graphics.Bitmap p18, int p19, int p20, boolean p21)
    {
        android.app.Notification v5_8;
        android.app.Notification$Builder vtmp7 = new android.app.Notification$Builder(p9).setWhen(p10.when).setSmallIcon(p10.icon, p10.iconLevel).setContent(p10.contentView).setTicker(p10.tickerText, p14).setSound(p10.sound, p10.audioStreamType).setVibrate(p10.vibrate).setLights(p10.ledARGB, p10.ledOnMS, p10.ledOffMS);
        if ((p10.flags & 2) == 0) {
            v5_8 = 0;
        } else {
            v5_8 = 1;
        }
        android.app.Notification v5_11;
        android.app.Notification$Builder v6_6 = vtmp7.setOngoing(v5_8);
        if ((p10.flags & 8) == 0) {
            v5_11 = 0;
        } else {
            v5_11 = 1;
        }
        android.app.Notification v5_15;
        android.app.Notification$Builder v6_7 = v6_6.setOnlyAlertOnce(v5_11);
        if ((p10.flags & 16) == 0) {
            v5_15 = 0;
        } else {
            v5_15 = 1;
        }
        android.app.Notification v5_24;
        android.app.Notification$Builder vtmp16 = v6_7.setAutoCancel(v5_15).setDefaults(p10.defaults).setContentTitle(p11).setContentText(p12).setContentInfo(p13).setContentIntent(p16).setDeleteIntent(p10.deleteIntent);
        if ((p10.flags & 128) == 0) {
            v5_24 = 0;
        } else {
            v5_24 = 1;
        }
        return vtmp16.setFullScreenIntent(p17, v5_24).setLargeIcon(p18).setNumber(p15).setProgress(p19, p20, p21).getNotification();
    }
}
