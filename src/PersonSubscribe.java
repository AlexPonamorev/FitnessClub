public class PersonSubscribe {

    private Subscription subscription;
    ZoneType zoneType2;
    static int clientID = 0;

    SubscriptionType subscriptionType;
    public PersonSubscribe(Subscription subscription) {
        clientID++;
    }
    public int getclientID(){
       return clientID;
    }

}
