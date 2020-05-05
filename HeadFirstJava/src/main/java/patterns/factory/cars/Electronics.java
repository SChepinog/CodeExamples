package patterns.factory.cars;

public abstract class Electronics {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static class FordElectronics extends Electronics {

    }

    public static class FerrariElectronics extends Electronics {

    }
}
