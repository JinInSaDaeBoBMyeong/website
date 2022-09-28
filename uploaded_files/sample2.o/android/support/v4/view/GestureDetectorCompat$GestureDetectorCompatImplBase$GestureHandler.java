package android.support.v4.view;
 class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler extends android.os.Handler {
    final synthetic android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase this$0;

    GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p1)
    {
        this.this$0 = p1;
        return;
    }

    GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase p2, android.os.Handler p3)
    {
        this.this$0 = p2;
        super(p3.getLooper());
        return;
    }

    public void handleMessage(android.os.Message p4)
    {
        switch (p4.what) {
            case 1:
                android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$100(this.this$0).onShowPress(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$000(this.this$0));
                break;
            case 2:
                android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$200(this.this$0);
                break;
            case 3:
                if (android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$300(this.this$0) == null) {
                } else {
                    if (android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$400(this.this$0)) {
                        android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$502(this.this$0, 1);
                    } else {
                        android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$300(this.this$0).onSingleTapConfirmed(android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase.access$000(this.this$0));
                    }
                }
                break;
            default:
                throw new RuntimeException(new StringBuilder().append("Unknown message ").append(p4).toString());
        }
        return;
    }
}
