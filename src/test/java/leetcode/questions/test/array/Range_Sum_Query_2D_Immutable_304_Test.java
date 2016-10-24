package leetcode.questions.test.array;

import leetcode.questions.array.Range_Sum_Query_2D_Immutable_304;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/18/2016.
 */
public class Range_Sum_Query_2D_Immutable_304_Test {

    @Test
    public void testSimple() {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        Range_Sum_Query_2D_Immutable_304 solution = new Range_Sum_Query_2D_Immutable_304(matrix);

        assertEquals(8, solution.sumRegion(2, 1, 4, 3));
        assertEquals(11, solution.sumRegion(1, 1, 2, 2));
        assertEquals(12, solution.sumRegion(1, 2, 2, 4));
    }

}
