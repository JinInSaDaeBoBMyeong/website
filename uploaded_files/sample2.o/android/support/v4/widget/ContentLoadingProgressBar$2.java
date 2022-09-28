package android.support.v4.widget;
 class ContentLoadingProgressBar$2 implements java.lang.Runnable {
    final synthetic android.support.v4.widget.ContentLoadingProgressBar this$0;

    ContentLoadingProgressBar$2(android.support.v4.widget.ContentLoadingProgressBar p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        android.support.v4.widget.ContentLoadingProgressBar.access$202(this.this$0, 0);
        if (!android.support.v4.widget.ContentLoadingProgressBar.access$300(this.this$0)) {
            android.support.v4.widget.ContentLoadingProgressBar.access$102(this.this$0, System.currentTimeMillis());
            this.this$0.setVisibility(0);
        }
        return;
    }
}
