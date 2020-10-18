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

    // здесь я создаю ресепшн
    // иначе никак, так как внешний интерфейс программ не знает ничего про класс Reception
    // и туда отправляем клиента
    // клиент по УСЛОВИЮ приходит на ресепшн со знанием зоны и рассисания ее работы (дельта времени)
    public void subcribe(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        this.reception = new Reception();
        reception.subscribe(client, zoneType, subscriptionType);

    }

    public void SetClientANDZone(Client client) {
        this.client = new Client();

    }

    // отправляю клиента на ресепшн с его пожеланиями
    public void SetSubscribtion() {
        reception.subscribe(this.client, this.zoneType, this.subscriptionType);
    }

}
