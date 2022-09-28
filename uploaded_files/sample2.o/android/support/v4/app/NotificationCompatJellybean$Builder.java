package android.support.v4.app;
public class NotificationCompatJellybean$Builder implements android.support.v4.app.NotificationBuilderWithBuilderAccessor, android.support.v4.app.NotificationBuilderWithActions {
    private android.app.Notification$Builder b;
    private java.util.List mActionExtrasList;
    private final android.os.Bundle mExtras;

    public NotificationCompatJellybean$Builder(android.content.Context p9, android.app.Notification p10, CharSequence p11, CharSequence p12, CharSequence p13, android.widget.RemoteViews p14, int p15, android.app.PendingIntent p16, android.app.PendingIntent p17, android.graphics.Bitmap p18, int p19, int p20, boolean p21, boolean p22, int p23, CharSequence p24, boolean p25, android.os.Bundle p26, String p27, boolean p28, String p29)
    {
        android.os.Bundle v4_14;
        this.mActionExtrasList = new java.util.ArrayList();
        android.app.Notification$Builder vtmp7 = new android.app.Notification$Builder(p9).setWhen(p10.when).setSmallIcon(p10.icon, p10.iconLevel).setContent(p10.contentView).setTicker(p10.tickerText, p14).setSound(p10.sound, p10.audioStreamType).setVibrate(p10.vibrate).setLights(p10.ledARGB, p10.ledOnMS, p10.ledOffMS);
        if ((p10.flags & 2) == 0) {
            v4_14 = 0;
        } else {
            v4_14 = 1;
        }
        android.os.Bundle v4_18;
        String v5_11 = vtmp7.setOngoing(v4_14);
        if ((p10.flags & 8) == 0) {
            v4_18 = 0;
        } else {
            v4_18 = 1;
        }
        android.os.Bundle v4_21;
        String v5_12 = v5_11.setOnlyAlertOnce(v4_18);
        if ((p10.flags & 16) == 0) {
            v4_21 = 0;
        } else {
            v4_21 = 1;
        }
        android.os.Bundle v4_32;
        android.app.Notification$Builder vtmp17 = v5_12.setAutoCancel(v4_21).setDefaults(p10.defaults).setContentTitle(p11).setContentText(p12).setSubText(p24).setContentInfo(p13).setContentIntent(p16).setDeleteIntent(p10.deleteIntent);
        if ((p10.flags & 128) == 0) {
            v4_32 = 0;
        } else {
            v4_32 = 1;
        }
        this.b = vtmp17.setFullScreenIntent(p17, v4_32).setLargeIcon(p18).setNumber(p15).setUsesChronometer(p22).setPriority(p23).setProgress(p19, p20, p21);
        this.mExtras = new android.os.Bundle();
        if (p26 != null) {
            this.mExtras.putAll(p26);
        }
        if (p25) {
            this.mExtras.putBoolean("android.support.localOnly", 1);
        }
        if (p27 != null) {
            this.mExtras.putString("android.support.groupKey", p27);
            if (!p28) {
                this.mExtras.putBoolean("android.support.useSideChannel", 1);
            } else {
                this.mExtras.putBoolean("android.support.isGroupSummary", 1);
            }
        }
        if (p29 != null) {
            this.mExtras.putString("android.support.sortKey", p29);
        }
        return;
    }

    public void addAction(android.support.v4.app.NotificationCompatBase$Action p3)
    {
        this.mActionExtrasList.add(android.support.v4.app.NotificationCompatJellybean.writeActionAndGetExtras(this.b, p3));
        return;
    }

    public android.app.Notification build()
    {
        android.app.Notification v5 = this.b.build();
        android.os.Bundle v1 = android.support.v4.app.NotificationCompatJellybean.getExtras(v5);
        android.os.Bundle v4_1 = new android.os.Bundle(this.mExtras);
        java.util.Iterator v2 = this.mExtras.keySet().iterator();
        while (v2.hasNext()) {
            String v3_1 = ((String) v2.next());
            if (v1.containsKey(v3_1)) {
                v4_1.remove(v3_1);
            }
        }
        v1.putAll(v4_1);
        android.util.SparseArray v0 = android.support.v4.app.NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
        if (v0 != null) {
            android.support.v4.app.NotificationCompatJellybean.getExtras(v5).putSparseParcelableArray("android.support.actionExtras", v0);
        }
        return v5;
    }

    public android.app.Notification$Builder getBuilder()
    {
        return this.b;
    }
}
