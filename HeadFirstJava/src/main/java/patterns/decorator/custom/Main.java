package patterns.decorator.custom;

public class Main {

    public static void main(String[] args) {
        Beverage darkCoffee = new DarkRoast();
        Beverage coffeeWithWhip = new DarkRoast().with(new Whip());
        Beverage coffeeWithMocha = new DarkRoast().with(new Mocha());
        Beverage mocha = new DarkRoast().with(new Mocha()).with(new Whip());
        Beverage mochaWithWhip = new Mocha().with(new Whip());

        System.out.println(darkCoffee.getCost());
        System.out.println(coffeeWithWhip.getCost());
        System.out.println(coffeeWithMocha.getCost());
        System.out.println(mocha.getCost());
        System.out.println(mochaWithWhip.getCost());
    }
}
