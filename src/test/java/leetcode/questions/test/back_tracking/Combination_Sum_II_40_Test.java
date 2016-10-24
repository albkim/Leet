package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Combination_Sum_II_40;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/10/2016.
 */
public class Combination_Sum_II_40_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Combination_Sum_II_40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

        assertEquals(4, result.size());

        assertEquals(7, result.get(0).get(0).intValue());
        assertEquals(1, result.get(0).get(1).intValue());

        assertEquals(6, result.get(1).get(0).intValue());
        assertEquals(2, result.get(1).get(1).intValue());

        assertEquals(6, result.get(2).get(0).intValue());
        assertEquals(1, result.get(2).get(1).intValue());
        assertEquals(1, result.get(2).get(2).intValue());

        assertEquals(5, result.get(3).get(0).intValue());
        assertEquals(2, result.get(3).get(1).intValue());
        assertEquals(1, result.get(3).get(2).intValue());
    }

}
