package utils;

public class IntGenerator {

    public static Integer get() {
        return get(1000);
    }

    public static Integer get(int max) {
        return (int) (Math.random() * max);
    }
}
