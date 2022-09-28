package android.support.v4.view;
public class ViewPager$LayoutParams extends android.view.ViewGroup$LayoutParams {
    int childIndex;
    public int gravity;
    public boolean isDecor;
    boolean needsMeasure;
    int position;
    float widthFactor;

    public ViewPager$LayoutParams()
    {
        super(-1, -1);
        super.widthFactor = 0;
        return;
    }

    public ViewPager$LayoutParams(android.content.Context p4, android.util.AttributeSet p5)
    {
        super(p4, p5);
        super.widthFactor = 0;
        android.content.res.TypedArray v0 = p4.obtainStyledAttributes(p5, android.support.v4.view.ViewPager.access$400());
        super.gravity = v0.getInteger(0, 48);
        v0.recycle();
        return;
    }
}
