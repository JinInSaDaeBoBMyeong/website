package android.support.v4.widget;
public class ListViewAutoScrollHelper extends android.support.v4.widget.AutoScrollHelper {
    private final android.widget.ListView mTarget;

    public ListViewAutoScrollHelper(android.widget.ListView p1)
    {
        super(p1);
        super.mTarget = p1;
        return;
    }

    public boolean canTargetScrollHorizontally(int p2)
    {
        return 0;
    }

    public boolean canTargetScrollVertically(int p11)
    {
        int v7 = 0;
        android.widget.ListView v6 = this.mTarget;
        int v3 = v6.getCount();
        if (v3 != 0) {
            int v0 = v6.getChildCount();
            int v1 = v6.getFirstVisiblePosition();
            if (p11 <= 0) {
                if ((p11 >= 0) || ((v1 <= 0) && (v6.getChildAt(0).getTop() >= 0))) {
                    return v7;
                }
            } else {
                if (((v1 + v0) >= v3) && (v6.getChildAt((v0 - 1)).getBottom() <= v6.getHeight())) {
                    return v7;
                }
            }
            v7 = 1;
        }
        return v7;
    }

    public void scrollTargetBy(int p6, int p7)
    {
        android.widget.ListView v3 = this.mTarget;
        int v0 = v3.getFirstVisiblePosition();
        if (v0 != -1) {
            android.view.View v1 = v3.getChildAt(0);
            if (v1 != null) {
                v3.setSelectionFromTop(v0, (v1.getTop() - p7));
            }
        }
        return;
    }
}
