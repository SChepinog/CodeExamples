package patterns.intro.ducks_simulator.ducks;

import patterns.intro.ducks_simulator.behavior.fly.FlyNoWay;
import patterns.intro.ducks_simulator.behavior.quack.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
