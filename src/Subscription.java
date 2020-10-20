import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Subscription {

    private Client client;
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;
    private LocalTime startTime;  //начало возможного посещения
    private LocalTime endTime;   // конец времени возможного посещения

    protected Subscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        if (Objects.isNull(client))
            throw new IllegalArgumentException(Information.OBJECT_IS_NULL);
        this.client = client;
        this.zoneType = zoneType;
        this.subscriptionType = subscriptionType;
        setStartAndEndTime();
    }

    public ZoneType getZoneType() {
        return zoneType;
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

}
