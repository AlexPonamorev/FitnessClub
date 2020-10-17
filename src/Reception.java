// здесь регестрирую абонемент клиетна
// идея - клиент приходит на ресепшн(подается в качестве параметра),
// со своими требованиями(также к качестве параметров - тип зоны, и желаемое время посещения
// тут, конечно может возникнуть вопрос - а если клиент не знает режима работы, а знает только ZoneType?
// пока этот случай не рассматривается

// в итоге ему выдается абонемент - взависимости от его требований
//далее на ресепшене проверим если свободные места в запрашиваемой зоне.

public class Reception {
    //private Fitness fitness;
    private Zone zone;
    ZoneType zoneType;
    private Subscription subscription;

    void subscribe(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        // проверки на тип абонимента
        if (subscriptionType == SubscriptionType.SINGLE && zoneType == ZoneType.GROUP)
            throw new RuntimeException(" клиенты могут посещать бассейн и тренажерный зал ");
        if (subscriptionType == SubscriptionType.DAY && zoneType == ZoneType.POOL)
            throw new RuntimeException(" клиенты могут посещать тренажерный зал и групповые занятия");
        // также в зависимости от типа абонимента  вносим в выдаваемый абонимент время по которому будут проводиться занятия
        int startDate = 0;
        int endDate = 0;
        if (subscriptionType == SubscriptionType.SINGLE) {
            startDate = 8;
            endDate = 22;
        }
        if (subscriptionType == SubscriptionType.DAY) {
            startDate = 8;
            endDate = 16;
        }
        this.subscription = new Subscription(client, startDate, endDate, zoneType, subscriptionType);
    }
    // здесь по заполненному абонименту нужно записать его в выбранную зону
    void AdditionZone(){
        zone.AddZone(this.subscription, zoneType);
    }
}
