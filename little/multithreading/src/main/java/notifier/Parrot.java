package notifier;

public class Parrot implements Subscriber{
    @Override
    public void react() {
        System.out.println("Parrot reacting");
    }
}
