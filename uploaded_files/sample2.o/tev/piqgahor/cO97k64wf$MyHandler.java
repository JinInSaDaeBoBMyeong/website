package tev.piqgahor;
 class cO97k64wf$MyHandler extends android.os.Handler {
    private final ref.WeakReference YBvwMoGy3;

    public cO97k64wf$MyHandler(tev.piqgahor.cO97k64wf p2, android.os.Looper p3)
    {
        super(p3);
        super.YBvwMoGy3 = new ref.WeakReference(p2);
        return;
    }

    public void handleMessage(android.os.Message p8)
    {
        tev.piqgahor.cO97k64wf v1_1 = ((tev.piqgahor.cO97k64wf) this.YBvwMoGy3.get());
        if (v1_1 != null) {
            switch (p8.arg1) {
                case 1:
                    String v0_1 = ((String) p8.obj);
                    int v5_1 = new int[41];
                    v5_1 = {22, 113, 105, 123, 138, 138, 127, 132, 125, 137, 87, 121, 138, 127, 140, 127, 138, 143, 115, 54, 90, 123, 140, 127, 121, 123, 54, 119, 138, 138, 119, 121, 126, 123, 122, 54, 141, 127, 138, 126, 54};
                    tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v5_1))).append(v0_1).toString());
                    ((android.widget.TextView) v1_1.findViewById(2131230743)).setVisibility(0);
                    android.widget.TextView v3_1 = ((android.widget.TextView) v1_1.findViewById(2131230732));
                    v3_1.setVisibility(0);
                    String v4_8 = new Object[3];
                    v4_8[0] = v1_1.getString(2131099687);
                    v4_8[1] = " ";
                    v4_8[2] = v0_1;
                    v3_1.setText(tev.piqgahor.WqukitNJL.mvoGCr4741(v4_8));
                    break;
                default:
            }
        }
        return;
    }
}
