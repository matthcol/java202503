package basics.tu;

import basics.WordGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WordGameTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "Radar",
            "Kayak",
            "kayak",
            "KAYAK",
            "",
            "A"
    })
    void testIsWordPalindrome_ok(String word) {
        boolean ok = WordGame.isWordPalindrome(word);
        assertTrue(ok, "is a palindrome");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "où",
            "Artichaud",
            "ananas",
            "hollow"
    })
    void testIsWordPalindrome_ko(String word) {
        boolean ok = WordGame.isWordPalindrome(word);
        assertFalse(ok, "is not a palindrome");
    }
}