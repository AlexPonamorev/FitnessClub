public class Subscription {

    private Client client;
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;
    private int startDate;
    private int endDate;

    // здесь протектед метод узнать активен ли абонимент в заданное время
    // на вход принимаю время - либо в качестве параметра либо системное
    // на выход false/ true
    Subscription(Client client, int startDate, int endDate, ZoneType zoneType, SubscriptionType subscriptionType) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        SetOption();

    }

    void SetOption() {
        this.zoneType = zoneType;
        this.subscriptionType = subscriptionType;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }
}
