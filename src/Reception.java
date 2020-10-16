public class Reception {
    Subscription subscribe(Client client,ZoneType zoneType,SubscriptionType subscriptionType){
       // if (SubscriptionType ==SubscriptionType.SINGLE) //
        if(subscriptionType == SubscriptionType.SINGLE && zoneType ==ZoneType.GROUP)
            throw new RuntimeException(" разовый абонимент можно купить басс и качалку");
        if(subscriptionType == SubscriptionType.DAY && zoneType == ZoneType.POOL)
            throw new RuntimeException("дневной не может включать бассейн");

        int startDate = 0;
        int endDate = 12;
        return new Subscription(client,startDate, endDate,zoneType,subscriptionType);

    }

}
