package search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class BinarySearchTest {

    @TestFactory
    public List<DynamicTest> doTests() {
        return Arrays.asList(
            DynamicTest.dynamicTest("Test1", () -> doTest(0, Arrays.asList("0", "1", "2"), "0")),
            DynamicTest.dynamicTest("Test2", () -> doTest(1, Arrays.asList("0", "1", "2"), "1")),
            DynamicTest.dynamicTest("Test3", () -> doTest(-1, Arrays.asList("0", "1", "2"), "11")),
            DynamicTest.dynamicTest("Test4", () -> doTest(-1, Arrays.asList("000", "111"), "0")),
            DynamicTest.dynamicTest("Test5", () -> doTest(-1, Arrays.asList("000", "111"), "0000")),
            DynamicTest.dynamicTest("Test6", () -> doTest(-1, Arrays.asList("000", "111"), "1")),
            DynamicTest.dynamicTest("Test7", () -> doTest(-1, Arrays.asList("000", "111"), "1111"))
        );
    }

    public void doTest(int indexExpected, List<String> strings, String elementToFind) {
        Assertions.assertEquals(indexExpected, new BinarySearch().setStrings(strings).getElementIndex(elementToFind));
    }
}
