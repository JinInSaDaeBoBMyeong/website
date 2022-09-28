package android.support.v4.app;
public class TaskStackBuilder implements java.lang.Iterable {
    private static final android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl IMPL = None;
    private static final String TAG = "TaskStackBuilder";
    private final java.util.ArrayList mIntents;
    private final android.content.Context mSourceContext;

    static TaskStackBuilder()
    {
        if (android.os.Build$VERSION.SDK_INT < 11) {
            android.support.v4.app.TaskStackBuilder.IMPL = new android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplBase();
        } else {
            android.support.v4.app.TaskStackBuilder.IMPL = new android.support.v4.app.TaskStackBuilder$TaskStackBuilderImplHoneycomb();
        }
        return;
    }

    private TaskStackBuilder(android.content.Context p2)
    {
        this.mIntents = new java.util.ArrayList();
        this.mSourceContext = p2;
        return;
    }

    public static android.support.v4.app.TaskStackBuilder create(android.content.Context p1)
    {
        return new android.support.v4.app.TaskStackBuilder(p1);
    }

    public static android.support.v4.app.TaskStackBuilder from(android.content.Context p1)
    {
        return android.support.v4.app.TaskStackBuilder.create(p1);
    }

    public android.support.v4.app.TaskStackBuilder addNextIntent(android.content.Intent p2)
    {
        this.mIntents.add(p2);
        return this;
    }

    public android.support.v4.app.TaskStackBuilder addNextIntentWithParentStack(android.content.Intent p3)
    {
        android.content.ComponentName v0 = p3.getComponent();
        if (v0 == null) {
            v0 = p3.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (v0 != null) {
            this.addParentStack(v0);
        }
        this.addNextIntent(p3);
        return this;
    }

    public android.support.v4.app.TaskStackBuilder addParentStack(android.app.Activity p4)
    {
        android.content.Intent v0 = 0;
        if ((p4 instanceof android.support.v4.app.TaskStackBuilder$SupportParentable)) {
            v0 = ((android.support.v4.app.TaskStackBuilder$SupportParentable) p4).getSupportParentActivityIntent();
        }
        if (v0 == null) {
            v0 = android.support.v4.app.NavUtils.getParentActivityIntent(p4);
        }
        if (v0 != null) {
            android.content.ComponentName v1 = v0.getComponent();
            if (v1 == null) {
                v1 = v0.resolveActivity(this.mSourceContext.getPackageManager());
            }
            this.addParentStack(v1);
            this.addNextIntent(v0);
        }
        return this;
    }

    public android.support.v4.app.TaskStackBuilder addParentStack(android.content.ComponentName p6)
    {
        int v1 = this.mIntents.size();
        try {
            android.content.Intent v2 = android.support.v4.app.NavUtils.getParentActivityIntent(this.mSourceContext, p6);
        } catch (android.content.pm.PackageManager$NameNotFoundException v0) {
            android.util.Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(v0);
        }
        while (v2 != null) {
            this.mIntents.add(v1, v2);
            v2 = android.support.v4.app.NavUtils.getParentActivityIntent(this.mSourceContext, v2.getComponent());
        }
        return this;
    }

    public android.support.v4.app.TaskStackBuilder addParentStack(Class p3)
    {
        return this.addParentStack(new android.content.ComponentName(this.mSourceContext, p3));
    }

    public android.content.Intent editIntentAt(int p2)
    {
        return ((android.content.Intent) this.mIntents.get(p2));
    }

    public android.content.Intent getIntent(int p2)
    {
        return this.editIntentAt(p2);
    }

    public int getIntentCount()
    {
        return this.mIntents.size();
    }

    public android.content.Intent[] getIntents()
    {
        android.content.Intent[] v1 = new android.content.Intent[this.mIntents.size()];
        if (v1.length != 0) {
            v1[0] = new android.content.Intent(((android.content.Intent) this.mIntents.get(0))).addFlags(268484608);
            int v0 = 1;
            while (v0 < v1.length) {
                v1[v0] = new android.content.Intent(((android.content.Intent) this.mIntents.get(v0)));
                v0++;
            }
        }
        return v1;
    }

    public android.app.PendingIntent getPendingIntent(int p2, int p3)
    {
        return this.getPendingIntent(p2, p3, 0);
    }

    public android.app.PendingIntent getPendingIntent(int p7, int p8, android.os.Bundle p9)
    {
        if (!this.mIntents.isEmpty()) {
            android.content.Context v1_6 = new android.content.Intent[this.mIntents.size()];
            android.content.Intent[] v2_1 = ((android.content.Intent[]) this.mIntents.toArray(v1_6));
            v2_1[0] = new android.content.Intent(v2_1[0]).addFlags(268484608);
            return android.support.v4.app.TaskStackBuilder.IMPL.getPendingIntent(this.mSourceContext, v2_1, p7, p8, p9);
        } else {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
    }

    public java.util.Iterator iterator()
    {
        return this.mIntents.iterator();
    }

    public void startActivities()
    {
        this.startActivities(0);
        return;
    }

    public void startActivities(android.os.Bundle p6)
    {
        if (!this.mIntents.isEmpty()) {
            int v3_5 = new android.content.Intent[this.mIntents.size()];
            android.content.Intent[] v0_1 = ((android.content.Intent[]) this.mIntents.toArray(v3_5));
            v0_1[0] = new android.content.Intent(v0_1[0]).addFlags(268484608);
            if (!android.support.v4.content.ContextCompat.startActivities(this.mSourceContext, v0_1, p6)) {
                android.content.Intent v1_1 = new android.content.Intent(v0_1[(v0_1.length - 1)]);
                v1_1.addFlags(268435456);
                this.mSourceContext.startActivity(v1_1);
            }
            return;
        } else {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
    }
}
