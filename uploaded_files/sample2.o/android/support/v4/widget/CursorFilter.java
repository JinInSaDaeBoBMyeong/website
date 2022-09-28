package android.support.v4.widget;
 class CursorFilter extends android.widget.Filter {
    android.support.v4.widget.CursorFilter$CursorFilterClient mClient;

    CursorFilter(android.support.v4.widget.CursorFilter$CursorFilterClient p1)
    {
        this.mClient = p1;
        return;
    }

    public CharSequence convertResultToString(Object p2)
    {
        return this.mClient.convertToString(((android.database.Cursor) p2));
    }

    protected android.widget.Filter$FilterResults performFiltering(CharSequence p4)
    {
        android.database.Cursor v0 = this.mClient.runQueryOnBackgroundThread(p4);
        android.widget.Filter$FilterResults v1_1 = new android.widget.Filter$FilterResults();
        if (v0 == null) {
            v1_1.count = 0;
            v1_1.values = 0;
        } else {
            v1_1.count = v0.getCount();
            v1_1.values = v0;
        }
        return v1_1;
    }

    protected void publishResults(CharSequence p4, android.widget.Filter$FilterResults p5)
    {
        android.database.Cursor vtmp1 = this.mClient.getCursor();
        if ((p5.values != null) && (p5.values != vtmp1)) {
            this.mClient.changeCursor(((android.database.Cursor) p5.values));
        }
        return;
    }
}
