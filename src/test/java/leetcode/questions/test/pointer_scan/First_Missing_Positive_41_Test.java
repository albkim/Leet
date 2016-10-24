package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.First_Missing_Positive_41;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/11/2016.
 */
public class First_Missing_Positive_41_Test {

    @Test
    public void testOver() {
        assertEquals(4, First_Missing_Positive_41.firstMissingPositive(new int[]{1, 2, 3}));
    }

    @Test
    public void testUnder() {
        assertEquals(1, First_Missing_Positive_41.firstMissingPositive(new int[] {2, 3, 4}));
    }

    @Test
    public void testZigZag() {
        assertEquals(4, First_Missing_Positive_41.firstMissingPositive(new int[] {5, 1, 2, 3}));
    }

    @Test
    public void testIgnoreNegative() {
        assertEquals(2, First_Missing_Positive_41.firstMissingPositive(new int[] {1, 3, -1, 0}));
    }

    @Test
    public void testDuplicates() {
        assertEquals(2, First_Missing_Positive_41.firstMissingPositive(new int[] {1, 1}));
    }

    @Test
    public void testComplex() {
        assertEquals(3, First_Missing_Positive_41.firstMissingPositive(new int[] {0, 2, 2, 1, 1}));
    }

}
