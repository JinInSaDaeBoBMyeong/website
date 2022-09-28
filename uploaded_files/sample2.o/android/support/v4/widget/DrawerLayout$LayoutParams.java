package android.support.v4.widget;
public class DrawerLayout$LayoutParams extends android.view.ViewGroup$MarginLayoutParams {
    public int gravity;
    boolean isPeeking;
    boolean knownOpen;
    float onScreen;

    public DrawerLayout$LayoutParams(int p2, int p3)
    {
        super(p2, p3);
        super.gravity = 0;
        return;
    }

    public DrawerLayout$LayoutParams(int p1, int p2, int p3)
    {
        this(p1, p2);
        this.gravity = p3;
        return;
    }

    public DrawerLayout$LayoutParams(android.content.Context p4, android.util.AttributeSet p5)
    {
        super(p4, p5);
        super.gravity = 0;
        android.content.res.TypedArray v0 = p4.obtainStyledAttributes(p5, android.support.v4.widget.DrawerLayout.access$100());
        super.gravity = v0.getInt(0, 0);
        v0.recycle();
        return;
    }

    public DrawerLayout$LayoutParams(android.support.v4.widget.DrawerLayout$LayoutParams p2)
    {
        super(p2);
        super.gravity = 0;
        super.gravity = p2.gravity;
        return;
    }

    public DrawerLayout$LayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        super(p2);
        super.gravity = 0;
        return;
    }

    public DrawerLayout$LayoutParams(android.view.ViewGroup$MarginLayoutParams p2)
    {
        super(p2);
        super.gravity = 0;
        return;
    }
}
