package patterns.factory.abstract_factory.ingridients;

public abstract class Cheese {

    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
