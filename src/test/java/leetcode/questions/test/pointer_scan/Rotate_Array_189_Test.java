package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Rotate_Array_189;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/11/2016.
 */
public class Rotate_Array_189_Test {

    @Test
    public void testSimple() {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        Rotate_Array_189.rotate(nums, 3);
        assertArrayEquals(new int[] {5,6,7,1,2,3,4}, nums);
    }

}
