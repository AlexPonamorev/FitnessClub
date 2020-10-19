import java.util.Objects;

public class Fitness {
    // абонимент проверяется фитнесом на валидность
    // где установит время?
    boolean Status;

    private ZoneType zoneType;
    private ZoneType zoneType2;
    SubscriptionType subscriptionType;
    private Client client;
    private Reception reception;
    private Zones zones;


    public Fitness(){
        this.zones = new Zones();
        this.reception = new Reception();
    }
    // здесь я создаю ресепшн
    // иначе никак, так как внешний интерфейс программ не знает ничего про класс Reception
    // и туда отправляем клиента
    // клиент по УСЛОВИЮ приходит на ресепшн со знанием зоны и рассисания ее работы (дельта времени)
    public void makeSubscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        reception.subscribe(client, zoneType,subscriptionType);
    }
    // клиент приходит со своим абониментом и запрашивает зону
    public void subscribeZone(Client client,SubscriptionType subscriptionType2){
        zones.subscribe(client,subscriptionType2);
    }




}
