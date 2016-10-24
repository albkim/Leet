package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Two_Sum_II_Input_Array_Is_Sorted_167;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Two_Sum_II_Input_Array_Is_Sorted_167_Test {

    @Test
    public void testSimple() {
        int[] result = Two_Sum_II_Input_Array_Is_Sorted_167.twoSum(new int[] {2, 7, 11, 15}, 9);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

}
