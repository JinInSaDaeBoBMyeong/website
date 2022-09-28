package android.support.v4.app;
public class ActionBarDrawerToggle implements android.support.v4.widget.DrawerLayout$DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImpl IMPL = None;
    private static final float TOGGLE_DRAWABLE_OFFSET = 1051372203;
    private final android.app.Activity mActivity;
    private final android.support.v4.app.ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private android.graphics.drawable.Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final android.support.v4.widget.DrawerLayout mDrawerLayout;
    private final int mOpenDrawerContentDescRes;
    private Object mSetIndicatorInfo;
    private android.support.v4.app.ActionBarDrawerToggle$SlideDrawable mSlider;
    private android.graphics.drawable.Drawable mThemeImage;

    static ActionBarDrawerToggle()
    {
        int v0 = android.os.Build$VERSION.SDK_INT;
        if (v0 < 18) {
            if (v0 < 11) {
                android.support.v4.app.ActionBarDrawerToggle.IMPL = new android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplBase(0);
            } else {
                android.support.v4.app.ActionBarDrawerToggle.IMPL = new android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplHC(0);
            }
        } else {
            android.support.v4.app.ActionBarDrawerToggle.IMPL = new android.support.v4.app.ActionBarDrawerToggle$ActionBarDrawerToggleImplJellybeanMR2(0);
        }
        return;
    }

    public ActionBarDrawerToggle(android.app.Activity p4, android.support.v4.widget.DrawerLayout p5, int p6, int p7, int p8)
    {
        this.mDrawerIndicatorEnabled = 1;
        this.mActivity = p4;
        if (!(p4 instanceof android.support.v4.app.ActionBarDrawerToggle$DelegateProvider)) {
            this.mActivityImpl = 0;
        } else {
            this.mActivityImpl = ((android.support.v4.app.ActionBarDrawerToggle$DelegateProvider) p4).getDrawerToggleDelegate();
        }
        this.mDrawerLayout = p5;
        this.mDrawerImageResource = p6;
        this.mOpenDrawerContentDescRes = p7;
        this.mCloseDrawerContentDescRes = p8;
        this.mThemeImage = this.getThemeUpIndicator();
        this.mDrawerImage = p4.getResources().getDrawable(p6);
        this.mSlider = new android.support.v4.app.ActionBarDrawerToggle$SlideDrawable(this, this.mDrawerImage, 0);
        this.mSlider.setOffset(1051372203);
        return;
    }

    static synthetic android.app.Activity access$400(android.support.v4.app.ActionBarDrawerToggle p1)
    {
        return p1.mActivity;
    }

    android.graphics.drawable.Drawable getThemeUpIndicator()
    {
        android.graphics.drawable.Drawable v0_2;
        if (this.mActivityImpl == null) {
            v0_2 = android.support.v4.app.ActionBarDrawerToggle.IMPL.getThemeUpIndicator(this.mActivity);
        } else {
            v0_2 = this.mActivityImpl.getThemeUpIndicator();
        }
        return v0_2;
    }

    public boolean isDrawerIndicatorEnabled()
    {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(android.content.res.Configuration p3)
    {
        this.mThemeImage = this.getThemeUpIndicator();
        this.mDrawerImage = this.mActivity.getResources().getDrawable(this.mDrawerImageResource);
        this.syncState();
        return;
    }

    public void onDrawerClosed(android.view.View p3)
    {
        this.mSlider.setPosition(0);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mOpenDrawerContentDescRes);
        }
        return;
    }

    public void onDrawerOpened(android.view.View p3)
    {
        this.mSlider.setPosition(1065353216);
        if (this.mDrawerIndicatorEnabled) {
            this.setActionBarDescription(this.mCloseDrawerContentDescRes);
        }
        return;
    }

    public void onDrawerSlide(android.view.View p5, float p6)
    {
        float v0_0;
        float v0_1 = this.mSlider.getPosition();
        if (p6 <= 1056964608) {
            v0_0 = Math.min(v0_1, (p6 * 1073741824));
        } else {
            v0_0 = Math.max(v0_1, (Math.max(0, (p6 - 1056964608)) * 1073741824));
        }
        this.mSlider.setPosition(v0_0);
        return;
    }

    public void onDrawerStateChanged(int p1)
    {
        return;
    }

    public boolean onOptionsItemSelected(android.view.MenuItem p4)
    {
        if ((p4 == null) || ((p4.getItemId() != 16908332) || (!this.mDrawerIndicatorEnabled))) {
            int v0_3 = 0;
        } else {
            if (!this.mDrawerLayout.isDrawerVisible(8388611)) {
                this.mDrawerLayout.openDrawer(8388611);
            } else {
                this.mDrawerLayout.closeDrawer(8388611);
            }
            v0_3 = 1;
        }
        return v0_3;
    }

    void setActionBarDescription(int p4)
    {
        if (this.mActivityImpl == null) {
            this.mSetIndicatorInfo = android.support.v4.app.ActionBarDrawerToggle.IMPL.setActionBarDescription(this.mSetIndicatorInfo, this.mActivity, p4);
        } else {
            this.mActivityImpl.setActionBarDescription(p4);
        }
        return;
    }

    void setActionBarUpIndicator(android.graphics.drawable.Drawable p4, int p5)
    {
        if (this.mActivityImpl == null) {
            this.mSetIndicatorInfo = android.support.v4.app.ActionBarDrawerToggle.IMPL.setActionBarUpIndicator(this.mSetIndicatorInfo, this.mActivity, p4, p5);
        } else {
            this.mActivityImpl.setActionBarUpIndicator(p4, p5);
        }
        return;
    }

    public void setDrawerIndicatorEnabled(boolean p4)
    {
        if (p4 != this.mDrawerIndicatorEnabled) {
            if (!p4) {
                this.setActionBarUpIndicator(this.mThemeImage, 0);
            } else {
                int v0_2;
                if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
                    v0_2 = this.mOpenDrawerContentDescRes;
                } else {
                    v0_2 = this.mCloseDrawerContentDescRes;
                }
                this.setActionBarUpIndicator(this.mSlider, v0_2);
            }
            this.mDrawerIndicatorEnabled = p4;
        }
        return;
    }

    public void syncState()
    {
        if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
            this.mSlider.setPosition(0);
        } else {
            this.mSlider.setPosition(1065353216);
        }
        if (this.mDrawerIndicatorEnabled) {
            int v0_4;
            if (!this.mDrawerLayout.isDrawerOpen(8388611)) {
                v0_4 = this.mOpenDrawerContentDescRes;
            } else {
                v0_4 = this.mCloseDrawerContentDescRes;
            }
            this.setActionBarUpIndicator(this.mSlider, v0_4);
        }
        return;
    }
}
