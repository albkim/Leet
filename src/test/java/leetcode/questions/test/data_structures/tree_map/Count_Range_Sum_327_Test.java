package leetcode.questions.test.data_structures.tree_map;

import leetcode.questions.data_structures.treemap.Count_Range_Sum_327;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Count_Range_Sum_327_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Count_Range_Sum_327.countRangeSum(new int[] {-2, 5, -1}, -2, 2));
    }

    @Test
    public void testEdge() {
        assertEquals(1, Count_Range_Sum_327.countRangeSum(new int[] {0}, 0, 0));
    }

    @Test
    public void testEdge1() {
        assertEquals(3, Count_Range_Sum_327.countRangeSum(new int[] {0, 0}, 0, 0));
    }

}
