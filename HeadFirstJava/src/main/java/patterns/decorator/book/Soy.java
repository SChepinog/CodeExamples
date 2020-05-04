package patterns.decorator.book;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}
