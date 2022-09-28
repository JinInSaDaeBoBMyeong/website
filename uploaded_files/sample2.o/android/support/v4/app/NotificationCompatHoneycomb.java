package android.support.v4.app;
 class NotificationCompatHoneycomb {

    NotificationCompatHoneycomb()
    {
        return;
    }

    static android.app.Notification add(android.content.Context p5, android.app.Notification p6, CharSequence p7, CharSequence p8, CharSequence p9, android.widget.RemoteViews p10, int p11, android.app.PendingIntent p12, android.app.PendingIntent p13, android.graphics.Bitmap p14)
    {
        android.app.Notification v1_8;
        android.app.Notification$Builder vtmp7 = new android.app.Notification$Builder(p5).setWhen(p6.when).setSmallIcon(p6.icon, p6.iconLevel).setContent(p6.contentView).setTicker(p6.tickerText, p10).setSound(p6.sound, p6.audioStreamType).setVibrate(p6.vibrate).setLights(p6.ledARGB, p6.ledOnMS, p6.ledOffMS);
        if ((p6.flags & 2) == 0) {
            v1_8 = 0;
        } else {
            v1_8 = 1;
        }
        android.app.Notification v1_11;
        android.app.Notification$Builder v2_6 = vtmp7.setOngoing(v1_8);
        if ((p6.flags & 8) == 0) {
            v1_11 = 0;
        } else {
            v1_11 = 1;
        }
        android.app.Notification v1_15;
        android.app.Notification$Builder v2_7 = v2_6.setOnlyAlertOnce(v1_11);
        if ((p6.flags & 16) == 0) {
            v1_15 = 0;
        } else {
            v1_15 = 1;
        }
        android.app.Notification v1_24;
        android.app.Notification$Builder vtmp16 = v2_7.setAutoCancel(v1_15).setDefaults(p6.defaults).setContentTitle(p7).setContentText(p8).setContentInfo(p9).setContentIntent(p12).setDeleteIntent(p6.deleteIntent);
        if ((p6.flags & 128) == 0) {
            v1_24 = 0;
        } else {
            v1_24 = 1;
        }
        return vtmp16.setFullScreenIntent(p13, v1_24).setLargeIcon(p14).setNumber(p11).getNotification();
    }
}
