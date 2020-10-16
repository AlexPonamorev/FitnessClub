public class Subscription {
//private DaySub [] daySubs = new DaySub[20];
//private FullSub[] fullSubs = new FullSub[20];
//private OneSub[] oneSubs = new OneSub[20];
private Client client;
//private enum ZoneType{ POOL,GUM,GROUP};
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;
    private int startDate;
    private int endDate;


// здесь протектед метод узнать активен ли абонимент в заданное время
    // на вход принимаю время - либо в качестве параметра либо системное
    // на выход false/ true
 Subscription(Client client, int startDate, int endDate, ZoneType zoneType, SubscriptionType subscriptionType){
     this.client = client;
     this.startDate = startDate;
     this.endDate = endDate;
     SetOption();

 }
 void SetOption(){
     this.zoneType = zoneType;
     this.subscriptionType = subscriptionType;
 }

    public ZoneType getZoneType() {
        return zoneType;
    }
}
