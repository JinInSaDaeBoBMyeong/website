package android.support.v4.widget;
public class ListPopupWindowCompat {
    static final android.support.v4.widget.ListPopupWindowCompat$ListPopupWindowImpl IMPL;

    static ListPopupWindowCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 19) {
            android.support.v4.widget.ListPopupWindowCompat.IMPL = new android.support.v4.widget.ListPopupWindowCompat$BaseListPopupWindowImpl();
        } else {
            android.support.v4.widget.ListPopupWindowCompat.IMPL = new android.support.v4.widget.ListPopupWindowCompat$KitKatListPopupWindowImpl();
        }
        return;
    }

    private ListPopupWindowCompat()
    {
        return;
    }

    public static android.view.View$OnTouchListener createDragToOpenListener(Object p1, android.view.View p2)
    {
        return android.support.v4.widget.ListPopupWindowCompat.IMPL.createDragToOpenListener(p1, p2);
    }
}
