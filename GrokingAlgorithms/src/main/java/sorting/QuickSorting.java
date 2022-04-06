package sorting;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import utils.ArrayListGenerator;

public class QuickSorting {

    public static void main(String[] args) {
        ArrayList<Integer> arrayToSort = ArrayListGenerator.get();

        sort(arrayToSort);
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> arrayToSort) {
        if (arrayToSort.size() == 0 || arrayToSort.size() == 1) {
            return arrayToSort;
        }
        System.out.println("Got array to sort: ");
        printArray(arrayToSort);

        int baseNumber = arrayToSort.get(0);
        System.out.println("Base element is: " + baseNumber);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        for (int i = 0; i < arrayToSort.size(); i++) {
            if (arrayToSort.get(i) < baseNumber) {
                less.add(arrayToSort.get(i));
            } else if (arrayToSort.get(i) > baseNumber) {
                more.add(arrayToSort.get(i));
            } else {
                equal.add(arrayToSort.get(i));
            }
        }
        ArrayList<Integer> result = sort(less);
        result.addAll(equal);
        result.addAll(sort(more));
        System.out.println("Sorted array:");
        printArray(result);
        return result;
    }

    private static void printArray(ArrayList<Integer> arrayToPrint) {
        System.out.printf("[%s]%n", arrayToPrint.stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }
}
