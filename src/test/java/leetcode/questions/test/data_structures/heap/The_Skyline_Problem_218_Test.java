package leetcode.questions.test.data_structures.heap;

import leetcode.questions.data_structures.heap.The_Skyline_Problem_218;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/13/2016.
 */
public class The_Skyline_Problem_218_Test {

    @Test
    public void testSimple() {
        int[][] buildings = new int[][] {
                new int[] {2, 9, 10},
                new int[] {3, 7, 15},
                new int[] {5, 12, 12},
                new int[] {15, 20, 10},
                new int[] {19, 24, 8}
        };

        List<int[]> result = The_Skyline_Problem_218.getSkyline(buildings);

        assertEquals(7, result.size());

        assertArrayEquals(new int[] {2, 10}, result.get(0));
        assertArrayEquals(new int[] {3, 15}, result.get(1));
        assertArrayEquals(new int[] {7, 12}, result.get(2));
        assertArrayEquals(new int[] {12, 0}, result.get(3));
        assertArrayEquals(new int[] {15, 10}, result.get(4));
        assertArrayEquals(new int[] {20, 8}, result.get(5));
        assertArrayEquals(new int[] {24, 0}, result.get(6));
    }

}
