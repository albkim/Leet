package leetcode.questions.test.array;

import leetcode.questions.array.Spiral_Matrix_II_59;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/17/2016.
 */
public class Spiral_Matrix_II_59_Test {

    @Test
    public void testSimple() {
        int[][] result = Spiral_Matrix_II_59.generateMatrix(3);

        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(3, result[0][2]);
        assertEquals(4, result[1][2]);
        assertEquals(5, result[2][2]);
        assertEquals(6, result[2][1]);
        assertEquals(7, result[2][0]);
        assertEquals(8, result[1][0]);
        assertEquals(9, result[1][1]);
    }

}
