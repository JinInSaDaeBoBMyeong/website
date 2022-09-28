package android.support.v4.view;
 class ViewPager$3 implements java.lang.Runnable {
    final synthetic android.support.v4.view.ViewPager this$0;

    ViewPager$3(android.support.v4.view.ViewPager p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        android.support.v4.view.ViewPager.access$000(this.this$0, 0);
        this.this$0.populate();
        return;
    }
}
