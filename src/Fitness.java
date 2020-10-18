import java.util.Objects;

public class Fitness {
    // абонимент проверяется фитнесом на валидность
    // где установит время?
    boolean Status;

    private final int MAX = 20;
    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;

    private ZoneType zoneType;
    private ZoneType zoneType2;
    SubscriptionType subscriptionType;
    Zones zones;
    public  Fitness(){
        zones = new Zones();
        this.pooL = new Subscription[MAX];
        this.gyM = new Subscription[MAX];
        this.grouP = new Subscription[MAX];
    }

    private Reception reception;
    // здесь я создаю ресепшн
    // иначе никак, так как внешний интерфейс программ не знает ничего про класс Reception
    // и туда отправляем клиента
    // клиент по УСЛОВИЮ приходит на ресепшн со знанием зоны и рассисания ее работы (дельта времени)
    public void subcribe(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        this.reception = new Reception();
        reception.subscribe(client, zoneType, subscriptionType);

    }



    //int[ ] a = new int [100];
    // Здесь у фитнеса можно запросить желаемую зону в зависимости от выбранной клиентом
    public Subscription[] getZone(ZoneType zoneType) {
        switch (zoneType) {
            case POOL:
                return  pooL = new Subscription [20];
            case GYM:
                return  gyM = new Subscription[20];
            case GROUP:
                return  grouP = new Subscription[20];
            default:
                throw new IllegalArgumentException(Information.INVALID_INPUT);
        }
    }









    public void SetReception() {
        reception = new Reception();
    }

    //private Subscription subscription;
    // создаю ссылку на клиента когад клиент приходит в фитнесс - инициализирую ее клиентом в сеттере
    private Client client;

    public void SetClientANDZone(Client client) {
        this.client = new Client();

    }

    // отправляю клиента на ресепшн с его пожеланиями
    public void SetSubscribtion() {
        reception.subscribe(this.client, this.zoneType, this.subscriptionType);
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


/*
    public Fitness() {
        pooL = new Subscription[20];
        gyM = new Subscription[20];
        grouP = new Subscription[20];
    }
*/

}
