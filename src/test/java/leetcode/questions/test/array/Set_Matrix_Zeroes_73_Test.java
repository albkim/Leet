package leetcode.questions.test.array;

import leetcode.questions.array.Set_Matrix_Zeroes_73;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 9/19/2016.
 */
public class Set_Matrix_Zeroes_73_Test {

    @Test
    public void testSimple() {
        int[][] input = new int[][] {
                new int[] { 1, 1, 1 },
                new int[] { 1, 0, 1 },
                new int[] { 1, 1, 1 }
        };

        Set_Matrix_Zeroes_73.setZeroes(input);

        assertEquals(1, input[0][0]);
        assertEquals(0, input[0][1]);
        assertEquals(1, input[0][2]);
        assertEquals(0, input[1][0]);
        assertEquals(0, input[1][1]);
        assertEquals(0, input[1][2]);
        assertEquals(1, input[2][0]);
        assertEquals(0, input[2][1]);
        assertEquals(1, input[2][2]);
    }

}
