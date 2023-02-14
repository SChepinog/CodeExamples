package dollar;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression times(int rate);

    Expression plus(Expression addend);
}
