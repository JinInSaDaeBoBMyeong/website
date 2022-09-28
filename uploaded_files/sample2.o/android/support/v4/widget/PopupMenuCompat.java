package android.support.v4.widget;
public class PopupMenuCompat {
    static final android.support.v4.widget.PopupMenuCompat$PopupMenuImpl IMPL;

    static PopupMenuCompat()
    {
        if (android.os.Build$VERSION.SDK_INT < 19) {
            android.support.v4.widget.PopupMenuCompat.IMPL = new android.support.v4.widget.PopupMenuCompat$BasePopupMenuImpl();
        } else {
            android.support.v4.widget.PopupMenuCompat.IMPL = new android.support.v4.widget.PopupMenuCompat$KitKatPopupMenuImpl();
        }
        return;
    }

    private PopupMenuCompat()
    {
        return;
    }

    public static android.view.View$OnTouchListener getDragToOpenListener(Object p1)
    {
        return android.support.v4.widget.PopupMenuCompat.IMPL.getDragToOpenListener(p1);
    }
}
