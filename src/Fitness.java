import java.time.LocalDateTime;
import java.util.Objects;

public class Fitness {
    private LocalDateTime currentDate;
    private int currentHour;

    private ZoneType zoneType;
    private ZoneType zoneType2;
    SubscriptionType subscriptionType;
    private Client client;
    private Reception reception;
    private Zones zones;
   // private int clientID;
    private Subscription subscription;

    public Fitness() {
        this.zones = new Zones();// созданы три зоны
        this.reception = new Reception(); // создана картотека
        this.currentDate = LocalDateTime.now();
        this.currentHour = currentDate.getHour();
    }

    // клиент приходит на ресепшн и запрашивает абонемент с нужной зоной и желаеммым графиком
    public Subscription writeAndGiveMeNewSubscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        reception.subscribe(client, zoneType, subscriptionType);
        subscription = new Subscription();
        subscription  = reception.getPersonSubscribe();
        return subscription;
    }

    // клиент приходит со своим абониментом и запрашивает зону
    public void addPerson(Subscription subscription, ZoneType zoneType,int currentHour) {
        int ID = subscription.getClientID();// запрашиваю ID клиента
        if (zones.checkingForAvailability(ID)){
           System.out.println(" посетитель уже есть на зоне ");
           return;
        }
        else zones.addPerson(subscription,zoneType,currentHour);

        // проверяю есть ли клиент с таким ID уже на зоне
        //for(int i )


    }
    //1 фитнесс должен прийти с клиентом N на ресепшн и узнать есть ли такой клиент в базе
    //2 если есть то проверить на предмет совпадения запрашиваемой зоны и зоны в абонементе
    //3 если совпадает то проверить вовремя ли он пришел
}


