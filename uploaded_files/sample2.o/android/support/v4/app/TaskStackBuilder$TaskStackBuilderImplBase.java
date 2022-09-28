package android.support.v4.app;
 class TaskStackBuilder$TaskStackBuilderImplBase implements android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl {

    TaskStackBuilder$TaskStackBuilderImplBase()
    {
        return;
    }

    public android.app.PendingIntent getPendingIntent(android.content.Context p3, android.content.Intent[] p4, int p5, int p6, android.os.Bundle p7)
    {
        android.content.Intent v0_1 = new android.content.Intent(p4[(p4.length - 1)]);
        v0_1.addFlags(268435456);
        return android.app.PendingIntent.getActivity(p3, p5, v0_1, p6);
    }
}
