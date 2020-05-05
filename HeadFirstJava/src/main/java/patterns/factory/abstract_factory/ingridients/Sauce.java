package patterns.factory.abstract_factory.ingridients;

public abstract class Sauce {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
