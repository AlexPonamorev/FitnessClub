public class PersonSubscribe {

    private Subscription subscription;
    ZoneType zoneType2;
    int clientID = 0; // уменьшится ли при удалении обьекта ?
    SubscriptionType subscriptionType;

    public PersonSubscribe(Subscription subscription) {
        clientID = (int) (Math.random() * 20); // 0 - 20 в теориии может совпасть
        this.subscription = subscription;
    }

    public int getClientID() {
        return clientID;
    }

    public ZoneType getZoneType() {
        return subscription.getZoneType();
    }

    public int getStartTime() {
        return subscription.getStartTime();
    }

    public int getEndTime() {
        return subscription.getEndTime();
    }

    public String getNameString() {
        return subscription.toString();
    }

    public Client getClient() {
        return subscription.getClient();
    }

    @Override
    public String toString() {
        return " Client " + subscription.getClient().toString();
    }
}
