package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Sqrt_69;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Sqrt_69_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Sqrt_69.mySqrt(9));
    }

    @Test
    public void testClosest() {
        assertEquals(2, Sqrt_69.mySqrt(5));
    }

    @Test
    public void testComplex() {
        assertEquals(46339, Sqrt_69.mySqrt(2147395599));
    }

}
