package android.support.v4.widget;
public class SlidingPaneLayout$LayoutParams extends android.view.ViewGroup$MarginLayoutParams {
    private static final int[] ATTRS;
    android.graphics.Paint dimPaint;
    boolean dimWhenOffset;
    boolean slideable;
    public float weight;

    static SlidingPaneLayout$LayoutParams()
    {
        int[] v0_1 = new int[1];
        v0_1[0] = 16843137;
        android.support.v4.widget.SlidingPaneLayout$LayoutParams.ATTRS = v0_1;
        return;
    }

    public SlidingPaneLayout$LayoutParams()
    {
        super(-1, -1);
        super.weight = 0;
        return;
    }

    public SlidingPaneLayout$LayoutParams(int p2, int p3)
    {
        super(p2, p3);
        super.weight = 0;
        return;
    }

    public SlidingPaneLayout$LayoutParams(android.content.Context p4, android.util.AttributeSet p5)
    {
        super(p4, p5);
        super.weight = 0;
        android.content.res.TypedArray v0 = p4.obtainStyledAttributes(p5, android.support.v4.widget.SlidingPaneLayout$LayoutParams.ATTRS);
        super.weight = v0.getFloat(0, 0);
        v0.recycle();
        return;
    }

    public SlidingPaneLayout$LayoutParams(android.support.v4.widget.SlidingPaneLayout$LayoutParams p2)
    {
        super(p2);
        super.weight = 0;
        super.weight = p2.weight;
        return;
    }

    public SlidingPaneLayout$LayoutParams(android.view.ViewGroup$LayoutParams p2)
    {
        super(p2);
        super.weight = 0;
        return;
    }

    public SlidingPaneLayout$LayoutParams(android.view.ViewGroup$MarginLayoutParams p2)
    {
        super(p2);
        super.weight = 0;
        return;
    }
}
