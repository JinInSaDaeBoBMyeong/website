package android.support.v4.app;
 class NotificationCompatKitKat {

    NotificationCompatKitKat()
    {
        return;
    }

    public static android.support.v4.app.NotificationCompatBase$Action getAction(android.app.Notification p8, int p9, android.support.v4.app.NotificationCompatBase$Action$Factory p10, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p11)
    {
        android.app.Notification$Action v6 = p8.actions[p9];
        android.os.Bundle v5_0 = 0;
        android.util.SparseArray v7 = p8.extras.getSparseParcelableArray("android.support.actionExtras");
        if (v7 != null) {
            v5_0 = ((android.os.Bundle) v7.get(p9));
        }
        return android.support.v4.app.NotificationCompatJellybean.readAction(p10, p11, v6.icon, v6.title, v6.actionIntent, v5_0);
    }

    public static int getActionCount(android.app.Notification p1)
    {
        int v0_1;
        if (p1.actions == null) {
            v0_1 = 0;
        } else {
            v0_1 = p1.actions.length;
        }
        return v0_1;
    }

    public static android.os.Bundle getExtras(android.app.Notification p1)
    {
        return p1.extras;
    }

    public static String getGroup(android.app.Notification p2)
    {
        return p2.extras.getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(android.app.Notification p2)
    {
        return p2.extras.getBoolean("android.support.localOnly");
    }

    public static String getSortKey(android.app.Notification p2)
    {
        return p2.extras.getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(android.app.Notification p2)
    {
        return p2.extras.getBoolean("android.support.isGroupSummary");
    }
}
