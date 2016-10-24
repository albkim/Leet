package leetcode.questions.test.array;

import leetcode.questions.array.Spiral_Matrix_54;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/15/2016.
 */
public class Spiral_Matrix_54_Test {

    @Test
    public void testEdge() {
        List<Integer> result = Spiral_Matrix_54.spiralOrder(new int[][] {
                { 2, 3 }
        });

        assertEquals(2, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
    }

    @Test
    public void testEdge2() {
        List<Integer> result = Spiral_Matrix_54.spiralOrder(new int[][] {
                { 2 },
                { 3 }
        });

        assertEquals(2, result.get(0).intValue());
        assertEquals(3, result.get(1).intValue());
    }

    @Test
    public void testEdge3() {
        List<Integer> result = Spiral_Matrix_54.spiralOrder(new int[][] {
                { 2, 5 },
                { 8, 4 },
                { 0, -1 }
        });

        assertEquals(2, result.get(0).intValue());
        assertEquals(5, result.get(1).intValue());
        assertEquals(4, result.get(2).intValue());
        assertEquals(-1, result.get(3).intValue());
        assertEquals(0, result.get(4).intValue());
        assertEquals(8, result.get(5).intValue());
    }

    @Test
    public void testEdge4() {
        List<Integer> result = Spiral_Matrix_54.spiralOrder(new int[][] {
                { 2 }
        });

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).intValue());
    }

    @Test
    public void testSimple() {
        List<Integer> result = Spiral_Matrix_54.spiralOrder(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });

        assertEquals(1, result.get(0).intValue());
        assertEquals(2, result.get(1).intValue());
        assertEquals(3, result.get(2).intValue());
        assertEquals(6, result.get(3).intValue());
        assertEquals(9, result.get(4).intValue());
        assertEquals(8, result.get(5).intValue());
        assertEquals(7, result.get(6).intValue());
        assertEquals(4, result.get(7).intValue());
        assertEquals(5, result.get(8).intValue());
    }

}
