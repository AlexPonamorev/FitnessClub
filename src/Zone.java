public class Zone {
    //private Subscription []subscriptions;
    //public enum ZoneType{POOL,GUM,GROUP};
    int countClient = 0;

    // метод чтобы записать абонимента в зону
    // возвращает true в случае успеха

    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
