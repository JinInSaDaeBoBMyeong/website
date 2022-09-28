package android.support.v4.app;
public class NotificationCompat {
    public static final int DEFAULT_ALL = 255;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    private static final android.support.v4.app.NotificationCompat$NotificationCompatImpl IMPL = None;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = 255;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = 254;
    public static final int STREAM_DEFAULT = 255;

    static NotificationCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 20) {
            if (android.os.Build$VERSION.SDK_INT < 19) {
                if (android.os.Build$VERSION.SDK_INT < 16) {
                    if (android.os.Build$VERSION.SDK_INT < 14) {
                        if (android.os.Build$VERSION.SDK_INT < 11) {
                            if (android.os.Build$VERSION.SDK_INT < 9) {
                                android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplBase();
                            } else {
                                android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplGingerbread();
                            }
                        } else {
                            android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplHoneycomb();
                        }
                    } else {
                        android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplIceCreamSandwich();
                    }
                } else {
                    android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean();
                }
            } else {
                android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplKitKat();
            }
        } else {
            android.support.v4.app.NotificationCompat.IMPL = new android.support.v4.app.NotificationCompat$NotificationCompatImplApi20();
        }
        return;
    }

    public NotificationCompat()
    {
        return;
    }

    static synthetic void access$000(android.support.v4.app.NotificationBuilderWithActions p0, java.util.ArrayList p1)
    {
        android.support.v4.app.NotificationCompat.addActionsToBuilder(p0, p1);
        return;
    }

    static synthetic void access$100(android.support.v4.app.NotificationBuilderWithBuilderAccessor p0, android.support.v4.app.NotificationCompat$Style p1)
    {
        android.support.v4.app.NotificationCompat.addStyleToBuilderJellybean(p0, p1);
        return;
    }

    static synthetic android.support.v4.app.NotificationCompat$NotificationCompatImpl access$200()
    {
        return android.support.v4.app.NotificationCompat.IMPL;
    }

    static synthetic android.app.Notification[] access$500(android.os.Bundle p1, String p2)
    {
        return android.support.v4.app.NotificationCompat.getNotificationArrayFromBundle(p1, p2);
    }

    private static void addActionsToBuilder(android.support.v4.app.NotificationBuilderWithActions p3, java.util.ArrayList p4)
    {
        java.util.Iterator v1 = p4.iterator();
        while (v1.hasNext()) {
            p3.addAction(((android.support.v4.app.NotificationCompat$Action) v1.next()));
        }
        return;
    }

    private static void addStyleToBuilderJellybean(android.support.v4.app.NotificationBuilderWithBuilderAccessor p10, android.support.v4.app.NotificationCompat$Style p11)
    {
        if (p11 != null) {
            if (!(p11 instanceof android.support.v4.app.NotificationCompat$BigTextStyle)) {
                if (!(p11 instanceof android.support.v4.app.NotificationCompat$InboxStyle)) {
                    if ((p11 instanceof android.support.v4.app.NotificationCompat$BigPictureStyle)) {
                        android.support.v4.app.NotificationCompatJellybean.addBigPictureStyle(p10, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mBigContentTitle, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mSummaryTextSet, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mSummaryText, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mPicture, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mBigLargeIcon, ((android.support.v4.app.NotificationCompat$BigPictureStyle) p11).mBigLargeIconSet);
                    }
                } else {
                    android.support.v4.app.NotificationCompatJellybean.addInboxStyle(p10, ((android.support.v4.app.NotificationCompat$InboxStyle) p11).mBigContentTitle, ((android.support.v4.app.NotificationCompat$InboxStyle) p11).mSummaryTextSet, ((android.support.v4.app.NotificationCompat$InboxStyle) p11).mSummaryText, ((android.support.v4.app.NotificationCompat$InboxStyle) p11).mTexts);
                }
            } else {
                android.support.v4.app.NotificationCompatJellybean.addBigTextStyle(p10, ((android.support.v4.app.NotificationCompat$BigTextStyle) p11).mBigContentTitle, ((android.support.v4.app.NotificationCompat$BigTextStyle) p11).mSummaryTextSet, ((android.support.v4.app.NotificationCompat$BigTextStyle) p11).mSummaryText, ((android.support.v4.app.NotificationCompat$BigTextStyle) p11).mBigText);
            }
        }
        return;
    }

    public static android.support.v4.app.NotificationCompat$Action getAction(android.app.Notification p1, int p2)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getAction(p1, p2);
    }

    public static int getActionCount(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getActionCount(p1);
    }

    public static android.os.Bundle getExtras(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getExtras(p1);
    }

    public static String getGroup(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getGroup(p1);
    }

    public static boolean getLocalOnly(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getLocalOnly(p1);
    }

    private static android.app.Notification[] getNotificationArrayFromBundle(android.os.Bundle p4, String p5)
    {
        android.app.Notification[] v2;
        android.app.Notification[] v0_0 = p4.getParcelableArray(p5);
        if ((!(v0_0 instanceof android.app.Notification[])) && (v0_0 != null)) {
            v2 = new android.app.Notification[v0_0.length];
            int v1 = 0;
            while (v1 < v0_0.length) {
                v2[v1] = ((android.app.Notification) v0_0[v1]);
                v1++;
            }
            p4.putParcelableArray(p5, v2);
        } else {
            v2 = ((android.app.Notification[]) ((android.app.Notification[]) v0_0));
        }
        return v2;
    }

    public static String getSortKey(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.getSortKey(p1);
    }

    public static boolean isGroupSummary(android.app.Notification p1)
    {
        return android.support.v4.app.NotificationCompat.IMPL.isGroupSummary(p1);
    }
}
