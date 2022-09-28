package android.support.v4.app;
public abstract class LoaderManager {

    public LoaderManager()
    {
        return;
    }

    public static void enableDebugLogging(boolean p0)
    {
        android.support.v4.app.LoaderManagerImpl.DEBUG = p0;
        return;
    }

    public abstract void destroyLoader();

    public abstract void dump();

    public abstract android.support.v4.content.Loader getLoader();

    public boolean hasRunningLoaders()
    {
        return 0;
    }

    public abstract android.support.v4.content.Loader initLoader();

    public abstract android.support.v4.content.Loader restartLoader();
}
