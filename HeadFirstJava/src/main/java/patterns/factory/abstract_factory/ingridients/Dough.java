package patterns.factory.abstract_factory.ingridients;

public abstract class Dough {
    @Override
    public String toString() {
        return this.getClass().getCanonicalName();
    }
}
