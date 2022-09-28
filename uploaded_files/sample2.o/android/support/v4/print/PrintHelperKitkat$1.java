package android.support.v4.print;
 class PrintHelperKitkat$1 extends android.print.PrintDocumentAdapter {
    private android.print.PrintAttributes mAttributes;
    final synthetic android.support.v4.print.PrintHelperKitkat this$0;
    final synthetic android.graphics.Bitmap val$bitmap;
    final synthetic int val$fittingMode;
    final synthetic String val$jobName;

    PrintHelperKitkat$1(android.support.v4.print.PrintHelperKitkat p1, String p2, android.graphics.Bitmap p3, int p4)
    {
        this.this$0 = p1;
        this.val$jobName = p2;
        this.val$bitmap = p3;
        this.val$fittingMode = p4;
        return;
    }

    public void onLayout(android.print.PrintAttributes p5, android.print.PrintAttributes p6, android.os.CancellationSignal p7, android.print.PrintDocumentAdapter$LayoutResultCallback p8, android.os.Bundle p9)
    {
        int v0 = 1;
        this.mAttributes = p6;
        android.print.PrintDocumentInfo vtmp3 = new android.print.PrintDocumentInfo$Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
        if (p6.equals(p5)) {
            v0 = 0;
        }
        p8.onLayoutFinished(vtmp3, v0);
        return;
    }

    public void onWrite(android.print.PageRange[] p10, android.os.ParcelFileDescriptor p11, android.os.CancellationSignal p12, android.print.PrintDocumentAdapter$WriteResultCallback p13)
    {
        android.print.pdf.PrintedPdfDocument v4_1 = new android.print.pdf.PrintedPdfDocument(this.this$0.mContext, this.mAttributes);
        try {
            android.graphics.pdf.PdfDocument$Page v3 = v4_1.startPage(1);
            v3.getCanvas().drawBitmap(this.val$bitmap, android.support.v4.print.PrintHelperKitkat.access$000(this.this$0, this.val$bitmap.getWidth(), this.val$bitmap.getHeight(), new android.graphics.RectF(v3.getInfo().getContentRect()), this.val$fittingMode), 0);
            v4_1.finishPage(v3);
        } catch (java.io.IOException v5_12) {
            if (v4_1 != null) {
                v4_1.close();
            }
            if (p11 != null) {
                try {
                    p11.close();
                } catch (java.io.IOException v6) {
                }
            }
            throw v5_12;
        }
        try {
            v4_1.writeTo(new java.io.FileOutputStream(p11.getFileDescriptor()));
            java.io.IOException v5_9 = new android.print.PageRange[1];
            v5_9[0] = android.print.PageRange.ALL_PAGES;
            p13.onWriteFinished(v5_9);
        } catch (java.io.IOException v1) {
            android.util.Log.e("PrintHelperKitkat", "Error writing printed content", v1);
            p13.onWriteFailed(0);
        }
        if (v4_1 != null) {
            v4_1.close();
        }
        if (p11 != null) {
            try {
                p11.close();
            } catch (java.io.IOException v5) {
            }
        }
        return;
    }
}
