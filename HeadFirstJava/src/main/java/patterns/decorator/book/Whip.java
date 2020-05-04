package patterns.decorator.book;

public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .1;
    }
}
