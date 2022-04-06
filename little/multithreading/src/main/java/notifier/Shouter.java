package notifier;

import java.util.ArrayList;
import java.util.List;

public class Shouter {

    private List<Subscriber> subscribers = new ArrayList<>();

    public void notifySubscribers() {
        subscribers.forEach(Subscriber::react);
    }

    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }

    public void deleteSubscriber(Subscriber s) {
        subscribers.remove(s);
    }
}
