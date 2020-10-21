import java.time.LocalDateTime;
import java.util.Objects;

public class Zones {
    //ZoneType zoneType;
    private final int MAX = 20;
    private Client client;
    private int[] pooL;
    private int[] gyM;
    private int[] grouP;
    private Client[] poolClients;
    private Client[] gumClients;
    private Client[] groupClients;
    public int currentDate;

    // на зону приходит клиен и сообщает куда хочет попасть
    public Zones() {
        this.pooL = new int[MAX];
        this.gyM = new int[MAX];
        this.grouP = new int[MAX];
        this.poolClients = new Client[MAX];
        this.gumClients = new Client[MAX];
        this.groupClients = new Client[MAX];
    }

    // Проверка на то что тетекущее время попадает в период действия абонеметна
    private boolean isNoValidTime(Subscription subscription) { // не знаю как тут сработает Zones zones - ведь это ссылка
        if (subscription.getEndTime() < currentDate ||                     // можно попробовать
                subscription.getStartTime() > currentDate) {
            return true;
        }
        return false;
    }

    public boolean checkingForAvailability(int ID) {
        for (int i = 0; i < pooL.length; ++i) {
            if (pooL[i] == ID) return true;
            if (gyM[i] == ID) return true;
            if (grouP[i] == ID) return true;
        }
        return false;
    }

    public void addPerson(Subscription subscription, ZoneType zoneType, int currentDate) {

        //this.zoneType = zoneType;
        this.currentDate = currentDate;

        if (isNoValidTime(subscription)) {
            System.out.println(subscription.toString() + " " + Information.NO_TIME);
            return;
        }
        if (subscription.getZoneType() != zoneType)
            System.out.println(subscription.toString() + " " + Information.NO_ENTRY);

        if (subscription.getZoneType() == ZoneType.GYM) {
            detectClient(subscription.getClient(), ZoneType.GYM);
            addPerson(gyM, subscription.getClientID());
        } else if (subscription.getZoneType() == ZoneType.GROUP) {
            detectClient(subscription.getClient(), ZoneType.GROUP);
            addPerson(grouP, subscription.getClientID());
        } else if (subscription.getZoneType() == ZoneType.POOL) {
            detectClient(subscription.getClient(), ZoneType.POOL);
            addPerson(pooL, subscription.getClientID());
        }
    }

    // не использую методов с шаблонными параметрами потому что не хочу)
    // запись в картотеку нужной зоны
    private void addPerson(int[] clients, int ClientID) {
        for (int i = 0; i < clients.length; ++i) {
            if (Objects.isNull(clients[i])) {
                clients[i] = ClientID;
                return; // else
            }
        }
    }

    private void addClient(Client[] client, Client clients) {
        for (int i = 0; i < client.length; ++i) {
            if (Objects.isNull(client[i])) {
                client[i] = clients;
                return; // else
            }
        }
        System.out.println(Information.IS_CROWDED);
    }

    public void detectClient(Client client, ZoneType zoneType) {
        System.out.println(Information.FIX_CLIENT);
        System.out.println(client.toString()
                + "\n   Дата посещения фитнесс зала: " + currentDate + "ч"
                + "\n   Зона: " + zoneType);
    }


    public void printClientsZone(ZoneType zoneType) {
        switch (zoneType) {
            case GYM:
                print(gumClients);
                break;
            case POOL:
                print(poolClients);
                break;
            case GROUP:
                print(groupClients);
                break;
            default:
                throw new IllegalArgumentException(Information.INVALID_INPUT);
        }
    }

    private void print(Client[] client) {
        for (int i = 0; i < client.length; i++) {
            if (Objects.nonNull(client[i])) {
                System.out.println("Посетитель фитнес клуба------------------");
                System.out.println(client[i].toString());
                System.out.println();
            }
        }
    }
}
