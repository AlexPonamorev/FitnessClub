// здесь создаю и заполняю поля заполняю поля абонимента.
public class Reception {
    Subscription subscribe(Client client,ZoneType zoneType,SubscriptionType subscriptionType){
       // проверки на тип абонимента
        if(subscriptionType == SubscriptionType.SINGLE && zoneType == ZoneType.GROUP)
            throw new RuntimeException(" клиенты могут посещать бассейн и тренажерный зал ");
        if(subscriptionType == SubscriptionType.DAY && zoneType == ZoneType.POOL)
            throw new RuntimeException(" клиенты могут посещать тренажерный зал и групповые занятия");
        // также в зависимости от типа абонимента  вносим в выдаваемый абонимент время по которому будут проводиться занятия
        int startDate = 0;
        int endDate = 0;
        if (subscriptionType == SubscriptionType.SINGLE) {startDate = 8; endDate = 22;};
        if(subscriptionType == SubscriptionType.DAY) {startDate = 8; endDate = 16;};


        return new Subscription(client,startDate, endDate,zoneType,subscriptionType);

    }

}
