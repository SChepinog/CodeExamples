package utils;

import java.util.ArrayList;

public class ArrayListGenerator {

    public static ArrayList<Integer> get() {
        return get(100);
    }

    public static ArrayList<Integer> get(int size) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(IntGenerator.get());
        }
        return result;
    }
}
