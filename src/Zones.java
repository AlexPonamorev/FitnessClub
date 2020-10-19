import java.time.LocalDateTime;
import java.util.Objects;
//  Посетитель не может пройти, если абонемент просрочен,
//  если он пытается пройти в зону, которая не разрешена по его абонементу,
//  если в зоне нет свободных мест.

// Абонемент не может быть зарегистрирован одновременно в нескольких зонах.

// Реализовать возможность вывода информации о посетителях:
// сначала посетителях тренажерного зала, потом бассейна, потом групповых занятий.
public class Zones {

    int countClient = 0;
    static private LocalDateTime currentDate;
/*
    public void setCurrentDate() {
        this.currentDate = LocalDateTime.now();
    }*/

    public static int getCurrent() {
        return currentDate.getHour();
    }
    // зона знает про абонимент
    // зона знает про фитнесс
    // зона хранит три массива с знами

    Subscription subscription;
    Client client;
    Reception reception;
    ZoneType zoneType;
    // зона спрашивает у фитнеса куда сейчас записывать

    private final int MAX = 20;
    private Subscription[] pooL;
    private Subscription[] gyM;
    private Subscription[] grouP;


    public void Zones() {
        this.pooL = new Subscription[MAX];
        this.gyM = new Subscription[MAX];
        this.grouP = new Subscription[MAX];
        this.currentDate = LocalDateTime.now();
    }

    // етекущее время не попадает в период действия абониметна
    private boolean isNoValidTime(Subscription subscription,Zones zones) {
        if (subscription.getEndTime() < zones.getCurrent() ||
                subscription.getStartTime() > zones.getCurrent()) {
            return true;
        }
        return false;
    }
// здесь должен быть метод проверяющий, есть ли такой абонемент в базе клентов
    private boolean isNoValidZone(PersonSubscribe personSubscribe) {

         }

    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
