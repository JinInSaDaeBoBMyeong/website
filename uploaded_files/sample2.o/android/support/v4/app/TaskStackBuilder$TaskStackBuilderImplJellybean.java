package android.support.v4.app;
 class TaskStackBuilder$TaskStackBuilderImplJellybean implements android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl {

    TaskStackBuilder$TaskStackBuilderImplJellybean()
    {
        return;
    }

    public android.app.PendingIntent getPendingIntent(android.content.Context p4, android.content.Intent[] p5, int p6, int p7, android.os.Bundle p8)
    {
        p5[0] = new android.content.Intent(p5[0]).addFlags(268484608);
        return android.support.v4.app.TaskStackBuilderJellybean.getActivitiesPendingIntent(p4, p6, p5, p7, p8);
    }
}