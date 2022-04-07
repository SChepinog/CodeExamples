package sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

import utils.ArrayListGenerator;

public class JoiningSorting {

    public static void main(String[] args) {
        ArrayList<Integer> arrayToSort = ArrayListGenerator.get();
        sort(arrayToSort);

        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
//        treeSet.
    }

    private static ArrayList<Integer> sort(ArrayList<Integer> arrayToSort) {
        if (arrayToSort.size() == 0 || arrayToSort.size() == 1) {
            return arrayToSort;
        }
        System.out.println("Array to sort: ");
        printArray(arrayToSort);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        splitArray(arrayToSort, left, right);

        left = sort(left);
        right = sort(right);

        ArrayList<Integer> result = join(left, right);
        System.out.println("Sorted Array: ");
        printArray(result);
        return result;
    }

    private static void splitArray(ArrayList<Integer> arrayToSplit, ArrayList<Integer> left, ArrayList<Integer> right) {
        int middleElementIndex = arrayToSplit.size() / 2;
        for (int i = 0; i < arrayToSplit.size(); i++) {
            if (i < middleElementIndex) {
                left.add(arrayToSplit.get(i));
            } else {
                right.add(arrayToSplit.get(i));
            }
        }
    }

    private static ArrayList<Integer> join(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        if (left.isEmpty()) {
            return right;
        } else if (right.isEmpty()) {
            return left;
        }
        ListIterator<Integer> leftIterator = left.listIterator();
        ListIterator<Integer> rightIterator = right.listIterator();

        Integer leftTemp = leftIterator.next();
        Integer rightTemp = rightIterator.next();
        while (leftTemp != null || rightTemp != null) {
            if (leftTemp == null) {
                result.add(rightTemp);
                while (rightIterator.hasNext()) {
                    result.add(rightIterator.next());
                }
                break;
            }
            if (rightTemp == null) {
                result.add(leftTemp);
                while (leftIterator.hasNext()) {
                    result.add(leftIterator.next());
                }
                break;
            }

            if (leftTemp <= rightTemp) {
                result.add(leftTemp);
                leftTemp = leftIterator.hasNext() ? leftIterator.next() : null;
            } else {
                result.add(rightTemp);
                rightTemp = rightIterator.hasNext() ? rightIterator.next() : null;
            }
        }
        assert result.size() == left.size() + right.size();
        return result;
    }

    private static void printArray(ArrayList<Integer> arrayToPrint) {
        System.out.printf("[%s]%n", arrayToPrint.stream().map(Objects::toString).collect(Collectors.joining(", ")));
    }
}
