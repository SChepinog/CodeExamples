package patterns.factory.cars;

public abstract class Wheel {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static class FordWheel extends Wheel {

    }

    public static class FerrariWheel extends Wheel {

    }
}
