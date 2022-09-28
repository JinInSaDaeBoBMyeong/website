package android.support.v4.view;
 class ViewPropertyAnimatorCompatJB {

    ViewPropertyAnimatorCompatJB()
    {
        return;
    }

    public static void withEndAction(android.view.View p1, Runnable p2)
    {
        p1.animate().withEndAction(p2);
        return;
    }

    public static void withLayer(android.view.View p1)
    {
        p1.animate().withLayer();
        return;
    }

    public static void withStartAction(android.view.View p1, Runnable p2)
    {
        p1.animate().withStartAction(p2);
        return;
    }
}
