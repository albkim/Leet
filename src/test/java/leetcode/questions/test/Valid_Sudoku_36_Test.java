package leetcode.questions.test;

import leetcode.questions.Valid_Sudoku_36;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/10/2016.
 */
public class Valid_Sudoku_36_Test {

    @Test
    public void testSimple() {
        assertTrue(Valid_Sudoku_36.isValidSudoku(new char[][] {
                ".87654321".toCharArray(),
                "2........".toCharArray(),
                "3........".toCharArray(),
                "4........".toCharArray(),
                "5........".toCharArray(),
                "6........".toCharArray(),
                "7........".toCharArray(),
                "8........".toCharArray(),
                "9........".toCharArray()
        }));
    }

}
