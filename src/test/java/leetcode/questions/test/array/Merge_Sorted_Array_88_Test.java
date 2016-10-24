package leetcode.questions.test.array;

import leetcode.questions.array.Merge_Sorted_Array_88;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/25/2016.
 */
public class Merge_Sorted_Array_88_Test {

    @Test
    public void testEdge1() {
        int[] nums1 = new int[1];
        int[] nums2 = new int[] {1};

        Merge_Sorted_Array_88.merge(nums1, 0, nums2, 1);

        assertEquals(1, nums1[0]);
    }

    @Test
    public void testEdge2() {
        int[] nums1 = new int[] {1};
        int[] nums2 = new int[0];

        Merge_Sorted_Array_88.merge(nums1, 1, nums2, 0);

        assertEquals(1, nums1[0]);
    }

    @Test
    public void testSimple() {
        int[] nums1 = new int[7];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        nums1[3] = 6;
        int[] nums2 = new int[] {2, 4, 8};

        Merge_Sorted_Array_88.merge(nums1, 4, nums2, 3);

        assertEquals(1, nums1[0]);
        assertEquals(2, nums1[1]);
        assertEquals(3, nums1[2]);
        assertEquals(4, nums1[3]);
        assertEquals(5, nums1[4]);
        assertEquals(6, nums1[5]);
    }

}
