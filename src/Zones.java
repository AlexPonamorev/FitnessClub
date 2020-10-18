import java.util.Objects;

public class Zones {

    int countClient = 0;
    // зона знает про абонимент
    // зона знает про фитнесс
    // зона хранит три массива с знами

   Subscription subscription;
   Fitness fitness;
   ZoneType zoneType;
   // зона спрашивает у фитнеса куда сейчас записывать

    private final int MAX = 20;
    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;

    Zones zones;
    public  Zones(){
        zones = new Zones();
        this.pooL = new Subscription[MAX];
        this.gyM = new Subscription[MAX];
        this.grouP = new Subscription[MAX];
    }


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

    private void addInArr(Subscription[] subscriptions, Subscription abonement){
        for (int i = 0; i < subscriptions.length; i++) {
            if (Objects.isNull(subscriptions[i])){
                subscriptions[i] = abonement;
                return;
            }
        }
        System.out.println(Information.IS_CROWDED);
    }


    private boolean checkVisitTime(Subscription subscription){
        if (subscription.getCurrentDate() < subscription.getStartTime()){
            System.out.println("Вам придется немного подождать");
            return true;
        }else if (subscription.getCurrentDate() > subscription.getEndTime()){
            System.out.println("Вы опоздали, приходите завтра");
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
