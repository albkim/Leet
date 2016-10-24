package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Minimum_Height_Trees_310;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 10/19/2016.
 */
public class Minimum_Height_Trees_310_Test {

    @Test
    public void testSimple() {
        List<Integer> result = Minimum_Height_Trees_310.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}});

        assertEquals(1, result.size());

        assertEquals(1, result.get(0).intValue());
    }

    @Test
    public void testSimple1() {
        List<Integer> result = Minimum_Height_Trees_310.findMinHeightTrees(6, new int[][] {
                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
        });

        assertEquals(2, result.size());

        assertEquals(3, result.get(0).intValue());
        assertEquals(4, result.get(1).intValue());
    }

    @Test
    public void testSimple2() {
        List<Integer> result = Minimum_Height_Trees_310.findMinHeightTrees(6, new int[][] {
                {0,1},{0,2},{0,3},{3,4},{4,5}
        });

        assertEquals(1, result.size());

        assertEquals(3, result.get(0).intValue());
    }

    @Test
    public void testSimple3() {
        List<Integer> result = Minimum_Height_Trees_310.findMinHeightTrees(7, new int[][] {
                {0,1},{1,2},{1,3},{2,4},{3,5},{4,6}
        });

        /*
                0 - 1 - 2 - 4 - 6
                  /
                3
               /
              5
         */
        assertEquals(2, result.size());

        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
    }

}
