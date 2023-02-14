package dollar;

public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return new Money(bank.reduce(augend, to).amount + bank.reduce(addend, to).amount, to);
    }

    @Override
    public Expression times(int rate) {
        return null;
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }
}
