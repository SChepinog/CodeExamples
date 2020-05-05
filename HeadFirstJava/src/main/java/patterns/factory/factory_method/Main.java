package patterns.factory.factory_method;

public class Main {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza1 = pizzaStore.orderPizza("pepperoni");
        Pizza pizza2 = pizzaStore.orderPizza("veggie");
        Pizza pizza3 = pizzaStore.orderPizza("clam");
        pizza1.nameYourself();
        pizza2.nameYourself();
        pizza3.nameYourself();

        pizzaStore = new ChicagoPizzaStore();
        pizza1 = pizzaStore.orderPizza("pepperoni");
        pizza2 = pizzaStore.orderPizza("veggie");
        pizza3 = pizzaStore.orderPizza("clam");
        pizza1.nameYourself();
        pizza2.nameYourself();
        pizza3.nameYourself();
    }
}
