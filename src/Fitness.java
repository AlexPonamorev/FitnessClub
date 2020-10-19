import java.util.Objects;

public class Fitness {
    private ZoneType zoneType;
    private ZoneType zoneType2;
    SubscriptionType subscriptionType;
    private Client client;
    private Reception reception;
    private Zones zones;


    public Fitness(){
        this.zones = new Zones();// созданы три зоны
        this.reception = new Reception(); // создана картотека
    }
    // клиент приходит на ресепшн и запрашивает абонемент с нужной зоной и желаеммым графиком
    public void makeSubscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        reception.subscribe(client, zoneType,subscriptionType);
    }
    // клиент приходит со своим абониментом и запрашивает зону
    public void subscribeZone(Client client,SubscriptionType subscriptionType2){
        //zones.subscribe(client,zoneType2,subscriptionType2);
    }
    //1 фитнесс должен прийти с клиентом N на ресепшн и узнать есть ли такой клиент в базе
    //2 если есть то проверить на предмет совпадения запрашиваемой зоны и зоны в абонементе
    //3 если совпадает то проверить вовремя ли он пришел




}
