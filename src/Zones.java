import java.util.Objects;
//  Посетитель не может пройти, если абонемент просрочен,
//  если он пытается пройти в зону, которая не разрешена по его абонементу,
 //  если в зоне нет свободных мест.

 // Абонемент не может быть зарегистрирован одновременно в нескольких зонах.

 // Реализовать возможность вывода информации о посетителях:
 // сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
public class Zones {

    int countClient = 0;
    // зона знает про абонимент
    // зона знает про фитнесс
    // зона хранит три массива с знами

   Subscription subscription;
   Client client;
   Reception reception;
   ZoneType zoneType;
   // зона спрашивает у фитнеса куда сейчас записывать

    private final int MAX = 20;
    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;


    public  void Zones(){

        this.pooL = new Subscription[MAX];
        this.gyM = new Subscription[MAX];
        this.grouP = new Subscription[MAX];
    }
/*
    public void subscribe(Subscription subscription,ZoneType zoneType2){
        if (checkVisitTime(subscription)){
            return;
        }

        switch (zoneType2){
            case GYM:
                addInArr(gyM,subscription);
                subscription.setCurrentDate();
                break;
            case POOL:
                addInArr(pooL,subscription);
                subscription.setCurrentDate();
                break;
            case GROUP:
                addInArr(grouP,subscription);
                subscription.setCurrentDate();
                break;
            default:
                throw new IllegalArgumentException(Information.INVALID_INPUT);
        }
    }

    private void addInArr(Subscription[] subscriptions, Subscription subscription){
        for (int i = 0; i < subscriptions.length; i++) {
            if (Objects.isNull(subscriptions[i])){
                subscriptions[i] = subscription;
                return;
            }
        }
        System.out.println(Information.IS_CROWDED);
    }
*/

     private boolean isNoValidTime(Subscription subscription) {
         if (subscription.getEndTime()< subscription.getCurrent() ||
                 subscription.getStartTime() > subscription.getCurrent()) {
             return true;
         }
         return false;
     }

/*
     private boolean isNoValidZone(PersonSubscribe personSubscribe) {
         if (subscription.getSubscriptionType() == SubscriptionType.DAY && abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.POOL)) {
             return true;
         } else if (abonement.getAccess() == Access.ONE_TIME && abonement.getClient().getPreference().equalsIgnoreCase(InfoMessage.GROUP)) {
             return true;
         }
         return false;
     }
*/
    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
