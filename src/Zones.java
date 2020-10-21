import java.time.LocalDateTime;
import java.util.Objects;
//  Посетитель не может пройти, если абонемент просрочен,
//  если он пытается пройти в зону, которая не разрешена по его абонементу,
//  если в зоне нет свободных мест.

// Абонемент не может быть зарегистрирован одновременно в нескольких зонах.

// Реализовать возможность вывода информации о посетителях:
// сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
public class Zones {
    private PersonSubscribe personSubscribe;
    ZoneType zoneType;
    private final int MAX = 20;
    private int[] pooL;
    private int[] gyM;
    private int[] grouP;
    public int currentDate;
// на зону приходит клиен и сообщает куда хочет попасть
    public Zones() {
        this.pooL = new int[MAX];
        this.gyM = new int[MAX];
        this.grouP = new int[MAX];

    }

    // Проверка на то что тетекущее время попадает в период действия абонеметна
    //
    private boolean isNoValidTime(PersonSubscribe personSubscribe) { // не знаю как тут сработает Zones zones - ведь это ссылка
        if (personSubscribe.getEndTime() < currentDate ||                     // можно попробовать
                personSubscribe.getStartTime() > currentDate) {
            return true;
        }
        return false;
    }

    public void addPerson(PersonSubscribe personSubscribe,ZoneType zoneType,int currentDate) {
        //abonement.fixCurrentDate();
        this.personSubscribe = personSubscribe;
        this.zoneType = zoneType;
        this.currentDate = currentDate;

        if (isNoValidTime(personSubscribe)) {
            System.out.println(personSubscribe.toString() + " " + Information.NO_TIME);
            return;
        }
        if (personSubscribe.getZoneType() != zoneType)
            System.out.println(personSubscribe.toString() + " " + Information.NO_ENTRY);

        if (personSubscribe.getZoneType() == ZoneType.GYM) {
            detectClient(personSubscribe, ZoneType.GYM);
            addPerson(gyM,personSubscribe.clientID);
        } else if (personSubscribe.getZoneType() == ZoneType.GROUP) {
            detectClient(personSubscribe, ZoneType.GROUP);
            addPerson(grouP,personSubscribe.clientID);
        } else if (personSubscribe.getZoneType() == ZoneType.POOL) {
            detectClient(personSubscribe, ZoneType.POOL);
            addPerson(pooL,personSubscribe.clientID);
        }
    }
/*
    public void printInfoAboutClients() {
        printClientsZone(gym);
        printClientsZone(pool);
        printClientsZone(group);
    }
*/
// запись в картотеку нужной зоны
private void addPerson(int [] clients, int ClientID) {
    for (int i = 0; i < clients.length; ++i) {
        if (Objects.isNull(clients[i])) {
            clients[i] = ClientID;
            return; // else
        }
    }
    System.out.println(Information.IS_CROWDED);
}

    public void detectClient(PersonSubscribe personSubscribe, ZoneType zoneType) {
        System.out.println(Information.FIX_CLIENT);
        System.out.println(personSubscribe.toString()
                + "\n   Дата посещения фитнесс зала: " + currentDate
                + "\n   Зона: " + zoneType);
    }

/*
    private void printClientsZone() {
        for (int i = 0; i < zone.getAbonements().length; i++) {
            if (Objects.nonNull(zone.getAbonements()[i])) {
                System.out.println("Посетитель фитнес клуба------------------");
                System.out.println(zone.getAbonements()[i].toString());
                System.out.println();
            }
        }
    }*/


}
