package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Search_Rotated_Sorted_Array_33;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/10/2016.
 */
public class Search_Rotated_Sorted_Array_33_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Search_Rotated_Sorted_Array_33.search(new int[] {3, 1}, 1));
    }

    @Test
    public void testRightRotation() {
        int[] array = new int[] {3, 4, 5, 6, 7, 1, 2};

        assertEquals(0, Search_Rotated_Sorted_Array_33.search(array, 3));
        assertEquals(2, Search_Rotated_Sorted_Array_33.search(array, 5));
        assertEquals(5, Search_Rotated_Sorted_Array_33.search(array, 1));
        assertEquals(6, Search_Rotated_Sorted_Array_33.search(array, 2));
        assertEquals(-1, Search_Rotated_Sorted_Array_33.search(array, 0));
        assertEquals(-1, Search_Rotated_Sorted_Array_33.search(array, 8));
    }

    @Test
    public void testLeftRotation() {
        int[] array = new int[] {6, 7, 1, 2, 3, 4, 5};

        assertEquals(4, Search_Rotated_Sorted_Array_33.search(array, 3));
        assertEquals(6, Search_Rotated_Sorted_Array_33.search(array, 5));
        assertEquals(2, Search_Rotated_Sorted_Array_33.search(array, 1));
        assertEquals(0, Search_Rotated_Sorted_Array_33.search(array, 6));
        assertEquals(-1, Search_Rotated_Sorted_Array_33.search(array, 0));
        assertEquals(-1, Search_Rotated_Sorted_Array_33.search(array, 8));
    }

}
