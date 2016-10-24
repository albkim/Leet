package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Move_Zeroes_283;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class Move_Zeroes_283_Test {

    @Test
    public void testSimple() {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        Move_Zeroes_283.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void testSimple1() {
        int[] nums = new int[] {0, 1};
        Move_Zeroes_283.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 0}, nums);
    }

}
