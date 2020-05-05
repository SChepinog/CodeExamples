package patterns.factory.abstract_factory;


public abstract class PizzaStore {

    public Pizza orderPizza(String pizzaName) {
        Pizza pizza = createPizza(pizzaName);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public abstract Pizza createPizza(String pizzaName);
}
