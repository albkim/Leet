package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.Word_Search_79;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/20/2016.
 */
public class Word_Search_79_Test {

    @Test
    public void testSimple() {
        char[][] input = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        assertTrue(Word_Search_79.exist(input, "ABCCED"));
        assertTrue(Word_Search_79.exist(input, "SEE"));
        assertFalse(Word_Search_79.exist(input, "ABCB"));
    }

    @Test
    public void testEdge() {
        char[][] input = new char[][]{
                {'A', 'A'}
        };

        assertFalse(Word_Search_79.exist(input, "AAA"));
    }

}
