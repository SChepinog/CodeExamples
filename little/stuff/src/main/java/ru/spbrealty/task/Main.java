package ru.spbrealty.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private final static int START_INCLUSIVE = 1;
    private final static int END_INCLUSIVE = 80;
    private final static String EMPTY_CHAR = " ";
    private final static Character NOT_EMPTY_CHAR = '#';

    public static void main(String[] args) throws Exception {
        DiamondSize diamondSize = getDiamondSizeFromConsole();
        printDiamond(diamondSize.height, diamondSize.width);
    }

    private static void printDiamond(int height, int width) {
        char[] emptyChars = IntStream.range(0, width).mapToObj(i -> EMPTY_CHAR).collect(Collectors.joining()).toCharArray();
        int heightIndexWithMaxWidth = new BigDecimal(height)
                .divide(BigDecimal.valueOf(2), RoundingMode.UP)
                .setScale(0, RoundingMode.UP).intValue() - 1;
        Function<Integer, Integer> widthWithCoefficient = x -> (int) ((float) (width - 1) / heightIndexWithMaxWidth * x) + 1;
        for (int i = 0; i < height; i++) {
            printCharArrayWithGrids(emptyChars.clone(), widthWithCoefficient.apply(i <= heightIndexWithMaxWidth ? i : (height - i - 1)));
        }
    }

    private static void printCharArrayWithGrids(char[] emptyChars, int widthToPrint) {
        int leftEmptyChars = emptyChars.length - ((emptyChars.length - widthToPrint) / 2) - widthToPrint;
        emptyChars[leftEmptyChars] = NOT_EMPTY_CHAR;
        emptyChars[leftEmptyChars + widthToPrint - 1] = NOT_EMPTY_CHAR;
        System.out.println(emptyChars);
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
