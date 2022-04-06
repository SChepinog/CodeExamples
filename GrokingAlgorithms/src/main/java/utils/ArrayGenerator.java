package utils;

public class ArrayGenerator {

    public static int[] get() {
        return get(100);
    }

    public static int[] get(int size) {
        int[] result = new int[size];
        for (int i =0; i < size; i++) {
            result[i] = getRandomInt();
        }
        return result;
    }

    private static int getRandomInt() {
        return (int) (Math.random() * 1000);
    }
}
