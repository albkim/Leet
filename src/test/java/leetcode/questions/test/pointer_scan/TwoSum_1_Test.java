package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.TwoSum_1;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 8/23/2016.
 */
public class TwoSum_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testNullArray(){
        TwoSum_1.twoSum(null, 1);
    }

    @Test(expected = IllegalStateException.class)
    public void testNoSolution(){
        TwoSum_1.twoSum(new int[] {1, 2}, 4);
    }

    @Test
    public void testValid(){
        int[] result = TwoSum_1.twoSum(new int[] {2, 7, 11, 15}, 9);

        assertNotNull(result);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

}
