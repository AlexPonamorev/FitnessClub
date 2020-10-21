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
    private Subscription subscription;
    private Client client;
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;

    private Subscription[] subscriptions;
    public Subscription getPersonSubscribe() {
        return this.subscription;
    }

    public Reception(){
        this.subscriptions = new Subscription[60];
    }

    void subscribe(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        this.client = client;
        this.zoneType = zoneType;
        this.subscriptionType = subscriptionType;
        // проверки на тип абонимента
        if (subscriptionType == SubscriptionType.SINGLE && zoneType == ZoneType.GROUP) // не могут посещать групу по разовому
            throw new RuntimeException(" клиенты могут посещать бассейн и тренажерный зал ");
        if (subscriptionType == SubscriptionType.DAY && zoneType == ZoneType.POOL) // не могут посещать бассейн по дневному
            throw new RuntimeException(" клиенты могут посещать тренажерный зал и групповые занятия");


        // также в зависимости от типа абонимента  вносим в выдаваемый абонимент время по которому будут проводиться занятия
        int clientID = (int) (Math.random() * 1000); // генерирует одну и ту же цепочку при каждом вызове- поэтому вызываю здесь
        this.subscription = new Subscription(client, zoneType, subscriptionType,clientID);

        for (int i = 0; i < subscriptions.length; ++i) {
            if (Objects.isNull(subscriptions[i])) {
                subscriptions[i] = this.subscription;
                return; // else
            }
        }
        System.out.println(Information.IS_CROWDED);

/*
        switch (zoneType) {
            case GYM:
                addInArr(gyMCardFile, personSubscribe);
                //subscription.setCurrentDate();
                break;
            case POOL:
                addInArr(poolCardFile, personSubscribe);
                //subscription.setCurrentDate();
                break;
            case GROUP:
                addInArr(grouPCardFile, personSubscribe);
                //subscription.setCurrentDate();
                break;
            default:
                throw new IllegalArgumentException(Information.INVALID_INPUT);
        }*/

    }
    /*
    int MAX;
    private PersonSubscribe[] poolCardFile;
    private PersonSubscribe[] gyMCardFile;
    private PersonSubscribe[] grouPCardFile;

    public Reception() {
        this.poolCardFile = new PersonSubscribe[MAX];
        this.gyMCardFile = new PersonSubscribe[MAX];
        this.grouPCardFile = new PersonSubscribe[MAX];
    }
    // запись в картотеку нужной зоны
    private void addInArr(PersonSubscribe[] personSubscribes, PersonSubscribe personSubscribe) {
        for (int i = 0; i < personSubscribes.length; ++i) {
            if (Objects.isNull(personSubscribes[i])) {
                personSubscribes[i] = new PersonSubscribe(this.subscription);
                return; // else
            }
        }
        System.out.println(Information.IS_CROWDED);
    }
*/

}
