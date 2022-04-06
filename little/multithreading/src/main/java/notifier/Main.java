package notifier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        double a = 40d;
        System.out.println(String.format(Locale.US,"nanana, %.2f", a));

        System.out.println(String.format(Locale.US,"SELECT fn_get_min_retail_price('%s', '%s', %.2f, %.2f)",
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            "nanana",
            a,
            23.45));


        Shouter shouter = new Shouter();
        Parrot parrot = new Parrot();
        shouter.addSubscriber(parrot);
        Dove dove = new Dove();
        shouter.addSubscriber(dove);

        shouter.notifySubscribers();
        Thread.sleep(1000);
        shouter.notifySubscribers();
    }
}
