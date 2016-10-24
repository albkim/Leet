package leetcode.questions.test.back_tracking;

import leetcode.questions.back_tracking.N_Queens_II_52;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sang on 9/14/2016.
 */
public class N_Queens_II_52_Test {

    @Test
    public void testSimple() {
        assertEquals(2, N_Queens_II_52.totalNQueens(4));
    }

    @Test
    public void testComplex() {
        assertEquals(1, N_Queens_II_52.totalNQueens(1));
        assertEquals(0, N_Queens_II_52.totalNQueens(2));
        assertEquals(0, N_Queens_II_52.totalNQueens(3));
        assertEquals(2, N_Queens_II_52.totalNQueens(4));
        assertEquals(10, N_Queens_II_52.totalNQueens(5));
    }

}
