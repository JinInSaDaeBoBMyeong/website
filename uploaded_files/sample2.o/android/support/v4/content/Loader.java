package android.support.v4.content;
public class Loader {
    boolean mAbandoned;
    boolean mContentChanged;
    android.content.Context mContext;
    int mId;
    android.support.v4.content.Loader$OnLoadCompleteListener mListener;
    boolean mProcessingChange;
    boolean mReset;
    boolean mStarted;

    public Loader(android.content.Context p3)
    {
        this.mStarted = 0;
        this.mAbandoned = 0;
        this.mReset = 1;
        this.mContentChanged = 0;
        this.mProcessingChange = 0;
        this.mContext = p3.getApplicationContext();
        return;
    }

    public void abandon()
    {
        this.mAbandoned = 1;
        this.onAbandon();
        return;
    }

    public void commitContentChanged()
    {
        this.mProcessingChange = 0;
        return;
    }

    public String dataToString(Object p3)
    {
        StringBuilder v0_1 = new StringBuilder(64);
        android.support.v4.util.DebugUtils.buildShortClassTag(p3, v0_1);
        v0_1.append("}");
        return v0_1.toString();
    }

    public void deliverResult(Object p2)
    {
        if (this.mListener != null) {
            this.mListener.onLoadComplete(this, p2);
        }
        return;
    }

    public void dump(String p2, java.io.FileDescriptor p3, java.io.PrintWriter p4, String[] p5)
    {
        p4.print(p2);
        p4.print("mId=");
        p4.print(this.mId);
        p4.print(" mListener=");
        p4.println(this.mListener);
        if ((this.mStarted) || ((this.mContentChanged) || (this.mProcessingChange))) {
            p4.print(p2);
            p4.print("mStarted=");
            p4.print(this.mStarted);
            p4.print(" mContentChanged=");
            p4.print(this.mContentChanged);
            p4.print(" mProcessingChange=");
            p4.println(this.mProcessingChange);
        }
        if ((this.mAbandoned) || (this.mReset)) {
            p4.print(p2);
            p4.print("mAbandoned=");
            p4.print(this.mAbandoned);
            p4.print(" mReset=");
            p4.println(this.mReset);
        }
        return;
    }

    public void forceLoad()
    {
        this.onForceLoad();
        return;
    }

    public android.content.Context getContext()
    {
        return this.mContext;
    }

    public int getId()
    {
        return this.mId;
    }

    public boolean isAbandoned()
    {
        return this.mAbandoned;
    }

    public boolean isReset()
    {
        return this.mReset;
    }

    public boolean isStarted()
    {
        return this.mStarted;
    }

    protected void onAbandon()
    {
        return;
    }

    public void onContentChanged()
    {
        if (!this.mStarted) {
            this.mContentChanged = 1;
        } else {
            this.forceLoad();
        }
        return;
    }

    protected void onForceLoad()
    {
        return;
    }

    protected void onReset()
    {
        return;
    }

    protected void onStartLoading()
    {
        return;
    }

    protected void onStopLoading()
    {
        return;
    }

    public void registerListener(int p3, android.support.v4.content.Loader$OnLoadCompleteListener p4)
    {
        if (this.mListener == null) {
            this.mListener = p4;
            this.mId = p3;
            return;
        } else {
            throw new IllegalStateException("There is already a listener registered");
        }
    }

    public void reset()
    {
        this.onReset();
        this.mReset = 1;
        this.mStarted = 0;
        this.mAbandoned = 0;
        this.mContentChanged = 0;
        this.mProcessingChange = 0;
        return;
    }

    public void rollbackContentChanged()
    {
        if (this.mProcessingChange) {
            this.mContentChanged = 1;
        }
        return;
    }

    public final void startLoading()
    {
        this.mStarted = 1;
        this.mReset = 0;
        this.mAbandoned = 0;
        this.onStartLoading();
        return;
    }

    public void stopLoading()
    {
        this.mStarted = 0;
        this.onStopLoading();
        return;
    }

    public boolean takeContentChanged()
    {
        boolean v0 = this.mContentChanged;
        this.mContentChanged = 0;
        this.mProcessingChange = (this.mProcessingChange | v0);
        return v0;
    }

    public String toString()
    {
        StringBuilder v0_1 = new StringBuilder(64);
        android.support.v4.util.DebugUtils.buildShortClassTag(this, v0_1);
        v0_1.append(" id=");
        v0_1.append(this.mId);
        v0_1.append("}");
        return v0_1.toString();
    }

    public void unregisterListener(android.support.v4.content.Loader$OnLoadCompleteListener p3)
    {
        if (this.mListener != null) {
            if (this.mListener == p3) {
                this.mListener = 0;
                return;
            } else {
                throw new IllegalArgumentException("Attempting to unregister the wrong listener");
            }
        } else {
            throw new IllegalStateException("No listener register");
        }
    }
}
