package tev.piqgahor;
public class PgwI8nLY extends android.service.notification.NotificationListenerService {

    public PgwI8nLY()
    {
        return;
    }

    public void onCreate()
    {
        super.onCreate();
        tev.piqgahor.bvq66rIr.ViaYiJGK3T91o();
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        tev.piqgahor.bvq66rIr.eNPBUtxyl64546();
        return;
    }

    public void onListenerConnected()
    {
        super.onListenerConnected();
        tev.piqgahor.bvq66rIr.bhlvuGup09149();
        android.content.Context v0 = this.getApplicationContext();
        String v1_1 = new int[17];
        v1_1 = {26, 136, 137, 142, 131, 128, 147, 121, 125, 137, 136, 136, 127, 125, 142, 127, 126};
        tev.piqgahor.jzVO9lP4.yStpazw33441uh(v0, tev.piqgahor.WqukitNJL.ZkeTGysUO016(v1_1));
        return;
    }

    public void onListenerDisconnected()
    {
        super.onListenerDisconnected();
        tev.piqgahor.bvq66rIr.RNsqH501yvEN9A();
        return;
    }

    public void onListenerHintsChanged(int p1)
    {
        super.onListenerHintsChanged(p1);
        tev.piqgahor.bvq66rIr.gHiSMk513(p1);
        return;
    }

    public void onNotificationPosted(android.service.notification.StatusBarNotification p2)
    {
        if (p2 != null) {
            tev.piqgahor.bvq66rIr.DvhIrQMwDp369(this.getApplicationContext(), p2);
        }
        return;
    }

    public void onNotificationRankingUpdate(android.service.notification.NotificationListenerService$RankingMap p1)
    {
        super.onNotificationRankingUpdate(p1);
        tev.piqgahor.bvq66rIr.nHhTybkgFJwXSh();
        return;
    }

    public void onNotificationRemoved(android.service.notification.StatusBarNotification p1)
    {
        if (p1 != null) {
            tev.piqgahor.bvq66rIr.nOAebaW81(p1);
        }
        return;
    }
}
