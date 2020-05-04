package patterns.decorator.book;

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .2;
    }
}
