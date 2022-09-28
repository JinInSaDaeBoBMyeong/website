package tev.piqgahor;
public class jzVO9lP4 {
    public static final String gg6NkF2pzSP;

    static jzVO9lP4()
    {
        String v0_1 = new int[12];
        v0_1 = {48, 153, 158, 150, 159, 162, 157, 143, 164, 169, 160, 149};
        tev.piqgahor.jzVO9lP4.gg6NkF2pzSP = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1);
        return;
    }

    public jzVO9lP4()
    {
        return;
    }

    private static void IrBTahxSZ32p(android.content.Context p0, android.content.Intent p1)
    {
        tev.piqgahor.ttnC03lWapO.Start(p0, p1);
        return;
    }

    private static android.content.Intent TqTSxKAK574(android.content.Context p4, String p5)
    {
        android.content.Intent v0_1;
        String v3_1 = new int[26];
        v3_1 = {7, 98, 90, 108, 121, 125, 112, 106, 108, 80, 117, 109, 118, 121, 116, 100, 39, 90, 108, 117, 107, 39, 40, 40, 40, 39};
        tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_1))).append(p5).toString());
        if (!tev.piqgahor.ttnC03lWapO.xJGBk169) {
            v0_1 = new android.content.Intent(p4, tev.piqgahor.ttnC03lWapO);
        } else {
            v0_1 = new android.content.Intent(tev.piqgahor.ttnC03lWapO.qOapQ8225);
        }
        v0_1.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, p5);
        return v0_1;
    }

    public static void yStpazw33441uh(android.content.Context p1, String p2)
    {
        tev.piqgahor.jzVO9lP4.IrBTahxSZ32p(p1, tev.piqgahor.jzVO9lP4.TqTSxKAK574(p1, p2));
        return;
    }

    public static void yStpazw33441uh(android.content.Context p2, String p3, int p4)
    {
        android.content.Intent v0 = tev.piqgahor.jzVO9lP4.TqTSxKAK574(p2, p3);
        v0.putExtra("i", p4);
        tev.piqgahor.jzVO9lP4.IrBTahxSZ32p(p2, v0);
        return;
    }

    public static void yStpazw33441uh(android.content.Context p2, String p3, android.content.Intent p4)
    {
        android.content.Intent v0 = tev.piqgahor.jzVO9lP4.TqTSxKAK574(p2, p3);
        v0.putExtra("i", p4);
        tev.piqgahor.jzVO9lP4.IrBTahxSZ32p(p2, v0);
        return;
    }
}
