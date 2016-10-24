package leetcode.questions.test.dp;

import leetcode.questions.dp.Scramble_String_87;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/26/2016.
 */
public class Scramble_String_87_Test {

    @Test
    public void testSimple() {
        String s1 = "great";

        assertTrue(Scramble_String_87.isScramble(s1, "rgeat"));
        assertTrue(Scramble_String_87.isScramble(s1, "rgtae"));
    }

    @Test
    public void testSimpleFalse() {
        assertFalse(Scramble_String_87.isScramble("abcd", "bdac"));
    }

    @Test
    public void testComplex() {
        assertTrue(Scramble_String_87.isScramble("abb", "bab"));
    }

}
