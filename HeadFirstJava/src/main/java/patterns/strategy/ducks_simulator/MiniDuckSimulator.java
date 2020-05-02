package patterns.strategy.ducks_simulator;

import patterns.strategy.ducks_simulator.behavior.fly.FlyRocketPowered;
import patterns.strategy.ducks_simulator.ducks.Duck;
import patterns.strategy.ducks_simulator.ducks.MallardDuck;
import patterns.strategy.ducks_simulator.ducks.ModelDuck;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
