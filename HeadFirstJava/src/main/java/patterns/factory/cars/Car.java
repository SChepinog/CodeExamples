package patterns.factory.cars;

public class Car {

    private DetailFactory detailFactory;
    private Wheel wheel;
    private Transmission transmission;
    private Electronics electronics;

    public Car(DetailFactory detailFactory) {
        this.detailFactory = detailFactory;
        this.make();
    }

    public Car make() {
        this.wheel = detailFactory.getWheel();
        this.transmission = detailFactory.getTransmission();
        this.electronics = detailFactory.getElectronics();
        nameYourself();
        return this;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    private void nameYourself() {
        String result = "%s is created with Wheels %s, transmission %s and Electronics %s";
        System.out.println(String.format(result, this, wheel, transmission, electronics));
    }


    public static class FerrariCar extends Car {

        public FerrariCar() {
            super(new DetailFactory.FerrariFactory());
        }

    }

    public static class FordCar extends Car {

        public FordCar() {
            super(new DetailFactory.FordFactory());
        }

    }
}
