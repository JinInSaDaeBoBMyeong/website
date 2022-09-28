package android.support.v4.app;
public abstract class FragmentTransaction {
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = 255;

    public FragmentTransaction()
    {
        return;
    }

    public abstract android.support.v4.app.FragmentTransaction add();

    public abstract android.support.v4.app.FragmentTransaction add();

    public abstract android.support.v4.app.FragmentTransaction add();

    public abstract android.support.v4.app.FragmentTransaction addToBackStack();

    public abstract android.support.v4.app.FragmentTransaction attach();

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract android.support.v4.app.FragmentTransaction detach();

    public abstract android.support.v4.app.FragmentTransaction disallowAddToBackStack();

    public abstract android.support.v4.app.FragmentTransaction hide();

    public abstract boolean isAddToBackStackAllowed();

    public abstract boolean isEmpty();

    public abstract android.support.v4.app.FragmentTransaction remove();

    public abstract android.support.v4.app.FragmentTransaction replace();

    public abstract android.support.v4.app.FragmentTransaction replace();

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle();

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbShortTitle();

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbTitle();

    public abstract android.support.v4.app.FragmentTransaction setBreadCrumbTitle();

    public abstract android.support.v4.app.FragmentTransaction setCustomAnimations();

    public abstract android.support.v4.app.FragmentTransaction setCustomAnimations();

    public abstract android.support.v4.app.FragmentTransaction setTransition();

    public abstract android.support.v4.app.FragmentTransaction setTransitionStyle();

    public abstract android.support.v4.app.FragmentTransaction show();
}
