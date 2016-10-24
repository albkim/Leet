package leetcode.questions.test;

import leetcode.questions.Game_Of_Life_289;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Sang on 10/17/2016.
 */
public class Game_Of_Life_289_Test {

    @Test
    public void testSimple() {
        int[][] board = new int[][] {
                {1,1},
                {1,0}
        };

        Game_Of_Life_289.gameOfLife(board);

        assertArrayEquals(new int[]{1, 1}, board[0]);
        assertArrayEquals(new int[]{1, 1}, board[1]);
    }

    @Test
    public void testSimple1() {
        int[][] board = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        };

        Game_Of_Life_289.gameOfLife(board);

        assertArrayEquals(new int[]{0,0,0,0,0}, board[0]);
        assertArrayEquals(new int[]{0,0,0,0,0}, board[1]);
        assertArrayEquals(new int[]{0,1,1,1,0}, board[2]);
        assertArrayEquals(new int[]{0,0,0,0,0}, board[3]);
        assertArrayEquals(new int[]{0,0,0,0,0}, board[4]);
    }

}
