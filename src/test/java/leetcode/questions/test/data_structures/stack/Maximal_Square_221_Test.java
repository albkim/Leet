package leetcode.questions.test.data_structures.stack;

import leetcode.questions.data_structures.stack.Maximal_Square_221;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/13/2016.
 */
public class Maximal_Square_221_Test {

    @Test
    public void testSimple() {
        char[][] matrix = new char[][] {
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };

        assertEquals(4, Maximal_Square_221.maximalSquare(matrix));
    }

    @Test
    public void testSimple1() {
        char[][] matrix = new char[][] {
                "1".toCharArray()
        };

        assertEquals(1, Maximal_Square_221.maximalSquare(matrix));
    }

    @Test
    public void testSimple2() {
        char[][] matrix = new char[][] {
                "101101".toCharArray(),
                "111111".toCharArray(),
                "011011".toCharArray(),
                "111010".toCharArray(),
                "011111".toCharArray(),
                "110111".toCharArray()
        };

        assertEquals(4, Maximal_Square_221.maximalSquare(matrix));
    }

}
