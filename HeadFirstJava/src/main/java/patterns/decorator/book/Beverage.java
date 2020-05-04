package patterns.decorator.book;

public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public void nameYourself() {
        System.out.println(getDescription() + " $" + cost());
    }

    public abstract double cost();
}
