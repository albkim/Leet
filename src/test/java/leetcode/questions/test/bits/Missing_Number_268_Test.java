package leetcode.questions.test.bits;

import leetcode.questions.bits.Missing_Number_268;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/16/2016.
 */
public class Missing_Number_268_Test {

    @Test
    public void testSimple() {
        int size = 10;
        int skip = 8;
        int[] nums = new int[size + 1];
        for (int number = 0; number < size; number++) {
            if (skip != number) {
                nums[number] = number;
            }
        }

        assertEquals(8, Missing_Number_268.missingNumber(nums));
    }

}
