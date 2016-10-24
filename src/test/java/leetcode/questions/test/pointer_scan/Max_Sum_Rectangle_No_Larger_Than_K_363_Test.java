package leetcode.test.questions.pointer_scan;

import leetcode.questions.pointer_scan.Max_Sum_Rectangle_No_Larger_Than_K_363;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 9/8/16.
 */
public class Max_Sum_Rectangle_No_Larger_Than_K_363_Test {

    @Test
    public void testEdge() {
        assertEquals(1, Max_Sum_Rectangle_No_Larger_Than_K_363.maxSumSubmatrix(new int[][] {new int[]{1}}, 2));
    }

    @Test
    public void testSample() {
        assertEquals(2, Max_Sum_Rectangle_No_Larger_Than_K_363.maxSumSubmatrix(new int[][] {
                new int[] {1,  0, 1},
                new int[] {0, -2, 3}
        }, 2));
    }

    @Test
    public void testComplex() {
        assertEquals(3, Max_Sum_Rectangle_No_Larger_Than_K_363.maxSumSubmatrix(new int[][] {
                new int[] {2, 2, -1}
        }, 3));
    }

    @Test
    public void testComplex2() {
        assertEquals(-1, Max_Sum_Rectangle_No_Larger_Than_K_363.maxSumSubmatrix(new int[][] {
                new int[] {2, 2, -1}
        }, 0));
    }

}
