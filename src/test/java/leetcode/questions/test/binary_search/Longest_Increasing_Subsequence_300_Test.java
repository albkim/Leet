package leetcode.questions.test.binary_search;

import leetcode.questions.binary_search.Longest_Increasing_Subsequence_300;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/17/2016.
 */
public class Longest_Increasing_Subsequence_300_Test {

    @Test
    public void testSimple() {
        assertEquals(4, Longest_Increasing_Subsequence_300.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }

    @Test
    public void testSimple1() {
        assertEquals(3, Longest_Increasing_Subsequence_300.lengthOfLIS(new int[] {4,10,4,3,8,9}));
    }

}
