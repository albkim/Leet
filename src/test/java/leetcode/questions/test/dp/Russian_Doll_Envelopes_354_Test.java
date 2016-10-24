package leetcode.test.questions.dp;

import leetcode.questions.dp.Russian_Doll_Envelopes_354;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by albertk on 9/23/16.
 */
public class Russian_Doll_Envelopes_354_Test {

    @Test
    public void testSimple() {
        assertEquals(3, Russian_Doll_Envelopes_354.maxEnvelopes(new int[][] {
                new int[] {5,4},
                new int[] {6,4},
                new int[] {6,7},
                new int[] {2,3}
        }));
    }

    @Test
    public void testSimple2() {
        assertEquals(3, Russian_Doll_Envelopes_354.maxEnvelopes(new int[][] {
                new int[] {4,5},
                new int[] {6,7},
                new int[] {2,3}
        }));
    }

    @Test
    public void testComplex() {
        assertEquals(2, Russian_Doll_Envelopes_354.maxEnvelopes(new int[][] {
                new int[] {46,89},
                new int[] {50,53},
                new int[] {52,68},
                new int[] {72,45},
                new int[] {72,45}
        }));
    }

    @Test
    public void testComplex2() {
        assertEquals(3, Russian_Doll_Envelopes_354.maxEnvelopes(new int[][] {
                new int[] {3,5},
                new int[] {7,8},
                new int[] {3,6},
                new int[] {3,10},
                new int[] {7,20},
                new int[] {17,3},
                new int[] {17,45}
        }));
    }
    @Test
    public void testComplex3() {
        assertEquals(5, Russian_Doll_Envelopes_354.maxEnvelopes(new int[][]{
                {15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9}, {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19},
                {8, 11}, {13, 11}, {2, 13}, {11, 19}, {16, 1}, {18, 13}, {14, 17}, {18, 19}
        }));
    }
}
