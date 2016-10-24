package leetcode.questions.test.dp;

import leetcode.questions.dp.Maximum_Subarray_53;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/15/2016.
 */
public class Maximum_Subarray_53_Test {

    @Test
    public void testAllNegative() {
        assertEquals(-1, Maximum_Subarray_53.maxSubArray(new int[] {-5, -4, -1, -10}));
    }

    @Test
    public void testSimple() {
        assertEquals(6, Maximum_Subarray_53.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}
