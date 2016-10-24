package leetcode.questions.test.sorting;

import leetcode.questions.sorting.Maximum_Gap_164;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/9/2016.
 */
public class Maximum_Gap_164_Test {

    @Test
    public void testEdge() {
        assertEquals(9999999, Maximum_Gap_164.maximumGap(new int[] { 1,10000000 }));
    }

    @Test
    public void testEdge1() {
        assertEquals(0, Maximum_Gap_164.maximumGap(new int[] { 1, 1, 1 }));
    }

    @Test
    public void testSimple() {
        assertEquals(4, Maximum_Gap_164.maximumGap(new int[] { 5, 1, 6, 8 }));
    }

    @Test
    public void testSimple1() {
        assertEquals(97, Maximum_Gap_164.maximumGap(new int[] { 100, 1, 2, 3 }));
    }

}
