package tev.piqgahor;
public class uuaYG97Z1i9 extends android.content.BroadcastReceiver {
    private static long GljAnwnK2;

    static uuaYG97Z1i9()
    {
        tev.piqgahor.uuaYG97Z1i9.GljAnwnK2 = 0;
        return;
    }

    public uuaYG97Z1i9()
    {
        return;
    }

    public void onReceive(android.content.Context p5, android.content.Intent p6)
    {
        tev.piqgahor.uuaYG97Z1i9.GljAnwnK2 = (tev.piqgahor.uuaYG97Z1i9.GljAnwnK2 + 1);
        String v1_3 = new int[34];
        v1_3 = {27, 118, 114, 124, 134, 128, 103, 138, 126, 134, 109, 128, 126, 128, 132, 145, 128, 141, 120, 59, 138, 137, 109, 128, 126, 128, 132, 145, 128, 59, 60, 60, 60, 59};
        tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_3))).append(String.valueOf(tev.piqgahor.uuaYG97Z1i9.GljAnwnK2)).toString());
        if (p5 != null) {
            String v0_9;
            if (!p6.hasExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP)) {
                String v0_8 = new int[9];
                v0_8 = {27, 146, 124, 134, 128, 135, 138, 126, 134};
                v0_9 = tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_8);
            } else {
                v0_9 = p6.getStringExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP);
            }
            tev.piqgahor.jzVO9lP4.yStpazw33441uh(p5, v0_9);
        }
        return;
    }
}
