package leetcode.questions.test.data_structures.graph;

import leetcode.questions.data_structures.graph.Number_Of_Islands_200;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/11/2016.
 */
public class Number_Of_Islands_200_Test {

    @Test
    public void testSimple() {
        assertEquals(1, Number_Of_Islands_200.numIslands(new char[][] {
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray()
        }));
    }

    @Test
    public void testSimple1() {
        assertEquals(3, Number_Of_Islands_200.numIslands(new char[][] {
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()
        }));
    }

}
