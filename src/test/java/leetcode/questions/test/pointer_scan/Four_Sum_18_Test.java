package leetcode.questions.test.pointer_scan;

import leetcode.questions.pointer_scan.Four_Sum_18;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/5/2016.
 */
public class Four_Sum_18_Test {

    @Test
    public void testSimple() {
        List<List<Integer>> result = Four_Sum_18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        assertEquals(3, result.size());

        assertEquals(-2, result.get(0).get(0).intValue());
        assertEquals(-1, result.get(0).get(1).intValue());
        assertEquals(1, result.get(0).get(2).intValue());
        assertEquals(2, result.get(0).get(3).intValue());

        assertEquals(-2, result.get(1).get(0).intValue());
        assertEquals(0, result.get(1).get(1).intValue());
        assertEquals(0, result.get(1).get(2).intValue());
        assertEquals(2, result.get(1).get(3).intValue());

        assertEquals(-1, result.get(2).get(0).intValue());
        assertEquals(0, result.get(2).get(1).intValue());
        assertEquals(0, result.get(2).get(2).intValue());
        assertEquals(1, result.get(2).get(3).intValue());

    }

    @Test
    public void testSimple2() {
        List<List<Integer>> result = Four_Sum_18.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);

        assertEquals(8, result.size());
    }
}
