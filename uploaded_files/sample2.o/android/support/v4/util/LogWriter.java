package android.support.v4.util;
public class LogWriter extends java.io.Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    public LogWriter(String p3)
    {
        this.mBuilder = new StringBuilder(128);
        this.mTag = p3;
        return;
    }

    private void flushBuilder()
    {
        if (this.mBuilder.length() > 0) {
            android.util.Log.d(this.mTag, this.mBuilder.toString());
            this.mBuilder.delete(0, this.mBuilder.length());
        }
        return;
    }

    public void close()
    {
        this.flushBuilder();
        return;
    }

    public void flush()
    {
        this.flushBuilder();
        return;
    }

    public void write(char[] p4, int p5, int p6)
    {
        int v1 = 0;
        while (v1 < p6) {
            char v0 = p4[(p5 + v1)];
            if (v0 != 10) {
                this.mBuilder.append(v0);
            } else {
                this.flushBuilder();
            }
            v1++;
        }
        return;
    }
}
