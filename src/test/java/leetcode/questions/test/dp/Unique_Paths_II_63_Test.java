package leetcode.questions.test.dp;

import leetcode.questions.dp.Unique_Paths_II_63;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/18/2016.
 */
public class Unique_Paths_II_63_Test {

    @Test
    public void testSimple() {
        assertEquals(2, Unique_Paths_II_63.uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        }));
    }

    @Test
    public void testEdge() {
        assertEquals(0, Unique_Paths_II_63.uniquePathsWithObstacles(new int[][] {
                new int[] {1}
        }));
    }

}
