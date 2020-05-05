package patterns.factory.cars;

public class Main {

    public static void main(String[] args) {
        Car ford = new Car.FordCar();
        Car ferrari = new Car.FerrariCar();
        System.out.println("");

        CarStore store = new CarStore.FerrariStore();
        store.buyCar();

        store = new CarStore.FordStore();
        store.buyCar();
    }
}
