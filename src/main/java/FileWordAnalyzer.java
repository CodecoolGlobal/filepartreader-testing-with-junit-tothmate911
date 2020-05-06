import java.util.*;

public class FileWordAnalyzer {
    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() {
        List<String> wordList = getWordList();
        Collections.sort(wordList, String.CASE_INSENSITIVE_ORDER);
        return wordList;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> wordList = getWordList();
        wordList.removeIf(word -> !word.contains(subString));
        return wordList;
    }

    public List<String> getStringsWhichPalindromes() {
        List<String> wordList = getWordList();
        wordList.removeIf(word -> !isPalindrome(word));
        return wordList;
    }

    private List<String> getWordList() {
        String lines = fpr.readLines();
        return new ArrayList<>(Arrays.asList(lines.split("\\s+")));
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (i++ < j--) {
            if (word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }

}
