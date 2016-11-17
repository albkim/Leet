package leetcode.hard.test;

import leetcode.hard.Median_Two_Sorted_Arrays_4;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 8/29/2016.
 */
public class Median_Two_Sorted_Arrays_4_Test {

    @Test
    public void testValid() {
        assertEquals(2, Median_Two_Sorted_Arrays_4.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0);
        assertEquals(3.5, Median_Two_Sorted_Arrays_4.findMedianSortedArrays(new int[] {1, 4, 5}, new int[] {2, 3, 6}), 0);
        assertEquals(3.5, Median_Two_Sorted_Arrays_4.findMedianSortedArrays(new int[] {4, 5, 6}, new int[] {1, 2, 3}), 0);
    }

    @Test
    public void testValidEven() {
        assertEquals(2.5, Median_Two_Sorted_Arrays_4.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0);
    }

    @Test
    public void testValidSimple() {
        assertEquals(1, Median_Two_Sorted_Arrays_4.findMedianSortedArrays(new int[] {1}, new int[] {1}), 0);
    }

    @Test
    public void testKEdgeCases() {
        assertEquals(4, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 2}, new int[] {3, 4}, 2, 1, 0, 1, 2));
        assertEquals(4, Median_Two_Sorted_Arrays_4.findKth(new int[] {3, 4}, new int[] {1, 2}, 0, 1, 2, 1, 2));
    }

    @Test
    public void testK1() {
        assertEquals(1, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 2}, new int[] {3, 4}, 0, 1, 0, 1, 1));
    }

    @Test
    public void testContinue() {
        assertEquals(3, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 2}, new int[] {3, 4}, 0, 1, 0, 1, 3));
    }

    @Test
    public void testCorrect() {
        assertEquals(3, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 3}, new int[] {2, 4}, 0, 1, 0, 1, 3));
        assertEquals(2, Median_Two_Sorted_Arrays_4.findKth(new int[] {1}, new int[] {2, 3}, 0, 0, 0, 1, 2));
        assertEquals(2, Median_Two_Sorted_Arrays_4.findKth(new int[] {1}, new int[] {2}, 0, 0, 0, 0, 2));
        assertEquals(2, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 3}, new int[] {2, 4}, 0, 1, 0, 1, 2));
        assertEquals(3, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 4, 5}, new int[] {2, 3, 6}, 0, 2, 0, 2, 3));
        assertEquals(4, Median_Two_Sorted_Arrays_4.findKth(new int[] {1, 4, 5}, new int[] {2, 3, 6}, 0, 2, 0, 2, 4));
    }

}
