package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Combination_Sum_III_216;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/13/2016.
 */
public class Combination_Sum_III_216_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Combination_Sum_III_216.combinationSum3(3, 7);

        assertEquals(1, result.size());

        assertEquals(4, result.get(0).get(0).intValue());
        assertEquals(2, result.get(0).get(1).intValue());
        assertEquals(1, result.get(0).get(2).intValue());
    }

    @Test
    public void testSimple1() {
        List<List<Integer>> result = Combination_Sum_III_216.combinationSum3(3, 9);

        assertEquals(3, result.size());

        assertEquals(6, result.get(0).get(0).intValue());
        assertEquals(2, result.get(0).get(1).intValue());
        assertEquals(1, result.get(0).get(2).intValue());

        assertEquals(5, result.get(1).get(0).intValue());
        assertEquals(3, result.get(1).get(1).intValue());
        assertEquals(1, result.get(1).get(2).intValue());

        assertEquals(4, result.get(2).get(0).intValue());
        assertEquals(3, result.get(2).get(1).intValue());
        assertEquals(2, result.get(2).get(2).intValue());
    }

    @Test
    public void testEdge() {
        List<List<Integer>> result = Combination_Sum_III_216.combinationSum3(2, 18);

        assertEquals(0, result.size());
    }

}
