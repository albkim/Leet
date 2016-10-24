package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Next_Permutation_31;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/8/2016.
 */
public class Next_Permutation_31_Test {

    @Test
    public void testEdge() {
        int[] nums = new int[] {1};
        Next_Permutation_31.nextPermutation(nums);
        assertEquals(1, nums[0]);
    }

    @Test
    public void testSample() {
        int[] nums = new int[] {1, 2, 3};
        Next_Permutation_31.nextPermutation(nums);
        assertEquals(1, nums[0]);
        assertEquals(3, nums[1]);
        assertEquals(2, nums[2]);

        Next_Permutation_31.nextPermutation(nums);
        assertEquals(2, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(3, nums[2]);

        Next_Permutation_31.nextPermutation(nums);
        assertEquals(2, nums[0]);
        assertEquals(3, nums[1]);
        assertEquals(1, nums[2]);

        Next_Permutation_31.nextPermutation(nums);
        assertEquals(3, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);

        Next_Permutation_31.nextPermutation(nums);
        assertEquals(3, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(1, nums[2]);

        Next_Permutation_31.nextPermutation(nums);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

}
