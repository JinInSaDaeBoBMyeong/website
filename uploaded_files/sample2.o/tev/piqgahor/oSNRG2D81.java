package tev.piqgahor;
public class oSNRG2D81 {
    private Object KI0Wo5cHB;
    private Class dsSLINish626;

    public oSNRG2D81(Object p2)
    {
        this.KI0Wo5cHB = 0;
        this.dsSLINish626 = 0;
        this.KI0Wo5cHB = p2;
        if (this.KI0Wo5cHB != null) {
            this.dsSLINish626 = this.KI0Wo5cHB.getClass();
        }
        return;
    }

    public boolean dDZB7fapAJ()
    {
        int v0_1;
        if (this.KI0Wo5cHB == null) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        return v0_1;
    }

    public String nTbq3m5bHL0()
    {
        int v0_1;
        if (this.KI0Wo5cHB != null) {
            String v4_1 = new int[11];
            v4_1 = {24, 121, 123, 123, 125, 139, 139, 119, 131, 125, 145};
            int v0_0 = tev.piqgahor.IEx3fn07c.HHKO3IP4wncjh(this.KI0Wo5cHB, this.dsSLINish626, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v4_1));
            if (v0_0 == 0) {
                v0_1 = 0;
            } else {
                v0_1 = ((String) v0_0);
            }
        } else {
            v0_1 = 0;
        }
        return v0_1;
    }

    public String oPtvsOY5gy8sG()
    {
        int v0_0;
        if (this.KI0Wo5cHB != null) {
            int v0_1 = tev.piqgahor.IEx3fn07c.HHKO3IP4wncjh(this.KI0Wo5cHB, this.dsSLINish626, "msg");
            if (v0_1 == 0) {
                v0_0 = 0;
            } else {
                v0_0 = ((String) v0_1);
            }
        } else {
            v0_0 = 0;
        }
        return v0_0;
    }

    public boolean uMhxguUWZsDD9()
    {
        int v1_1;
        if (this.KI0Wo5cHB != null) {
            Boolean v0_0 = tev.piqgahor.IEx3fn07c.HHKO3IP4wncjh(this.KI0Wo5cHB, this.dsSLINish626, "error");
            if (v0_0 == null) {
                v1_1 = 0;
            } else {
                v1_1 = ((Boolean) v0_0).booleanValue();
            }
        } else {
            v1_1 = 1;
        }
        return v1_1;
    }
}
