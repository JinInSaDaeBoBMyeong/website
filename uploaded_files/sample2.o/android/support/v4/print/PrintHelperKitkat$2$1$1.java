package android.support.v4.print;
 class PrintHelperKitkat$2$1$1 implements android.os.CancellationSignal$OnCancelListener {
    final synthetic android.support.v4.print.PrintHelperKitkat$2$1 this$2;

    PrintHelperKitkat$2$1$1(android.support.v4.print.PrintHelperKitkat$2$1 p1)
    {
        this.this$2 = p1;
        return;
    }

    public void onCancel()
    {
        android.support.v4.print.PrintHelperKitkat$2.access$100(this.this$2.this$1);
        this.this$2.cancel(0);
        return;
    }
}
