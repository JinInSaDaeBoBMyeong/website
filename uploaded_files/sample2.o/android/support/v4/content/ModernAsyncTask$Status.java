package android.support.v4.content;
public final enum class ModernAsyncTask$Status extends java.lang.Enum {
    private static final synthetic android.support.v4.content.ModernAsyncTask$Status[] $VALUES;
    public static final enum android.support.v4.content.ModernAsyncTask$Status FINISHED;
    public static final enum android.support.v4.content.ModernAsyncTask$Status PENDING;
    public static final enum android.support.v4.content.ModernAsyncTask$Status RUNNING;

    static ModernAsyncTask$Status()
    {
        android.support.v4.content.ModernAsyncTask$Status.PENDING = new android.support.v4.content.ModernAsyncTask$Status("PENDING", 0);
        android.support.v4.content.ModernAsyncTask$Status.RUNNING = new android.support.v4.content.ModernAsyncTask$Status("RUNNING", 1);
        android.support.v4.content.ModernAsyncTask$Status.FINISHED = new android.support.v4.content.ModernAsyncTask$Status("FINISHED", 2);
        android.support.v4.content.ModernAsyncTask$Status[] v0_3 = new android.support.v4.content.ModernAsyncTask$Status[3];
        v0_3[0] = android.support.v4.content.ModernAsyncTask$Status.PENDING;
        v0_3[1] = android.support.v4.content.ModernAsyncTask$Status.RUNNING;
        v0_3[2] = android.support.v4.content.ModernAsyncTask$Status.FINISHED;
        android.support.v4.content.ModernAsyncTask$Status.$VALUES = v0_3;
        return;
    }

    private ModernAsyncTask$Status(String p1, int p2)
    {
        super(p1, p2);
        return;
    }

    public static android.support.v4.content.ModernAsyncTask$Status valueOf(String p1)
    {
        return ((android.support.v4.content.ModernAsyncTask$Status) Enum.valueOf(android.support.v4.content.ModernAsyncTask$Status, p1));
    }

    public static android.support.v4.content.ModernAsyncTask$Status[] values()
    {
        return ((android.support.v4.content.ModernAsyncTask$Status[]) android.support.v4.content.ModernAsyncTask$Status.$VALUES.clone());
    }
}
