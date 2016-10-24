package leetcode.questions.test.bits;

import leetcode.questions.bits.Single_Number_III_260;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/15/2016.
 */
public class Single_Number_III_260_Test {

    @Test
    public void testSimple() {
        assertArrayEquals(new int[] {3, 5}, Single_Number_III_260.singleNumber(new int[] {1, 2, 1, 3, 2, 5}));
    }

    @Test
    public void testEdge2() {
        assertArrayEquals(new int[] {-145417756,744132272}, Single_Number_III_260.singleNumber(new int[] {
                43772400,1674008457,1779561093,744132272,1674008457,448610617,1779561093,124075538,-1034600064,49040018,
                612881857,390719949,-359290212,-812493625,124732,-1361696369,49040018,-145417756,-812493625,2078552599,
                1568689850,865876872,865876872,-1471385435,1816352571,1793963758,2078552599,-1034600064,1475115274,
                -119634980,124732,661111294,-1813882010,1568689850,448610617,1347212898,-1293494866,612881857,661111294,
                -1361696369,1816352571,-1813882010,-359290212,1475115274,1793963758,1347212898,43772400,-1471385435,
                124075538,-1293494866,-119634980,390719949}));
    }

}
