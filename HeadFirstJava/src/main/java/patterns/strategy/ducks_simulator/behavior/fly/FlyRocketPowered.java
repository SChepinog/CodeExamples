package patterns.strategy.ducks_simulator.behavior.fly;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!!!");
    }
}
