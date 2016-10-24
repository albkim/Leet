package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Course_Schedule_207;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/12/2016.
 */
public class Course_Schedule_207_Test {

    @Test
    public void testEdge() {
        assertTrue(Course_Schedule_207.canFinish(3, new int[][] {new int[] {1, 0}}));
    }

    @Test
    public void testEdge1() {
        assertTrue(Course_Schedule_207.canFinish(3, new int[][]{new int[]{2, 0}, new int[] {2, 1}}));
    }

    @Test
    public void testSimple() {
        assertTrue(Course_Schedule_207.canFinish(2, new int[][] {new int[] {1, 0}}));
        assertFalse(Course_Schedule_207.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
    }

}
