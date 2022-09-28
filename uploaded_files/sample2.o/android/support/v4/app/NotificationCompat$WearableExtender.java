package android.support.v4.app;
public final class NotificationCompat$WearableExtender implements android.support.v4.app.NotificationCompat$Extender {
    private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    private static final int DEFAULT_FLAGS = 1;
    private static final int DEFAULT_GRAVITY = 80;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_HIDE_ICON = 2;
    private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    private static final int FLAG_START_SCROLL_BOTTOM = 8;
    private static final String KEY_ACTIONS = "actions";
    private static final String KEY_BACKGROUND = "background";
    private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    private static final String KEY_CONTENT_ICON = "contentIcon";
    private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    private static final String KEY_DISPLAY_INTENT = "displayIntent";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_GRAVITY = "gravity";
    private static final String KEY_PAGES = "pages";
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = 255;
    private java.util.ArrayList mActions;
    private android.graphics.Bitmap mBackground;
    private int mContentActionIndex;
    private int mContentIcon;
    private int mContentIconGravity;
    private int mCustomContentHeight;
    private int mCustomSizePreset;
    private android.app.PendingIntent mDisplayIntent;
    private int mFlags;
    private int mGravity;
    private java.util.ArrayList mPages;

    public NotificationCompat$WearableExtender()
    {
        this.mActions = new java.util.ArrayList();
        this.mFlags = 1;
        this.mPages = new java.util.ArrayList();
        this.mContentIconGravity = 8388613;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
        return;
    }

    public NotificationCompat$WearableExtender(android.app.Notification p12)
    {
        int v3;
        this.mActions = new java.util.ArrayList();
        this.mFlags = 1;
        this.mPages = new java.util.ArrayList();
        this.mContentIconGravity = 8388613;
        this.mContentActionIndex = -1;
        this.mCustomSizePreset = 0;
        this.mGravity = 80;
        android.os.Bundle v1 = android.support.v4.app.NotificationCompat.getExtras(p12);
        if (v1 == null) {
            v3 = 0;
        } else {
            v3 = v1.getBundle("android.wearable.EXTENSIONS");
        }
        if (v3 != 0) {
            android.support.v4.app.NotificationCompat$Action[] v0 = android.support.v4.app.NotificationCompat.access$200().getActionsFromParcelableArrayList(v3.getParcelableArrayList("actions"));
            if (v0 != null) {
                java.util.Collections.addAll(this.mActions, v0);
            }
            this.mFlags = v3.getInt("flags", 1);
            this.mDisplayIntent = ((android.app.PendingIntent) v3.getParcelable("displayIntent"));
            android.app.Notification[] v2 = android.support.v4.app.NotificationCompat.access$500(v3, "pages");
            if (v2 != null) {
                java.util.Collections.addAll(this.mPages, v2);
            }
            this.mBackground = ((android.graphics.Bitmap) v3.getParcelable("background"));
            this.mContentIcon = v3.getInt("contentIcon");
            this.mContentIconGravity = v3.getInt("contentIconGravity", 8388613);
            this.mContentActionIndex = v3.getInt("contentActionIndex", -1);
            this.mCustomSizePreset = v3.getInt("customSizePreset", 0);
            this.mCustomContentHeight = v3.getInt("customContentHeight");
            this.mGravity = v3.getInt("gravity", 80);
        }
        return;
    }

