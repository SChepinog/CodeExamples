package patterns.factory.abstract_factory;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (pizzaName.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Cheese pizza");
        } else if (pizzaName.equals("clams")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("NY clam pizza");
        }
        return pizza;
    }
}
