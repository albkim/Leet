package leetcode.questions.test.array;

import leetcode.questions.array.Surrounded_Regions_130;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sang on 10/5/2016.
 */
public class Surrounded_Regions_130_Test {

    @Test
    public void testSimple() {
        char[][] board = new char[][] {
                "XXXX".toCharArray(),
                "XOOX".toCharArray(),
                "XXOX".toCharArray(),
                "XOXX".toCharArray()
        };

        Surrounded_Regions_130.solve(board);

        assertEquals("XXXX", new String(board[0]));
        assertEquals("XXXX", new String(board[1]));
        assertEquals("XXXX", new String(board[2]));
        assertEquals("XOXX", new String(board[3]));
    }

}
