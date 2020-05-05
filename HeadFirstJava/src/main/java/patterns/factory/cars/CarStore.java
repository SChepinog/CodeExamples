package patterns.factory.cars;

public abstract class CarStore {

    private DetailFactory detailFactory;

    public CarStore(DetailFactory detailFactory) {
        this.detailFactory = detailFactory;
    }

    public Car buyCar() {
        return new Car(detailFactory);
    }

    public static class FordStore extends CarStore {

        public FordStore() {
            super(new DetailFactory.FordFactory());
        }
    }

    public static class FerrariStore extends CarStore {

        public FerrariStore() {
            super(new DetailFactory.FerrariFactory());
        }
    }
}
