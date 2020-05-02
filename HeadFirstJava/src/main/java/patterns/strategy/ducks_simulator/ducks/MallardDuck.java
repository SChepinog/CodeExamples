package patterns.strategy.ducks_simulator.ducks;

import patterns.strategy.ducks_simulator.behavior.fly.FlyWithWings;
import patterns.strategy.ducks_simulator.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Display MallardDuck");
    }
}
