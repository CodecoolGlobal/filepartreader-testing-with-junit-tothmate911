import java.util.*;

public class FileWordAnalyzer {
    private FilePartReader fpr;

    public FileWordAnalyzer(FilePartReader fpr) {
        this.fpr = fpr;
    }

    public List<String> getWordsOrderedAlphabetically() {
        List<String> wordList = getWordList();
        Collections.sort(wordList);
        return wordList;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        List<String> wordList = getWordList();
        wordList.removeIf(word -> !word.contains(subString));
        return wordList;
    }

    public List<String> getStringsWhichPalindromes() {
        List<String> wordList = getWordList();
        wordList.removeIf(this::isPalindrome);
        return wordList;

    }

    private List<String> getWordList() {
        String lines = fpr.readLines();
        return new ArrayList<>(Arrays.asList(lines.split("\\n?\\n")));
    }

    private boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length();
        while (i++ < j--) {
            if (word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }

}
