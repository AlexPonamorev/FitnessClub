public class Zone {
    //private Subscription []subscriptions;
    //public enum ZoneType{POOL,GUM,GROUP};
    int countClient = 0;
    // в зоне хранит массив на 20 абониментов
    Subscription[] subscriptions = new Subscription[20];

    // метод чтобы записать абонимента в зону
// если данные о зоне в абонементе == заявленной
    public void AddZone(Subscription subscription, ZoneType zoneType) {
        if (subscription.getZoneType() == zoneType) {
            for (int i = 0; i < subscriptions.length; ++i) {
                if (subscriptions[i] == null) {
                    subscriptions[i] = subscription;
                }
            }
        }
    }

    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
