package android.support.v4.internal.view;
public interface SupportMenuItem implements android.view.MenuItem {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    public abstract boolean collapseActionView();

    public abstract boolean expandActionView();

    public abstract android.view.View getActionView();

    public abstract android.support.v4.view.ActionProvider getSupportActionProvider();

    public abstract boolean isActionViewExpanded();

    public abstract android.view.MenuItem setActionView();

    public abstract android.view.MenuItem setActionView();

    public abstract void setShowAsAction();

    public abstract android.view.MenuItem setShowAsActionFlags();

    public abstract android.support.v4.internal.view.SupportMenuItem setSupportActionProvider();

    public abstract android.support.v4.internal.view.SupportMenuItem setSupportOnActionExpandListener();
}
