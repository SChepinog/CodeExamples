package patterns.factory.simple_factory;

public class Main {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza1 = pizzaStore.orderPizza("pepperoni");
        Pizza pizza2 = pizzaStore.orderPizza("veggie");
        Pizza pizza3 = pizzaStore.orderPizza("clam");
        pizza1.nameYourself();
        pizza2.nameYourself();
        pizza3.nameYourself();
    }
}
