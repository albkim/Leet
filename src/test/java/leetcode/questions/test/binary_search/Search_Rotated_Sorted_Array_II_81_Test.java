package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_Rotated_Sorted_Array_II_81;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/21/2016.
 */
public class Search_Rotated_Sorted_Array_II_81_Test {

    @Test
    public void testSimple() {
        assertTrue(Search_Rotated_Sorted_Array_II_81.search(new int[] {1, 1, 1, 1, 1, 5, 1, 1, 1, 1}, 5));
        assertFalse(Search_Rotated_Sorted_Array_II_81.search(new int[] {1, 1, 1, 1, 1, 5, 1, 1, 1, 1}, 6));
    }

    @Test
    public void testEdge() {
        assertTrue(Search_Rotated_Sorted_Array_II_81.search(new int[]{3, 1}, 1));
    }

    @Test
    public void testEdge2() {
        assertTrue(Search_Rotated_Sorted_Array_II_81.search(new int[]{1, 3, 1}, 1));
    }

}
