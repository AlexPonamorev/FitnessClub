public class Zone {
    //private Subscription []subscriptions;
    int countClient = 0;
    public enum ZoneType{POOL,GUM,GROUP};
    boolean subscribe(Subscription subscription) {
        if (countClient < 20) {
            countClient++;
            return true;
        } else return false;

    }

}
