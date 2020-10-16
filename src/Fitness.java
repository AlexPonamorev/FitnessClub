public class Fitness {
    // абонимент проверяется фитнесом на валидность
    // где установит время?
    boolean Status;
//Client client,ZoneType zoneType,SubscriptionType subscriptionType
    private Zone pooL ;
    private Zone gyM;
    private Zone grouP;

    private Reception reception;
    private Subscription subscription ;

    public Fitness(){
       pooL = new Zone();
       gyM = new Zone();
       grouP = new Zone();
    }
    // здесь хочу создать абонимент
    public Subscription makesSub(Client client,ZoneType zoneType,SubscriptionType subscriptionType){
      return reception.subscribe(client,zoneType,subscriptionType);
    }
    // здесь нужно отправить чувака в определенную зону
    void AddZone(){
      if (subscription.getZoneType() == ZoneType.POOL){
          pooL.AddZone(subscription,ZoneType.POOL);
      }
        if (subscription.getZoneType() == ZoneType.GYM){
            pooL.AddZone(subscription,ZoneType.GYM);
        }
        if (subscription.getZoneType() == ZoneType.GROUP){
            pooL.AddZone(subscription,ZoneType.GROUP);
        }
    }




// pool.subscribe() - метод узнать что в зоне есть места
     //открыт - закрыт
    // массив абонементов в тренажере
    // массив абонементов в бассейне
    // массив абонементов на груп. занятиях
// фитнесс принимает время и клиента
    

}
