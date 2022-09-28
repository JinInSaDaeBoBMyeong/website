package android.support.v4.print;
 class PrintHelperKitkat$2$1 extends android.os.AsyncTask {
    final synthetic android.support.v4.print.PrintHelperKitkat$2 this$1;
    final synthetic android.os.CancellationSignal val$cancellationSignal;
    final synthetic android.print.PrintDocumentAdapter$LayoutResultCallback val$layoutResultCallback;
    final synthetic android.print.PrintAttributes val$newPrintAttributes;
    final synthetic android.print.PrintAttributes val$oldPrintAttributes;

    PrintHelperKitkat$2$1(android.support.v4.print.PrintHelperKitkat$2 p1, android.os.CancellationSignal p2, android.print.PrintAttributes p3, android.print.PrintAttributes p4, android.print.PrintDocumentAdapter$LayoutResultCallback p5)
    {
        this.this$1 = p1;
        this.val$cancellationSignal = p2;
        this.val$newPrintAttributes = p3;
        this.val$oldPrintAttributes = p4;
        this.val$layoutResultCallback = p5;
        return;
    }

    protected varargs android.graphics.Bitmap doInBackground(android.net.Uri[] p4)
    {
        try {
            int v0_2 = android.support.v4.print.PrintHelperKitkat.access$200(this.this$1.this$0, this.this$1.val$imageFile, 3500);
        } catch (int v0) {
            v0_2 = 0;
        }
        return v0_2;
    }

    protected bridge synthetic Object doInBackground(Object[] p2)
    {
        return this.doInBackground(((android.net.Uri[]) p2));
    }

    protected void onCancelled(android.graphics.Bitmap p2)
    {
        this.val$layoutResultCallback.onLayoutCancelled();
        return;
    }

    protected bridge synthetic void onCancelled(Object p1)
    {
        this.onCancelled(((android.graphics.Bitmap) p1));
        return;
    }

    protected void onPostExecute(android.graphics.Bitmap p5)
    {
        int v0 = 1;
        super.onPostExecute(p5);
        this.this$1.mBitmap = p5;
        if (p5 == null) {
            this.val$layoutResultCallback.onLayoutFailed(0);
        } else {
            android.print.PrintDocumentInfo v1 = new android.print.PrintDocumentInfo$Builder(this.this$1.val$jobName).setContentType(1).setPageCount(1).build();
            if (this.val$newPrintAttributes.equals(this.val$oldPrintAttributes)) {
                v0 = 0;
            }
            this.val$layoutResultCallback.onLayoutFinished(v1, v0);
        }
        return;
    }

    protected bridge synthetic void onPostExecute(Object p1)
    {
        this.onPostExecute(((android.graphics.Bitmap) p1));
        return;
    }

    protected void onPreExecute()
    {
        this.val$cancellationSignal.setOnCancelListener(new android.support.v4.print.PrintHelperKitkat$2$1$1(this));
        return;
    }
}
