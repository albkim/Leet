package leetcode.questions.test.number;

import leetcode.questions.number.Reverse_Integer_7;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/1/2016.
 */
public class Reverse_Integer_7_Test {

    @Test
    public void testSample() {
        assertEquals(321, Reverse_Integer_7.reverse(123));
    }

    @Test
    public void testZero() {
        assertEquals(0, Reverse_Integer_7.reverse(0));
    }

    @Test
    public void testZeros() {
        assertEquals(1, Reverse_Integer_7.reverse(10));
    }

    @Test
    public void testOne() {
        assertEquals(2, Reverse_Integer_7.reverse(2));
    }

    @Test
    public void testNegative() {
        assertEquals(-321, Reverse_Integer_7.reverse(-123));
    }

    @Test
    public void testOverflow() {
        assertEquals(0, Reverse_Integer_7.reverse(1534236469));
    }

    @Test
    public void testOverflowNegative() {
        assertEquals(0, Reverse_Integer_7.reverse(-2147483648));
    }

}
