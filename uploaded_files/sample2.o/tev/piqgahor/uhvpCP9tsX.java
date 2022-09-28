package tev.piqgahor;
public class uhvpCP9tsX {

    public uhvpCP9tsX()
    {
        return;
    }

    public static void StartThread(Runnable p1)
    {
        new Thread(p1).start();
        return;
    }

    public static void UFigarjS77(java.io.InputStream p1, java.io.OutputStream p2, int p3)
    {
        tev.piqgahor.uhvpCP9tsX.UFigarjS77(p1, p2, p3, 1024);
        return;
    }

    public static void UFigarjS77(java.io.InputStream p3, java.io.OutputStream p4, int p5, int p6)
    {
        int v0 = new byte[p6];
        while(true) {
            int v1 = tev.piqgahor.uhvpCP9tsX.tLxLZU289(p3, v0, p5, p6);
            if (v1 == -1) {
                break;
            }
            if (p5 <= 0) {
                p4.write(v0, 0, v1);
            } else {
                p5 = 0;
            }
        }
        return;
    }

    private static int tLxLZU289(java.io.InputStream p1, byte[] p2, int p3, int p4)
    {
        if (p3 <= 0) {
            p3 = p4;
        }
        return p1.read(p2, 0, p3);
    }
}
