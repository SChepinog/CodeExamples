package patterns.factory.abstract_factory;

public class Main {

    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();
        Pizza pizza = store.orderPizza("cheese");
        System.out.println(pizza.toString());

        store = new ChicagoPizzaStore();
        pizza = store.orderPizza("cheese");
        System.out.println(pizza.toString());

//        store = new ChicagoPizzaStore();
        pizza = store.orderPizza("clams");
        System.out.println(pizza.toString());
    }


}
