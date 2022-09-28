package android.support.v4.app;
public abstract class FragmentManager {
    public static final int POP_BACK_STACK_INCLUSIVE = 1;

    public FragmentManager()
    {
        return;
    }

    public static void enableDebugLogging(boolean p0)
    {
        android.support.v4.app.FragmentManagerImpl.DEBUG = p0;
        return;
    }

    public abstract void addOnBackStackChangedListener();

    public abstract android.support.v4.app.FragmentTransaction beginTransaction();

    public abstract void dump();

    public abstract boolean executePendingTransactions();

    public abstract android.support.v4.app.Fragment findFragmentById();

    public abstract android.support.v4.app.Fragment findFragmentByTag();

    public abstract android.support.v4.app.FragmentManager$BackStackEntry getBackStackEntryAt();

    public abstract int getBackStackEntryCount();

    public abstract android.support.v4.app.Fragment getFragment();

    public abstract java.util.List getFragments();

    public abstract boolean isDestroyed();

    public android.support.v4.app.FragmentTransaction openTransaction()
    {
        return this.beginTransaction();
    }

    public abstract void popBackStack();

    public abstract void popBackStack();

    public abstract void popBackStack();

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate();

    public abstract void putFragment();

    public abstract void removeOnBackStackChangedListener();

    public abstract android.support.v4.app.Fragment$SavedState saveFragmentInstanceState();
}
