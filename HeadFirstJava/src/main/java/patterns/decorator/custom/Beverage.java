package patterns.decorator.custom;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {

    float cost;
    List<Beverage> beverage;

    public Beverage() {
        this.cost = 0;
    }

    public Beverage with(Beverage beverage) {
        if (this.beverage == null) {
            this.beverage = new ArrayList<>();
        }
        this.beverage.add(beverage);
        return this;
    }

    public float getCost() {
        if (beverage == null) {
            return this.cost;
        } else {
            return (float) (cost + beverage.stream().mapToDouble(Beverage::getCost).sum());
        }
    }
}
