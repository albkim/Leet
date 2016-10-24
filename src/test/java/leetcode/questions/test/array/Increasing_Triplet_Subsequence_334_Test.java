package leetcode.questions.test.array;

import leetcode.questions.array.Increasing_Triplet_Subsequence_334;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/22/2016.
 */
public class Increasing_Triplet_Subsequence_334_Test {

    @Test
    public void testSimple() {
        assertTrue(Increasing_Triplet_Subsequence_334.increasingTriplet(new int[]{ 1, 2, 3, 4, 5}));
        assertFalse(Increasing_Triplet_Subsequence_334.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testSimple1() {
        assertFalse(Increasing_Triplet_Subsequence_334.increasingTriplet(new int[]{1,2,1,2,1,2,1,2,1,2}));
    }

}
