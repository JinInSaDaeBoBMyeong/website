package android.support.v4.widget;
 class PopupMenuCompatKitKat {

    PopupMenuCompatKitKat()
    {
        return;
    }

    public static android.view.View$OnTouchListener getDragToOpenListener(Object p1)
    {
        return ((android.widget.PopupMenu) p1).getDragToOpenListener();
    }
}
