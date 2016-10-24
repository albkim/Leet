package leetcode.questions.test.dp;

import leetcode.questions.dp.Longest_Increasing_Path_Matrix_329;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/22/2016.
 */
public class Longest_Increasing_Path_Matrix_329_Test {

    @Test
    public void testSimple() {
        assertEquals(4, Longest_Increasing_Path_Matrix_329.longestIncreasingPath(new int[][] {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }));
    }

    @Test
    public void testSimple1() {
        assertEquals(4, Longest_Increasing_Path_Matrix_329.longestIncreasingPath(new int[][] {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        }));
    }

    @Test
    public void testEdge() {
        assertEquals(1, Longest_Increasing_Path_Matrix_329.longestIncreasingPath(new int[][] {
                {1}
        }));
    }

    @Test
    public void testEdge1() {
        assertEquals(2, Longest_Increasing_Path_Matrix_329.longestIncreasingPath(new int[][] {
                {1,2}
        }));
    }

}
