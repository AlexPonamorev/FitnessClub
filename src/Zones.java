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
    private PersonSubscribe[] pooL;
    private PersonSubscribe[] gyM;
    private PersonSubscribe[] grouP;
    public int currentDate;
// на зону приходит клиен и сообщает куда хочет попасть
    public Zones() {
        this.pooL = new PersonSubscribe[MAX];
        this.gyM = new PersonSubscribe[MAX];
        this.grouP = new PersonSubscribe[MAX];

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

    public void addAbonement(PersonSubscribe personSubscribe,ZoneType zoneType,int currentDate) {
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
            detectClient(abonement, gym);
            gym.addAbonement(personSubscribe.clientID);
        } else if (personSubscribe.getZoneType() == ZoneType.GROUP) {
            detectClient(abonement, group);
            group.addAbonement(personSubscribe.clientID);
        } else if (personSubscribe.getZoneType() == ZoneType.POOL) {
            detectClient(abonement, pool);
            pool.addAbonement(personSubscribe.clientID);
        }
    }
/*
    public void printInfoAboutClients() {
        printClientsZone(gym);
        printClientsZone(pool);
        printClientsZone(group);
    }
*/
    public void detectClient(PersonSubscribe personSubscribe, ZoneType zoneType) {
        System.out.println(InfoMessage.FIX_CLIENT);
        System.out.println("   Фамилия: " + abonement.getClient().getSurName()
                + "\n   Имя: " + abonement.getClient().getName()
                + "\n   Дата посещения фитнесс зала: " + abonement.getCurrentDate()
                + "\n   Зона: " + zoneType);
    }


    private void printClientsZone(Zone zone) {
        for (int i = 0; i < zone.getAbonements().length; i++) {
            if (Objects.nonNull(zone.getAbonements()[i])) {
                System.out.println("Посетитель фитнес клуба------------------");
                System.out.println(zone.getAbonements()[i].toString());
                System.out.println();
            }
        }
    }
}
