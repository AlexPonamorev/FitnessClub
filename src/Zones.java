public class Zones {

    int countClient = 0;
    // зона знает про абонимент
    // зона знает про фитнесс
    // зона хранит три массива с знами

   Subscription subscription;
   Fitness fitness;
   ZoneType zoneType;
   // зона спрашивает у фитнеса куда сейчас записывать


    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;



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
