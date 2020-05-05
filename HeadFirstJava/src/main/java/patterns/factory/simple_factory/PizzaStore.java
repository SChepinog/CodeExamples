package patterns.factory.simple_factory;

public class PizzaStore {
    SimplePizzaFactory pizzaFactory;

    public PizzaStore(SimplePizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String pizzaName) {
        Pizza pizza = pizzaFactory.createPizza(pizzaName);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
