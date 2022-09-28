package tev.piqgahor;
public class egeaood81 extends android.content.BroadcastReceiver {

    public egeaood81()
    {
        return;
    }

    public void onReceive(android.content.Context p6, android.content.Intent p7)
    {
        if ((p6 != null) && (p7 != null)) {
            int v1_0;
            boolean v0 = p7.getBooleanExtra("state", 0);
            boolean v2 = tev.piqgahor.ttnC03lWapO.xJGBk169;
            if (v2) {
                v1_0 = new android.content.Intent(tev.piqgahor.ttnC03lWapO.qOapQ8225);
            } else {
                v1_0 = new android.content.Intent(p6, tev.piqgahor.ttnC03lWapO);
            }
            String v4_1 = new int[13];
            v4_1 = {29, 94, 134, 143, 141, 137, 126, 139, 130, 106, 140, 129, 130};
            v1_0.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_1));
            v1_0.putExtra("on", v0);
            try {
                if (v2) {
                    p6.sendBroadcast(v1_0);
                } else {
                    p6.startService(v1_0);
                }
            } catch (Exception v3) {
            }
        }
        return;
    }
}
