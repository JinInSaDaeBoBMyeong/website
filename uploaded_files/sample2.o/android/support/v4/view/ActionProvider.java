package android.support.v4.view;
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final android.content.Context mContext;
    private android.support.v4.view.ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
    private android.support.v4.view.ActionProvider$VisibilityListener mVisibilityListener;

    public ActionProvider(android.content.Context p1)
    {
        this.mContext = p1;
        return;
    }

    public android.content.Context getContext()
    {
        return this.mContext;
    }

    public boolean hasSubMenu()
    {
        return 0;
    }

    public boolean isVisible()
    {
        return 1;
    }

    public abstract android.view.View onCreateActionView();

    public android.view.View onCreateActionView(android.view.MenuItem p2)
    {
        return this.onCreateActionView();
    }

    public boolean onPerformDefaultAction()
    {
        return 0;
    }

    public void onPrepareSubMenu(android.view.SubMenu p1)
    {
        return;
    }

    public boolean overridesItemVisibility()
    {
        return 0;
    }

    public void refreshVisibility()
    {
        if ((this.mVisibilityListener != null) && (this.overridesItemVisibility())) {
            this.mVisibilityListener.onActionProviderVisibilityChanged(this.isVisible());
        }
        return;
    }

    public void setSubUiVisibilityListener(android.support.v4.view.ActionProvider$SubUiVisibilityListener p1)
    {
        this.mSubUiVisibilityListener = p1;
        return;
    }

    public void setVisibilityListener(android.support.v4.view.ActionProvider$VisibilityListener p4)
    {
        if ((this.mVisibilityListener != null) && (p4 != null)) {
            android.util.Log.w("ActionProvider(support)", new StringBuilder().append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(this.getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        }
        this.mVisibilityListener = p4;
        return;
    }

    public void subUiVisibilityChanged(boolean p2)
    {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(p2);
        }
        return;
    }
}
