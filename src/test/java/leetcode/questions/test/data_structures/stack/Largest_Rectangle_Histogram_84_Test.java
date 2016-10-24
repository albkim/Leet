package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Largest_Rectangle_Histogram_84;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/22/2016.
 */
public class Largest_Rectangle_Histogram_84_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Largest_Rectangle_Histogram_84.largestRectangleArea(new int[] {1}));
    }

    @Test
    public void testSmallest() {
        assertEquals(3, Largest_Rectangle_Histogram_84.largestRectangleArea(new int[] {2,1,2}));
        assertEquals(3, Largest_Rectangle_Histogram_84.largestRectangleArea(new int[] {2, 0, 2,1,2}));
    }

    @Test
    public void testSimple() {
        assertEquals(10, Largest_Rectangle_Histogram_84.largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }

}
