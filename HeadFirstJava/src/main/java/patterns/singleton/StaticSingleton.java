package patterns.singleton;

public class StaticSingleton {

    private static StaticSingleton INSTANCE = new StaticSingleton();

    private StaticSingleton() {
    }

    public static synchronized StaticSingleton getInstance() {
        return INSTANCE;
    }
}
