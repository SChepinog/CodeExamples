package dollar;

import java.util.Hashtable;

public class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String source, String target, int rate) {
        rates.put(Pair.of(source, target), rate);
    }

    public int rate(String from, String to) {
        return from.equals(to)
                ? 1
                : rates.get(Pair.of(from, to));
//        return "CHF".equals(from) && "USD".equals(to) ? 2 :1;
    }
}
