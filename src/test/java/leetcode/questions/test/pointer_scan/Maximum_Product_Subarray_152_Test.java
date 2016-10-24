package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Maximum_Product_Subarray_152;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/8/2016.
 */
public class Maximum_Product_Subarray_152_Test {

    @Test
    public void testEdge() {
        assertEquals(16, Maximum_Product_Subarray_152.maxProduct(new int[] {-4,-4}));
    }

    @Test
    public void testEdge1() {
        assertEquals(-2, Maximum_Product_Subarray_152.maxProduct(new int[] {-2}));
    }

    @Test
    public void testEdge2() {
        assertEquals(48, Maximum_Product_Subarray_152.maxProduct(new int[] {2,3,-2,-4}));
    }

    @Test
    public void testEdge3() {
        assertEquals(0, Maximum_Product_Subarray_152.maxProduct(new int[] {-2,0,-1}));
    }

    @Test
    public void testSimple() {
        assertEquals(6, Maximum_Product_Subarray_152.maxProduct(new int[] {2,3,-2,4}));
    }

}
