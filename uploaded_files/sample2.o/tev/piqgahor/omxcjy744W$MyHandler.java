package tev.piqgahor;
 class omxcjy744W$MyHandler extends android.os.Handler {
    private final ref.WeakReference OPBPpn2p650f;

    public omxcjy744W$MyHandler(tev.piqgahor.omxcjy744W p2, android.os.Looper p3)
    {
        super(p3);
        super.OPBPpn2p650f = new ref.WeakReference(p2);
        return;
    }

    public void handleMessage(android.os.Message p10)
    {
        tev.piqgahor.omxcjy744W v4_1 = ((tev.piqgahor.omxcjy744W) this.OPBPpn2p650f.get());
        if (v4_1 != null) {
            switch (p10.arg1) {
                case 1:
                    String v5_1 = ((String) p10.obj);
                    int v7_1 = new int[33];
                    v7_1 = {14, 105, 90, 125, 117, 119, 124, 101, 124, 114, 107, 46, 82, 115, 132, 119, 113, 115, 46, 111, 130, 130, 111, 113, 118, 115, 114, 46, 133, 119, 130, 118, 46};
                    tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v7_1))).append(v5_1).toString());
                    ((android.widget.EditText) v4_1.findViewById(2131230731)).setVisibility(8);
                    ((android.widget.Button) v4_1.findViewById(2131230733)).setVisibility(8);
                    android.widget.TextView v1_1 = ((android.widget.TextView) v4_1.findViewById(2131230732));
                    String v6_10 = new Object[3];
                    v6_10[0] = v4_1.getString(2131099687);
                    v6_10[1] = " ";
                    v6_10[2] = v5_1;
                    v1_1.setText(tev.piqgahor.WqukitNJL.mvoGCr4741(v6_10));
                    break;
                case 2:
                    tev.piqgahor.omxcjy744W.access$1(v4_1, tev.piqgahor.omxcjy744W.access$0(), ((String) p10.obj), ((String) p10.obj));
                    break;
                default:
            }
        }
        return;
    }
}
