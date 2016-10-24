package leetcode.questions.test.number;

import leetcode.questions.number.Factorial_Trailing_Zeroes_172;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/10/2016.
 */
public class Factorial_Trailing_Zeroes_172_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Factorial_Trailing_Zeroes_172.trailingZeroes(2));
    }

    @Test
    public void testSimple() {
        assertEquals(2, Factorial_Trailing_Zeroes_172.trailingZeroes(12));
    }

    @Test
    public void testSimple2() {
        assertEquals(7, Factorial_Trailing_Zeroes_172.trailingZeroes(30));
    }

}
