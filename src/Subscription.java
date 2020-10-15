abstract public class Subscription {
//private DaySub [] daySubs = new DaySub[20];
//private FullSub[] fullSubs = new FullSub[20];
//private OneSub[] oneSubs = new OneSub[20];
private Client client;
private enum ZoneType{ POOL,GUM,GROUP};
int VisitTime;



    int Valid;
// здесь протектед метод узнать активен ли абонимент в заданное время
    // на вход принимаю время - либо в качестве параметра либо системное
    // на выход false/ true
    public void setInfo(ZoneType zoneType, Client client,int time){
        // вызов конструктора для клиента ?

    }

    protected  boolean IsValid(ZoneType zoneType, int VisitTime){
        // методы
        // отправляю время в классы
        // получаю ответ ДА или НЕТ
        return false;
    }


}
