package patterns.factory.factory_method;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        switch (pizzaName) {
            case "cheese":
                pizza = new NYCheesePizza();
                break;
            case "veggie":
                pizza = new NYVeggiePizza();
                break;
            case "clam":
                pizza = new NYClamPizza();
                break;
            case "pepperoni":
                pizza = new NYPepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException("Unknown pizza name!");
        }
        return pizza;
    }

}
