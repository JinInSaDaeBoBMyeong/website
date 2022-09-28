package android.support.v4.content;
public class CursorLoader extends android.support.v4.content.AsyncTaskLoader {
    android.database.Cursor mCursor;
    final android.support.v4.content.Loader$ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    android.net.Uri mUri;

    public CursorLoader(android.content.Context p2)
    {
        super(p2);
        super.mObserver = new android.support.v4.content.Loader$ForceLoadContentObserver(super);
        return;
    }

    public CursorLoader(android.content.Context p2, android.net.Uri p3, String[] p4, String p5, String[] p6, String p7)
    {
        super(p2);
        super.mObserver = new android.support.v4.content.Loader$ForceLoadContentObserver(super);
        super.mUri = p3;
        super.mProjection = p4;
        super.mSelection = p5;
        super.mSelectionArgs = p6;
        super.mSortOrder = p7;
        return;
    }

    public void deliverResult(android.database.Cursor p3)
    {
        if (!this.isReset()) {
            android.database.Cursor v0 = this.mCursor;
            this.mCursor = p3;
            if (this.isStarted()) {
                super.deliverResult(p3);
            }
            if ((v0 != null) && ((v0 != p3) && (!v0.isClosed()))) {
                v0.close();
            }
        } else {
            if (p3 != null) {
                p3.close();
            }
        }
        return;
    }

    public bridge synthetic void deliverResult(Object p1)
    {
        this.deliverResult(((android.database.Cursor) p1));
        return;
    }

    public void dump(String p2, java.io.FileDescriptor p3, java.io.PrintWriter p4, String[] p5)
    {
        super.dump(p2, p3, p4, p5);
        p4.print(p2);
        p4.print("mUri=");
        p4.println(this.mUri);
        p4.print(p2);
        p4.print("mProjection=");
        p4.println(java.util.Arrays.toString(this.mProjection));
        p4.print(p2);
        p4.print("mSelection=");
        p4.println(this.mSelection);
        p4.print(p2);
        p4.print("mSelectionArgs=");
        p4.println(java.util.Arrays.toString(this.mSelectionArgs));
        p4.print(p2);
        p4.print("mSortOrder=");
        p4.println(this.mSortOrder);
        p4.print(p2);
        p4.print("mCursor=");
        p4.println(this.mCursor);
        p4.print(p2);
        p4.print("mContentChanged=");
        p4.println(this.mContentChanged);
        return;
    }

    public String[] getProjection()
    {
        return this.mProjection;
    }

    public String getSelection()
    {
        return this.mSelection;
    }

    public String[] getSelectionArgs()
    {
        return this.mSelectionArgs;
    }

    public String getSortOrder()
    {
        return this.mSortOrder;
    }

    public android.net.Uri getUri()
    {
        return this.mUri;
    }

    public android.database.Cursor loadInBackground()
    {
        android.database.Cursor v6 = this.getContext().getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder);
        if (v6 != null) {
            v6.getCount();
            v6.registerContentObserver(this.mObserver);
        }
        return v6;
    }

    public bridge synthetic Object loadInBackground()
    {
        return this.loadInBackground();
    }

    public void onCanceled(android.database.Cursor p2)
    {
        if ((p2 != null) && (!p2.isClosed())) {
            p2.close();
        }
        return;
    }

    public bridge synthetic void onCanceled(Object p1)
    {
        this.onCanceled(((android.database.Cursor) p1));
        return;
    }

    protected void onReset()
    {
        super.onReset();
        this.onStopLoading();
        if ((this.mCursor != null) && (!this.mCursor.isClosed())) {
            this.mCursor.close();
        }
        this.mCursor = 0;
        return;
    }

    protected void onStartLoading()
    {
        if (this.mCursor != null) {
            this.deliverResult(this.mCursor);
        }
        if ((this.takeContentChanged()) || (this.mCursor == null)) {
            this.forceLoad();
        }
        return;
    }

    protected void onStopLoading()
    {
        this.cancelLoad();
        return;
    }

    public void setProjection(String[] p1)
    {
        this.mProjection = p1;
        return;
    }

    public void setSelection(String p1)
    {
        this.mSelection = p1;
        return;
    }

    public void setSelectionArgs(String[] p1)
    {
        this.mSelectionArgs = p1;
        return;
    }

    public void setSortOrder(String p1)
    {
        this.mSortOrder = p1;
        return;
    }

    public void setUri(android.net.Uri p1)
    {
        this.mUri = p1;
        return;
    }
}
