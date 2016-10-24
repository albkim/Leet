package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Sudoku_Solver_37;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/10/2016.
 */
public class Sudoku_Solver_37_Test {

    @Test
    public void testSimple() {
        char[][] board = new char[][] {
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };

        Sudoku_Solver_37.solveSudoku(board);

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                assertNotEquals('.', board[x][y]);
            }
        }
    }

}
