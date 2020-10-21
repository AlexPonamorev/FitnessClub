import java.time.LocalDateTime;
import java.util.Objects;

public class Fitness {
    private LocalDateTime currentDate;
    private int currentHour;
    private Reception reception;
    private Zones zones;
    private Subscription subscription;
    Information information;

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
        subscription = reception.getPersonSubscribe();
        return subscription;
    }

    // клиент приходит со своим абониментом и запрашивает зону
    public void addPerson(Subscription subscription, ZoneType zoneType) {
        int ID = subscription.getClientID();// запрашиваю ID клиента
        if (zones.checkingForAvailability(ID)) {
            System.out.println(information.ALREADY_HERE);
            return;
        } else zones.addPerson(subscription, zoneType, currentHour);

    }
}


