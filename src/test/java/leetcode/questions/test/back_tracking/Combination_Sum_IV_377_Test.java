package leetcode.test.questions.back_tracking;

import leetcode.questions.back_tracking.Combination_Sum_IV_377;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertk on 8/24/16.
 */
public class Combination_Sum_IV_377_Test {

    @Test
    public void testValidRecursive() {
        assertEquals(7, Combination_Sum_IV_377.combinationSum4Recursive(new int[] {1, 2, 3}, 4));
    }

    @Test
    public void testValidMemoization() {
        assertEquals(7, Combination_Sum_IV_377.combinationSum4Memoization(new int[] {1, 2, 3}, 4));
    }

}
