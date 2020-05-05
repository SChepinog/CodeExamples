package patterns.factory.cars;

public interface DetailFactory {

    Wheel getWheel();

    Transmission getTransmission();

    Electronics getElectronics();

    class FerrariFactory implements DetailFactory {

        @Override
        public Wheel getWheel() {
            return new Wheel.FerrariWheel();
        }

        @Override
        public Transmission getTransmission() {
            return new Transmission.FerrariTransmission();
        }

        @Override
        public Electronics getElectronics() {
            return new Electronics.FerrariElectronics();
        }
    }

    class FordFactory implements DetailFactory {
        @Override
        public Wheel getWheel() {
            return new Wheel.FordWheel();
        }

        @Override
        public Transmission getTransmission() {
            return new Transmission.FordTransmission();
        }

        @Override
        public Electronics getElectronics() {
            return new Electronics.FordElectronics();
        }
    }
}
