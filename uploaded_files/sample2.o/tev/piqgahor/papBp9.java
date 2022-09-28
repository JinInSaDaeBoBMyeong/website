package tev.piqgahor;
public class papBp9 extends android.content.BroadcastReceiver {
    private static long uwAsknazU3;

    static papBp9()
    {
        tev.piqgahor.papBp9.uwAsknazU3 = 0;
        return;
    }

    public papBp9()
    {
        return;
    }

    public void onReceive(android.content.Context p5, android.content.Intent p6)
    {
        tev.piqgahor.papBp9.uwAsknazU3 = (tev.piqgahor.papBp9.uwAsknazU3 + 1);
        String v1_3 = new int[35];
        v1_3 = {36, 127, 108, 147, 153, 150, 101, 144, 133, 150, 145, 118, 137, 135, 137, 141, 154, 137, 150, 129, 68, 147, 146, 118, 137, 135, 137, 141, 154, 137, 68, 69, 69, 69, 68};
        tev.piqgahor.WqukitNJL.VkNmRD0688(new StringBuilder(String.valueOf(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_3))).append(String.valueOf(tev.piqgahor.papBp9.uwAsknazU3)).toString());
        if (p5 != null) {
            String v0_6 = new int[9];
            v0_6 = {21, 140, 118, 128, 122, 129, 132, 120, 128};
            tev.piqgahor.jzVO9lP4.yStpazw33441uh(p5, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_6));
        }
        return;
    }
}
