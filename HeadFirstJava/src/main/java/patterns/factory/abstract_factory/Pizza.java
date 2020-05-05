package patterns.factory.abstract_factory;

import patterns.factory.abstract_factory.ingridients.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String veggiesResult = veggies == null ? null : Stream.of(this.veggies).map(Object::toString).collect(Collectors.joining(", "));
        String result = "Pizza named %s on dough %s with sauce %s, including veggies %s and cheese %s, with pepperoni %s and %s clams";
        return String.format(result, name, dough, sauce, veggiesResult, cheese, pepperoni, clams);
    }
}
