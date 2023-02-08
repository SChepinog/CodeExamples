package ru.spbrealty.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 80;

    public static void main(String[] args) throws Exception {
        DiamondSize diamondSize = getDiamondSizeFromConsole();
//        printDiamond(5,5);
//        printDiamond(6,3);
//        printDiamond(6,6);
        printDiamond(diamondSize.height, diamondSize.width);
    }

    private static void printDiamond(int height, int width) {
        char[] emptyChars = IntStream.range(0, width).mapToObj(i -> " ").collect(Collectors.joining("")).toCharArray();
        int zeroPoint = width / 2;
        Function<Integer, Integer> xWithCoefficient = x -> (int) ((((float) (width) / (height)) * x));
        Function<Integer, Integer> xToRightIndex = x -> (width - 1) - Math.abs(xWithCoefficient.apply(x) - zeroPoint);
        Function<Integer, Integer> xToLeftIndex = x -> Math.abs(zeroPoint - xWithCoefficient.apply(x));
        for (int i = 0; i < height; i++) {
            char[] clone = emptyChars.clone();
            clone[xToRightIndex.apply(i)] = '#';
            clone[xToLeftIndex.apply(i)] = '#';
            System.out.println(clone);
        }
        System.out.println("----------------");
        for (int i = 0; i < height; i++) {
            char[] clone = emptyChars.clone();
            clone[xToRightIndex.apply(i)] = '#';
            System.out.println(clone);
        }
        System.out.println("----------------");
        for (int i = 0; i < height; i++) {
            char[] clone = emptyChars.clone();
            clone[xToLeftIndex.apply(i)] = '#';
            System.out.println(clone);
        }
        System.out.println("----------------");
    }

    private static DiamondSize getDiamondSizeFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int height = getNumberFromConsole(reader, "height");
        int width = getNumberFromConsole(reader, "width");
        return new DiamondSize(height, width);
    }

    private static int getNumberFromConsole(BufferedReader reader, String whatToEnter) throws IOException {
        while (true) {
            System.out.printf("Please, enter %s from %d to %d%n", whatToEnter, START_INCLUSIVE, END_INCLUSIVE);
            String sizeString = reader.readLine();
            if ("exit".equals(sizeString)) {
                System.out.println("Bye!");
                System.exit(0);
            }
            try {
                int sizeInt = Integer.parseInt(sizeString);
                if (START_INCLUSIVE <= sizeInt && sizeInt <= END_INCLUSIVE) {
                    return sizeInt;
                }
            } catch (Exception ignored) {
            }
            System.out.printf("Error. You entered incorrect %s. Try again or type 'exit' to quit%n", whatToEnter);
        }
    }

    static class DiamondSize {
        DiamondSize(int h, int w) {
            height = h;
            width = w;
        }

        int height;
        int width;
    }
}
