package basics;

public class WordGame {

    public static boolean isWordPalindrome(String word) {
        // reverse word
        StringBuilder stringBuilder = new StringBuilder(word);
        String reversedWord = stringBuilder
                .reverse()
                .toString();
        // check word and reversed word are equals
        return word.equalsIgnoreCase(reversedWord);
    }
}
