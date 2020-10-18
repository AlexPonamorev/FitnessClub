import java.time.LocalDateTime;
import java.time.LocalTime;

public class Subscription {

    private Client client;
    private ZoneType zoneType;
    private SubscriptionType subscriptionType;
    private LocalDateTime currentDate;
    private LocalTime startTime;
    private LocalTime endTime;

    protected Subscription(Client client, ZoneType zoneType,SubscriptionType subscriptionType) {
        this.client = client;
        setStartAndEndTime();
        SetOption();
    }

    public void SetOption() {
        this.zoneType = zoneType;
        this.subscriptionType = subscriptionType;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

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

    public void setCurrentDate() {
        this.currentDate = LocalDateTime.now();

    }

    public int getStartTime(){
        return startTime.getHour();
    }

    public int getCurrentHour() {
        return currentDate.getHour();
    }

    public int getEndTime() {
        return endTime.getHour();
    }

}
