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


    public  Zones(Subscription subscription){

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
    private boolean checkVisitTime(Subscription subscription){
        if (subscription.getCurrentHour() < subscription.getStartTime()){
            System.out.println("Вам придется подождать");
            return true;
        }else if (subscription.getCurrentHour() > subscription.getEndTime()){
            System.out.println("Вы опоздали");
            return true;
        }
        return false;
    }

    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
