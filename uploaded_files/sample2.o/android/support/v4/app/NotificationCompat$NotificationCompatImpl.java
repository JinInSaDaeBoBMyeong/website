package android.support.v4.app;
interface NotificationCompat$NotificationCompatImpl {

    public abstract android.app.Notification build();

    public abstract android.support.v4.app.NotificationCompat$Action getAction();

    public abstract int getActionCount();

    public abstract android.support.v4.app.NotificationCompat$Action[] getActionsFromParcelableArrayList();

    public abstract android.os.Bundle getExtras();

    public abstract String getGroup();

    public abstract boolean getLocalOnly();

    public abstract java.util.ArrayList getParcelableArrayListForActions();

    public abstract String getSortKey();

    public abstract boolean isGroupSummary();
}
