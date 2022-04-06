package notifier;

public class Dove implements Subscriber{
    @Override
    public void react() {
        System.out.println("Dove reacting");
    }
}
