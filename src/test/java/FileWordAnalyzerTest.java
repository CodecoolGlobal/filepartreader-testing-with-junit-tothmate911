import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordAnalyzerTest {
    private FilePartReader fpr = new FilePartReader();
    private FileWordAnalyzer fwa = new FileWordAnalyzer(fpr);

    private final String TO_SORT_FILE_PATH = "src/test/resources/testToSort.txt";
    private final String SUBSTRINGS_FILE_PATH = "src/test/resources/testSubStrings.txt";
    private final String PALINDROME_FILE_PATH = "src/test/resources/testPalindrome.txt";

    @Test
    public void testSort() {
        fpr.setup(TO_SORT_FILE_PATH, 2, 3);
        assertIterableEquals(Arrays.asList("apple", "banana", "Emily", "Hannah"),
                fwa.getWordsOrderedAlphabetically());
    }

    @Test
    public void testContainingSubstring() {
        fpr.setup(SUBSTRINGS_FILE_PATH, 1, 2);
        assertIterableEquals(Arrays.asList("stubulring", "functiubulon"),
                fwa.getWordsContainingSubstring("ubul"));
    }

    @Test
    public void testPalindromes() {
        fpr.setup(PALINDROME_FILE_PATH, 2, 3);
        assertIterableEquals(Arrays.asList("anna", "görög", "ahha"),
                fwa.getStringsWhichPalindromes());
    }

}