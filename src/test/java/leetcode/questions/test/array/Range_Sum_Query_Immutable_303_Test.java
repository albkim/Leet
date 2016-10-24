package leetcode.questions.test.array;

import leetcode.questions.array.Range_Sum_Query_Immutable_303;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/18/2016.
 */
public class Range_Sum_Query_Immutable_303_Test {

    @Test
    public void testSimple() {
        Range_Sum_Query_Immutable_303 solution = new Range_Sum_Query_Immutable_303(new int[] {-2, 0, 3, -5, 2, -1});

        assertEquals(1, solution.sumRange(0, 2));
        assertEquals(-1, solution.sumRange(2, 5));
        assertEquals(-3, solution.sumRange(0, 5));
    }

}
