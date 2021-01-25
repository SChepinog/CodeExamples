package patterns.factory.factory_method;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String pizzaName) {
        Pizza pizza;
        switch (pizzaName) {
            case "cheese":
                pizza = new ChicagoCheesePizza();
                break;
            case "veggie":
                pizza = new ChicagoVeggiePizza();
                break;
            case "clam":
                pizza = new ChicagoClamPizza();
                break;
            case "pepperoni":
                pizza = new ChicagoPepperoniPizza();
                break;
            default:
                throw new IllegalArgumentException("Unknown pizza name!");
        }
        return pizza;
    }

}
