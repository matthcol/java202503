package basics.tu;

import basics.NumberGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Timeout.ThreadMode.SEPARATE_THREAD;

@Timeout(value = 1, unit = TimeUnit.SECONDS, threadMode = SEPARATE_THREAD)
class NumberGameTest {

    @ParameterizedTest
    @CsvSource({
           "1, 1, 1",
           "1, 4, 1",
           "4, 1, 1",
           "3, 5, 1",
           "12, 16, 4",
           "16, 12, 4"
    })
    void testPgcd_ok(int a, int b, int expected_gcd) {
        int actual_gcd = NumberGame.pgcd(a, b);
        assertEquals(expected_gcd, actual_gcd, "greatest common divider");

    }

    @ParameterizedTest
    @CsvSource({
            "0, 4",
            "4, 0",
            "0, 0",
            "-5, 4",
            "4, -5",
            "-12, -5"
    })
    void testPgcd_ko(int a, int b) {
        assertThrows(IllegalArgumentException.class,
                () -> NumberGame.pgcd(a, b)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "0, 4",
            "4, 0",
            "0, 0",
            "-5, 4",
            "4, -5",
            "-12, -5"
    })
    void testPgcd_ko_message(int a, int b) {
        // check right exception
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> NumberGame.pgcd(a, b)
        );
        // check message of the exception
        assertEquals("argument must be strictly positive", ex.getMessage());
    }
}