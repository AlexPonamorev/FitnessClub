public class Fitness {
    // абонимент проверяется фитнесом на валидность
    // где установит время?
    boolean Status;

    ZoneType zoneType;
    SubscriptionType subscriptionType;

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    //Client client,ZoneType zoneType,SubscriptionType subscriptionType
    private Zone[] pooL;
    private Zone[] gyM;
    private Zone[] grouP;

    // Здесь у фитнеса можно запросить желаемую зону
    public Zone getZone(ZoneType zoneType) {
        switch (zoneType) {
            case POOL:
                return pooL[20];
            case GYM:
                return gyM[20];
            case GROUP:
                return grouP[20];
            default:
                throw new IllegalArgumentException();
        }
    }

    private Reception reception;

    public void SetReception() {
        reception = new Reception();
    }

    //private Subscription subscription;
    // создаю ссылку на клиента когад клиент приходит в фитнесс - инициализирую ее клиентом в сеттере
    private Client client;

    public void SetClientANDZone(Client client) {
        this.client = new Client();

    }

    // отправляю клиента на ресепшн с его пожеланиями
    public void SetSubscribtion() {
        reception.subscribe(this.client, this.zoneType, this.subscriptionType);
    }
    public void AdditionZone(){
        reception.AdditionZone();
    }


    public Fitness() {
        pooL = new Zone[20];
        gyM = new Zone[20];
        grouP = new Zone[20];
    }
}
