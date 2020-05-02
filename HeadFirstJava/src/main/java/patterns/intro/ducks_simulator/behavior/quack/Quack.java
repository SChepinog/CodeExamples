package patterns.intro.ducks_simulator.behavior.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QUACK!");
    }
}
