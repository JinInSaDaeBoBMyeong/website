package android.support.v4.widget;
public class SimpleCursorAdapter extends android.support.v4.widget.ResourceCursorAdapter {
    private android.support.v4.widget.SimpleCursorAdapter$CursorToStringConverter mCursorToStringConverter;
    protected int[] mFrom;
    String[] mOriginalFrom;
    private int mStringConversionColumn;
    protected int[] mTo;
    private android.support.v4.widget.SimpleCursorAdapter$ViewBinder mViewBinder;

    public SimpleCursorAdapter(android.content.Context p2, int p3, android.database.Cursor p4, String[] p5, int[] p6)
    {
        super(p2, p3, p4);
        super.mStringConversionColumn = -1;
        super.mTo = p6;
        super.mOriginalFrom = p5;
        super.findColumns(p5);
        return;
    }

    public SimpleCursorAdapter(android.content.Context p2, int p3, android.database.Cursor p4, String[] p5, int[] p6, int p7)
    {
        super(p2, p3, p4, p7);
        super.mStringConversionColumn = -1;
        super.mTo = p6;
        super.mOriginalFrom = p5;
        super.findColumns(p5);
        return;
    }

    private void findColumns(String[] p6)
    {
        if (this.mCursor == null) {
            this.mFrom = 0;
        } else {
            int v0 = p6.length;
            if ((this.mFrom == null) || (this.mFrom.length != v0)) {
                int[] v2_1 = new int[v0];
                this.mFrom = v2_1;
            }
            int v1 = 0;
            while (v1 < v0) {
                this.mFrom[v1] = this.mCursor.getColumnIndexOrThrow(p6[v1]);
                v1++;
            }
        }
        return;
    }

    public void bindView(android.view.View p12, android.content.Context p13, android.database.Cursor p14)
    {
        android.support.v4.widget.SimpleCursorAdapter$ViewBinder v0 = this.mViewBinder;
        int v2 = this.mTo.length;
        int[] v3 = this.mFrom;
        int[] v6 = this.mTo;
        int v4 = 0;
        while (v4 < v2) {
            android.widget.ImageView v7_0 = p12.findViewById(v6[v4]);
            if (v7_0 != null) {
                boolean v1 = 0;
                if (v0 != null) {
                    v1 = v0.setViewValue(v7_0, p14, v3[v4]);
                }
                if (!v1) {
                    String v5 = p14.getString(v3[v4]);
                    if (v5 == null) {
                        v5 = "";
                    }
                    if (!(v7_0 instanceof android.widget.TextView)) {
                        if (!(v7_0 instanceof android.widget.ImageView)) {
                            throw new IllegalStateException(new StringBuilder().append(v7_0.getClass().getName()).append(" is not a ").append(" view that can be bounds by this SimpleCursorAdapter").toString());
                        } else {
                            this.setViewImage(((android.widget.ImageView) v7_0), v5);
                        }
                    } else {
                        this.setViewText(((android.widget.TextView) v7_0), v5);
                    }
                }
            }
            v4++;
        }
        return;
    }

    public void changeCursorAndColumns(android.database.Cursor p2, String[] p3, int[] p4)
    {
        this.mOriginalFrom = p3;
        this.mTo = p4;
        super.changeCursor(p2);
        this.findColumns(this.mOriginalFrom);
        return;
    }

    public CharSequence convertToString(android.database.Cursor p3)
    {
        CharSequence v0_2;
        if (this.mCursorToStringConverter == null) {
            if (this.mStringConversionColumn <= -1) {
                v0_2 = super.convertToString(p3);
            } else {
                v0_2 = p3.getString(this.mStringConversionColumn);
            }
        } else {
            v0_2 = this.mCursorToStringConverter.convertToString(p3);
        }
        return v0_2;
    }

    public android.support.v4.widget.SimpleCursorAdapter$CursorToStringConverter getCursorToStringConverter()
    {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn()
    {
        return this.mStringConversionColumn;
    }

    public android.support.v4.widget.SimpleCursorAdapter$ViewBinder getViewBinder()
    {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(android.support.v4.widget.SimpleCursorAdapter$CursorToStringConverter p1)
    {
        this.mCursorToStringConverter = p1;
        return;
    }

    public void setStringConversionColumn(int p1)
    {
        this.mStringConversionColumn = p1;
        return;
    }

    public void setViewBinder(android.support.v4.widget.SimpleCursorAdapter$ViewBinder p1)
    {
        this.mViewBinder = p1;
        return;
    }

    public void setViewImage(android.widget.ImageView p3, String p4)
    {
        try {
            p3.setImageResource(Integer.parseInt(p4));
        } catch (NumberFormatException v0) {
            p3.setImageURI(android.net.Uri.parse(p4));
        }
        return;
    }

    public void setViewText(android.widget.TextView p1, String p2)
    {
        p1.setText(p2);
        return;
    }

    public android.database.Cursor swapCursor(android.database.Cursor p3)
    {
        android.database.Cursor v0 = super.swapCursor(p3);
        this.findColumns(this.mOriginalFrom);
        return v0;
    }
}
