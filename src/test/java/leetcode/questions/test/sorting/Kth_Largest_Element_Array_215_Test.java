package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Kth_Largest_Element_Array_215;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/13/2016.
 */
public class Kth_Largest_Element_Array_215_Test {

    @Test
    public void testSimple() {
        assertEquals(5, Kth_Largest_Element_Array_215.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
    }

    @Test
    public void testSimple1() {
        assertEquals(2, Kth_Largest_Element_Array_215.findKthLargest(new int[] {-1,2,0}, 1));
    }

    @Test
    public void testSimple2() {
        assertEquals(1, Kth_Largest_Element_Array_215.findKthLargest(new int[] {2,1}, 2));
    }

}
