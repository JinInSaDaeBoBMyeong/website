package android.support.v4.view;
interface KeyEventCompat$KeyEventVersionImpl {

    public abstract boolean dispatch();

    public abstract Object getKeyDispatcherState();

    public abstract boolean isTracking();

    public abstract boolean metaStateHasModifiers();

    public abstract boolean metaStateHasNoModifiers();

    public abstract int normalizeMetaState();

    public abstract void startTracking();
}
