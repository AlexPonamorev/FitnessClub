public class menu {
    public static void main(String[] args) {
        Client Alex = new Client("Alex", "QWERTY", 1991);
        Fitness fitness = new Fitness();
        Subscription newSubscribtionAlex = new Subscription();

        newSubscribtionAlex = fitness.writeAndGiveMeNewSubscription(Alex, ZoneType.GYM, SubscriptionType.DAY);
        fitness.addPerson(newSubscribtionAlex, ZoneType.GYM);
    }


}
