package leetcode.hard.test;

import leetcode.hard.Longest_Consecutive_Sequence_128;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/5/2016.
 */
public class Longest_Consecutive_Sequence_128_Test {

    @Test
    public void testSimple() {
        assertEquals(4, Longest_Consecutive_Sequence_128.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void testComplex() {
        assertEquals(9, Longest_Consecutive_Sequence_128.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
    }

    @Test
    public void testComplex1() {
        assertEquals(7, Longest_Consecutive_Sequence_128.longestConsecutive(new int[] {-3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1}));
    }

}
