package tests.simple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SkippedTests {
    @Test
    @Disabled
    void test1 () {
        assertTrue(true);
    }

    @Test
    @Disabled
    void test2 () {
        assertTrue(true);
    }

    @Test
    @Disabled("tak nado")
    void test3 () {
        assertTrue(true);
    }
}
