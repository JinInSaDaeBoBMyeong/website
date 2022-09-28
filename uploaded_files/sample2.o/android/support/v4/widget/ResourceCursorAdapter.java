package android.support.v4.widget;
public abstract class ResourceCursorAdapter extends android.support.v4.widget.CursorAdapter {
    private int mDropDownLayout;
    private android.view.LayoutInflater mInflater;
    private int mLayout;

    public ResourceCursorAdapter(android.content.Context p2, int p3, android.database.Cursor p4)
    {
        super(p2, p4);
        super.mDropDownLayout = p3;
        super.mLayout = p3;
        super.mInflater = ((android.view.LayoutInflater) p2.getSystemService("layout_inflater"));
        return;
    }

    public ResourceCursorAdapter(android.content.Context p2, int p3, android.database.Cursor p4, int p5)
    {
        super(p2, p4, p5);
        super.mDropDownLayout = p3;
        super.mLayout = p3;
        super.mInflater = ((android.view.LayoutInflater) p2.getSystemService("layout_inflater"));
        return;
    }

    public ResourceCursorAdapter(android.content.Context p2, int p3, android.database.Cursor p4, boolean p5)
    {
        super(p2, p4, p5);
        super.mDropDownLayout = p3;
        super.mLayout = p3;
        super.mInflater = ((android.view.LayoutInflater) p2.getSystemService("layout_inflater"));
        return;
    }

    public android.view.View newDropDownView(android.content.Context p4, android.database.Cursor p5, android.view.ViewGroup p6)
    {
        return this.mInflater.inflate(this.mDropDownLayout, p6, 0);
    }

    public android.view.View newView(android.content.Context p4, android.database.Cursor p5, android.view.ViewGroup p6)
    {
        return this.mInflater.inflate(this.mLayout, p6, 0);
    }

    public void setDropDownViewResource(int p1)
    {
        this.mDropDownLayout = p1;
        return;
    }

    public void setViewResource(int p1)
    {
        this.mLayout = p1;
        return;
    }
}
