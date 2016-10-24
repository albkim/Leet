package leetcode.questions.test.bits;

import leetcode.questions.bits.Power_Of_Two_231;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/14/2016.
 */
public class Power_Of_Two_231_Test {

    @Test
    public void testSimple() {
        assertTrue(Power_Of_Two_231.isPowerOfTwo(2));
        assertTrue(Power_Of_Two_231.isPowerOfTwo(4));
        assertTrue(Power_Of_Two_231.isPowerOfTwo(8));
        assertTrue(Power_Of_Two_231.isPowerOfTwo(16));

        assertFalse(Power_Of_Two_231.isPowerOfTwo(3));
        assertFalse(Power_Of_Two_231.isPowerOfTwo(9));
    }

}
