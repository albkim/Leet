package leetcode.questions.test.dp;

import leetcode.questions.dp.Minimum_Path_Sum_64;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Minimum_Path_Sum_64_Test {

    @Test
    public void testZero() {
        assertEquals(0, Minimum_Path_Sum_64.minPathSum(new int[][]{{0}}));
    }

    @Test
    public void testSimple() {
        assertEquals(3, Minimum_Path_Sum_64.minPathSum(new int[][] {
                {1,2},
                {1,1}
        }));
    }

}
