package leetcode.questions.test.array;

import leetcode.questions.array.Rotate_Image_48;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/14/2016.
 */
public class Rotate_Image_48_Test {

    @Test
    public void testSimple() {
        int[][] matrix = new int[][] {
                new int[] {1,2,3},
                new int[] {4,5,6},
                new int[] {7,8,9},
        };

        Rotate_Image_48.rotate(matrix);

        assertEquals(7, matrix[0][0]);
        assertEquals(4, matrix[0][1]);
        assertEquals(1, matrix[0][2]);
        assertEquals(8, matrix[1][0]);
        assertEquals(5, matrix[1][1]);
        assertEquals(2, matrix[1][2]);
        assertEquals(9, matrix[2][0]);
        assertEquals(6, matrix[2][1]);
        assertEquals(3, matrix[2][2]);
    }

}
