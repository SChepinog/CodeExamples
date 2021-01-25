package patterns.factory.simple_factory;

public class SimplePizzaFactory {

    public Pizza createPizza(String pizzaName) {
        Pizza pizza;
        switch (pizzaName) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
            case "clam":
                pizza = new ClamPizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException("Unknown pizza name!");
        }
        return pizza;
    }

}
