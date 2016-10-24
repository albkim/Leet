package leetcode.questions.test.bits;

import leetcode.questions.bits.Divide_Two_Integers_29;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/6/2016.
 */
public class Divide_Two_Integers_29_Test {

    @Test
    public void testEdge() {
        assertEquals(0, Divide_Two_Integers_29.divide(0, 3));
        assertEquals(1, Divide_Two_Integers_29.divide(3, 3));
        assertEquals(Integer.MAX_VALUE, Divide_Two_Integers_29.divide(3, 0));
    }

    @Test
    public void testSimple() {
        assertEquals(3, Divide_Two_Integers_29.divide(9, 3));
        assertEquals(3, Divide_Two_Integers_29.divide(10, 3));
    }

    @Test
    public void testNegative() {
        assertEquals(-3, Divide_Two_Integers_29.divide(9, -3));
        assertEquals(3, Divide_Two_Integers_29.divide(-9, -3));
    }

    @Test
    public void testOverflow() {
        assertEquals(Integer.MAX_VALUE, Divide_Two_Integers_29.divide(-2147483648, -1));
    }

}
