public class Fitness {
    // абонимент проверяется фитнесом на валидность
    // где установит время?
    boolean Status;
    //Client client,ZoneType zoneType,SubscriptionType subscriptionType
    private Zone pooL;
    private Zone gyM;
    private Zone grouP;
    // а почему он серый ? как этот класс работает
    private Reception reception;
    private Subscription subscription;

    public Zone getZone(ZoneType zoneType) {
        switch (zoneType) {
            case POOL:
                return pooL;
            case GYM:
                return gyM;
            case GROUP:
                return grouP;
            default: throw new IllegalArgumentException();
        }
    }


    public Fitness() {
        pooL = new Zone();
        gyM = new Zone();
        grouP = new Zone();
    }

    public void SetSubscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        this.subscription = this.reception.subscribe(client, zoneType, subscriptionType);
    }

    // здесь нужно отправить чувака в определенную зону
    void AddZone() {
        if (this.subscription.getZoneType() == ZoneType.POOL) {
            pooL.AddZone(subscription, ZoneType.POOL);
        }
        if (this.subscription.getZoneType() == ZoneType.GYM) {
            pooL.AddZone(subscription, ZoneType.GYM);
        }
        if (this.subscription.getZoneType() == ZoneType.GROUP) {
            pooL.AddZone(subscription, ZoneType.GROUP);
        }
    }


// pool.subscribe() - метод узнать что в зоне есть места
    //открыт - закрыт
    // массив абонементов в тренажере
    // массив абонементов в бассейне
    // массив абонементов на груп. занятиях
// фитнесс принимает время и клиента


}
