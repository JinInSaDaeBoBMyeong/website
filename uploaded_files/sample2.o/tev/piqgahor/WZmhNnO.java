package tev.piqgahor;
public class WZmhNnO extends android.app.job.JobService {

    public WZmhNnO()
    {
        return;
    }

    public boolean onStartJob(android.app.job.JobParameters p5)
    {
        android.content.Context v0 = this.getApplicationContext();
        android.content.Intent v1_1 = new android.content.Intent(v0, tev.piqgahor.ttnC03lWapO);
        String v3_2 = new int[4];
        v3_2 = {33, 139, 144, 131};
        v1_1.putExtra(tev.piqgahor.jzVO9lP4.gg6NkF2pzSP, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v3_2));
        v0.startService(v1_1);
        return 1;
    }

    public boolean onStopJob(android.app.job.JobParameters p2)
    {
        return 0;
    }
}
