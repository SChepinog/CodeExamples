package patterns.factory.factory_method;

public abstract class Pizza {
    public void prepare() {
    }

    public void bake() {
    }

    public void cut() {
    }

    public void box() {
    }

    public void nameYourself() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
