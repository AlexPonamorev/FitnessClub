import java.time.LocalDateTime;
import java.util.Objects;

public class Fitness {
    public static LocalDateTime currentDate;



    private ZoneType zoneType;
    private ZoneType zoneType2;
    SubscriptionType subscriptionType;
    private Client client;
    private Reception reception;
    private Zones zones;


    public Fitness() {
        this.zones = new Zones();// созданы три зоны
        this.reception = new Reception(); // создана картотека
        this.currentDate = LocalDateTime.now();
    }

    // клиент приходит на ресепшн и запрашивает абонемент с нужной зоной и желаеммым графиком
    public void makeSubscription(Client client, ZoneType zoneType, SubscriptionType subscriptionType) {
        reception.subscribe(client, zoneType, subscriptionType);
    }

    // клиент приходит со своим абониментом и запрашивает зону
    public void subscribeZone(PersonSubscribe personSubscribe, ZoneType zoneType) {
        //zones.subscribe(client,zoneType2,subscriptionType2);
    }
    //1 фитнесс должен прийти с клиентом N на ресепшн и узнать есть ли такой клиент в базе
    //2 если есть то проверить на предмет совпадения запрашиваемой зоны и зоны в абонементе
    //3 если совпадает то проверить вовремя ли он пришел
}

/*
    enum Priority{
        HIGT(100),MIDDLE(100); // момент создания объекта - если параметры не заданы то
         private  int code; // если поле будет паблик то можно обращаться к полю без всяких сеттеров и геттеров

         Priority (int code){
             this.code = code;
         }

         public int getCode(){ // достиупен все объекта перечисления
             return code;
         }

        public void setCode(int code) { // достиупен все объекта перечисления вызываются для каждого члена перечесления
            this.code = code;
        }
    }

    class SomeClass{
        private  EnumInClass enumInClass;

        public SomeClass (EnumInClass enumInClass){
            this.enumInClass = enumInClass;
        }

        public enum EnumInClass{
            ONE,TWO,TREE
        }
    }

}

/*
Country byString = Country.valueOf("USA"); // вернет Country.USA - если такое значение есть в перечислении либо исключение
String countryName = Country.AUSTRALIA.name();
  System.out.print(countryName)// приведение к строке

в enum можем добавлять конструкторы
геттеры и сеттеры - будут без реализации и доступны всем членам перечесления



 */
