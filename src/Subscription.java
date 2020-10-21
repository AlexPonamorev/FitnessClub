import java.sql.ClientInfoStatus;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Subscription {

    private Client client;
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;
    private LocalTime startTime;  //начало возможного посещения
    private LocalTime endTime;   // конец времени возможного посещения
    private int clientID;

    public Subscription() {
    }

    public Subscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType, int clientID) {
        if (Objects.isNull(client))
            throw new IllegalArgumentException(Information.OBJECT_IS_NULL);
        this.client = client;
        this.zoneType = zoneType;
        this.subscriptionType = subscriptionType;
        setStartAndEndTime();
        this.clientID = clientID;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

    public int getClientID() {
        return clientID;
    }
    //public SubscriptionType getSubscriptionType() {
    //   return subscriptionType;
    //}

    private void setStartAndEndTime() {
        switch (this.subscriptionType) {
            case SINGLE:
            case FULL:
                this.startTime = LocalTime.of(8, 0);
                this.endTime = LocalTime.of(22, 0);
                break;
            case DAY:
                this.startTime = LocalTime.of(8, 0);
                this.endTime = LocalTime.of(16, 0);
                break;
        }
    }

    public int getStartTime() {
        return startTime.getHour();
    }

    public int getEndTime() {
        return endTime.getHour();
    }

    public Client getClient() {
        return client;
    }

}
