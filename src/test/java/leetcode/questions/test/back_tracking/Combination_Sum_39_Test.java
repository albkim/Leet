package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Combination_Sum_39;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/10/2016.
 */
public class Combination_Sum_39_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Combination_Sum_39.combinationSum(new int[] {2, 3, 6, 7}, 7);

        assertEquals(2, result.size());

        assertEquals(7, result.get(0).get(0).intValue());

        assertEquals(3, result.get(1).get(0).intValue());
        assertEquals(2, result.get(1).get(1).intValue());
        assertEquals(2, result.get(1).get(2).intValue());
    }
}
