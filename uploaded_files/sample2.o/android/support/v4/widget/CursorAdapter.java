package android.support.v4.widget;
public abstract class CursorAdapter extends android.widget.BaseAdapter implements android.widget.Filterable, android.support.v4.widget.CursorFilter$CursorFilterClient {
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected android.support.v4.widget.CursorAdapter$ChangeObserver mChangeObserver;
    protected android.content.Context mContext;
    protected android.database.Cursor mCursor;
    protected android.support.v4.widget.CursorFilter mCursorFilter;
    protected android.database.DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected android.widget.FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    public CursorAdapter(android.content.Context p2, android.database.Cursor p3)
    {
        this.init(p2, p3, 1);
        return;
    }

    public CursorAdapter(android.content.Context p1, android.database.Cursor p2, int p3)
    {
        this.init(p1, p2, p3);
        return;
    }

    public CursorAdapter(android.content.Context p2, android.database.Cursor p3, boolean p4)
    {
        int v0;
        if (!p4) {
            v0 = 2;
        } else {
            v0 = 1;
        }
        this.init(p2, p3, v0);
        return;
    }

    public abstract void bindView();

    public void changeCursor(android.database.Cursor p2)
    {
        android.database.Cursor v0 = this.swapCursor(p2);
        if (v0 != null) {
            v0.close();
        }
        return;
    }

    public CharSequence convertToString(android.database.Cursor p2)
    {
        String v0;
        if (p2 != null) {
            v0 = p2.toString();
        } else {
            v0 = "";
        }
        return v0;
    }

    public int getCount()
    {
        if ((!this.mDataValid) || (this.mCursor == null)) {
            int v0_2 = 0;
        } else {
            v0_2 = this.mCursor.getCount();
        }
        return v0_2;
    }

    public android.database.Cursor getCursor()
    {
        return this.mCursor;
    }

    public android.view.View getDropDownView(int p4, android.view.View p5, android.view.ViewGroup p6)
    {
        android.view.View v0;
        if (!this.mDataValid) {
            v0 = 0;
        } else {
            this.mCursor.moveToPosition(p4);
            if (p5 != null) {
                v0 = p5;
            } else {
                v0 = this.newDropDownView(this.mContext, this.mCursor, p6);
            }
            this.bindView(v0, this.mContext, this.mCursor);
        }
        return v0;
    }

    public android.widget.Filter getFilter()
    {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new android.support.v4.widget.CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public android.widget.FilterQueryProvider getFilterQueryProvider()
    {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int p2)
    {
        if ((!this.mDataValid) || (this.mCursor == null)) {
            android.database.Cursor v0_2 = 0;
        } else {
            this.mCursor.moveToPosition(p2);
            v0_2 = this.mCursor;
        }
        return v0_2;
    }

    public long getItemId(int p4)
    {
        long v0_0 = 0;
        if ((this.mDataValid) && ((this.mCursor != null) && (this.mCursor.moveToPosition(p4)))) {
            v0_0 = this.mCursor.getLong(this.mRowIDColumn);
        }
        return v0_0;
    }

    public android.view.View getView(int p5, android.view.View p6, android.view.ViewGroup p7)
    {
        if (this.mDataValid) {
            if (this.mCursor.moveToPosition(p5)) {
                android.view.View v0;
                if (p6 != null) {
                    v0 = p6;
                } else {
                    v0 = this.newView(this.mContext, this.mCursor, p7);
                }
                this.bindView(v0, this.mContext, this.mCursor);
                return v0;
            } else {
                throw new IllegalStateException(new StringBuilder().append("couldn\'t move cursor to position ").append(p5).toString());
            }
        } else {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
    }

    public boolean hasStableIds()
    {
        return 1;
    }

    void init(android.content.Context p5, android.database.Cursor p6, int p7)
    {
        int v0 = 1;
        if ((p7 & 1) != 1) {
            this.mAutoRequery = 0;
        } else {
            p7 |= 2;
            this.mAutoRequery = 1;
        }
        if (p6 == null) {
            v0 = 0;
        }
        android.database.DataSetObserver v1_1;
        this.mCursor = p6;
        this.mDataValid = v0;
        this.mContext = p5;
        if (v0 == 0) {
            v1_1 = -1;
        } else {
            v1_1 = p6.getColumnIndexOrThrow("_id");
        }
        this.mRowIDColumn = v1_1;
        if ((p7 & 2) != 2) {
            this.mChangeObserver = 0;
            this.mDataSetObserver = 0;
        } else {
            this.mChangeObserver = new android.support.v4.widget.CursorAdapter$ChangeObserver(this);
            this.mDataSetObserver = new android.support.v4.widget.CursorAdapter$MyDataSetObserver(this, 0);
        }
        if (v0 != 0) {
            if (this.mChangeObserver != null) {
                p6.registerContentObserver(this.mChangeObserver);
            }
            if (this.mDataSetObserver != null) {
                p6.registerDataSetObserver(this.mDataSetObserver);
            }
        }
        return;
    }

    protected void init(android.content.Context p2, android.database.Cursor p3, boolean p4)
    {
        int v0;
        if (!p4) {
            v0 = 2;
        } else {
            v0 = 1;
        }
        this.init(p2, p3, v0);
        return;
    }

    public android.view.View newDropDownView(android.content.Context p2, android.database.Cursor p3, android.view.ViewGroup p4)
    {
        return this.newView(p2, p3, p4);
    }

    public abstract android.view.View newView();

    protected void onContentChanged()
    {
        if ((this.mAutoRequery) && ((this.mCursor != null) && (!this.mCursor.isClosed()))) {
            this.mDataValid = this.mCursor.requery();
        }
        return;
    }

    public android.database.Cursor runQueryOnBackgroundThread(CharSequence p2)
    {
        android.database.Cursor v0_1;
        if (this.mFilterQueryProvider == null) {
            v0_1 = this.mCursor;
        } else {
            v0_1 = this.mFilterQueryProvider.runQuery(p2);
        }
        return v0_1;
    }

    public void setFilterQueryProvider(android.widget.FilterQueryProvider p1)
    {
        this.mFilterQueryProvider = p1;
        return;
    }

    public android.database.Cursor swapCursor(android.database.Cursor p3)
    {
        android.database.Cursor v0;
        if (p3 != this.mCursor) {
            v0 = this.mCursor;
            if (v0 != null) {
                if (this.mChangeObserver != null) {
                    v0.unregisterContentObserver(this.mChangeObserver);
                }
                if (this.mDataSetObserver != null) {
                    v0.unregisterDataSetObserver(this.mDataSetObserver);
                }
            }
            this.mCursor = p3;
            if (p3 == null) {
                this.mRowIDColumn = -1;
                this.mDataValid = 0;
                this.notifyDataSetInvalidated();
            } else {
                if (this.mChangeObserver != null) {
                    p3.registerContentObserver(this.mChangeObserver);
                }
                if (this.mDataSetObserver != null) {
                    p3.registerDataSetObserver(this.mDataSetObserver);
                }
                this.mRowIDColumn = p3.getColumnIndexOrThrow("_id");
                this.mDataValid = 1;
                this.notifyDataSetChanged();
            }
        } else {
            v0 = 0;
        }
        return v0;
    }
}
