package patterns.factory.abstract_factory.ingridients;

public abstract class Pepperoni {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
