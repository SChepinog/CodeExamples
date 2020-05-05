package patterns.factory.abstract_factory.ingridients;

public abstract class Veggies {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
