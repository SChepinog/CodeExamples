package patterns.factory.cars;

public abstract class Transmission {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static class FordTransmission extends Transmission {

    }

    public static class FerrariTransmission extends Transmission {

    }
}
