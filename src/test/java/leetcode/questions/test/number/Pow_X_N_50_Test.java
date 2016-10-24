package leetcode.questions.test.number;

import leetcode.questions.number.Pow_X_N_50;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/14/2016.
 */
public class Pow_X_N_50_Test {

    @Test
    public void testZero() {
        assertEquals(1, Pow_X_N_50.myPow(0, 0), 0);
    }

    @Test
    public void testNegative() {
        assertEquals(1d/8, Pow_X_N_50.myPow(2, -3), 0);
    }

    @Test
    public void testSimple() {
        assertEquals(8, Pow_X_N_50.myPow(2, 3), 0);
    }

}
