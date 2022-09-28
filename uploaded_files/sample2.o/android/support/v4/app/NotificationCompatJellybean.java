package android.support.v4.app;
 class NotificationCompatJellybean {
    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class sActionClass;
    private static reflect.Field sActionIconField;
    private static reflect.Field sActionIntentField;
    private static reflect.Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static reflect.Field sActionsField;
    private static final Object sActionsLock;
    private static reflect.Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;

    static NotificationCompatJellybean()
    {
        android.support.v4.app.NotificationCompatJellybean.sExtrasLock = new Object();
        android.support.v4.app.NotificationCompatJellybean.sActionsLock = new Object();
        return;
    }

    NotificationCompatJellybean()
    {
        return;
    }

    public static void addBigPictureStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor p3, CharSequence p4, boolean p5, CharSequence p6, android.graphics.Bitmap p7, android.graphics.Bitmap p8, boolean p9)
    {
        android.app.Notification$BigPictureStyle v0 = new android.app.Notification$BigPictureStyle(p3.getBuilder()).setBigContentTitle(p4).bigPicture(p7);
        if (p9) {
            v0.bigLargeIcon(p8);
        }
        if (p5) {
            v0.setSummaryText(p6);
        }
        return;
    }

    public static void addBigTextStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor p3, CharSequence p4, boolean p5, CharSequence p6, CharSequence p7)
    {
        android.app.Notification$BigTextStyle vtmp3 = new android.app.Notification$BigTextStyle(p3.getBuilder()).setBigContentTitle(p4).bigText(p7);
        if (p5) {
            vtmp3.setSummaryText(p6);
        }
        return;
    }

    public static void addInboxStyle(android.support.v4.app.NotificationBuilderWithBuilderAccessor p5, CharSequence p6, boolean p7, CharSequence p8, java.util.ArrayList p9)
    {
        android.app.Notification$InboxStyle v1 = new android.app.Notification$InboxStyle(p5.getBuilder()).setBigContentTitle(p6);
        if (p7) {
            v1.setSummaryText(p8);
        }
        java.util.Iterator v0 = p9.iterator();
        while (v0.hasNext()) {
            v1.addLine(((CharSequence) v0.next()));
        }
        return;
    }

    public static android.util.SparseArray buildActionExtrasMap(java.util.List p4)
    {
        android.util.SparseArray v1_0 = 0;
        int v3 = 0;
        int v2 = p4.size();
        while (v3 < v2) {
            android.os.Bundle v0_1 = ((android.os.Bundle) p4.get(v3));
            if (v0_1 != null) {
                if (v1_0 == null) {
                    v1_0 = new android.util.SparseArray();
                }
                v1_0.put(v3, v0_1);
            }
            v3++;
        }
        return v1_0;
    }

    private static boolean ensureActionReflectionReadyLocked()
    {
        int v2 = 0;
        int v1 = 1;
        if (!android.support.v4.app.NotificationCompatJellybean.sActionsAccessFailed) {
            try {
                if (android.support.v4.app.NotificationCompatJellybean.sActionsField == null) {
                    android.support.v4.app.NotificationCompatJellybean.sActionClass = Class.forName("android.app.Notification$Action");
                    android.support.v4.app.NotificationCompatJellybean.sActionIconField = android.support.v4.app.NotificationCompatJellybean.sActionClass.getDeclaredField("icon");
                    android.support.v4.app.NotificationCompatJellybean.sActionTitleField = android.support.v4.app.NotificationCompatJellybean.sActionClass.getDeclaredField("title");
                    android.support.v4.app.NotificationCompatJellybean.sActionIntentField = android.support.v4.app.NotificationCompatJellybean.sActionClass.getDeclaredField("actionIntent");
                    android.support.v4.app.NotificationCompatJellybean.sActionsField = android.app.Notification.getDeclaredField("actions");
                    android.support.v4.app.NotificationCompatJellybean.sActionsField.setAccessible(1);
                }
            } catch (NoSuchFieldException v0_1) {
                android.util.Log.e("NotificationCompat", "Unable to access notification actions", v0_1);
                android.support.v4.app.NotificationCompatJellybean.sActionsAccessFailed = 1;
            } catch (NoSuchFieldException v0_0) {
                android.util.Log.e("NotificationCompat", "Unable to access notification actions", v0_0);
                android.support.v4.app.NotificationCompatJellybean.sActionsAccessFailed = 1;
            }
            if (android.support.v4.app.NotificationCompatJellybean.sActionsAccessFailed) {
                v1 = 0;
            }
            v2 = v1;
        }
        return v2;
    }

    public static android.support.v4.app.NotificationCompatBase$Action getAction(android.app.Notification p11, int p12, android.support.v4.app.NotificationCompatBase$Action$Factory p13, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p14)
    {
        try {
            Object v7 = android.support.v4.app.NotificationCompatJellybean.getActionObjectsLocked(p11)[p12];
            android.os.Bundle v5_1 = 0;
            android.os.Bundle v9 = android.support.v4.app.NotificationCompatJellybean.getExtras(p11);
        } catch (android.support.v4.app.NotificationCompatBase$Action v0_8) {
            throw v0_8;
        }
        if (v9 != null) {
            android.util.SparseArray v6 = v9.getSparseParcelableArray("android.support.actionExtras");
            if (v6 != null) {
                v5_1 = ((android.os.Bundle) v6.get(p12));
            }
        }
        android.support.v4.app.NotificationCompatBase$Action v0_3 = android.support.v4.app.NotificationCompatJellybean.readAction(p13, p14, android.support.v4.app.NotificationCompatJellybean.sActionIconField.getInt(v7), ((CharSequence) android.support.v4.app.NotificationCompatJellybean.sActionTitleField.get(v7)), ((android.app.PendingIntent) android.support.v4.app.NotificationCompatJellybean.sActionIntentField.get(v7)), v5_1);
        return v0_3;
    }

    public static int getActionCount(android.app.Notification p3)
    {
        try {
            int v1_0;
            Object[] v0 = android.support.v4.app.NotificationCompatJellybean.getActionObjectsLocked(p3);
        } catch (int v1_1) {
            throw v1_1;
        }
        if (v0 == null) {
            v1_0 = 0;
        } else {
            v1_0 = v0.length;
        }
        return v1_0;
    }

    private static android.support.v4.app.NotificationCompatBase$Action getActionFromBundle(android.os.Bundle p6, android.support.v4.app.NotificationCompatBase$Action$Factory p7, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p8)
    {
        return p7.build(p6.getInt("icon"), p6.getCharSequence("title"), ((android.app.PendingIntent) p6.getParcelable("actionIntent")), p6.getBundle("extras"), android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(p6, "remoteInputs"), p8));
    }

    private static Object[] getActionObjectsLocked(android.app.Notification p5)
    {
        try {
            int v1_2;
            if (android.support.v4.app.NotificationCompatJellybean.ensureActionReflectionReadyLocked()) {
                try {
                    v1_2 = ((Object[]) ((Object[]) android.support.v4.app.NotificationCompatJellybean.sActionsField.get(p5)));
                } catch (IllegalAccessException v0) {
                    android.util.Log.e("NotificationCompat", "Unable to access notification actions", v0);
                    android.support.v4.app.NotificationCompatJellybean.sActionsAccessFailed = 1;
                    v1_2 = 0;
                }
            } else {
                v1_2 = 0;
            }
        } catch (int v1_3) {
            throw v1_3;
        }
        return v1_2;
    }

    public static android.support.v4.app.NotificationCompatBase$Action[] getActionsFromParcelableArrayList(java.util.ArrayList p3, android.support.v4.app.NotificationCompatBase$Action$Factory p4, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p5)
    {
        android.support.v4.app.NotificationCompatBase$Action[] v0;
        if (p3 != null) {
            v0 = p4.newArray(p3.size());
            int v1 = 0;
            while (v1 < v0.length) {
                v0[v1] = android.support.v4.app.NotificationCompatJellybean.getActionFromBundle(((android.os.Bundle) p3.get(v1)), p4, p5);
                v1++;
            }
        } else {
            v0 = 0;
        }
        return v0;
    }

    private static android.os.Bundle getBundleForAction(android.support.v4.app.NotificationCompatBase$Action p3)
    {
        android.os.Bundle v0_1 = new android.os.Bundle();
        v0_1.putInt("icon", p3.getIcon());
        v0_1.putCharSequence("title", p3.getTitle());
        v0_1.putParcelable("actionIntent", p3.getActionIntent());
        v0_1.putBundle("extras", p3.getExtras());
        v0_1.putParcelableArray("remoteInputs", android.support.v4.app.RemoteInputCompatJellybean.toBundleArray(p3.getRemoteInputs()));
        return v0_1;
    }

    public static android.os.Bundle getExtras(android.app.Notification p7)
    {
        try {
            Throwable v1_1;
            if (!android.support.v4.app.NotificationCompatJellybean.sExtrasFieldAccessFailed) {
                try {
                    if (android.support.v4.app.NotificationCompatJellybean.sExtrasField != null) {
                        v1_1 = ((android.os.Bundle) android.support.v4.app.NotificationCompatJellybean.sExtrasField.get(p7));
                        if (v1_1 == null) {
                            v1_1 = new android.os.Bundle();
                            android.support.v4.app.NotificationCompatJellybean.sExtrasField.set(p7, v1_1);
                        }
                        return v1_1;
                    } else {
                        reflect.Field v2 = android.app.Notification.getDeclaredField("extras");
                        if (android.os.Bundle.isAssignableFrom(v2.getType())) {
                            v2.setAccessible(1);
                            android.support.v4.app.NotificationCompatJellybean.sExtrasField = v2;
                        } else {
                            android.util.Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                            android.support.v4.app.NotificationCompatJellybean.sExtrasFieldAccessFailed = 1;
                            v1_1 = 0;
                            return v1_1;
                        }
                    }
                } catch (NoSuchFieldException v0_1) {
                    android.util.Log.e("NotificationCompat", "Unable to access notification extras", v0_1);
                } catch (NoSuchFieldException v0_0) {
                    android.util.Log.e("NotificationCompat", "Unable to access notification extras", v0_0);
                }
                android.support.v4.app.NotificationCompatJellybean.sExtrasFieldAccessFailed = 1;
                v1_1 = 0;
            } else {
                v1_1 = 0;
            }
        } catch (Throwable v3_1) {
            throw v3_1;
        }
        return v1_1;
    }

    public static String getGroup(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatJellybean.getExtras(p2).getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatJellybean.getExtras(p2).getBoolean("android.support.localOnly");
    }

    public static java.util.ArrayList getParcelableArrayListForActions(android.support.v4.app.NotificationCompatBase$Action[] p6)
    {
        java.util.ArrayList v4_1;
        if (p6 != null) {
            v4_1 = new java.util.ArrayList(p6.length);
            int v3 = p6.length;
            int v2 = 0;
            while (v2 < v3) {
                v4_1.add(android.support.v4.app.NotificationCompatJellybean.getBundleForAction(p6[v2]));
                v2++;
            }
        } else {
            v4_1 = 0;
        }
        return v4_1;
    }

    public static String getSortKey(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatJellybean.getExtras(p2).getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(android.app.Notification p2)
    {
        return android.support.v4.app.NotificationCompatJellybean.getExtras(p2).getBoolean("android.support.isGroupSummary");
    }

    public static android.support.v4.app.NotificationCompatBase$Action readAction(android.support.v4.app.NotificationCompatBase$Action$Factory p6, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory p7, int p8, CharSequence p9, android.app.PendingIntent p10, android.os.Bundle p11)
    {
        android.support.v4.app.RemoteInputCompatBase$RemoteInput[] v5 = 0;
        if (p11 != null) {
            v5 = android.support.v4.app.RemoteInputCompatJellybean.fromBundleArray(android.support.v4.app.BundleUtil.getBundleArrayFromBundle(p11, "android.support.remoteInputs"), p7);
        }
        return p6.build(p8, p9, p10, p11, v5);
    }

    public static android.os.Bundle writeActionAndGetExtras(android.app.Notification$Builder p4, android.support.v4.app.NotificationCompatBase$Action p5)
    {
        p4.addAction(p5.getIcon(), p5.getTitle(), p5.getActionIntent());
        android.os.Bundle v0_0 = new android.os.Bundle(p5.getExtras());
        if (p5.getRemoteInputs() != null) {
            v0_0.putParcelableArray("android.support.remoteInputs", android.support.v4.app.RemoteInputCompatJellybean.toBundleArray(p5.getRemoteInputs()));
        }
        return v0_0;
    }
}
