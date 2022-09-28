package android.support.v4.app;
 class NotificationCompatApi20 {

    NotificationCompatApi20()
    {
        return;
    }

    public static android.support.v4.app.NotificationCompatBase$Action getAction(android.app.Notification p1, int p2, android.support.v4.app.NotificationCompatBase$Action$Factory p3, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p4)
    {
        return android.support.v4.app.NotificationCompatApi20.getActionCompatFromAction(p1.actions[p2], p3, p4);
    }

    private static android.support.v4.app.NotificationCompatBase$Action getActionCompatFromAction(android.app.Notification$Action p6, android.support.v4.app.NotificationCompatBase$Action$Factory p7, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p8)
    {
        return p7.build(p6.icon, p6.title, p6.actionIntent, p6.getExtras(), android.support.v4.app.RemoteInputCompatApi20.toCompat(p6.getRemoteInputs(), p8));
    }

    private static android.app.Notification$Action getActionFromActionCompat(android.support.v4.app.NotificationCompatBase$Action p11)
    {
        android.app.Notification$Action$Builder v0 = new android.app.Notification$Action$Builder(p11.getIcon(), p11.getTitle(), p11.getActionIntent()).addExtras(p11.getExtras());
        android.support.v4.app.RemoteInputCompatBase$RemoteInput[] v5 = p11.getRemoteInputs();
        if (v5 != null) {
            android.app.RemoteInput[] v1 = android.support.v4.app.RemoteInputCompatApi20.fromCompat(v5);
            int v3 = v1.length;
            int v2 = 0;
            while (v2 < v3) {
                v0.addRemoteInput(v1[v2]);
                v2++;
            }
        }
        return v0.build();
    }

    public static android.support.v4.app.NotificationCompatBase$Action[] getActionsFromParcelableArrayList(java.util.ArrayList p4, android.support.v4.app.NotificationCompatBase$Action$Factory p5, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p6)
    {
        android.support.v4.app.NotificationCompatBase$Action[] v1;
        if (p4 != null) {
            v1 = p5.newArray(p4.size());
            int v2 = 0;
            while (v2 < v1.length) {
                v1[v2] = android.support.v4.app.NotificationCompatApi20.getActionCompatFromAction(((android.app.Notification$Action) p4.get(v2)), p5, p6);
                v2++;
            }
        } else {
            v1 = 0;
        }
        return v1;
    }

    public static String getGroup(android.app.Notification p1)
    {
        return p1.getGroup();
    }

    public static boolean getLocalOnly(android.app.Notification p1)
    {
        int v0_2;
        if ((p1.flags & 256) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public static java.util.ArrayList getParcelableArrayListForActions(android.support.v4.app.NotificationCompatBase$Action[] p6)
    {
        java.util.ArrayList v4_1;
        if (p6 != null) {
            v4_1 = new java.util.ArrayList(p6.length);
            int v3 = p6.length;
            int v2 = 0;
            while (v2 < v3) {
                v4_1.add(android.support.v4.app.NotificationCompatApi20.getActionFromActionCompat(p6[v2]));
                v2++;
            }
        } else {
            v4_1 = 0;
        }
        return v4_1;
    }

    public static String getSortKey(android.app.Notification p1)
    {
        return p1.getSortKey();
    }

    public static boolean isGroupSummary(android.app.Notification p1)
    {
        int v0_2;
        if ((p1.flags & 512) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }
}
