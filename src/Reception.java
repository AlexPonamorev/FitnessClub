// здесь регестрирую абонемент клиетна
// идея - клиент приходит на ресепшн(подается в качестве параметра),
// со своими требованиями(также к качестве параметров - тип зоны, и желаемое время посещения
// тут, конечно может возникнуть вопрос - а если клиент не знает режима работы, а знает только ZoneType?
// пока этот случай не рассматривается

// в итоге ему выдается абонемент - взависимости от его требований
//T.E РЕСЕПШН СОЗДАЕТ АБОНИМЕНТ И ХРАНИТ У СЕБЯ

//далее на ресепшене проверим если свободные места в запрашиваемой зоне.
// ТАК ЖЕ РЕСЕПШН ЗНАЕТ ПРО ФИТНЕСС(ХРАНИТ ССЫЛКУ НА НЕГО)


import java.util.Objects;

public class Reception {
    //private Fitness fitness;

    //ZoneType zoneType;
    private Subscription subscription;
    private Client client;
    private ZoneType zoneType;
    String preference;
    private SubscriptionType subscriptionType;
    private PersonSubscribe personSubscribe;

    void subscribe(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        // проверки на тип абонимента
        if (subscriptionType == SubscriptionType.SINGLE && zoneType == ZoneType.GROUP) // не могут посещать групу по разовому
            throw new RuntimeException(" клиенты могут посещать бассейн и тренажерный зал ");
        if (subscriptionType == SubscriptionType.DAY && zoneType == ZoneType.POOL) // не могут посещать бассейн по дневному
            throw new RuntimeException(" клиенты могут посещать тренажерный зал и групповые занятия");
        // также в зависимости от типа абонимента  вносим в выдаваемый абонимент время по которому будут проводиться занятия

        this.subscription = new Subscription(client, zoneType, subscriptionType);
    }

    int MAX;
    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;

    public Reception() {
       // subscription = new Subscription();
       // personSubscribe = new PersonSubscribe();
        this.pooL = new Subscription[MAX];
        this.gyM = new Subscription[MAX];
        this.grouP = new Subscription[MAX];
    }

    public void filing(Client client, ZoneType zoneType2,SubscriptionType subscriptionType) {
        switch (zoneType2) {
            case GYM:
                personSubscribe = new PersonSubscribe(subscription,zoneType2);
                addInArr(gyM, subscription);
                subscription.setCurrentDate();
                break;
            case POOL:
                addInArr(pooL, subscription);
                subscription.setCurrentDate();
                break;
            case GROUP:
                addInArr(grouP, subscription);
                subscription.setCurrentDate();
                break;
            default:
                throw new IllegalArgumentException(Information.INVALID_INPUT);
        }
    }
// приходит клиент д нужной зоны
    private void addInArr(Subscription[] subscriptions, Subscription subscription) {
        for (int i = 0; i < subscriptions.length; i++) {
            if (Objects.isNull(subscriptions[i])) {
                subscriptions[i] = new Subscription(client, zoneType, subscriptionType);

                return;
            }
        }
        System.out.println(Information.IS_CROWDED);
    }

}
