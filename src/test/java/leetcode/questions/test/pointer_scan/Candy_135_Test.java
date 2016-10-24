package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Candy_135;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/6/2016.
 */
public class Candy_135_Test {

    @Test
    public void testSimple1() {
        assertEquals(4, Candy_135.candy(new int[] { 1,2,2 }));
    }

    @Test
    public void testEdge() {
        assertEquals(5, Candy_135.candy(new int[] { 1,0,2 }));
    }

    @Test
    public void testEdge1() {
        assertEquals(3, Candy_135.candy(new int[] { 1,1,1 }));
    }

    @Test
    public void testSimple() {
        assertEquals(6, Candy_135.candy(new int[] { 1,3,5 }));
    }

    @Test
    public void testSimple2() {
        assertEquals(9, Candy_135.candy(new int[] { 1,2,4,4,3 }));
    }

    @Test
    public void testSimple3() {
        assertEquals(9, Candy_135.candy(new int[] { 4,2,3,4,1 }));
    }

}
