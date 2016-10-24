package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Remove_Duplicates_Sorted_Array_II_80;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/20/2016.
 */
public class Remove_Duplicates_Sorted_Array_II_80_Test {

    @Test
    public void testSimple() {
        int[] input = new int[] {1,1,1,2,2,3};
        assertEquals(5, Remove_Duplicates_Sorted_Array_II_80.removeDuplicates(input));

        assertEquals(1, input[0]);
        assertEquals(1, input[1]);
        assertEquals(2, input[2]);
        assertEquals(2, input[3]);
        assertEquals(3, input[4]);
    }

}
