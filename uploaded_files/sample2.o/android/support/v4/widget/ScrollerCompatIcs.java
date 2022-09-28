package android.support.v4.widget;
 class ScrollerCompatIcs {

    ScrollerCompatIcs()
    {
        return;
    }

    public static float getCurrVelocity(Object p1)
    {
        return ((android.widget.OverScroller) p1).getCurrVelocity();
    }
}