    private void setFlag(int p3, boolean p4)
    {
        if (!p4) {
            this.mFlags = (this.mFlags & (p3 ^ -1));
        } else {
            this.mFlags = (this.mFlags | p3);
        }
        return;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender addAction(android.support.v4.app.NotificationCompat$Action p2)
    {
        this.mActions.add(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender addActions(java.util.List p2)
    {
        this.mActions.addAll(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender addPage(android.app.Notification p2)
    {
        this.mPages.add(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender addPages(java.util.List p2)
    {
        this.mPages.addAll(p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender clearActions()
    {
        this.mActions.clear();
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender clearPages()
    {
        this.mPages.clear();
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender clone()
    {
        android.support.v4.app.NotificationCompat$WearableExtender v0_1 = new android.support.v4.app.NotificationCompat$WearableExtender();
        v0_1.mActions = new java.util.ArrayList(this.mActions);
        v0_1.mFlags = this.mFlags;
        v0_1.mDisplayIntent = this.mDisplayIntent;
        v0_1.mPages = new java.util.ArrayList(this.mPages);
        v0_1.mBackground = this.mBackground;
        v0_1.mContentIcon = this.mContentIcon;
        v0_1.mContentIconGravity = this.mContentIconGravity;
        v0_1.mContentActionIndex = this.mContentActionIndex;
        v0_1.mCustomSizePreset = this.mCustomSizePreset;
        v0_1.mCustomContentHeight = this.mCustomContentHeight;
        v0_1.mGravity = this.mGravity;
        return v0_1;
    }

    public bridge synthetic Object clone()
    {
        return this.clone();
    }

    public android.support.v4.app.NotificationCompat$Builder extend(android.support.v4.app.NotificationCompat$Builder p6)
    {
        android.os.Bundle v0_1 = new android.os.Bundle();
        if (!this.mActions.isEmpty()) {
            android.support.v4.app.NotificationCompat$Action[] v4_2 = new android.support.v4.app.NotificationCompat$Action[this.mActions.size()];
            v0_1.putParcelableArrayList("actions", android.support.v4.app.NotificationCompat.access$200().getParcelableArrayListForActions(((android.support.v4.app.NotificationCompat$Action[]) this.mActions.toArray(v4_2))));
        }
        if (this.mFlags != 1) {
            v0_1.putInt("flags", this.mFlags);
        }
        if (this.mDisplayIntent != null) {
            v0_1.putParcelable("displayIntent", this.mDisplayIntent);
        }
        if (!this.mPages.isEmpty()) {
            android.app.Notification[] v3_2 = new android.app.Notification[this.mPages.size()];
            v0_1.putParcelableArray("pages", ((android.os.Parcelable[]) this.mPages.toArray(v3_2)));
        }
        if (this.mBackground != null) {
            v0_1.putParcelable("background", this.mBackground);
        }
        if (this.mContentIcon != 0) {
            v0_1.putInt("contentIcon", this.mContentIcon);
        }
        if (this.mContentIconGravity != 8388613) {
            v0_1.putInt("contentIconGravity", this.mContentIconGravity);
        }
        if (this.mContentActionIndex != -1) {
            v0_1.putInt("contentActionIndex", this.mContentActionIndex);
        }
        if (this.mCustomSizePreset != 0) {
            v0_1.putInt("customSizePreset", this.mCustomSizePreset);
        }
        if (this.mCustomContentHeight != 0) {
            v0_1.putInt("customContentHeight", this.mCustomContentHeight);
        }
        if (this.mGravity != 80) {
            v0_1.putInt("gravity", this.mGravity);
        }
        p6.getExtras().putBundle("android.wearable.EXTENSIONS", v0_1);
        return p6;
    }

    public java.util.List getActions()
    {
        return this.mActions;
    }

    public android.graphics.Bitmap getBackground()
    {
        return this.mBackground;
    }

    public int getContentAction()
    {
        return this.mContentActionIndex;
    }

    public int getContentIcon()
    {
        return this.mContentIcon;
    }

    public int getContentIconGravity()
    {
        return this.mContentIconGravity;
    }

    public boolean getContentIntentAvailableOffline()
    {
        int v0_2;
        if ((this.mFlags & 1) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public int getCustomContentHeight()
    {
        return this.mCustomContentHeight;
    }

    public int getCustomSizePreset()
    {
        return this.mCustomSizePreset;
    }

    public android.app.PendingIntent getDisplayIntent()
    {
        return this.mDisplayIntent;
    }

    public int getGravity()
    {
        return this.mGravity;
    }

    public boolean getHintHideIcon()
    {
        int v0_2;
        if ((this.mFlags & 2) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public boolean getHintShowBackgroundOnly()
    {
        int v0_2;
        if ((this.mFlags & 4) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public java.util.List getPages()
    {
        return this.mPages;
    }

    public boolean getStartScrollBottom()
    {
        int v0_2;
        if ((this.mFlags & 8) == 0) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        return v0_2;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setBackground(android.graphics.Bitmap p1)
    {
        this.mBackground = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setContentAction(int p1)
    {
        this.mContentActionIndex = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setContentIcon(int p1)
    {
        this.mContentIcon = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setContentIconGravity(int p1)
    {
        this.mContentIconGravity = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setContentIntentAvailableOffline(boolean p2)
    {
        this.setFlag(1, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setCustomContentHeight(int p1)
    {
        this.mCustomContentHeight = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setCustomSizePreset(int p1)
    {
        this.mCustomSizePreset = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setDisplayIntent(android.app.PendingIntent p1)
    {
        this.mDisplayIntent = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setGravity(int p1)
    {
        this.mGravity = p1;
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setHintHideIcon(boolean p2)
    {
        this.setFlag(2, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setHintShowBackgroundOnly(boolean p2)
    {
        this.setFlag(4, p2);
        return this;
    }

    public android.support.v4.app.NotificationCompat$WearableExtender setStartScrollBottom(boolean p2)
    {
        this.setFlag(8, p2);
        return this;
    }
}
