import java.time.LocalDateTime;
import java.util.Objects;
//  Посетитель не может пройти, если абонемент просрочен,
//  если он пытается пройти в зону, которая не разрешена по его абонементу,
//  если в зоне нет свободных мест.

// Абонемент не может быть зарегистрирован одновременно в нескольких зонах.

// Реализовать возможность вывода информации о посетителях:
// сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
public class Zones {
    //private PersonSubscribe personSubscribe;
    ZoneType zoneType;
   // Subscription subscription;
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
    private boolean isNoValidTime(Subscription subscription) { // не знаю как тут сработает Zones zones - ведь это ссылка
        if (subscription.getEndTime() < currentDate ||                     // можно попробовать
                subscription.getStartTime() > currentDate) {
            return true;
        }
        return false;
    }

    public boolean checkingForAvailability(int ID){
        for (int i = 0; i< pooL.length; ++i){
            if(pooL[i] == ID) return true;
            if(gyM[i] == ID) return true;
            if (grouP[i] == ID) return true;
        }
        return false;
    }
    public void addPerson(Subscription subscription,ZoneType zoneType,int currentDate) {

        this.zoneType = zoneType;
        this.currentDate = currentDate;

        if (isNoValidTime(subscription)) {
            System.out.println(subscription.toString() + " " + Information.NO_TIME);
            return;
        }
        if (subscription.getZoneType() != zoneType)
            System.out.println(subscription.toString() + " " + Information.NO_ENTRY);

        if (subscription.getZoneType() == ZoneType.GYM) {
            detectClient(subscription, ZoneType.GYM);
            addPerson(gyM,subscription.getClientID());
        } else if (subscription.getZoneType() == ZoneType.GROUP) {
            detectClient(subscription, ZoneType.GROUP);
            addPerson(grouP,subscription.getClientID());
        } else if (subscription.getZoneType() == ZoneType.POOL) {
            detectClient(subscription, ZoneType.POOL);
            addPerson(pooL,subscription.getClientID());
        }
    }
/*
    public void printInfoAboutClients() {
        printClientsZone(gym);
        printClientsZone(pool);
        printClientsZone(group);
    }
*/
   // public int getClientID (Subscription subscription){
   //     return subscription.getClientID();
  //  }
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

    public void detectClient(Subscription subscription, ZoneType zoneType) {
        System.out.println(Information.FIX_CLIENT);
        System.out.println(subscription.toString()
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
