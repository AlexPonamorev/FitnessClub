import java.sql.ClientInfoStatus;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Subscription {

    private Client client;
    private ZoneType zoneType;  // зона для возможного посещения
    private SubscriptionType subscriptionType;
    private LocalTime startTime;  //начало возможного посещения
    private LocalTime endTime;   // конец времени возможного посещения
    private int clientID;
    private ZoneType[] zones; // разрешенные для посещения зоны
    public Subscription() {
    }

    // какой здесь модификатора если иего будут использовать только другие классы но не из main?
    public Subscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType, int clientID, ZoneType[] zones) {
        if (Objects.isNull(client))
            throw new IllegalArgumentException(Information.OBJECT_IS_NULL);
        this.client = client;
        this.subscriptionType = subscriptionType;
        setStartAndEndTime();
        this.clientID = clientID;
        this.zones = zones;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

    public ZoneType[] getListOfAllowedZones(){ return  zones;}

    public int getClientID() {
        return clientID;
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

    public int getStartTime() {
        return startTime.getHour();
    }

    public int getEndTime() {
        return endTime.getHour();
    }

    public Client getClient() {
        return client;
    }
    @Override
    public String toString() {
    return client.toString();
    }
}
