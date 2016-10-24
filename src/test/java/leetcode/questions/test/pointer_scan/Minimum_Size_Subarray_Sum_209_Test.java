package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Minimum_Size_Subarray_Sum_209;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/12/2016.
 */
public class Minimum_Size_Subarray_Sum_209_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Minimum_Size_Subarray_Sum_209.minSubArrayLen(7, new int[] {7,2,3,1,2,4,3}));
        assertEquals(1, Minimum_Size_Subarray_Sum_209.minSubArrayLen(7, new int[] {2,3,1,2,4,3,7}));
        assertEquals(0, Minimum_Size_Subarray_Sum_209.minSubArrayLen(3, new int[] {1,1}));
    }

    @Test
    public void testSimple() {
        assertEquals(2, Minimum_Size_Subarray_Sum_209.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }

}
