package leetcode.questions.test.data_structures.heap;

import leetcode.questions.data_structures.heap.Find_Median_Data_Stream_295;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/17/2016.
 */
public class Find_Median_Data_Stream_295_Test {

    @Test
    public void testSimple() {
        Find_Median_Data_Stream_295 ds = new Find_Median_Data_Stream_295();
        ds.addNum(1);
        ds.addNum(2);
        assertEquals(1.5, ds.findMedian(), 0.1);
        ds.addNum(3);
        assertEquals(2, ds.findMedian(), 0);
    }

    @Test
    public void testSimple1() {
        Find_Median_Data_Stream_295 ds = new Find_Median_Data_Stream_295();
        ds.addNum(-1);
        assertEquals(-1, ds.findMedian(), 0);
        ds.addNum(-2);
        assertEquals(-1.5, ds.findMedian(), 0);
        ds.addNum(-3);
        assertEquals(-2, ds.findMedian(), 0);
        ds.addNum(-4);
        assertEquals(-2.5, ds.findMedian(), 0);
        ds.addNum(-5);
        assertEquals(-3, ds.findMedian(), 0);
    }

}
