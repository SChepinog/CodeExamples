package patterns.decorator.book;

public class Milk extends CondimentDecorator {

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + .1;
    }
}
