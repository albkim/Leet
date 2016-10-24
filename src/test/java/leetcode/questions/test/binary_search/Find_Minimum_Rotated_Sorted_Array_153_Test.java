package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Find_Minimum_Rotated_Sorted_Array_153;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Find_Minimum_Rotated_Sorted_Array_153_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Find_Minimum_Rotated_Sorted_Array_153.findMin(new int[] {2,1}));
        assertEquals(1, Find_Minimum_Rotated_Sorted_Array_153.findMin(new int[] {1,2}));
    }

    @Test
    public void testSimple() {
        assertEquals(1, Find_Minimum_Rotated_Sorted_Array_153.findMin(new int[] {3,1,2}));
        assertEquals(0, Find_Minimum_Rotated_Sorted_Array_153.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
    }

}
