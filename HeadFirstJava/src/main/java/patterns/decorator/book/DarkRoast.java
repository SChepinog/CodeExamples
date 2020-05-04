package patterns.decorator.book;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "RadkRoast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
