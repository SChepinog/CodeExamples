package patterns.factory.abstract_factory;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        if (pizzaName.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Cheese pizza");
        } else if (pizzaName.equals("clams")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago clam pizza");
        }
        return pizza;
    }
}
