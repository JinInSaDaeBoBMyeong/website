package android.support.v4.print;
 class PrintHelperKitkat$2 extends android.print.PrintDocumentAdapter {
    android.os.AsyncTask loadBitmap;
    private android.print.PrintAttributes mAttributes;
    android.graphics.Bitmap mBitmap;
    final synthetic android.support.v4.print.PrintHelperKitkat this$0;
    final synthetic int val$fittingMode;
    final synthetic android.net.Uri val$imageFile;
    final synthetic String val$jobName;

    PrintHelperKitkat$2(android.support.v4.print.PrintHelperKitkat p2, String p3, android.net.Uri p4, int p5)
    {
        this.this$0 = p2;
        this.val$jobName = p3;
        this.val$imageFile = p4;
        this.val$fittingMode = p5;
        this.mBitmap = 0;
        return;
    }

    static synthetic void access$100(android.support.v4.print.PrintHelperKitkat$2 p0)
    {
        p0.cancelLoad();
        return;
    }

    private void cancelLoad()
    {
        android.support.v4.print.PrintHelperKitkat.access$300(this.this$0);
        try {
            if (this.this$0.mDecodeOptions != null) {
                this.this$0.mDecodeOptions.requestCancelDecode();
                this.this$0.mDecodeOptions = 0;
            }
        } catch (android.support.v4.print.PrintHelperKitkat v0_1) {
            throw v0_1;
        }
        return;
    }

    public void onFinish()
    {
        super.onFinish();
        this.cancelLoad();
        this.loadBitmap.cancel(1);
        return;
    }

    public void onLayout(android.print.PrintAttributes p10, android.print.PrintAttributes p11, android.os.CancellationSignal p12, android.print.PrintDocumentAdapter$LayoutResultCallback p13, android.os.Bundle p14)
    {
        int v6 = 1;
        if (!p12.isCanceled()) {
            if (this.mBitmap == null) {
                this.loadBitmap = new android.support.v4.print.PrintHelperKitkat$2$1(this, p12, p11, p10, p13);
                android.net.Uri[] v1_0 = new android.net.Uri[0];
                this.loadBitmap.execute(v1_0);
                this.mAttributes = p11;
            } else {
                android.print.PrintDocumentInfo vtmp4 = new android.print.PrintDocumentInfo$Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
                if (p11.equals(p10)) {
                    v6 = 0;
                }
                p13.onLayoutFinished(vtmp4, v6);
            }
        } else {
            p13.onLayoutCancelled();
            this.mAttributes = p11;
        }
        return;
    }

    public void onWrite(android.print.PageRange[] p10, android.os.ParcelFileDescriptor p11, android.os.CancellationSignal p12, android.print.PrintDocumentAdapter$WriteResultCallback p13)
    {
        android.print.pdf.PrintedPdfDocument v4_1 = new android.print.pdf.PrintedPdfDocument(this.this$0.mContext, this.mAttributes);
        try {
            android.graphics.pdf.PdfDocument$Page v3 = v4_1.startPage(1);
            v3.getCanvas().drawBitmap(this.mBitmap, android.support.v4.print.PrintHelperKitkat.access$000(this.this$0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), new android.graphics.RectF(v3.getInfo().getContentRect()), this.val$fittingMode), 0);
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
