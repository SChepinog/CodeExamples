package search;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    List<String> strings;

    public static void main(String[] args) {
        System.out.println("1".compareTo("11"));

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.strings = Arrays.asList("111", "222", "333", "444", "555", "666", "777", "888", "999");
        String value = "1";
        int index = binarySearch.getElementIndex(value);
        System.out.println(
            index < 0
                ? "Element not found"
                : "Element found on index " + index
        );
    }

    private int getElementIndex(String value) {
        if (strings == null || strings.isEmpty()) {
            return -1;
        }
        int left = 0;
        int right = strings.size() - 1;
        return getElementIndexForBoundaries(left, right, value);
    }

    private int getElementIndexForBoundaries(int left, int right, String value) {
        if (left == right) {
            if (strings.get(left).compareTo(value) == 0) {
                return left;
            } else {
                return -1;
            }
        }
        int middleIndex = (left + right) / 2;
        int compared = strings.get(middleIndex).compareTo(value);
        if (compared == 0) {
            return middleIndex;
        } else if (compared < 0) {
            left = middleIndex + 1;
        } else {
            right = middleIndex - 1;
        }
        return getElementIndexForBoundaries(left, right, value);
    }
}
