public class DaySub extends Subscription{
    protected boolean timeValid(int time){
        if (time > 8 && time < 22)
            return true;
        else return false;
    }
}
